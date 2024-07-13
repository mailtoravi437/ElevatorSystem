package com.scm;

import com.scm.button.Direction;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem implements Observable{
    private static ElevatorSystem INSTANCE;
    private final List<Elevator> elevators;

    private ElevatorSystem() {
        this.elevators = new ArrayList<>();
    }

    public static ElevatorSystem getInstance() {
        if (INSTANCE == null) {
            synchronized (ElevatorSystem.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ElevatorSystem();
                }
            }
        }
        return INSTANCE;
    }

    public void addElevators(Elevator elevator) {
        elevators.add(elevator);
    }

    public void requestElevator(int floor, Direction direction) {
        Request request = new Request(floor, direction);
        notifyElevators(request);
    }

    public void notifyElevators(Request request) {
        Elevator closestElevator = findClosestElevator(request);
        if (closestElevator != null) {
            closestElevator.update(request);
        }
    }

    private Elevator findClosestElevator(Request request) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.canHandleRequest(request)) {
                int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
                if (distance < minDistance) {
                    minDistance = distance;
                    closestElevator = elevator;
                }
            }
        }
        return closestElevator;
    }
}
