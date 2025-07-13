/**
 * A class representing the Gold Tier. This class extends the ConcreteTier class -- will implement same methods.
 */
public class Gold extends ConcreteTier {
    // Extends / inheritance means that this derived class will have same named fields as base class but NOT same
    // contents (reset to default)...

    /**
     * This overloaded constructor, and only constructor of the Gold class, takes in the number of flights
     * (uncancelled and cancelled) and cancelled flights BEFORE the Passenger has the Gold Tier and assigns them
     * to Gold's respective flights and cancelledFlights fields.
     * @param flights -- takes in the number of flights the Passenger has BEFORE having the Gold Tier. Once the Passenger
     *                has reached / met the requirements for the Gold Tier, the number of flights the Passenger has
     *                gets assigned to Gold's flights field.
     * @param cancelledFlights -- takes in the number of cancelled flights the Passenger has BEFORE having the Gold Tier.
     *                Once the Passenger has reached / met the requirements for the Gold Tier, the number of
     *                cancelled flights the Passenger has gets assigned to Gold's flights field.
     */
    public Gold(int flights, int cancelledFlights) {
        this.flights = flights;
        this.cancelledFlights = cancelledFlights;
    }
}
