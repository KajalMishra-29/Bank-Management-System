# Bank-Management-System
A simple and secure Bank Management System (ATM SIMULATOR) developed in Java using Swing for the user interface and MySQL for database management. This system allows users to perform basic banking operations like creating an account, logging in, making deposits/withdrawals, changing PIN, checking balance, and more.
<br><br>

<b>TECHNOLOGIES USED</b>      

Java :-  Core programming language.               
Swing & AWT :-  For building the graphical user interface (GUI).                   
MySQL :-  For managing user accounts and transactions.  
<br><br>

<b>FEATURES</b>    

-> User Registration & Login                
User can register and log in to the system.               
User can change PIN and view mini statements.                    

-> Banking Operations              
Deposit :-  Deposit money into the bank account.                
Withdraw :-  Withdraw money from the bank account, with balance checking.                        
Fast Cash :-  Quickly withdraw predefined amounts.                        
Balance Enquiry :-  Check the current balance.                            
Mini Statement :-  View recent transactions.                        

-> Security Features                                  
PIN-based authentication for secure access to the system.                        
Validation to ensure all fields are filled properly.

-> Database Integration                           
User data, transactions, and account information are stored in a MySQL database.                               
<br><br>


<b>FILE STRUCTURE </b>        

bank.management.system :-  Contains all Java classes for the application.              
Conn.java :-  Manages database connection.                 
Login.java :-  Handles the login process.               
SignupOne.java, SignupTwo.java, SignupThree.java :-  User registration process.                  
Transaction.java :-  Main screen after login, offering various banking operations.                           
PinChange.java :-  Allows users to change their PIN.                    
Deposit.java :-  Handles the deposit operation.                 
Withdraw.java :-  Handles the withdrawal operation.                         
FastCash.java :-  Facilitates quick withdrawals.              
MiniStatement.java :-  Displays recent transactions.                 
BalanceEnquiry.java :-  Displays current account balance. 
database_setup.sql :-  commands for setting up database.          
<br><br>


<b>DATABASE SETUP</b>           

open database_setup.sql file (SQL script)            
use either the MySQL command line or MySQL Workbench to execute the SQL script.           

1. Using MySQL Command Line :               
Open the MySQL Command Line Client or Terminal.          
Log into MySQL:            
![image](https://github.com/user-attachments/assets/bf343ce6-b465-40b0-bf8c-8af67b467e7b)                 
(replace root with your MySQL username, and you'll be prompted for your password).                    
                       
Once logged into MySQL, execute the SQL script by running:                         
![image](https://github.com/user-attachments/assets/49c0188b-88f7-4433-98bd-3d7a72d1a9d0)                            
Replace /path/to/database_setup.sql with the actual path to your database_setup.sql file.                        

2. Using MySQL Workbench :          
Open MySQL Workbench.          
Connect to your MySQL server using your credentials.              
Open the database_setup.sql file:               
Click File > Open SQL Script and select the database_setup.sql file.               
Run the script:             
After the script is loaded, click the lightning bolt icon (or press Ctrl+Shift+Enter) to execute the SQL commands.                
<br><br>


<b>How to Run </b>            
1. Clone the repository           
2. Import the project into your IDE.              
3. Ensure that MySQL is running and the database and tables are set up as described above.          
4. Run the <b>Login.java</b> class to start the application.              
<br><br>

<b>some smaple screenshots</b>               
<br>
Login Screen            
![image](https://github.com/user-attachments/assets/4ea40c71-2e2e-4613-9238-f2689b5225f9)                 
                      

Signup Screen        
![image](https://github.com/user-attachments/assets/f6e2be36-7e66-408b-9ad2-a3e0d80fbc68)                 
      

Main Transaction Screen             
![image](https://github.com/user-attachments/assets/af33bd94-c163-4206-9bdb-64080ec32f16)                  
                

Withdraw Screen            
![image](https://github.com/user-attachments/assets/7eb82535-f29c-4e3f-b316-b114e97fb3e5)                 

Mini Statement screen           
![image](https://github.com/user-attachments/assets/fcc129fd-cd4c-414b-a7e4-829aea83c406)                   

