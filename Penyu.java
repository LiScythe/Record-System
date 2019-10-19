import java.text.ParseException;
import java.util.Date;

public class Penyu //here Penyu class. Make get and set method for each attribute. It will be used for editing :D
{
	private int ID;
	private String Location;
	private Date Date;
	private String time;
	private String Species;
	private double weight;
	private double length;
	private int flip;

	public Penyu(  int id,String l, Date d, String t,String s, double w, double len, int f) throws ParseException{//we called this in Program class together with add method
       
		this.setID(id);
        this.Location = l;
        this.Date = d;
		this.time=t;
        this.Species = s;
        this.weight = w;
        this.length = len;
        this.flip = f;
    }



	public String getLocation() {
		return Location;
	}

	public void setLocation(String l) {
		Location = l;
	}

	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double w) {
		this.weight = w;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double len) {
		this.length = len;
	}

	public int getFlip() {
		return flip;
	}

	public void setFlip(int f) {
		this.flip = f;
	}


	public String getSpecies() {
		return Species;
	}


	public void setSpecies(String s) {
		Species = s;
	}
	
	public String toString()
	{
	    String output = Location + ";" + Date + ";" + Species + ";" + weight + ";" + length + ";" + flip + ";" ;
	    
	return output;
	}



	public java.util.Date getDate() {
		
		return Date;
	}
	
	public void setDate(Date d) {
		Date =d;
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}
	
	public String getTime() {
		return time;
	}



	public void setTime(String t) {
		time = t;
	}



	
	
	}//end class



