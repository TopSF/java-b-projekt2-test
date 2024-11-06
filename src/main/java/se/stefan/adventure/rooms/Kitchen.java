package se.stefan.adventure.rooms;

import se.stefan.adventure.main.DirectionConstants;
import se.stefan.adventure.model.Entity;

public class Kitchen implements Room {


    @Override
    public void checkRoom() {
        if (DirectionConstants.currentLocation.equals(DirectionConstants.VARDAGSRUM)) {
            System.out.println("Du smyger till köket");
            DirectionConstants.currentLocation = DirectionConstants.KOK;

        } else if (DirectionConstants.currentLocation.equals(DirectionConstants.KOK)) {
            System.out.println("Du är redan i köket.");
        } else {
            System.out.println(DirectionConstants.WRONG_WAY);
        }
    }

    @Override
    public void setRoom() {

    }

}
