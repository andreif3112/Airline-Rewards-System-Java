/*
    @author: Andrei Favorito
    @date: 07/10/2025 (date for last update)
    @version: 1.0

    @ description:
    This academic project is a rewards program for passengers who have stayed loyal to an airline.

    This project determines the rewards tier for passengers based on their number of accumulated miles 
    (larger amount of accumulated miles = higher rewards tier); the number of accumulated miles is determined 
    by the number of cancelled flights a passenger had within a single year -- each cancelled flight is initially 
    worth 1000 miles.
    Moreover, if a passenger never complained after having multiple cancelled flights for the ENTIRE year, they 
    earn the mileage multiplier, which doubles the number of accumulated miles for a single flight cancellation 
    (1000 miles --> 2000 miles per each cancelled flight).
 */
/*
    changelog:
        03/25/2023
            - created Passenger, interface Tier, class concreteTier (to get miles, flights, etc. for a passenger NOT in
                a tier), other tier classes
            - created adding + updating hashmap
        03/26/2023
            - took care of getting correct tier by creating determineTier() and overloaded constructors + overridden
                methods for all tiers
                - with this, took care of complained and hasMultiplier
        03/27/2023
            - fixed getTier() + changed tier field in Passenger from Tier to ConcreteTier
            - created promptUser(), enclosed it in a while loop, used '?' as sentinel value, implemented some
                exception handling for invalid input (invalid Passenger ID).
                - while creating promptUser(), also created getPromptOutput() in the Passenger class
        03/28/2023
            - started fixing output in promptUser()
            - changed getTier() to circumvent the package problem (i.e., if the classes of the tiers are in a package).
                - e.g., Passenger's getTier() uses tier.getClass().getName() might return "packageName.className" instead
            of just "className"
        03/31/2023
            - inserted javadoc comments

    Important Notes:
    -

    to-do:
        - try to implement MORE exception handling?
 */

// will use a hashmap to store Passenger objects
import java.io.IOException;
import java.util.HashMap;
import java.io.FileInputStream;
import java.util.Scanner;


/**
 * A class that includes two methods: promptUser() and main(). These methods read in a file, store the contents
 * from that file accordingly in a data structure, and ask the user for an item from that populated data structure.
 */
public class Main {
    /**
     * Prompts the user for a Passenger ID and displays information for that inputted Passenger ID.
     * @param hashPass is the HashMap data structure that contains Passenger objects.
     */
    public static void promptUser(HashMap<String, Passenger> hashPass) {
        Scanner scnr = new Scanner(System.in);
        String idInput = "Default Input (No input was entered)";
        boolean continueLoop = true; // remains true until the user enters the sentinel value I chose ('?').


        // This while loop continuously prompts the user for a Passenger ID until the user enters the sentinel value I
        // chose ('?'). If a valid ID is entered, the Passenger object will be retrieved from the HashMap and its
        // information will be displayed. If an invalid ID is entered, a Passenger object will try to be retrieved,
        // but no ID exists in the populated HashMap and a NullPointerException will be thrown and handled.
        while (continueLoop) {
            try {
                System.out.println("Enter a Passenger ID (or type '?' to quit the program): ");
                idInput = scnr.next();

                if (idInput.equals("?")) {
                    System.out.println("\n\tYou have entered '?'. Quitting program...");
                    continueLoop = false;
                } else {
                    Passenger passObj = hashPass.get(idInput); // get passenger object from input and store into reference variable
                    System.out.println(passObj.getPromptOutput());
                    System.out.println("===============================================================================");
                }
            }
            catch(NullPointerException nullPointerException) {
                System.out.println("\n\tThe Passenger ID you have entered, " + '"' + idInput + '"' + ", does not exist.");
                System.out.println("===============================================================================");
            }
        }


    }


    /**
     * Opens the input file and reads in each line to either create a new Passenger object that will be stored into
     * a HashMap of Passenger objects or retrieve an update a Passenger object that already exists in the HashMap.
     * @param args -- takes in a String array
     * @throws IOException -- for input/output exceptions + FileNotFound exceptions
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream;
        Scanner inFS;


        // Open + create scanner for input file
        fileInputStream = new FileInputStream("flight-data.txt");
        inFS = new Scanner(fileInputStream);

        // Create hashmap object
        HashMap<String, Passenger> hashPass = new HashMap<>();


        // Read in file
        // Read in + parse each line
        while(inFS.hasNextLine()) {
            String line = inFS.nextLine();
            String id = line.substring(0, line.indexOf(" ")); // get id from line
            String cancelled = line.substring(line.indexOf(" ") + 1, line.indexOf(" ") + 2); // get second character from line which is "Y" or "N" for if flight was cancelled


            // if a certain id already exists in the hashmap, then just update that passenger; don't create new passenger object
            if(hashPass.containsKey(id)) {
                // Each line represents a line for a passenger
                Passenger passObj = hashPass.get(id);

                if(cancelled.equals("Y")) {
                    passObj.addFlight(true);
                    // complained should be placed inside this if block
                    String complained = line.substring(line.lastIndexOf(" ") + 1); // get last character which is complained if flight was cancelled

                    if(complained.equals("Y")) {
                        passObj.setHasComplainedTrue();
                    }
                }
                else {
                    passObj.addFlight(false);
                }

                // Should be in this if block where the passenger object already exists in the hash map
                passObj.determineTier();
            }
            else {
                Passenger passObj = new Passenger(id);

                // Passenger object is different from the passObj in the if block above
                if(cancelled.equals("Y")) {
                    passObj.addFlight(true);
                    String complained = line.substring(line.lastIndexOf(" ") + 1); // get last character which is complained if flight was cancelled

                    if(complained.equals("Y")) {
                        passObj.setHasComplainedTrue();
                    }

                }
                else {
                    passObj.addFlight(false);
                }

                // Only in this else block, would not "put" passObj in the if block above
                hashPass.put(id,passObj);
            }

        }
        // Outside of while loop

        // Close input file stream
        fileInputStream.close();

        // System.out.println(hashPass); // Print out hashmap -- just for debugging

        // HashMap hashPass has been populated by the while loop
        promptUser(hashPass);


    }
}
