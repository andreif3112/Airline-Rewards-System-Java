/**
 * A class representing the Executive Platinum Tier. This class extends the ConcreteTier class -- will implement same methods.
 */
public class ExecutivePlatinum extends ConcreteTier {
    /**
     * This overloaded constructor, and only constructor of the ExecutivePlatinum class, takes in the number of flights
     * (uncancelled and cancelled) and cancelled flights BEFORE the Passenger has the Executive Platinum Tier but when the
     * Passenger has the Platinum Tier and assigns them to ExecutivePlatinum's respective flights and cancelledFlights fields.
     * @param flights -- takes in the number of flights the Passenger has BEFORE having the Executive Platinum Tier.
     *                Once the Passenger has reached / met the requirements for the ExecutivePlatinum Tier, the number of flights
     *                the Passenger has gets assigned to ExecutivePlatinum's flights field.
     * @param cancelledFlights -- takes in the number of cancelled flights the Passenger has BEFORE having the Executive Platinum
     *                Tier but when the Passenger has the Platinum Tier.
     *                Once the Passenger has reached / met the requirements for the Executive Platinum Tier, the number of
     *                cancelled flights the Passenger has gets assigned to ExecutivePlatinum's flights field.
     */
    public ExecutivePlatinum(int flights, int cancelledFlights) {
        this.flights = flights;
        this.cancelledFlights = cancelledFlights;
    }
}
