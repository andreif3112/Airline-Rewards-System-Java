<h1 align="center">Airline-Rewards-System</h1>

<p align="center">
   <img src="assets/sky-plane-256.gif" alt="Plane flying"/>
</p>
<p align="center">
   <a href="https://pixabay.com/gifs/plane-aviator-vacation-airplane-83/" target="_blank">GIF Credits</a>
</p>

<details open>
<summary>
   <h3>About (Project Background & Specifications)</h3>
</summary>
<br>
<b>Background</b>
<br>
This is academic project that calculates the rewards for passengers based on their number of miles flown and flights cancelled within a single year.
This Java project highlights the use of data structures (HashMaps), inheritance, polymorphism, abstraction, interfaces, encapsulation, and error handling.
<br>
<br>
<b>Specifications</b>
<br>
<pre>
File input: A text/.txt file called "flight-data.txt" containing flight passenger data is preloaded in the Main.java. More information about the file can be found in the <a href="https://github.com/andreif3112/Airline-Rewards-System/edit/main/README.md#text-file-contents">Text File Contents section</a>.
<br>
<b>Reward Tiers</b>, based on miles earned / flights cancelled within a single year:
<li><b>Gold</b>: 25 flight cancellations. Each cancellation is worth 1000 miles.
<li><b>Platinum</b>: 50 flight cancellations. Each cancellation is worth 1000 miles.
<li><b>Platinum Pro</b>: A special sub-tier of Platinum, reserved for those passengers with the mileage multiplier. This will earn double the miles per cancelled flight (2000 miles) for passengers who did not complain about flight cancellations at all throughout the year.
<li><b>Executive Platinum</b>: 100 flight cancellations. Each cancellation is worth 1000 miles.
<li><b>Super Executive Platinum</b>: A special sub-tier of Executive Platinum, reserved for those passengers with the mileage multiplier. This will earn double the miles per cancelled flight (2000 miles) for passengers who did not complain about flight cancellations at all throughout the year.
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
The data in each line is and <b>MUST</b> be structured in a certain way:
<br>
&emsp;&emsp;[Passenger ID]&emsp;<b>space</b>&emsp;[Flight Cancelled]&emsp;<b>space</b>&emsp; [Passenger Complained]
<br>
The Passenger ID is a 3-digit number to represent the ID of the passenger.
The Flight Cancelled is a 'Y' or 'N' character to represent "Yes" or "No" respectively to answer the question of if a flight was cancelled or not.
The Passenger Complained is a 'Y' or 'N' character to represent "Yes" or "No" respectively to answer the question of if the passenger complained to a <b>CANCELLED</b> flight.<br><br>
<b>Important Notes about File Contents:</b>
<li>Notice that if a flight was not cancelled (denoted as 'N' in the second field), there is no third field for if the passenger complained or not.
<li>The file <b>IS</b> supposed to contain duplicate lines. This determines if a passenger belongs in a tier (Gold, Platinum, Platinum Pro, Executive Platinum, Super Executive Platinum) or not (ConcreteTier).
</pre>
<br><br>
</details>




<details open>
<summary>
   <h3>Demo</h3>
</summary>   
</details>
