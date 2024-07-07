package com.scm.button;

public class ButtonFactory {
    public static Button createButton(int floor,Direction direction){
        if(direction==null){
            return new InternalButton(floor);
        }
        else if(direction==Direction.DOWN || direction==Direction.UP){
            return new ExternalButton(direction,floor);
        }

        return new NullButton();
    }
}
