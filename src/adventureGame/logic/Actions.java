//// IGNORE THIS CLASS, not being used currently!

////Controller in charge of all player actions
////Fx. the switch, goNorth, loot etc
//
//package adventureGame.logic;
//
////Group 20
////Lau, Mark, Jonatan og Mads
//
//import adventureGame.data.Dungeon;
//import adventureGame.data.Player;
//import adventureGame.view.TUI;
//
//public class Actions {
//    //Player player;
//    Dungeon dungeon;
//    TUI ui;
//    
//    public Actions(Dungeon dungeon, TUI ui){
//        this.dungeon = dungeon;
//        this.ui = ui;      
//    }
//
////    Method that asks the player for an action
////    and through the switch tries to do something
////    public void playerAction() {
////        String direction = ui.askDirection();
////        switch (direction) {
////            case "n":
////                goNorth();
////                break;
////            case "e":
////                goEast();
////                break;
////            case "s":
////                goSouth();
////                break;
////            case "w":
////                goWest();
////                break;
////            case "help":
////                ui.listOfCommands();
////                break;
////            case "quit":
////                System.out.println("GG");
////                System.exit(0);
////            default:
////                ui.invalidCommand();
////        }
////    }
//
//    //Checks if there is a door north with checkDirection(), moves to room north if there is.
//    public Player goNorth(Player player) {
//        if (checkDirection(1, player)) {
//            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getNorth()); //set current room to the room north
//        } else {
//            ui.noDoorMessage();
//        }
//        return player;
//    }
//
//    //Checks if there is a door east with checkDirection(), moves to room east if there is.
//    public Player goEast(Player player) {
//        if (checkDirection(1, player)) {
//            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getEast()); //set current room to the room north
//        } else {
//            ui.noDoorMessage();
//        }
//        return player;
//    }
//
//    //Checks if there is a door south with checkDirection(), moves to room south if there is.
//    public Player goSouth(Player player) {
//        if (checkDirection(1, player)) {
//            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getSouth()); //set current room to the room north
//        } else {
//            ui.noDoorMessage();
//        }
//        return player;
//    }
//
//    //Checks if there is a door west with checkDirection(), moves to room west if there is.
//    public Player goWest(Player player) {
//        if (checkDirection(1, player)) {
//            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getWest()); //set current room to the room north
//        } else {
//            ui.noDoorMessage();
//        }
//        return player;
//    }
//
//    //Determines if the chosen direction is possible. If there is no door in a
//    //certain direction, its value is -1, so we check if the value is 0 or higher.
//    //the values that are 0 or higher matches that room's index in the dungeon rooms arraylist.
//    private boolean checkDirection(int direction, Player player) {
//        switch (direction) {
//            case 1:
//                return dungeon.rooms.get(player.getCurrentRoom()).getNorth() >= 0;
//            case 2:
//                return dungeon.rooms.get(player.getCurrentRoom()).getEast() >= 0;
//            case 3:
//                return dungeon.rooms.get(player.getCurrentRoom()).getSouth() >= 0;
//            case 4:
//                return dungeon.rooms.get(player.getCurrentRoom()).getWest() >= 0;
//            default:
//                return false;
//        }
//    }
//}
