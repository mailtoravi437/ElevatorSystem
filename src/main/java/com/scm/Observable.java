package com.scm;

import com.scm.button.Direction;

public interface Observable {
    void addElevators(Elevator elevator);
    void requestElevator(int floor, Direction direction);
    void notifyElevators(Request request);
}
