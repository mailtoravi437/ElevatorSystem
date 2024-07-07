package com.scm.button;

public class NullButton implements Button {
    @Override
    public void press() {
        System.out.println("Specify currect button");
    }
}
