

package QUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Overrides {

	static int roomnum= 0;
	static int num = 0;
	public Overrides() {
	}

public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	//System.out.println("Helloooooooooooooo");
		
	int roomNumber = logMaintenanceInfo(65, "The ac is broken and the fan fell of the ceiling");
	
	String newroom = Room.TrackAvaliableRooms("Rooms.txt","K");

	
	String oldroomnumber = changeroomstatus("Rooms.txt",6);
	
		
	changeRoom("EmployeeRooms.txt", newroom,oldroomnumber);
	//System.out.println(oldroomnumber);
	
	//changeroomstatustoavailable("Rooms.txt", 65);

}
public static int logMaintenanceInfo(int roomNumber, String info) throws IOException {
	//FileWriter myWriter = null;
	try {
	if ((roomNumber == 0 ) || (roomNumber > 500)) {
		System.out.println("Please enter valid room number");
	}else {
		FileWriter myWriter = new FileWriter("Maintenance.txt", true);
		myWriter.write("Room"+roomNumber +":" +info);
		myWriter.write("\r\n");
		myWriter.close();
		}
	}catch (IOException e) {
		System.out.println("An error has occured");
	}
	return roomNumber;
}


		
public static String changeroomstatus(String rfile, int roomNumber) throws IOException{
        
	File f1=new File(rfile); //Creation of File Descriptor for input file
    String[] words=null;  //Initialize the word Array
    FileReader fr = new FileReader(f1);  //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
    FileWriter writer = null;
    String s;
    String id;
    String oldLine = "";
    String newLine;
       
        
    // String input="Java]";   // Input word to be searched
    int count=0;   //Intialize the word to zero
    //System.out.println(roomNumber);
    if(roomNumber != 0){
    	try{    
    		while((s=br.readLine()) !=null) //Reading Content from the file
            {
    			num = 0;
                //System.out.println(s);
                String line [] =s.split(" ");
                roomnum = Integer.parseInt(line[0]);
                Integer.toString(roomNumber);
                System.out.println("HIIIIIIIIIIIIIIII");
                if(roomNumber == roomnum){
                	System.out.println("HIIIIIIIIIIIIIIII");
                	System.out.println(roomNumber);
                	System.out.println(roomnum);
                	count++;
                    id = line[0];
                    
                    //System.out.println(id);
                    //oldLine = oldLine + s + System.lineSeparator();
                    if (s.contains("Available")) {
                    	System.out.println("HIIIIIIIIIIIIIIII");
                        newLine = s.replace("Available", "Closed");
                    }else{
                        newLine = s.replace("N/A", "Closed");	
                    }     
                    oldLine = oldLine + newLine + System.lineSeparator();
                    //System.out.println(newLine);
                        
                    writer = new FileWriter(f1);
                    writer.write(newLine);
                    }else{
                        oldLine = oldLine + s + System.lineSeparator();               
                        writer = new FileWriter(f1);
                        writer.write(oldLine);     
                        num++; 
                        System.out.println("HIIIIIIIIIIIIIIII");
                    }   
                }
            } catch (IOException ex){
                	System.out.println("File not found");
            }
            finally{
                fr.close();
                writer.close();
            }
        //System.out.println("Room "+ roomNumber+" closed for maintenance");  
            //System.out.println("Room number invalid");
        }
			//if (num > 0) {
				//System.out.println("Room Number is invalidd");}
		String oldroomNumber = Integer.toString(roomNumber);
		return oldroomNumber;
}       
   

public static void changeRoom(String efile, String newroom, String oldroomNumber) throws IOException {
	File f1=new File(efile); //Creation of File Descriptor for input file
    String[] words=null;  //Initialize the word Array
    FileReader fr = new FileReader(f1);  //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
    FileWriter writer = null;
    String s;
    String id;
    String oldLine = "";
    String newLine;
    
   // String input="Java]";   // Input word to be searched
    int count=0;   //Intialize the word to zero
    if(newroom != ""){
        try{    
            while((s=br.readLine()) !=null) //Reading Content from the file
            {
                //System.out.println(s);
                String line [] =s.split(" ");
                //String roomnum = line[2];
                //System.out.println(newroom);
               // System.out.println(roomnum);
               // System.out.println(oldroomNumber);
               // System.out.println(s);
                //System.out.println(line[2]);
                if(s.contains(oldroomNumber)) {
                    
                	//String newstring = Integer.toString(newroom);
                	//System.out.println("yes");
                        String roomtype = line[3];
                        String rum = Room.TrackAvaliableRooms("Rooms.txt",roomtype);
                	newLine = s.replace(oldroomNumber, rum);
                    oldLine = oldLine + newLine + System.lineSeparator();
                    //System.out.println(oldLine);
                }else {
                	//System.out.println("Cant find room number");
                	oldLine = oldLine + s + System.lineSeparator();
                	writer = new FileWriter(f1);
                    writer.write(oldLine);
                }
            } 
        }catch (IOException ex){
                 ErrorHandling er = new ErrorHandling("Save File not found","");
                er.setVisible(true);;
            }
            finally{
                fr.close();
                writer.close();}
}
}  
public static String changeroomstatustoavailable(String rfile, int roomNumber) throws IOException{
    
	File f1=new File(rfile); //Creation of File Descriptor for input file
    String[] words=null;  //Initialize the word Array
    FileReader fr = new FileReader(f1);  //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
    FileWriter writer = null;
    String s;
    String id;
    String oldLine = "";
    String newLine;
       
        
    // String input="Java]";   // Input word to be searched
    int count=0;   //Intialize the word to zero
    System.out.println(roomNumber);
    if(roomNumber != 0){
    	try{    
    		while((s=br.readLine()) !=null) //Reading Content from the file
            {
    			num = 0;
                //System.out.println(s);
                String line [] =s.split(" ");
                roomnum = Integer.parseInt(line[0]);
                
                if(roomNumber == roomnum){
                	System.out.println(roomNumber);
                	System.out.println(roomnum);
                	count++;
                    id = line[0];
                    //System.out.println(id);
                    //oldLine = oldLine + s + System.lineSeparator();
                    if (s.contains("Closed") ) {
                        newLine = s.replace("Closed", "Available");
                    }else{
                        newLine = s.replace("N/A", "Available");	
                    }     
                    oldLine = oldLine + newLine + System.lineSeparator();
                    //System.out.println(newLine);
                        
                    writer = new FileWriter(f1);
                    writer.write(newLine);
                    }else{
                        oldLine = oldLine + s + System.lineSeparator();
                        
                        writer = new FileWriter(f1);
                        writer.write(oldLine);     
                        num++;    
                    }   
                }
            } catch (IOException ex){
                ErrorHandling er = new ErrorHandling("Save File not found","Invalid Entry");
                er.setVisible(true);;
            }
            finally{
                fr.close();
                writer.close();
            }
        //System.out.println("Room "+ roomNumber+" closed for maintenance");  
            //System.out.println("Room number invalid");
        }
        else{
            try{    
                while((s=br.readLine()) !=null) //Reading Content from the file
                {
                    ErrorHandling er = new ErrorHandling("Room of this type is not available ","");
                    er.setVisible(true); }
    
            } catch (IOException ex){
                ErrorHandling er = new ErrorHandling("Save File not found","Invalid Entry");
                er.setVisible(true);;
            }
            finally{
                fr.close();
            }
        }
    String oldroomNumber = Integer.toString(roomNumber);
	return oldroomNumber;
}
}







