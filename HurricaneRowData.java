/*
Andrew Achusim
03/11/2025
Purpose: Create two classes Main.java and HurricaneRowData.java. For HurricaneRowData, create 
         five prvivate instance variables for each column of ace.cvc, a constructor, and a toString method.
Sources:
    1). I learned about instance variables @ https://www.javatpoint.com/instance-variable-in-java.
    2). I learned about constructors @ https://www.w3schools.com/java/java_constructors.asp.
    3). I learned about getters and setters @ https://www.w3schools.com/java/java_encapsulation.asp.
    4). I leaerend about the toString method @ https://www.baeldung.com/java-tostring.
*/
public class HurricaneRowData
{
    // Private variables
    private int year;
    private int ace;
    private int tStorms;
    private int cat5;
    private int catMajor;

    // constructor
    public HurricaneRowData(int year, int ace, int tStorms, int cat5, int catMajor)
    {
        this.year = year;
        this.ace = ace;
        this.tStorms = tStorms;
        this.cat5 = cat5;
        this.catMajor = catMajor;
    }

    // getters
    public int getYear(){return year;}
    public int getAce(){return ace;}
    public int getStorm(){return tStorms;}
    public int getCat5(){return cat5;}
    public int getCatMajor(){return catMajor;}

    // toString method
    public String toString()
    {
        return "Year: " + year + "\nACE: " + ace + "\nTropical Storms: " + tStorms + "\nHurricanes: " + cat5 + "\nMajor Hurricanes: " + catMajor;
    }
}