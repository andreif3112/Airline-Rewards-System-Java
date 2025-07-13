/**
 * A class representing the Super Executive Platinum Tier. This class extends the ConcreteTier class -- will implement
 * the same methods. This class could also extend PlatinumPro as this class implements the same methods
 * (even getMiles() as 2000 is used rather than 1000 in the miles' calculation). This class can extend Executive
 * Platinum as a subtype of it as indicated in the instructions.
 */
// extends PlatinumPro as the passenger will earn double the miles per flight.
public class SuperExecutivePlatinum extends ConcreteTier {

    /**
     * This overloaded constructor, and only constructor of the SuperExecutivePlatinum class, takes in the number of flights
     * (uncancelled and cancelled) and cancelled flights BEFORE the Passenger has the Super Executive Platinum Tier but when the
     * Passenger has the Executive Platinum Tier and assigns them to SuperExecutivePlatinum's respective flights and cancelledFlights fields.
     * @param flights -- takes in the number of flights the Passenger has BEFORE having the Super Executive Platinum Tier.
     *                Once the Passenger has reached / met the requirements for the Super Executive Platinum Tier, the number of
     *                flights the Passenger has gets assigned to SuperExecutivePlatinum's flights field.
     * @param cancelledFlights -- takes in the number of cancelled flights the Passenger has BEFORE having the Super
     *                Executive Platinum Tier but when the Passenger has the Executive Platinum Tier.
     *                Once the Passenger has reached / met the requirements for the Super Executive Platinum Tier, the number of
     *                cancelled flights the Passenger has gets assigned to SuperExecutivePlatinum's flights field.
     */
    public SuperExecutivePlatinum(int flights, int cancelledFlights) {
        this.flights = flights;
        this.cancelledFlights = cancelledFlights;
    }

    /**
     * Calculates the number of miles from the number of cancelled flights the Passenger has from having the Super Executive Platinum
     * Tier. However, this getMiles() method must be here to override ConcreteTier's getMiles() method as Passengers
     * who have earned the Super Executive Platinum Tier earn twice the number of miles per cancelled flight
     * (2000 miles per cancelled flight instead of the 1000 miles per cancelled flight) as stated in the
     * instructions.
     * @return miles -- the number of miles the Passenger has from the previous Executive Platinum Tier. Uses 2000 rather than
     * 1000 in the calculation.
     */
    // This needs to override Executive Platinum's / ConcreteTier's getMiles() as the passenger will earn double the miles per
    // flight.
    @Override
    public int getMiles() {
        // Can be .this or .super or just getCancelledFlights() as this class extends
        return this.getCancelledFlights() * 2000;
    }
}
