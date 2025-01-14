# Bank-Management-System
A simple and secure Bank Management System (ATM SIMULATOR) developed in Java using Swing for the user interface and MySQL for database management. This system allows users to perform basic banking operations like creating an account, logging in, making deposits/withdrawals, changing PIN, checking balance, and more.
<br><br>

## TECHNOLOGIES USED     
Java :-  Core programming language.               
Swing & AWT :-  For building the graphical user interface (GUI).                   
MySQL :-  For managing user accounts and transactions.  
<br><br>

## FEATURES   
### User Registration & Login                
User can register and log in to the system.               
User can change PIN and view mini statements.                    

### Banking Operations              
Deposit :-  Deposit money into the bank account.                
Withdraw :-  Withdraw money from the bank account, with balance checking.                        
Fast Cash :-  Quickly withdraw predefined amounts.                        
Balance Enquiry :-  Check the current balance.                            
Mini Statement :-  View recent transactions.                        

### Security Features                                  
PIN-based authentication for secure access to the system.                        
Validation to ensure all fields are filled properly.

### Database Integration                           
User data, transactions, and account information are stored in a MySQL database.                               
<br><br>


# FILE STRUCTURE   
```
src
├── database_setup.sql
├── config.properties
├── icons
└── bank.management.system 
     ├── BalanceEnquiry.java
     ├── Conn.java
     ├── Deposit.java
     ├── FastCash.java
     ├── Login.java
     ├── MiniStatement.java
     ├── PinChange.java
     ├── Transaction.java
     ├── Withdraw.java
     ├── SignupOne.java
     ├── SignupThree.java
     ├── SignupTwo.java
     └──JIntegerField
          ├── JIntegerPasswordField.java
          └──JIntegerTextField.java
```
     
BalanceEnquiry.java -  Displays current account balance. 
Conn.java -  Manages database connection.                 
Deposit.java -  Handles the deposit operation.                 
FastCash.java -  Facilitates quick withdrawals.              
Login.java -  Handles the login process.               
MiniStatement.java -  Displays recent transactions.                 
PinChange.java -  Allows users to change their PIN.                    
SignupOne.java, SignupTwo.java, SignupThree.java -  User registration process.                  
Transaction.java -  Main screen after login, offering various banking operations.                           
Withdraw.java -  Handles the withdrawal operation.                                   
<br><br>

# DATABASE SETUP      
          
### Using Command Line  
1. navigate to folder containg database_setup.sql file
   ```bash
   cd src/database_setup.sql
   ```
2. Log into MySQL (replace root with your MySQL username, and you'll be prompted for your password).      
   ```bash
   mysql -u root -p
   ```                      
3. Once logged into MySQL, execute the SQL script by running                        
   ```bash
   source database_setup.sql
   ```                   

### Using MySQL Workbench      
1. Open MySQL Workbench.          
2. Connect to your MySQL server using your credentials.                    
3. File > Open SQL Script and select the database_setup.sql file.               
4. click the lightning bolt icon (or press Ctrl+Shift+Enter) to execute the SQL commands.                
<br><br>


## How to Run             
1. Clone the repository           
2. Import the project into your IDE.           
3. Ensure that MySQL is running and the database and tables are set up as described above.
4. create ```config.properties``` file containing mySql credentials in the root directory of your project
   ```bash
   db.url = jdbc:mysql://localhost:3306/bankSystem
   db.username = root
   db.password = password
   ```      
5. Run the ```Login.java``` class to start the application.              
<br><br>

# some smaple screenshots              
### Login Screen            
![image](https://github.com/user-attachments/assets/4ea40c71-2e2e-4613-9238-f2689b5225f9)                 
                      

### Signup Screen        
![image](https://github.com/user-attachments/assets/f6e2be36-7e66-408b-9ad2-a3e0d80fbc68)                 
      

### Main Transaction Screen             
![image](https://github.com/user-attachments/assets/af33bd94-c163-4206-9bdb-64080ec32f16)                  
                

### Withdraw Screen            
![image](https://github.com/user-attachments/assets/7eb82535-f29c-4e3f-b316-b114e97fb3e5)                 

### Mini Statement screen           
![image](https://github.com/user-attachments/assets/a0c8cf4c-14d5-4610-8e6e-ed9b4824505a)
                  

