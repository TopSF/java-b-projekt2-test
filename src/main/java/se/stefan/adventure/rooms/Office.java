package se.stefan.adventure.rooms;

import se.stefan.adventure.main.DirectionConstants;
import se.stefan.adventure.model.Entity;

public class Office implements Room {


    @Override
    public void checkRoom() {
        if (DirectionConstants.currentLocation.equals(DirectionConstants.VARDAGSRUM)) {
            System.out.println("Du smyger till kontoret");
            DirectionConstants.currentLocation = DirectionConstants.KONTOR;

        } else if (DirectionConstants.currentLocation.equals(DirectionConstants.KONTOR)) {
            System.out.println("Du är redan i kontoret.");
        } else {
            System.out.println(DirectionConstants.WRONG_WAY);
        }

    }

    @Override
    public void setRoom() {

    }

}
