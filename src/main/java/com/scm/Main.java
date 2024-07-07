package com.scm;

import com.scm.button.Button;
import com.scm.button.ButtonFactory;
import com.scm.button.Direction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();
        Elevator elevator1 = new Elevator();
        Elevator elevator2 = new Elevator();
        Elevator elevator3 = new Elevator();

        elevatorSystem.addElevators(elevator1);
        elevatorSystem.addElevators(elevator2);

//        Button externalButton = ButtonFactory.createButton(5,Direction.UP);
        Button internalButton = ButtonFactory.createButton(3,null);
        Button externalButton1 = ButtonFactory.createButton(1,Direction.UP);


//        externalButton.press();
        internalButton.press();
        externalButton1.press();


        System.out.println(elevator1.getCurrentFloor());
        System.out.println(elevator2.getCurrentFloor());


    }
}