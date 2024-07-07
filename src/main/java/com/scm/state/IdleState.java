package com.scm.state;

import com.scm.Elevator;
import com.scm.Request;

public class IdleState implements ElevatorState{
    private Elevator elevator;

    public IdleState(Elevator elevator){
        this.elevator = elevator;
    }
    @Override
    public void handleRequest(Request request) {
        if(request.getFloor()>elevator.getCurrentFloor()){
            elevator.setElevatorState(new MovingUpState(elevator));
        }
        else if(request.getFloor()<elevator.getCurrentFloor()){
            elevator.setElevatorState(new MovingDownState(elevator));
        }
        elevator.addRequest(request);
    }
}
