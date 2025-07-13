/**
 * A class representing the PlatinumPro Tier. This class extends the ConcreteTier class -- will implement same methods.
 * This class could also extend Platinum.
 */
public class PlatinumPro extends ConcreteTier {
    /**
     * This overloaded constructor, and only constructor of the PlatinumPro class, takes in the number of flights
     * (uncancelled and cancelled) and cancelled flights BEFORE the Passenger has the Platinum Pro Tier but when the
     * Passenger has the Platinum Tier and assigns them to PlatinumPro's respective flights and cancelledFlights fields.
     * @param flights -- takes in the number of flights the Passenger has BEFORE having the Platinum Pro Tier.
     *                Once the Passenger has reached / met the requirements for the Platinum Pro Tier, the number of
     *                flights the Passenger has gets assigned to PlatinumPro's flights field.
     * @param cancelledFlights -- takes in the number of cancelled flights the Passenger has BEFORE having the Platinum
     *                Pro Tier but when the Passenger has the Platinum Tier.
     *                Once the Passenger has reached / met the requirements for the Platinum Pro Tier, the number of
     *                cancelled flights the Passenger has gets assigned to PlatinumPro's flights field.
     */
    public PlatinumPro(int flights, int cancelledFlights) {
        this.flights = flights;
        this.cancelledFlights = cancelledFlights;
    }

    /**
     * Calculates the number of miles from the number of cancelled flights the Passenger has from having the Platinum
     * Tier. However, this getMiles() method must be here to override ConcreteTier's getMiles() method as Passengers
     * who have earned the Platinum Pro Tier earn twice the number of miles per cancelled flight
     * (2000 miles per cancelled flight instead of the 1000 miles per cancelled flight) as stated in the
     * instructions.
     * @return miles -- the number of miles the Passenger has from the previous Platinum Tier. Uses 2000 rather than
     * 1000 in the calculation.
     */
    // This needs to override Platinum's / ConcreteTier's getMiles() as the passenger will earn double the miles per
    // flight.
    @Override
    public int getMiles() {
        // Can be .this or .super or just getCancelledFlights() as this class extends
        return this.getCancelledFlights() * 2000;
    }
}
