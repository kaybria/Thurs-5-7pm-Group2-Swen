package QUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.time.format.DateTimeFormatter;
//import java.io.File;
import java.time.LocalDateTime;
public class Employee {
    private String name;
    private String roomType;
    private String roomNum;
    private String currentDatetxt;
    private double balance;
    private double bal;
    private Room room;
    private LocalDateTime rentDue;
    private String endDate;
    private int lengthStay;
    final static double kingroom = 24;

    final static double doubleroom = 23;
    public Employee() {

    }

    public Employee(String name, String roomType, double balance) {
        this.name = name;
        this.roomType = roomType;
        this.balance = balance;
        System.out.println(balance);
    }

    public double getBalance() {
        return balance;

    }
    
    public String getName(){
        return name;
    }

    public String getRoomType() {
        return roomType;
    }
    
    public String getRoomNum(){
        return roomNum;
    
    }
    

    public int getLenghtStay() {
        return lengthStay;
    }

    public void setRentDue(LocalDateTime rentDue){
        this.rentDue = rentDue;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void setRoom(Room room){
        this.room = room;
    }
    
    public void setRoomNum(String num){
        this.roomNum = num;
    }
    


    public void calculationLenStay() {
         final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MMMM yyyy  HH:mm:ss", Locale.ENGLISH);
         LocalDateTime now = LocalDateTime.now();
         currentDatetxt = now.toString();



        if (roomType.equals("K")) {
            double length = balance / kingroom;
            lengthStay = (int) length;
            double remainingBal = balance - (lengthStay * kingroom) ;
            bal = remainingBal;
            System.out.println("Length of stay is: " + length + "days");
            System.out.println("Remaining Balance is: $" + remainingBal);
            LocalDateTime date = LocalDateTime.now();
            rentDue = date.plusDays(lengthStay);
            endDate = rentDue.toString(); 
            System.out.println("Rent for this employee is due: " + rentDue);


        } else if (roomType.equals("D")) {
            double length = balance / doubleroom;
            lengthStay = (int) length;
            double remainingBal = balance - (lengthStay * doubleroom) ;
            bal = remainingBal;
            System.out.println("Length of stay is : " + lengthStay + "days");
            System.out.println("Remaining Balance is: $" + remainingBal);
            LocalDateTime date = LocalDateTime.now();
            rentDue = date.plusDays(lengthStay);
            endDate = rentDue.toString();
            System.out.println("Rent for this employee is due: " + rentDue);

        } else {
            System.out.println("Invalid Room Type Entered.");// ref to gui and end process
        }


    }
    
   
   
    public void save(){
       room = new Room(roomType);
       
       if (roomNum == null){
       setRoomNum(room.getRoomNumber());
       Report report = new Report(name,bal,roomType,roomNum,currentDatetxt,endDate);
       }else{
       Report report = new Report(name,bal,roomType,roomNum,currentDatetxt,endDate);
       }
   
   // create reprt and send name, balance, room type and room number as an array or string
    }

}

