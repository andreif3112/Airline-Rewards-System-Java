/**
 * A class representing the Platinum Tier. This class extends the ConcreteTier class -- will implement same methods.
 */
// Can extend but should not extend Gold as Platinum is not a type of Gold Tier, but just a
// type of Tier (or Concrete Tier)
public class Platinum extends ConcreteTier {
    /**
     * This overloaded constructor, and only constructor of the Platinum class, takes in the number of flights
     * (uncancelled and cancelled) and cancelled flights BEFORE the Passenger has the Platinum Tier but when the
     * Passenger has the Gold Tier and assigns them to Platinum's respective flights and cancelledFlights fields.
     * @param flights -- takes in the number of flights the Passenger has BEFORE having the Platinum Tier.
     *                Once the Passenger has reached / met the requirements for the Platinum Tier, the number of flights
     *                the Passenger has gets assigned to Platinum's flights field.
     * @param cancelledFlights -- takes in the number of cancelled flights the Passenger has BEFORE having the Platinum
     *                Tier but when the Passenger has the Gold Tier.
     *                Once the Passenger has reached / met the requirements for the Platinum Tier, the number of
     *                cancelled flights the Passenger has gets assigned to Platinum's flights field.
     */
    public Platinum(int flights, int cancelledFlights) {
        this.flights = flights;
        this.cancelledFlights = cancelledFlights;
    }
}
