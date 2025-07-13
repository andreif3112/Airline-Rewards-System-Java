/**
 * A class representing a Passenger and their information.
 */
public class Passenger {
    /**
     * The unique ID of a Passenger
     */
    private String id = "No Passenger ID";
    /**
     * The tier that the Passenger belongs to; i.e., an object that holds the Passenger's tier -- can be used to call
     * methods like getMiles(), getCancelledFlights(), etc. if a Passenger belongs in a tier or not.
     */
    private ConcreteTier tier = null;
    /**
     * A boolean value to indicate whether the Passenger has complained about their cancelled flight.
     */
    private boolean hasComplained = false;


    /**
     * The only constructor, an overloaded constructor, needed that takes in the Passenger's ID as a String argument
     * from the input file.
     * @param id
     */
    public Passenger(String id) {
        this.id = id;
        tier = new ConcreteTier();
        this.hasComplained = false;
    }


    /**
     * Gets the tier of a Passenger, whether the Passenger belongs in a tier or not. If a Passenger does not belong
     * in a tier, a message indicating that the Passenger does not belong in a tier will be returned; otherwise,
     * the name of the Passenger's tier will be returned.
     * This getTier() method also considers + handles if the tier object of ConcreteTier type will be in
     * a Package or not. By default, the tier object should not be in a package.
     * @return tier that the Passenger belongs to -- tier can be a String of the name of the tier
     * or a message indicating the Passenger does not belong in a tier.
     */
    // Ensure that this will not be in a package, otherwise the "tier.getClass().getName()" will return
    // "packageName.className" and not just "className"
    public String getTier() {
        // if tier is in a package, the "tier.getClass().getName()" will return "packageName.className", not just
        // "className", so we want to just get the class name by using the ".substring()"
        if(tier.getClass().getName().contains(".")) {
            if (tier.getClass().getName().substring(tier.getClass().getName().lastIndexOf(".")).equals("ConcreteTier")) {
                return "This passenger (ID: " + this.id + ") does not meet the minimum requirements for a tier.";
            }
            else if(tier.getClass().getName().substring(tier.getClass().getName().lastIndexOf(".")).equals("SuperExecutivePlatinum")) {
                return "Super Executive Platinum";
            }
            else if(tier.getClass().getName().substring(tier.getClass().getName().lastIndexOf(".")).equals("ExecutivePlatinum")) {
                return "Executive Platinum";
            }
            else if(tier.getClass().getName().substring(tier.getClass().getName().lastIndexOf(".")).equals("PlatinumPro")) {
                return "Platinum Pro";
            }
            else if(tier.getClass().getName().substring(tier.getClass().getName().lastIndexOf(".")).equals("Platinum")) {
                return "Platinum";
            }
            return "Gold";
        }
        else {
            if(tier.getClass().getName().equals("SuperExecutivePlatinum")) {
                return "Super Executive Platinum";
            }
            else if(tier.getClass().getName().equals("ExecutivePlatinum")) {
                return "Executive Platinum";
            }
            else if(tier.getClass().getName().equals("PlatinumPro")) {
                return "Platinum Pro";
            }
            // For Platinum and Gold
            return tier.getClass().getName();
        }
    }

    /**
     * Gets the number of miles the Passenger has accumulated for the number of cancelled flights. This getMiles() method
     * in the Passenger class calls the Passenger's tier object's getMiles() method as stated in the instructions.
     * @return miles -- returns the number of miles the Passenger has accumulated for the number of cancelled flights.
     */
    // getMiles() returns the number of miles from CANCELLED FLIGHTS, NOT ALL FLIGHTS as stated in the documentation
    public int getMiles() {
        return tier.getMiles();
    }

    /**
     * Gets the number of cancelled flights the Passenger has accumulated from each line of the input file being read.
     * This getCancelledFlights() method calls the Passenger's tier object's getCancelledFlights() method
     * as stated in the instructions.
     * @return cancelledFlights -- returns the number of cancelled flights the Passenger has accumulated.
     */
    public int getCancelledFlights() {
        return tier.getCancelledFlights();
    }

