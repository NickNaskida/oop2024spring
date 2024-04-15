package quizes.q3.nikoloz_naskidashvili_1;

import java.util.ArrayList;

/**
 * Room class that represents a room in a hotel.
 */
public class Room {
    Integer roomID;
    ArrayList<Person> tenants = new ArrayList<>();

    /**
     * Get the room ID.
     * @return The room ID.
     */
    public Integer getRoomID() {
        return roomID;
    }

    /**
     * Set the room ID.
     * @param roomID The room ID.
     */
    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    /**
     * Check in a person to the room.
     * @param person The person to check in.
     */
    public void checkIn(Person person) {
        tenants.add(person);
    }

    /**
     * Check out a person from the room.
     * @param person The person to check out.
     */
    public void checkOut(Person person) {
        tenants.remove(person);
    }

    /**
     * Get the tenants of the room.
     * @return The tenants of the room.
     */
    public ArrayList<Person> getTenants() {
        return tenants;
    }
}
