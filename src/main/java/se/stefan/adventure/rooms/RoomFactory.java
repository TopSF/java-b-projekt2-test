package se.stefan.adventure.rooms;

public class RoomFactory {
    public static Room createRoom(String roomType) {
        switch (roomType) {
            case "sovrum":
                return new Bedroom();

            case "hall":
                return new Hall();

            case "kök":
                return new Kitchen();

            case "vardagsrum":
                return new LivingRoom();

            case "kontor":
                return new Office();

            default:
                throw new IllegalArgumentException("Uknown room type: " + roomType);
        }
    }

}
