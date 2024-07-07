package com.scm.state;

import com.scm.Request;

public interface ElevatorState {
    void handleRequest(Request request);
}
