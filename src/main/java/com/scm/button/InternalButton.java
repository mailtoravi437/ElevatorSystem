package com.scm.button;

import com.scm.ElevatorSystem;
import lombok.Data;

@Data
public class InternalButton implements Button{
    int floor;
     InternalButton(int floor){
         this.floor = floor;
     }
    @Override
    public void press() {
        ElevatorSystem.getInstance().requestElevator(floor,null);
    }
}
