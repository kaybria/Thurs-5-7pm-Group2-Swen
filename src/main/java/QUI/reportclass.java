package QUI;

import java.io.*;
import java.util.ArrayList;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.time.LocalDateTime;

//class Main{
    //for unit testing
   // public static void main(String arg[]) {
   //        addToDatabase("Orlando Drummonds 500 D 268 ");
   //        //getEmployeeList();
   //         // Search employee("Orlando Drummonds")
   //}
class Report{
        
    private String name;
    private String balance;
    private String roomType;
    private String roomNum;
    private String startDate;
    private String endDate;
    private String employeeRecord;
    
    public Report(){};
    
    public Report(String name, double balance, String roomType, String roomNum, String startDate, String endDate){
        this.name = name;
        this.balance = Double.toString(balance);
        this.roomType= roomType;
        this.roomNum= roomNum;  
        this.startDate = startDate; 
        this.endDate = endDate;
        employeeRecord = this.name + " " + this.balance + " " + this.roomType  + " " + this.roomNum + " " + this.startDate + " " + this.endDate;
        addToDatabase(employeeRecord);
    }

    

    //this returns an arry list of records in the database file
    //takes a sting of the form "firstName lastName Balance roomType roomNumber StartOfRentPeriod  EndOFRentPeriod"
    //called on in GUI to display list of records or intandem with with other methods in class
    public  static ArrayList<String> getEmployeeList(){
        String readerline ;
        ArrayList<String> employeelist= new ArrayList<String>();
        
        try{
        FileReader fr = new FileReader("Databasefile");
        BufferedReader br = new BufferedReader(fr);

            while( (readerline=br.readLine()) != null ){ 
                          
                if(readerline != null){ 
                    employeelist.add(readerline);
                }
            }
            br.close();
        }catch(IOException e){
        e.printStackTrace();
        } 
        return(employeelist);
    }


    //called in Employee to add emplyee record to database
    public static void  addToDatabase(String employeerecord){
        try{
            ArrayList<String> emplist = new ArrayList<String>();
            emplist =getEmployeeList();
            System.out.println(emplist);
            BufferedWriter bw = new BufferedWriter(new FileWriter("Databasefile"));
            for (String record :emplist){
               // System.out.println(record);
                bw.write(record + "\n");
            }
            bw.write(employeerecord);
            bw.close();
           
        }catch(IOException e){
        e.printStackTrace();   
        }
    } 

    //Used only in report class to assist in file editting 
    public static void updateDatabase(ArrayList<String> employeelist){
        try{
         ArrayList<String> emplist = new ArrayList<String>();
            System.out.println(emplist);
            BufferedWriter bw = new BufferedWriter(new FileWriter("Databasefile"));
            for (String record :employeelist){
               // System.out.println(record);
                bw.write(record + "\n");
            }
            bw.close();
        }catch(IOException e){
        e.printStackTrace();   
        }

    }

    //Deletes a record and rewrites file
    public static void deleteRecord(String record){
        ArrayList<String> employeeList = new ArrayList<String>();
        employeeList = getEmployeeList();
        employeeList.remove(record);
        updateDatabase(employeeList);
    }

   //used by Gui to find a record given a name
   //if not found it asks gui to create error window
   public static String searchEmployee(String employename){
       String nameOnRecord;
       for (String record :getEmployeeList()){
               // System.out.println(record);
                nameOnRecord = record.split(" ")[0] + " " + record.split(" ")[1];
                if(employename.equals(nameOnRecord)){
                    return(record);
                }
            }
        //gui call or return message is used in GUI
        return("Employee does not exists") ;
   } 

   //Used to edit a single field of a single record
   //accepts, (as strings) :   1. old record to be changed
   //                          2. new info to be inserted
   //                          3. the type of info to be change "name" , "balnce" , "type" ,"num" , "startdate" ,"enddate"
   public static void editEmployeeRecord(String oldrecord, String newinfo, String infoType){

        String newRecord;
        System.out.println(oldrecord);
        String oldname = oldrecord.split(" ")[0] + " " + oldrecord.split(" ")[1] ;
        System.out.println(oldname);
        String oldBalance = oldrecord.split(" ")[2];
        System.out.println(oldBalance);
        String oldRoomType = oldrecord.split(" ")[3];
        String oldRoomNum = oldrecord.split(" ")[4];
        String oldstartdate = oldrecord.split(" ")[5];
        String oldEndDate = oldrecord.split(" ")[6];
        ArrayList<String> employeelist;
        switch(infoType){
            case "name": 
                newRecord = newinfo + " " + oldBalance + " " + oldRoomType + " " + oldRoomNum + " " + oldstartdate + " " + oldEndDate;
                break;
            case "balance":
                newRecord = oldname + " " + newinfo + " " + oldRoomType + " " + oldRoomNum + " " + oldstartdate + " " + oldEndDate;
                break;
            case "type":
                newRecord = oldname + " " + oldBalance + " " + newinfo + " " + oldRoomNum + " " + oldstartdate + " " + oldEndDate;
                break;
            case "num":
                newRecord = oldname + " " + oldBalance + " " + oldRoomType + " " + newinfo + " " + oldstartdate + " " + oldEndDate;
                break;
            case "startdate":
                newRecord = oldname + " " + oldBalance + " " + oldRoomType + " " + oldRoomNum + " " + newinfo + " " + oldEndDate ;
                break;
            case "enddate":
                newRecord = oldname + " " + oldBalance + " " + oldRoomType + " " + oldRoomNum + " " + oldstartdate + " " + newinfo ;
                break;
            default:
                newRecord ="error with edit";
        }
        
        employeelist = getEmployeeList();
        
        
        employeelist.remove(oldrecord);
        
        
        employeelist.add(newRecord);
        
        
        updateDatabase(employeelist);
        System.out.println(employeelist);

   }





}
