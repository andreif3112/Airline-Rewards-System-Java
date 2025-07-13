/**
 * A class that implements the Tier interface; the purpose of this ConcreteTier class is to allow access to the
 * Passenger's information - e.g., the number of flights, cancelled flights, miles... - without the Passenger being in
 * a tier.
 */
// This class is so that we can get the passenger's miles, flights, etc. by creating and calling an object's method
// with the passenger not being in a tier
public class ConcreteTier implements Tier {
    /**
     * The number of cancelled flights
     */
    // protected so that subclasses can use
    protected int cancelledFlights = 0;
    /**
     * The number of flights that include cancelled and not cancelled flights
     */
    protected int flights = 0;


    /**
     * Calculates the number of miles the Passenger has based on the number of cancelled flights accumulated for the
     * Passenger. Each cancelled flight is worth 1000 miles according to the instructions.
     * @return the number of miles as a primitive integer based on the number of cancelled flights the Passenger has.
     */
    // getMiles() returns the number of miles from CANCELLED FLIGHTS, NOT ALL FLIGHTS as stated in the documentation
    public int getMiles() {
        return this.cancelledFlights * 1000;
    }

    /**
     * Returns the cancelledFlights field / number of cancelled flights from reading the input file.
     * @return the number of cancelled flights as a primitive integer the Passenger has for the year
     */
    public int getCancelledFlights() {
        return this.cancelledFlights;
    }
    /**
     * Returns the flights field / number of flights (both cancelled and not cancelled) from reading the input file.
     * @return the number of flights as a primitive integer the Passenger has for the year
     */
    public int getFlights() {
        return this.flights;
    }
    /**
     * Updates the flights and/or the cancelledFlights field -- the flights field will always be updated (hence being
     * outside the if block) as each line in the input file represents a flight.
     * @param isCancelled -- the boolean argument "isCancelled" tells us if the flight was a cancelled one or not. If the
     *                    flight was a cancelled one, the cancelledFlights field gets incremented.
     */
    public void addFlight(boolean isCancelled) {
        if(isCancelled) {
            this.cancelledFlights++;
        }
        this.flights++;
    }


}
