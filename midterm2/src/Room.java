public class Room {
    private int roomNumber;
    private int capacity;

    /**
     * Constructs a room with a room number and capacity.
     * @param roomNumber the room number
     * @param capacity the capacity of the room
     */
    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    /**
     * Returns the room number.
     * @return the room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room number.
     * @param roomNumber the room number
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Returns the capacity of the room.
     * @return the capacity of the room
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the room.
     * @param capacity the capacity of the room
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Returns a string representation of the room.
     * @return a string representation of the room
     */
    @Override
    public String toString() {
        return "Room N#" + roomNumber + ", capacity: " + capacity;
    }
}
