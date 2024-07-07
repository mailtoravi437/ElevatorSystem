package com.scm;

import com.scm.button.Direction;
import com.scm.state.ElevatorState;
import com.scm.state.IdleState;
import com.scm.state.MovingDownState;
import com.scm.state.MovingUpState;
import lombok.Data;

import java.util.TreeSet;

@Data
public class Elevator implements Observer{
    private int currentFloor;
    private ElevatorState elevatorState;
    private TreeSet<Integer> destination;

    Elevator(){
        this.currentFloor = 0;
        this.destination = new TreeSet<>();
        this.elevatorState = new IdleState(this);
    }
    @Override
    public void update(Request request) {
        addRequest(request);
    }

    public void addRequest(Request request){
        this.destination.add(request.getFloor());
        elevatorState.handleRequest(request);
    }

    public boolean canHandleRequest(Request request){
        if(request.getDirection()==null){
            return true;
        }
        else if(this.elevatorState instanceof IdleState){
            return true;
        }
        else if(this.elevatorState instanceof MovingUpState && request.getDirection().equals(Direction.UP)){
            return request.getFloor()>this.currentFloor;
        }
        else if(this.elevatorState instanceof MovingDownState && request.getDirection().equals(Direction.DOWN)){
            return request.getFloor()<this.currentFloor;
        }
        return true;
    }
}
