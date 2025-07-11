<h1 align="center">Airline-Rewards-System</h1>

<p align="center">
   <img src="assets/sky-plane-256.gif" alt="Plane flying"/>
</p>
<p align="center">
   <a href="https://pixabay.com/gifs/plane-aviator-vacation-airplane-83/" target="_blank">GIF Credits</a>
</p>

This is an academic project that is essentially a rewards program for passengers who have stayed loyal to an airline.
<br>
It is written in Java and includes data structures (HashMaps), inheritance, polymorphism, abstraction, interfaces, encapsulation, error handling, and heavy documentation (code comments!).
<details open>
<summary>
   <h3>About (Project Summary & Specifications)</h3>
</summary>
<br>
<b>Summary</b><br>
This project determines the rewards tier for passengers based on their number of accumulated miles (larger amount of accumulated miles = higher rewards tier); the number of accumulated miles is determined
by the number of cancelled flights a passenger had within a single year -- each cancelled flight is initially worth 1000 miles.<br>Moreover, if a passenger never complained after having multiple cancelled flights for the ENTIRE year, they earn the mileage multiplier, which doubles the number of accumulated miles for a single flight cancellation (1000 miles --> 2000 miles per each cancelled flight).
<br>
<br>
<b>Specifications</b>
<br>
<pre>
<b>File input</b>:
A text/.txt file called "flight-data.txt" containing flight passenger data is preloaded in the Main.java.
More information about the file can be found in the Text File Contents section.
<br>
<b>Reward Tiers</b>, based on miles earned / flights cancelled within a single year:
<li><b>Gold</b>: 25 flight cancellations. Each cancellation is worth 1000 miles.
<li><b>Platinum</b>: 50 flight cancellations. Each cancellation is worth 1000 miles.
<li><b>Platinum Pro</b>: A special sub-tier of Platinum, reserved for those passengers with the mileage multiplier. This will earn double the miles per cancelled flight (2000 miles) for passengers who did not complain about flight cancellations at all throughout the year.
<li><b>Executive Platinum</b>: 100 flight cancellations. Each cancellation is worth 1000 miles.
<li><b>Super Executive Platinum</b>: A special sub-tier of Executive Platinum, reserved for those passengers with the mileage multiplier. This will earn double the miles per cancelled flight (2000 miles) for passengers who did not complain about flight cancellations at all throughout the year.
<br>
<b>Mileage Multipler</b>:
The flights are in no/random order (<b>not</b> chronological) in the file; the mileage multiplier is applied after the entire file is read (i.e., the multiplier is not applied while the program is still reading each line).
</pre>
<br><br>
</details>



<details open>
<summary> 
   <h3>How to Run the Program </h3> 
</summary>

<pre>
1. First have the following installed:
   - Java (JDK): for "javac java" commands
2. Download the project on local machine
3. Navigate to project directory using CLI
<br>
<b>Terminal on MacOS</b>
4. Type "javac Main.java" to compile Main.java in the Terminal
5. Type "java Main.java" to run the program
<br>
6. A prompt will pop up in the console/terminal telling you to input Passenger ID. Passenger IDs range from "101" - "135".
7. Typing a question mark '?' will quit the program
</pre>

&emsp;&emsp;To be continued on other CLIs...
<br><br>
</details>




<details>
<summary>
   <h3>Text File Contents</h3>
</summary>
   
<pre>
Each line in the text file contains passenger and flight data.
The entire file contains data for a single year.
The data in each line is and <b>MUST</b> be structured a certain way:
<br>
&emsp;&emsp;[Passenger ID]&emsp;<b>space</b>&emsp;[Flight Cancelled]&emsp;<b>space</b>&emsp; [Passenger Complained]
<br>
The Passenger ID is a 3-digit number to represent the ID of the passenger.
The Flight Cancelled is a 'Y' or 'N' character to represent "Yes" or "No" respectively to answer the question of if a flight was cancelled or not.
The Passenger Complained is a 'Y' or 'N' character to represent "Yes" or "No" respectively to answer the question of if the passenger complained to a <b>CANCELLED</b> flight.<br><br>
<b>Important Notes about File Contents:</b>
<li>Notice that if a flight was not cancelled (denoted as 'N' in the second field), there is no third field for if the passenger complained or not.
<li>The file <b>IS</b> supposed to contain duplicate lines.
<li>The flights are in random order (<b>NOT</b> chronological); the mileage multiplier is applied after the entire file is read (i.e., the multiplier is not applied while the program is still reading each line).
</pre>
<br><br>
</details>




<details open>
<summary>
   <h3>Demo</h3>
</summary>
<pre>
<b>How the Program Works (a bit condensed, but still lengthy explanation)</b>
The program involves reading each line from the file.
If a passenger ID exists in the HashMap as a key, then do not create a new Passenger object as the value; else, 
create a new Passenger object and set the object as the value and set the ID as the key -- Entries 
that already exist in the HashMap are only updated.
<br>
Note, a passenger can complain the first time its ID is read in the program.
<br>
Each Passenger object has an ID field, complained field, and ConcreteTier field.
The ConcreteTier implements the Tier interface, and the other Tier classes inherit from ConcreteTier.
The Tier interface has methods to increment cancelled and 
non-cancelled flights, get the number of cancelled and non-cancelled flights, and get the number of miles from the 
cancelledFlights field (cancelledFlights * 1000).
The Tier classes that have the multiplier (Platinum Pro and Super Executive Platinum) override the getMiles() method
for [cancelledFlights * 2000].
<br>
After the entire file is read, we can prompt the user to enter a passenger ID and display their information.
A method for output in the Passenger object displays the tier, total miles accumulated for the year, 
total flight cancellations for the year, and if the passenger has earned the multiplier.
The output method in the Passenger object uses the fields in the Passenger object for output.
<br>
<b>Actual Demo</b>
</pre>
</details>

<h4>Final Remark: There are many ways to design this program/solution, but this is one design that worked.</h4>
