
<h1>Airline-Rewards-System</h1>

This project parses a text/.txt file containing flight passenger information and determines what airline tier that passenger belongs to.
<br><br>

<details open>
<summary>
   <b>About the Project (Background, Purpose)</b>
</summary>
<br>
This is an academic project that highlights the use of data structures (HashMaps), inheritance, polymorphism, abstraction, encapsulation, and error handling.
<br><br>
</details>




<details>
<summary>
   <b>Project Info (How it Works)</b>
</summary>   
</details>




<details open>
<summary> 
   <b>How to Run the Program</b> 
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
   <b>Text File Contents</b>
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
<ul><li>Notice that if a flight was not cancelled (denoted as 'N' in the second field), there is no third field for if the passenger complained or not.</li><li>The file <b>IS</b> supposed to contain duplicate lines. This determines if a passenger belongs in a tier (Gold, Platinum, Platinum Pro, Executive Platinum, Super Executive Platinum) or not (ConcreteTier).</li></ul></pre>
<br><br>
</details>




<details open>
<summary>
   <b>Demo</b>
</summary>   
</details>
