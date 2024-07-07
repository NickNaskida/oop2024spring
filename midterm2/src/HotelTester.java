public class HotelTester {
    public static void main(String[] args) {
        // Create a hotel instance
        Hotel hotel = new Hotel();

        // Create rooms in the hotel
        Room room1 = new Room(101, 2);
        Room room2 = new Room(102, 4);
        Room room3 = new Room(103, 6);

        // Add rooms to the hotel
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        System.out.println(hotel.getRooms());

        // Remove a room from the hotel
        hotel.removeRoom(room2);
        System.out.println(hotel.getRooms());

        // Save the state of the hotel
        Hotel.saveState(hotel);

        // Clear the hotel
        hotel.getRooms().clear();
        System.out.println(hotel.getRooms());

        // Restore the state of the hotel
        Hotel.restoreState(hotel);
        System.out.println(hotel.getRooms());
    }
}
