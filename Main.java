/*
Andrew Achusim
03/19/2025
Purpose: Create two classes Main.java and HurricaneRowData.java. For Main, create a private static 
         method that takes an array of data as in put, returns the year in which the ACE index was 
         at its greatest, then displays that information while outputting it to a text file.
Sources:
    1.) I learend about ArrayList @ https://www.w3schools.com/java/java_arraylist.asp.
    2.) I learend about IO Exception and how to use try and catch @ https://www.geeksforgeeks.org/handle-an-ioexception-in-java/.
    3.) I learend how to convert a String into an interger @ https://www.javatpoint.com/java-integer-parseint-method.
    4.) I learend what BufferdReader is and what it does @ https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html.
    5.) I learend what FileReader is and what it does @ https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html.
    6.) I learned how to create and write a Java text file @ https://www.w3schools.com/java/java_files_create.asp.
*/
// A java.io class that reads texts from a stream and buffers character for reading character, arrays and lines.
import java.io.BufferedReader;
// A java.io class that give access to blocks of code that can be used to read and modify text files.
import java.io.FileReader;
// A java.io class that gives access to blocks of code that create and write text in files.
import java.io.FileWriter;
// A java.io class that give access to blocks of code that can be used to handle IOExceptions as they occur.
import java.io.IOException;
// A java.util class that give access to a resizable array and the ability to manipulate lists.
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // A new DoublyLinkedSortedList object.
        DoublyLinkedSortedList data = new DoublyLinkedSortedList();

        // A HurricaneRowData object array that contains the content of "ace.cvc".
        ArrayList<HurricaneRowData> hurricaneData = readData("ace.csv");

        // A for loop that inserts the data from the HurricaneRowData object into the 
        // DoublyLinkedSortedList object.
        for(int i = 0; i < hurricaneData.size(); i++)
        {
            HurricaneRowData rowData = hurricaneData.get(i);
            data.insert(rowData);
        }

        // A DoublyLinkedSortedList object that gets the value of data.getFirst().
        DoublyLinkedSortedList chain = data.getFirst();
        // A HurricaneRowData object that gets the value of chain.getValue().
        HurricaneRowData link = chain.getValue();
        // An integer varable that contains the value in link.getYear().
        int max_year = link.getYear();

        try
        {
            // A FileWriter object called "maxAce.txt"
            FileWriter results = new FileWriter("maxAce.txt");
            // The max value of ACE and the respective year is written here.
            results.write("The year with the maximum ACE index: " + max_year);
            // The detailed value of the found max value of ACE is written here.
            results.write(link.toString());
            // Closes the file contained in results.
            results.close();

            // The max value of ACE and the respective year is printed here.
            System.out.println("The year with the maximum ACE index: " + max_year);
            // The detialed value of the found max value of ACE is printed here.
            System.out.println(link.toString());
            // A confirmation on the file creation is printed here.
            System.out.println("This information has been saved to a maxAce.txt.\n");
        }
        // What is executed when an exception is found.
        catch(IOException e){System.out.println("ERROR! Please review code.");}

        // An introduction to the incoming list.
        System.out.println("All data in order of Ace:");
        // Prints out the value within the DoublyLinkedSortedList object.
        System.out.println(data);
        
    }

    // A private method that opens and reads the data of a csv file,
    // orgaizes its content in to several integer variables, and closes said csv file. 
    private static ArrayList<HurricaneRowData> readData(String filename)
    {
        // A blank HurricaneRowData object array
        ArrayList<HurricaneRowData> data = new ArrayList<>();

        // A block of code where an exception error is likely to occur.
        try
        {
            // A BufferedReader object that cotains the file it just opened
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            // A string that contains the current line of reader
            String line = reader.readLine();

            // A while loop that ends when the conents of reader rund out.
            // During each loop the current line of reader is split up amongst 5 interger variables.
            // These variables are then entered into a HurricaneRowData object.
            while((line = reader.readLine()) != null)
            {
                String[] items = line.split(",");
                int year = Integer.parseInt(items[0]);
                int ace = Integer.parseInt(items[1]);
                int tStorms = Integer.parseInt(items[2]);
                int cat5 = Integer.parseInt(items[3]);
                int catMajor = Integer.parseInt(items[4]);

                HurricaneRowData rowData = new HurricaneRowData(year, ace, tStorms, cat5, catMajor);
                data.add(rowData);
            }
            // Closes the file contained in reader
            reader.close();
        }
        // What is executed when an exception is found.
        catch(IOException e){System.out.println("ERROR! Please review code.");} 

        return data;
    }
}