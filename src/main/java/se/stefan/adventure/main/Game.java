package se.stefan.adventure.main;

import se.stefan.adventure.model.Burglar;
import se.stefan.adventure.model.Resident;
import se.stefan.adventure.rooms.*;

import java.util.Scanner;


public class Game {

    Resident resident = new Resident("Tobbe", 10, 2);
    Burglar burglar = new Burglar("Tjuv", 10, 5);

    Instructions instructions = new Instructions();

    private Scanner scanner = new Scanner(System.in);

    private boolean running = true;

    Room LivingRoom = RoomFactory.createRoom("vardagsrum");


    private String userInput() {
        return scanner.nextLine();
    }

    private void gameMessage(String message) {
        System.out.println(message);
    }


    private boolean processInput(String input) {

        switch (input) {

            case "hall" -> {
                Room hall = RoomFactory.createRoom(input);
                hall.checkRoom();
                runEncounter();
            }

            case "sovrum" -> {
                Room bedroom = RoomFactory.createRoom(input);
                bedroom.checkRoom();
            }

            case "kontor" -> {
                Room office = RoomFactory.createRoom(input);
                office.checkRoom();
                callFromOffice();
            }

            case "kök" -> {
                Room kitchen = RoomFactory.createRoom(input);
                kitchen.checkRoom();
                getFryingPan();
            }

            case "vardagsrum" -> LivingRoom.checkRoom();

            default -> System.out.println("fel inmatning");

        }
        return running;
    }

    private void callFromOffice() {
        if (DirectionConstants.currentLocation.equals(DirectionConstants.KONTOR)) {
            if (!burglar.isConscious()) {
                gameMessage("Vill du ringa polisen? \nSkriva ja eller nej");
                String ringPolisen = userInput();
                boolean call = true;

                while (call) {
                    switch (ringPolisen) {
                        case "ja" -> {
                            gameMessage("Du ringer polisen, efter en stund kommer polisen " +
                                    "och griper tjuven.\nGAME WON");
                            running = false;
                            call = false;
                        }
                        case "nej" -> {
                            gameMessage("Du väljer att inte ringa polisen. " +
                                    "\nEfter en stund vaknar tjuven och slår dig medvetslös " +
                                    "\nGAME OVER");
                            running = false;
                            call = false;
                        }
                        default -> {
                            gameMessage("Du måste skriva ja eller nej");
                            ringPolisen = userInput();
                        }
                    }

                }

            } else {
                gameMessage("Inget här, gå tillbaka till vardagsrummet");
            }
        }

    }

    private void getFryingPan() {
        if (DirectionConstants.currentLocation.equals(DirectionConstants.KOK)) {
            if (resident.getDamage() == 2) {

                gameMessage("I köket ser du en stekpanna, vill du ta den?" +
                        "\nSkriv ja eller nej?");

                String stekpanna = userInput();
                boolean panna = true;

                while (panna) {
                    switch (stekpanna) {
                        case "ja" -> {
                            gameMessage("Du tar upp stekpannan");
                            resident.setDamage(resident.getDamage() + 3);
                            panna = false;
                        }
                        case "nej" -> {
                            gameMessage("Du tar inte upp stekpannan");
                            panna = false;
                        }

                        default -> {
                            gameMessage("Du måste skriva ja eller nej");
                            stekpanna = userInput();
                        }
                    }
                }

                gameMessage("Gå tillbaka till vardagsrummet");
            } else {
                gameMessage("Inget här, gå tillbaka till vardagsrummet");
            }
        }

    }

    private void runEncounter() {

        if (DirectionConstants.currentLocation.equals(DirectionConstants.HALL)) {
            if (burglar.isConscious() && resident.isConscious()) {
                gameMessage("Du ser en tjuv ståendes vid ytterdörren! Vad vill du göra?" +
                        "\nSkriv konfrontera eller vardagsrum, för att gå tillbaka till " +
                        "vardagsrummet");
                switchEncounter();

            } else if (!burglar.isConscious()) {
                gameMessage("Tjuven ligger medvetslös på golvet");
            }

        }

    }


    private void switchEncounter() {
        String choice = userInput();
        boolean encounter = true;

        while (encounter) {
            switch (choice) {
                case "konfrontera" -> {
                    gameMessage("Du konfronterar tjuven och ett slagsmål bryter ut");
                    resident.fightOneRound(resident, burglar);
                    if (!resident.isConscious()) {
                        gameMessage("Tjuven slår dig medvetslös \nGAME OVER");
                        running = false;
                        encounter = false;
                    } else {
                        gameMessage("Gå till kontoret för att ringa polisen");
                        encounter = false;
                    }
                }
                case "vardagsrum" -> {
                    LivingRoom.checkRoom();
                    encounter = false;
                }
                default -> {
                    gameMessage("fel inmatning");
                    choice = userInput();
                }
            }
        }


    }

    public void runGame() {

        instructions.gameStory();

        LivingRoom.setRoom();
        instructions.gameMenu();

        while (running) {
            processInput(userInput());
        }

        scanner.close();

    }




}
