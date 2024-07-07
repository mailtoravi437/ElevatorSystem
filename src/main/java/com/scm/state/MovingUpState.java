package com.scm.state;

import com.scm.Elevator;
import com.scm.Request;

public class MovingUpState implements ElevatorState{
    Elevator elevator;

    MovingUpState(Elevator elevator){
        this.elevator = elevator;
    }
    @Override
    public void handleRequest(Request request) {
        if(request.getFloor()>elevator.getCurrentFloor()){
            elevator.setCurrentFloor(request.getFloor());
            if(elevator.getDestination().isEmpty()){
                elevator.setElevatorState(new IdleState(elevator));
            }
        }
    }
}
