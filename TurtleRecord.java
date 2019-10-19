
import java.util.ArrayList;


public class TurtleRecord
{
	

	private ArrayList<Penyu> turtlerec = new ArrayList<Penyu>();// here we start using ArrayList :D taking Penyu class and declare it

	
	public void addTurtle(Penyu p)
	{
	   turtlerec.add(p);//this is to add Penyu and the geng in the Program class. It will be called at there.
	}//1
	
	public Penyu getPenyu(int index)
	{
	    return turtlerec.get(index);
	}//2
	
	
	
	 public void removePenyu (int index)
	    {
		 turtlerec.remove(index);//this is the delete method called in Program class
	    }//3
	 
	 public int size ()
	 {
	     return turtlerec.size();//this is to store all record and make us be able to go thru all record
	 }//4*/

	 public String toString()
	    {
	        String output = "";
	        for (int i = 0; i<turtlerec.size(); i++)
	            output = output + turtlerec.get(i).toString() + "\n";

	        return output;
	    }
		
}//end class
