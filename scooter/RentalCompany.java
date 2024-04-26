package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

public class RentalCompany {

    private int uid = 0;

    List<Scooter> scooters = new ArrayList<>();

    /**
     * Returns a list of all available scooters.
     * @return List of available scooters.
     */
    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter: scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    /**
     * Adds a new scooter to the company.
     * @param scooter The scooter to be added.
     */
    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooters.add(scooter);
    }

    /**
     * Removes a scooter from the company.
     * @param id The id of the scooter to be removed.
     * @return True if the scooter was removed, false otherwise.
     */
    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Rents a scooter.
     * @param id The id of the scooter to be rented.
     */
    public void rentScooter(int id) {
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooter.setAvailable(false);
                break;
            }
        }
    }

    /**
     * Returns a scooter.
     * @param id The id of the scooter to be returned.
     * @param x The x coordinate of the scooter's new location.
     * @param y The y coordinate of the scooter's new location.
     */
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooter.setAvailable(true);
                scooter.setX(x);
                scooter.setY(y);
                break;
            }
        }
    }

    /**
     * Displays all scooters.
     */
    public void displayAllScooters() {
        for (Scooter scooter : scooters) {
            System.out.println(scooter);
        }
    }
}