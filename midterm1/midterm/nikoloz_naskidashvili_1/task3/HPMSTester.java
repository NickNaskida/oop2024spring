package midterm.nikoloz_naskidashvili_1.task3;

public class HPMSTester {
    /**
     * Main method showcasing task 3 solution.
     */
    public static void main(String[] args) {
        // Create HPMS object
        HPMS hpms = new HPMS();

        // Display rooms
        hpms.displayRooms();

        // Test getters and setters
        Room room = new Room();
        room.setRoomNumber(1);
        room.setFloor(1);
        room.setMaxGuests("2");
        room.setPricePerNight("100");

        System.out.println("Room created by getters and setters:");
        System.out.println(room.toString());

        // Create rooms
        Room room1 = new Room(1, 1, "2", "100");
        Room room2 = new Room(2, 2, "3", "150");

        // Add rooms to HPMS
        hpms.addRoom(room1);
        hpms.addRoom(room2);

        // Display rooms
        hpms.displayRooms();

        // Remove room
        hpms.removeRoom(room1);

        // Display rooms
        hpms.displayRooms();
    }
}
