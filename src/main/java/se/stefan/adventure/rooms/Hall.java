package se.stefan.adventure.rooms;

import se.stefan.adventure.main.DirectionConstants;
import se.stefan.adventure.model.Entity;

public class Hall implements Room {


    @Override
    public void checkRoom() {
        if (DirectionConstants.currentLocation.equals(DirectionConstants.VARDAGSRUM)) {
            System.out.println("Du smyger ut till hallen.");
            DirectionConstants.currentLocation = DirectionConstants.HALL;

        } else if (DirectionConstants.currentLocation.equals(DirectionConstants.HALL)) {
            System.out.println("Du är redan i hallen.");
            System.out.println(DirectionConstants.WRONG_WAY);
        } else {
            System.out.println(DirectionConstants.WRONG_WAY);
        }
    }

    @Override
    public void setRoom() {

    }
}
