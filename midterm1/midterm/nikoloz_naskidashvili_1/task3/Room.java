package midterm.nikoloz_naskidashvili_1.task3;

public class Room {
    private Integer roomNumber;
    private Integer floor;
    private String maxGuests;
    private String pricePerNight;

    /**
     * Room default Constructor
     */
    public Room() {

    }

    /**
     * Room Constructor
     * @param roomNumber - room number
     * @param floor - floor number
     * @param maxGuests - max guests
     * @param pricePerNight - price per night
     */
    public Room(Integer roomNumber, Integer floor, String maxGuests, String pricePerNight) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.maxGuests = maxGuests;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Get room number
     * @return room number
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }

    /**
     * Set room number
     * @param roomNumber - room number
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Get floor number
     * @return floor number
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * Set floor number
     * @param floor - floor number
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     * Get max guests
     * @return max guests
     */
    public String getMaxGuests() {
        return maxGuests;
    }

    /**
     * Set max guests
     * @param maxGuests - max guests
     */
    public void setMaxGuests(String maxGuests) {
        this.maxGuests = maxGuests;
    }

    /**
     * Get price per night
     * @return price per night
     */
    public String getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Set price per night
     * @param pricePerNight - price per night
     */
    public void setPricePerNight(String pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    /**
     * Get the information of the room.
     * @return The information of the room.
     */
    public String toString() {
        String result = "Room number: " + roomNumber + "\n";
        result += "Floor: " + floor + "\n";
        result += "Max guests: " + maxGuests + "\n";
        result += "Price per night: " + pricePerNight;
        return result;
    }
}
