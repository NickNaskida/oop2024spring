package midterm.nikoloz_naskidashvili_1.task3;

import java.util.ArrayList;

public class HPMS {
    ArrayList <Room> rooms = new ArrayList<>();

    /**
     * Adds a new room to the system.
     * @param room The room to be added.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Removes a room from the system.
     * @param room The room to be removed.
     */
    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    /**
     * Returns a list of all rooms in the system.
     * @return List of all rooms in the system.
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Displays all rooms in the system.
     */
    public void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room room : rooms) {
                System.out.println("------------");
                System.out.println("HOTEL STATE:");
                System.out.println("------------");
                System.out.println(room.toString());
                System.out.println("------------");
            }
        }
    }
}
