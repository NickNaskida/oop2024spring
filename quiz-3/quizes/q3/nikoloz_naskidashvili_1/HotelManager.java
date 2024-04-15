package quizes.q3.nikoloz_naskidashvili_1;

import quizes.q3.nikoloz_naskidashvili_1.PersonManager;

import java.util.HashMap;
import java.util.Map;

/**
 * HotelManager class that is responsible for managing the hotel rooms and guests.
 */
public class HotelManager {
    Map<Integer, Room> guestRoomMap = new HashMap<>();


    /**
     * Display the information of the hotel.
     * Display the room ID and the tenants of each room.
     */
    public void displayInfo() {
        for (Map.Entry<Integer, Room> entry : guestRoomMap.entrySet()) {
            System.out.println("Room ID: " + entry.getKey());
            System.out.println("Tenants: ");
            for (Person tenant : entry.getValue().getTenants()) {
                System.out.println(tenant.getName() + " " + tenant.getSurname());
            }
        }
    }

    /**
     * Check in a person to a room.
     * @param person The person to check in.
     * @param room   The room to check in the person to.
     */
    public void checkIn(Person person, Room room) {
        // Add the person to the room
        person.checkIn(person, room);
        // Add the room to the guestRoomMap
        guestRoomMap.put(room.getRoomID(), room);
    }

    /**
     * Check out a person from a room.
     * @param person The person to check out.
     * @param room   The room to check out the person from.
     */
    public void checkOut(Person person, Room room) {
        // Remove the person from the room
        person.checkOut(person, room);
        // Remove the room from the guestRoomMap
        guestRoomMap.remove(room.getRoomID());
    }


    /**
     * Main method showcasing quiz 3 solution.
     */
    public static void main(String[] args) {
        // Create my person object
        Person myself = new Person();
        myself.setId("1");
        myself.setName("Nikoloz");
        myself.setSurname("Naskidashvili");

        // Get another person object from the PersonManager
        PersonManager personManager = new PersonManager();
        Person anotherPerson = personManager.getPersons().get(0);

        // Create a room object
        Room room = new Room();
        room.setRoomID(1);

        // Create a hotel manager object
        HotelManager hotelManager = new HotelManager();

        // Check in myself to the room
        hotelManager.checkIn(myself, room);

        // Check in another person to the room
        hotelManager.checkIn(anotherPerson, room);

        // Display the hotel information
        hotelManager.displayInfo();
    }
}
