package com.scm.button;

import com.scm.ElevatorSystem;
import lombok.Data;

@Data
public class ExternalButton implements Button{
    Direction direction;
    int floor;

    ExternalButton(Direction direction,int floor){
        this.direction = direction;
        this.floor = floor;
    }
    @Override
    public void press() {
        ElevatorSystem.getInstance().requestElevator(floor,direction);
    }
}
