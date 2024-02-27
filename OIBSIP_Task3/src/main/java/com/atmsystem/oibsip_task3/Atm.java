package com.atmsystem.atm_interface;
import java.util.Scanner;


class Account{
String Names;
String Surname;
String Accountno;
String Password;
float Balance = 50000f;
float Deposit =0 ;
int Transaction = 0;
String TransactionHistory = "";


public void Register(){
 Scanner scan = new Scanner(System.in);

System.out.println("\nEnter Your Names:");
    this.Names = scan.nextLine();
System.out.println("\nEnter Your Surname:");
    this.Surname = scan.nextLine();
System.out.println("\nEnter Your Account:");
this.Accountno = scan.nextLine();
System.out.println("\nEnter Your Password:");
    this.Password = scan.nextLine();
    System.out.println("\nRegistration Succesful.");
    System.out.println("\n------ Hello ------");
}

public boolean Login(){
boolean isLogin = false;
Scanner scan = new Scanner(System.in);
while (!isLogin){
    System.out.println("\nEnter Account Number:");
String accountNo = scan.nextLine();
if (accountNo.equals(Accountno)){
while(!isLogin){
    System.out.println("\nEnter Password:");
String password = scan.nextLine();
if(password.equals(Password)){
    System.out.println("\nLogin Successful.");
    System.out.println("\n------ WELCOME ------");
isLogin = true;
}
else{
    System.out.println("\nInvalid Password.");
}
}
}
else{
    System.out.println("\nAccount Number Not Found.");
}
}
return isLogin;
}

public void Withdraw(){
    System.out.println("Please input the amount you wish to withdraw:");
Scanner scan = new Scanner(System.in);
float Amount = scan.nextFloat();
try{

if (Balance>= Amount){
Transaction++;
Balance -= Amount;
    System.out.println("\nApproved. \nYour withdrawal has been successfully processed.");
String st = "R " + Amount + " is withdrawn.\n";
TransactionHistory = TransactionHistory.concat(st);

}
else{
    System.out.println("\nDeclined.");
}
}
catch (Exception e){
 }
}

public void Deposit(){
    System.out.println("\nPlease enter the amount you wish to deposit: ");
Scanner scan = new Scanner(System.in);
float Amount = scan.nextFloat();

try{

if(Amount <= 50000){
Transaction++;
Balance = Balance +Amount;
    System.out.println("\nYour funds have been credited..");
String st ="R " + Amount + " is credited.\n";
TransactionHistory = TransactionHistory.concat(st);
}
else{
    System.out.println("\nYour Limit Is 50000.00");
}
}
catch (Exception e){
}
}

public void Transfer(){
Scanner scan = new Scanner(System.in);
    System.out.println("\nEnter The Receipent Name: ");
String receipent = scan.nextLine();
    System.out.println("\nEnter Amaount To Tranfer: ");
float Amount = scan.nextFloat();

try{
if(Balance>= Amount){
if(Amount<= 10000){
Transaction++;
Balance -= Amount;
    System.out.println("Transfered Successful to " + receipent);
String st ="R " + Amount + " is trasnfered To " + receipent + "\n";
TransactionHistory = TransactionHistory.concat(st);
}
else{
    System.out.println("\nDeclined. Limit is 10000.");
}
}
else{
    System.out.println("\nInsufficient funds.");
}
}catch (Exception e){
}
}

public void CheckBalance(){
    System.out.println("\n" +"R " + Balance);
}

public void TransactHistory(){
if(Transaction ==0){
    System.out.println("\nEmpty.");
}
else{
    System.out.println("\n " + TransactionHistory);
}
}
}


public class Atm {
   public static int takeIntIn(int Limit){
   int Input =0;
   boolean Flag =false;

while(!Flag){
try{
Scanner scan = new Scanner(System.in);
Input = scan.nextInt();
Flag = true;
if(Flag && Input > Limit || Input < 1){
    System.out.println("Choose Limit Between 1 To " + Limit);
Flag = false;
}
} 
catch (Exception e){
    System.out.println("Please enter an integer value only.");
Flag = false;
}
};
return Input;
}

public static void main (String[] main){
    System.out.println("\n------ Welcome to JPP ATM! How can I assist you today? ------");
    System.out.println("Please select an option from the list below:");
    System.out.println("1. Register \n2. Quit");
int choice = takeIntIn(2);

if(choice ==1){
Account a = new Account();
a.Register();
while(true){

    System.out.println("\nPlease select an option from the list below:");
    System.out.println("\n1.Login \n2. Quit");
int choy = takeIntIn(2);
if(choy ==1){
if(a.Login()){
    System.out.println("\n\n------ Welcome back! " + a.Names +". How may I assist you today? " + " ------\n");
boolean isFinished = false;
while(!isFinished){
    System.out.println("\nPlease select an option from the list below:");
    System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Quit");
    
int cho = takeIntIn(6);
switch(cho) {
case 1:
a.Withdraw();
break;
case 2:
a.Deposit();
break;
case 3:
a.Transfer();
break;
case 4:
a.CheckBalance();
break;
case 5: 
a.TransactHistory();
break;
case 6:
isFinished = true;
break;
}
}
}
}
else{
System.exit(0);
}
}
}
else{
System.exit(0);
}
}
}



