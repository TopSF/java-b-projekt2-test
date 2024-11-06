package se.stefan.adventure.rooms;

import se.stefan.adventure.main.DirectionConstants;
import se.stefan.adventure.model.Entity;

public class Bedroom implements Room {


    @Override
    public void checkRoom() {
        if (DirectionConstants.currentLocation.equals(DirectionConstants.VARDAGSRUM)) {
            System.out.println("Du smyger till sovrummet");
            DirectionConstants.currentLocation = DirectionConstants.SOVRUM;
            System.out.println("Inget i sovrummet, gå tillbaka");
        } else if (DirectionConstants.currentLocation.equals(DirectionConstants.SOVRUM)) {
            System.out.println("Du är redan i sovrummet.");
            System.out.println(DirectionConstants.WRONG_WAY);
        } else {
            System.out.println(DirectionConstants.WRONG_WAY);
        }
    }

    @Override
    public void setRoom() {

    }


}
