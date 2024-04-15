package quizes.q3.nikoloz_naskidashvili_1;

public class Person {

    String id;
    String name, surname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Check in a person to a room.
     *
     * @param person The person to check in.
     * @param room   The room to check in the person to.
     */
    public void checkIn(Person person, Room room) {
        // Add the person to the room
        room.checkIn(person);
    }

    /**
     * Check out a person from a room.
     *
     * @param person The person to check out.
     * @param room   The room to check out the person from.
     */
    public void checkOut(Person person, Room room) {
        // Remove the person from the room
        room.checkOut(person);
    }
}
