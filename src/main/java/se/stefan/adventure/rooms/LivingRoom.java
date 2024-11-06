package se.stefan.adventure.rooms;

import se.stefan.adventure.main.DirectionConstants;
import se.stefan.adventure.main.Instructions;
import se.stefan.adventure.model.Entity;

public class LivingRoom implements Room {

    Instructions instructions = new Instructions();

    @Override
    public void checkRoom() {
        if (!DirectionConstants.currentLocation.equals(DirectionConstants.VARDAGSRUM)) {
            System.out.println("Du smyger till vardagsrummet");
            DirectionConstants.currentLocation = DirectionConstants.VARDAGSRUM;
            System.out.println("Vilket rum vill du gå till?");
            instructions.gameMenu();
        } else if(DirectionConstants.currentLocation.equals(DirectionConstants.VARDAGSRUM)) {
            System.out.println("Du befinner dig redan i vardagsrummet");
        }
    }

    @Override
    public void setRoom() {
        System.out.println("Nu befinner du dig i vardagsrummet");
        System.out.println("Var vill du gå nu?");
        DirectionConstants.currentLocation = DirectionConstants.VARDAGSRUM;
    }


}
