package com.scm;

import com.scm.button.Direction;
import lombok.Data;

@Data
public class Request {
    private int floor;
    Direction direction;

    Request(int floor,Direction direction){
        this.floor = floor;
        this.direction = direction;
    }

}