    /**
     * Determines whether the Passenger has the multiplier or not. A Passenger has the multiplier if they are in the
     * Platinum Pro or Super Executive Platinum tiers; i.e., if they have reached a certain number of miles from the
     * number of cancelled flights and if they have not complained throughout an entire year.
     * @return boolean -- returns true if the Passenger has the multiplier; false if not.
     */
    // Since this function is only stated for the Passenger class in the documentation, this function should only just
    // be for the Passenger class, not the Tier interface.
    public boolean hasMultiplier() {
        // if this.hasComplained is false, or if the passenger has not complained, and is in the Super/Pro tiers,
        // then return true to indicate that passenger has multiplier
        if(!this.hasComplained && (tier.getClass().getName().equals("PlatinumPro") ||
                tier.getClass().getName().equals("SuperExecutivePlatinum"))) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Adds a flight to the Passenger's record of flights -- each line in the input file represents a flight, whether the
     * flight could be a cancelled or non-cancelled one. This addFlight() method in the Passenger class calls the
     * Passenger's tier object's getCancelledFlights() method as stated in the instructions.
     * @param isCancelled -- tells us whether the flight was cancelled or not.
     */
    public void addFlight(boolean isCancelled) {
        tier.addFlight(isCancelled);
    }


    // Additional methods I added --------------------------------------------------------------------------------------
    /**
     * Sets the boolean field, "hasComplained" true if the Passenger has complained as the "hasComplained" field is false
     * by default. This method of setting the "hasComplained" field to be true exists, but setting the "hasComplained"
     * field to be false is not needed; the main concern is that once a Passenger has complained about their cancelled
     * flight, then they can no longer receive the multiplier.
     */
    public void setHasComplainedTrue() {
        this.hasComplained = true;
    }

    /**
     * Updates the tier (object of ConcreteTier type) that the Passenger holds. If a Passenger has attained a certain
     * number of cancelled flights and/or has not complained, then they would be moved up a tier (starting from not
     * being in a tier).
     */
    public void determineTier() {
        // this.hasComplained must be false, and !hasComplained evaluates to true so that SuperExecPlat tier can be
        // assigned.
        if(this.getCancelledFlights() >= 100 && !this.hasComplained) {
            this.tier = new SuperExecutivePlatinum(this.tier.getFlights(), this.tier.getCancelledFlights());
        }
        else if(this.getCancelledFlights() >= 100) {
            this.tier = new ExecutivePlatinum(this.tier.getFlights(), this.tier.getCancelledFlights());
        }
        else if(this.getCancelledFlights() >= 50 && this.getCancelledFlights() < 100 && !this.hasComplained) {
            this.tier = new PlatinumPro(this.tier.getFlights(), this.tier.getCancelledFlights());
        }
        else if(this.getCancelledFlights() >= 50 && this.getCancelledFlights() < 100) {
            this.tier = new Platinum(this.tier.getFlights(), this.tier.getCancelledFlights());
        }
        else if(this.getCancelledFlights() == 25) {
            // *** IMPORTANT ***
            // Be sure to pass in Passenger's current tier's flights and cancelledFlights [in this case, ConcreteTier's
            // so that we'd still keep the current number of each (for accumulation) rather than having to use
            // the new RESETTED fields of the new (Gold) Tier object]. Same goes for tiers above.

            // When we create a Gold object, it will create a Gold object + ConcreteTier object, but the
            // ConcreteTier object won't have the fields of the passenger's ConcreteTier object
            this.tier = new Gold(this.tier.getFlights(), this.tier.getCancelledFlights());
        }
    }

    /**
     * This toString() method overrides Object's toString(). When a Passenger object is outputted to the console using
     * "System.out.print(passengerObject)", the Passenger object's toString() method will automatically be called;
     * however, instead of calling Object's toString() (which would output className@Object'sHashCode), Passenger's
     * toString() should override Object's to output different information that is more relevant and understandable.
     * @return String -- a message that includes relevant information of the Passenger:
     *  - The Passenger's ID
     *  - The number of the Passenger's cancelled and non-cancelled flights
     *  - The number of the Passenger's cancelled flights
     *  - The number of miles from the number of the Passenger's cancelled flights
     *  - Whether the Passenger has complained or not
     *  - The tier (or absence of a tier) that the Passenger belongs to
     *   - Whether the Passenger has the multiplier or not
     */
    // For printing out HashMap of Passenger objects itself
    @Override
    public String toString() {
        return "ID:" + this.id + "\tFlights:" + this.tier.getFlights() +
                "\tCFlights:" + this.tier.getCancelledFlights() + "\tMiles:" + this.tier.getMiles() +
                "\thasComplained: " + this.hasComplained + "\tTier: " + this.getTier() +
                "\thasMultiplier: " + this.hasMultiplier() + "\n";
    }

    /**
     * This getPromptOutput() is used in the promptUser() method in the Main class. A String containing relevant
     * questions + information about the Passenger is returned.
     * @return String -- contains the questions in the instructions to be outputted + the questions' respective
     * answers/responses/information
     */
    public String getPromptOutput() {
        // This hasM variable and if-block is needed so that the return value of hasMultipler(), "true" or "false", will
        // not be displayed but rather "Yes" or "No"
        String hasM = "No";
        if(this.hasMultiplier()) {
            hasM = "Yes";
        }


        return String.format("\nResults for Passenger %s:\n\tRewards tier: %s\n\tTotal miles accumulated for the year: " +
                "%d\n\tTotal cancellations accumulated for the year: %d\n\tHas multiplier? %s", this.id,
                this.getTier(), this.tier.getMiles(), this.tier.getCancelledFlights(), hasM);
    }

}
