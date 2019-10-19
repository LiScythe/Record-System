
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class Program {
	
	public static TurtleRecord myturtle = new TurtleRecord(); // this is declaring the other class and at the same time creating new record. This is the friend of arrayList
	
	public static Scanner in = new Scanner(System.in); // declarinf scanner( better declare once and close once to avoid out of bound exception, line not found.) For example I close it once in main method

	public static void main(String[] args) throws ParseException // this throw parseexeption existed because Im using parsing.
	
	{
		 emptyScreen();//this is clear screen method to create new beautiful interface
		 boolean x = false;//this is flag
		
		 
		while (x == false){ // display out menu untill user want to quit
			
		 System.out.println("\n\n\n\t\t\t--------------------------------------------WELCOME TO PENYU MAMI AND THE GENG SDN BHD------------------------------ ");
		 System.out.println("\n\n\n\t\t\t------------------------------------------------PLEASE CHOOSE FROM THE MENU-----------------------------------------\n\n\n ");
	     System.out.println("\t\t\t\t\t\t\t\t\tPress 1 -> Add Turtle Record\n\n");
	     System.out.println("\t\t\t\t\t\t\t\t\tPress 2 -> Edit Turtle Record\n\n");
	     System.out.println("\t\t\t\t\t\t\t\t\tPress 3 -> Delete Turtle Record\n\n");
	     System.out.println("\t\t\t\t\t\t\t\t\tPress 4 -> View Turtle Record\n\n");
	     System.out.println("\t\t\t\t\t\t\t\t\tPress 5 -> Search Turtle Record\n\n");
	     System.out.println("\t\t\t\t\t\t\t\t\tPress 6 -> View Turtle Record Summary\n\n");
	     System.out.println("\t\t\t\t\t\t\t\t\tPress 7 -> Close Program\n\n");
		 System.out.println("\t\t\t---------------------------------------------------------------------------------------------------------------------\n\n");
	     System.out.print("\t\t\tChoice:");
		 int y = Integer.parseInt(in.nextLine());// this one of the reason I put throws ParseException on the above
	     System.out.println("\n\n\t\t\t---------------------------------------------------------------------------------------------------------------------");
	   
	    
		switch(y)//this switch bring you to the function/method pages where real thingy gets real :D Magic!
	     {
	     case 1:
	     {
	    	 emptyScreen();
	    	 add();
	    	 Program.main(new String[0]);//this is how we call main method in java
	    	 break;
	     }//end case1
	     
	     case 2:
	     {
			 emptyScreen();
	    	 System.out.print("\n\t\t\t\t\tEnter ID to Edit: "); // enter turtle ID you want to edit. eg:1111~
				int input = Integer.parseInt(in.nextLine());
				for (int index = 0; index < myturtle.size(); index++)// the program/our cute java will go thru all record first
				{
					if(myturtle.getPenyu(index).getID()==(input))//then here if it find any index contain ID equal to your input, you can edit ;)
					{
						displayafteredit(index);//this to show you before edit record (sebelum) like the makeup one~ before make up gitu
						edit(index);
						displayafteredit(index);//this to show you after edit record (selepas) like after makeup~
						
				}
				
				}
						
		 
				for (int index = 0; index < myturtle.size(); index++)// of not found after go thru, it tell you Not Found..
				{
					if(myturtle.getPenyu(index).getID()!=(input))
					{
						emptyScreen();
						System.out.println("Not Found..\n\n\n\n\n\n");
						Program.main(new String[0]);
						break;
					}
					
				}
	    	
	    	 break;
	     }//end case2
	     
	     case 3:
	     {
			 emptyScreen();
	    	 delete();//this is delete method
	    	 break;
	    	 
	     }//end case3
	     case 4:
	     {
			 emptyScreen();
	    	 view();//this is to view all record
	    	 break;
	     }//end case4
	     
	     case 5:
	     {
			 emptyScreen();
	    	 search();// this is to search method (based on location,minimum weight and maximum weight
	    	 break;
	     }//end case5
	     
	     case 6:
	     {
			 emptyScreen();
	    	 summarize();//summarizing the record by two method : Location & Location and Date Range
	    	 break;
	     }//end case6
		 
		 case 7:
		 {
			 emptyScreen();
			 bye();//bye bye exit function
			 break;
		 }
		 
	     }//end switch
		}
	     
	     in.close();//haaa! this what I mean. close the scanner only once here ~ at main method so we can avoid that "no line found" error :D

		
	}//main end
	
	
		public static void add() throws ParseException //this where the magic start, we add record *_* fill in the data below correctly so the java woulf not get upset and gives errors
		
		{
			System.out.println("\n\n\n\t\t\t\t---------------------------------------------Add Turtle Info-------------------------------------------------");
			System.out.print("\n\t\t\t\t\t\t\t\t\tEnter ID: ");
	        int id = Integer.parseInt(in.nextLine()); 
			System.out.print("\n\t\t\t\t\t\t\t\t\tEnter Location: ");
            String length= in.nextLine();
            System.out.print("\n\t\t\t\t\t\t\t\t\tEnter Date (dd/MM/yyyy): ");
            String d= in.nextLine();
			System.out.print("\n\t\t\t\t\t\t\t\t\tEnter Time (hour:minutes (am)or(pm): ");
            String t= in.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");// here is where we set the date format so we can compare it range later :D
            Date date = formatter.parse(d); 
            System.out.print("\n\t\t\t\t\t\t\t\t\tEnter Species: ");
            String s= in.nextLine();
            System.out.print("\n\t\t\t\t\t\t\t\t\tEnter Weight (in kg): ");
            double w = Double.parseDouble(in.nextLine());
            System.out.print("\n\t\t\t\t\t\t\t\t\tEnter Length (in meter): ");
            double len = Double.parseDouble(in.nextLine());
            System.out.print("\n\t\t\t\t\t\t\t\t\tEnter Number of Working Flipper: ");
            int f = Integer.parseInt(in.nextLine());
            myturtle.addTurtle(new Penyu( id,length, date,t,s, w, len, f));//my.addTurtle is on of method we called of TurtleRecord class. while Penyu(id, bla bla) we called them from Penyu Class. Make sure the number of parameter is right so it will error free~ :D
			System.out.println("\n\n\n\t\t\t\t-------------------------------------------------------Successfully Added-----------------------------------");
			System.out.println("\n\n\n\t\t\t\t------------------------------------------------------------------------------------------------------------");
            System.out.println("\n\t\t\t\t\tPress 1 to enter another Record\n\n\t\t\t\t\tPress 2 to View Record \n\n\t\t\t\t\tPress 3 to Return to Menu\n\n\t\t\t\t\tPress 4 to exit\n");
			System.out.println("\n\n\n\t\t\t\t------------------------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t\t\tChoice: ");
			int c = Integer.parseInt(in.nextLine());
			 switch(c)
			 {
				 case 1:
				 {
					 emptyScreen();
					 add();
					 break;
				 }//end case1
				 
				 case 2:
				 {	 emptyScreen();
					 view();
					 break;
				 }
				 
				 case 3:
				 {
					 emptyScreen();
					 Program.main(new String[0]);
					 break;
				 }
				 
				 case 4:
				 {
					 emptyScreen();
					 bye();
					 break;
				 }
			 }//end switch	
           
		}
		
		public static void delete() throws ParseException // this where you delete unwanted turtle record. 
		{
			
			System.out.print("\n\t\t\tEnter ID to Delete: ");//enter anyt ID among the cute bubbly turtle you entered before.
			int id = Integer.parseInt(in.nextLine());
			
			for (int index = 0; index < myturtle.size(); index++)
			{
				if(myturtle.getPenyu(index).getID()==(id))
				{
					myturtle.removePenyu(index);// here it remove the record we called from TurtleRecord class. It will see which index( I called it natural ID as it generated by ArrayList it self when storing ) It will compare if the ID you found existed in the record, and delete the record you want by deleting its natural index so all the record berkaitan gone~
					System.out.println("\n\t\t\tRecord Deleted~");// to tell you that record already deleted
					break;
				}
				
			}
			
			 System.out.println("\n\t\t\t\tPress 1 to Return to Main Menu\n\n\t\t\t\tPress 2 to View Record\n\n\t\t\t\tPress 3 to exit\n");// submenu
			 System.out.print("\t\t\t\tChoice:");
			 int c = Integer.parseInt(in.nextLine());
			 switch(c)
			 {
				 case 1:
				 {
					 emptyScreen();
					 Program.main(new String[0]);
					 break;
				 }//end case1
				 
				 case 2:
				 {	 System.out.println("\n\n\n\t\t\t\t--------------------------------------------------After Deletion-------------------------------------------------------");//you can view after deletetion record here
					 view();
					 break;
				 }
				 
				 case 3:
				 {
					 emptyScreen();
					 bye();
					 break;
				 }
			 }
				
			}
            
           
		
		
		public static void search() throws ParseException//search record by location && min weight && max weigth
		{
		 
		 System.out.println("\n\n\n\t\t\t------------------------------------------------------Searching Record-------------------------------------------------------");
       	 System.out.print("\n\n\n\t\t\t\t\tEnter Location: ");
       	 String l= in.nextLine();
       	 System.out.print("\n\n\t\t\t\t\tEnter Minimum weight: ");
       	 double w1 = Double.parseDouble(in.nextLine());
       	 System.out.print("\n\n\t\t\t\t\tEnter Maximum weight: ");
       	 double w2 = Double.parseDouble(in.nextLine());
       	 System.out.println("\n\n\n\t\t\t--------------------------------------------------------------Result---------------------------------------------------------");
       	 String search = l;
       	 int searchListLength = myturtle.size();
       	 for (int index = 0; index < searchListLength; index++) {
       	 if (myturtle.getPenyu(index).getLocation().contains(search) && myturtle.getPenyu(index).getWeight()>= w1 && myturtle.getPenyu(index).getWeight()<=w2) //here is will fiind and comparing and poof! display it out :D
       	 {
       		 	displayafteredit(index);
       	 }//end if
       	 }//end for
		 
		 System.out.println("\n\t\t\t---------------------------------------------------------------------------------------------------------------------------------");
		 System.out.println("\n\t\t\t\tPress 1 to Return to Main Menu\n\n\t\t\t\tPress 2 to View Record\n\n\t\t\t\tPress 3 to exit\n");
		 System.out.print("\t\t\t\tChoice:");
			 int c = Integer.parseInt(in.nextLine());
			 switch(c)
			 {
				 case 1:
				 {
					 emptyScreen();
					 Program.main(new String[0]);
					 break;
				 }//end case1
				 
				 case 2:
				 {
					 emptyScreen();
					 view();
					 break;
				 }
				 
				 case 3:
				 {
					 emptyScreen();
					 bye();
					 break;
				 }
			 }
       	 
       	
		}
		
		public static void summarize() throws ParseException//here is summarize~ 
		 {
		
			System.out.println("\n\t\t\t\t-----------------------------------------------------Summarizing Record------------------------------------------------------------");
			filter();//we called this filter function tu filter. I put it like this so I can resummarize by on different method on other function so I don't need to retyping because it is tiring
		
		 }
           
		
		
		public static void edit(int input) throws ParseException// this is where the edit happen, we use get and set ~ simple and amazing// we display before and after edit too ;D
		{
			
			
    	 	System.out.println("\n\t\t\tPress 1 to edit Location\n\t\t\tPress 2 to edit Date\n\t\t\tPress 3 to edit Species\n\t\t\tPress 4 to edit Weight\n\t\t\tPress 5 to edit Length\n\t\t\tPress 6 to edit Number of working flipper\n\t\t\tPress 7 to Edit Time");
			System.out.print("\n\t\t\tChoice:");
    		int choice = Integer.parseInt(in.nextLine());
    	 
    	 	
 	 

			switch(choice)
		{
			case 1:
 	 	{
 	 	    System.out.print("\n\t\t\tEnter new Location:");
            String l= in.nextLine();
            myturtle.getPenyu(input).setLocation(l);
			displayafteredit(input);
            break;
            
 	 	}//end case1
 	 	
		case 2:
		{
			System.out.print("\n\t\t\tEnter new Date: ");
			String d2= in.nextLine();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(d2); 
			myturtle.getPenyu(input).setDate(date);
			displayafteredit(input);
			break;
         
		}//end case2
  	
		case 3:
		{
 	 		System.out.print("\n\t\t\tEnter new Species: ");
 	 		String s= in.nextLine();
 	 		myturtle.getPenyu(input).setSpecies(s);
			displayafteredit(input);
 	 		break;
          
 	 	}//end case3
 	 case 4:
 	 	{
 	 		System.out.print("\n\t\t\tEnter new Weight: ");
 	 		double w = Double.parseDouble(in.nextLine());
 	 		myturtle.getPenyu(input).setWeight(w);
			displayafteredit(input);
 	 		break;
           
 	 	}//end case4
 	 	
 	 case 5:
 	 	{
 	 		System.out.print("\n\t\t\tEnter new Length: ");
 	 		double l = Double.parseDouble(in.nextLine());
 	 		myturtle.getPenyu(input).setLength(l);
			displayafteredit(input);
 	 		break;
            
 	 	}//end case5
 	 	
 	 case 6:
  	{
  		System.out.print("\n\t\t\tEnter new Number of Working Flipper: ");
  		int f = Integer.parseInt(in.nextLine());
  		myturtle.getPenyu(input).setFlip(f);
		displayafteredit(input);
  		break;
         
  	}//end case5
	
	 case 7:
  	{
  		System.out.print("\n\t\t\tEnter new Time (hour:minutes (am) or (pm) ");
  		String t = in.nextLine();
  		myturtle.getPenyu(input).setTime(t);
		displayafteredit(input);
  		break;
         
  	}//end case5
 	 	
 	 }//end switch
	 
	 System.out.println("\n\t\t\t----------------------------------------------------------------------------------------------------------------------------------");
 	 System.out.println("\n\t\t\tPress 1 to continue edit other detail\n\n\t\t\tPress 2 to Edit Other Record\n\n\t\t\tPress 3 to Return to Menu\n\n\t\t\tPress 4 to Exit");
 	 System.out.print("\n\t\t\tChoice:");
 	 int ch = Integer.parseInt(in.nextLine());
 	 switch(ch)
 	 {
 	 case 1:
 	 {
	    edit(input);
		for (int index = 0; index < myturtle.size(); index++)
				{
					if(myturtle.getPenyu(index).getID()==(input))
					{
						displayafteredit(input);
					}
				}
		
		 break;
 	 }//end case1
 	 
 	 case 2:
 	 {
			 emptyScreen();
	    	 System.out.print("\n\n\n\t\t\t\tEnter ID to Edit: ");
			 input = Integer.parseInt(in.nextLine());
				for (int index = 0; index < myturtle.size(); index++)
				{
					if(myturtle.getPenyu(index).getID()==(input))
					{
						displayafteredit(index);
						edit(index);
						displayafteredit(index);
						
					}
				
				}
				
				for (int index = 0; index < myturtle.size(); index++)
				{
					if(myturtle.getPenyu(index).getID()!=(input))
					{
						emptyScreen();
						System.out.println("Not Found..\n\n\n\n\n\n");
						Program.main(new String[0]);
						break;
					}
					
				}
	    	
	    	 break;
 	 }//end case2
	 
	
	 
	 case 3:
	 {
		 emptyScreen();
		 Program.main(new String[0]);
		 break;
		 
	 }//end case3
	 
	 case 4:
	 {
		 emptyScreen();
		 bye();
		 break;
	 }//end case4
	 
	 
 	 }//end switch
 	 
 	
	}//end edit()
		
		public static void view() throws ParseException //view record method
		{
			System.out.println("\n\t\t\t----------------------------------------------------------------------------------------------------------------------------------");
       	 	System.out.println("\t\t\t------------------------------------------------------------Record------------------------------------------------------------------");
       	 	
       	 	if(myturtle.size()>0) { //if record exist display all record
            for (int index = 0; index < myturtle.size(); index++) // go through all record existed
            {
           	
            	displayafteredit(index); //display all record by index which automatically existed in arrayList to store record
              
            }}
       	 	
       	 	else // if record not exits, display "empty"
       	 	{
       	 	System.out.println("\t\t\t--------------------------------------------------------------Empty---------------------------------------------------------------");
       	 	System.out.println("\t\t\t----------------------------------------------------------------------------------------------------------------------------------");
       	 	}
			
			 System.out.println("\t\t\t----------------------------------------------------------------------------------------------------------------------------------\n\n");
			 System.out.println("\t\t\t\t\tPress 1 to Add Record \n\n\t\t\t\t\tPress 2 to Edit Record \n\n\t\t\t\t\tPress 3 to Delete Record\n\n\t\t\t\t\tPress 4 to Return to Menu\n\n\t\t\t\t\tPress 5 to Search\n\n\t\t\t\t\tPress 6 Summarize Record\n\n\t\t\t\t\tPress 7 Exit");
			 System.out.print("\n\t\t\t\t\tChoice:");
			 int c = Integer.parseInt(in.nextLine());
			 switch(c)
			 {
				 
				 case 1:
				 {
					 emptyScreen();
					 add();
					 break;
				 }
				 case 2:
				 {
					 emptyScreen();
					 System.out.print("\n\t\t\t\t\tEnter ID to Edit:");
					int input = Integer.parseInt(in.nextLine());
				for (int index = 0; index < myturtle.size(); index++)
				{
					if(myturtle.getPenyu(index).getID()==(input))
					{
						displayafteredit(index);
						edit(index);
						displayafteredit(index);
						
				}
				
				
				
				}
						
		 
				for (int index = 0; index < myturtle.size(); index++)
				{
					if(myturtle.getPenyu(index).getID()!=(input))
					{
						emptyScreen();
						System.out.println("Not Found..\n\n\n\n\n\n");
						Program.main(new String[0]);
						break;
					}
					
				}
					 break;
				 }//end case1
				 
				 case 3:
				 {	 emptyScreen();
					 delete();
					 break;
				 }
				 
				 case 4:
				 {
					 emptyScreen();
					 Program.main(new String[0]);
					 break;
				 }
				 
				 case 5:
				 {
					 search();
					 break;
				 }
				 
				 case 6:
				{
					summarize();
					break;
					
				}
				
				case 7:
				{
					 emptyScreen();
					 bye();
					 break;
				}
				 
			 }
            
           
            
		}
		
		public static void emptyScreen()// this is where clear screen or clear cmd method as we don't have automatic function like cls() in c++/ c language
		{
			try
			{	
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}catch(Exception E)
				{
					System.out.println(E);
				}
		}
		
		public static void bye()//this is exit function~ 
		{
			emptyScreen();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t-------------------------------------------------------------------Bye:)Have a Nice Day-----------------------------------------------------\n\n");
			System.exit(0);
		}
		
		public static void displayafteredit(int index)
		{
			
						System.out.println("\n\t\t\t----------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\n\t\t\t\t\t\t\t\t\tID: " +  myturtle.getPenyu(index).getID());
						System.out.println("\n\t\t\t\t\t\t\t\t\tLocation Found: " + myturtle.getPenyu(index).getLocation());
						System.out.println("\n\t\t\t\t\t\t\t\t\tDate Found: " + myturtle.getPenyu(index).getDate());
						System.out.println("\n\t\t\t\t\t\t\t\t\tTime Found: " + myturtle.getPenyu(index).getTime());
						System.out.println("\n\t\t\t\t\t\t\t\t\tSpecies: " + myturtle.getPenyu(index).getSpecies());
						System.out.println("\n\t\t\t\t\t\t\t\t\tWeight: " + myturtle.getPenyu(index).getWeight() +"kg");
						System.out.println("\n\t\t\t\t\t\t\t\t\tLength: " + myturtle.getPenyu(index).getLength() + "m");
						System.out.println("\n\t\t\t\t\t\t\t\t\tNumber of working flipper: " +myturtle.getPenyu(index).getFlip());
						System.out.println("\n\t\t\t----------------------------------------------------------------------------------------------------------------------------------");
					
		}
		
		public static void ask() throws ParseException// this is sub menu 
		{
			 System.out.println("\n\t\t\t----------------------------------------------------------------------------------------------------------------------------------");
			 System.out.println("\n\t\t\t\t\tPress 1 to Filter the Report By Other Method\n\n\t\t\t\t\tPress 2 to Return to Menu\n\n\t\t\t\t\tPress 3 to Exit");
			 System.out.println("\n\t\t\t----------------------------------------------------------------------------------------------------------------------------------");
			 System.out.print("\n\t\t\t\t\tChoice:");
			 int c = Integer.parseInt(in.nextLine());
			 switch(c)
			 {
				 case 1:
				 {
					 emptyScreen();
					 filter();
					 break;
				 }//end case1
				 
				 case 2:
				 {	 emptyScreen();
					 Program.main(new String[0]);
					 break;
				 }
				 
				 case 3:
				 {
					 emptyScreen();
					 bye();
					 break;
				 }
			 }
		}
		
		public static void filter() throws ParseException// this is the filter for summarizing
		{
		 System.out.println("\n\t\t\t\tPress 1 to Filter Record Summary by Location Only");
		 System.out.println("\n\t\t\t\tPress 2 to Filter Record Summary by Location & Date Range");
		 System.out.print("\n\t\t\t\tChoice: ");
		 int q = Integer.parseInt(in.nextLine());
		 switch(q)
		 {
			 case 1:
			 {
				 System.out.print("\n\t\t\t\tEnter Location: ");
				 String l2= in.nextLine();
				  for (int index = 0; index < myturtle.size(); index++) 
            {
           	 if (myturtle.getPenyu(index).getLocation().contains(l2)) 
           	 {
				 displayafteredit(index);
				 
			 }
			}
				 ask();
				 break;
			 }//end case1		 
		case 2:
		{
			System.out.print("\n\t\t\t\tEnter Location: ");
			String l= in.nextLine();
       	    System.out.print("\n\t\t\t\tEnter Start Date: ");
			String d2= in.nextLine();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(d2); 
       	    System.out.print("\n\t\t\t\tEnter End Date: ");
       	    String d1= in.nextLine();
       	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = formatter1.parse(d1); 
            int searchListLength = myturtle.size();
            for (int index = 0; index < searchListLength; index++) 
            {
           	 if (myturtle.getPenyu(index).getLocation().contains(l) && myturtle.getPenyu(index).getDate().after(date)  &&  myturtle.getPenyu(index).getDate().before(date1)) 
           	 {
					displayafteredit(index);
           	 }//end if
           	 
			}
			
			ask();
			
			 break;
		 }//end case3
		 }//end switch q
		}
		
		
}// class end
