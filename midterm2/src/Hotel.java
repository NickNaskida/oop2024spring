import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Hotel {
    private final List<Room> rooms;
    private static final String STATE_FILE = "state.csv";

    /**
     * Constructs a hotel with no rooms.
     */
    public Hotel() {
        this.rooms = new ArrayList<>();
    }

    /**
     * Returns the list of rooms in the hotel.
     * @return the list of rooms in the hotel
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Adds a room to the hotel.
     * @param room the room to add
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Removes a room from the hotel.
     * @param room the room to remove
     */
    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    /**
     * Saves the state of the hotel to a file.
     * @param hotel the hotel to save
     */
    public static void saveState(Hotel hotel) {
        try (FileWriter writer = new FileWriter(STATE_FILE)) {
            writer.write("roomNumber,capacity\n");
            for (Room room : hotel.getRooms()) {
                writer.write(room.getRoomNumber() + "," + room.getCapacity() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    /**
     * Restores the state of the hotel from a file.
     * @param hotel the hotel to restore
     */
    public static void restoreState(Hotel hotel) {
        hotel.getRooms().clear(); // Clear existing rooms to prevent inconsistency

        try (BufferedReader reader = new BufferedReader(new FileReader(STATE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip the header line
                if (line.equals("roomNumber,capacity")) {
                    continue;
                }

                // Parse the room number and capacity
                String[] parts = line.split(",");
                int roomNumber = Integer.parseInt(parts[0]);
                int capacity = Integer.parseInt(parts[1]);

                Room room = new Room(roomNumber, capacity);
                hotel.getRooms().add(room);
            }
        } catch (IOException e) {
            System.err.println("Error restoring state: " + e.getMessage());
        }
    }
}