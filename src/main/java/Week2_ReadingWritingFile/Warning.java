package Week2_ReadingWritingFile;

// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;
public class Warning
{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args)
    {
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        String line, name, inputName = "students.dat";
        String outputName = "warning.dat";
        try
        {
            // Set up scanner to input file
            // Set up the output file stream
            // Print a header to the output file
            Scanner scan = new Scanner(new File("src/main/java/Week2_ReadingWritingFile/"+ inputName));
            PrintWriter outFile = new PrintWriter("src/main/java/Week2_ReadingWritingFile/output.dat");
            outFile.println ();
            outFile.println ("Students on Academic Warning");
            outFile.println ();
            // Process the input file, one token at a time

            while (scan.hasNextLine())
            {
                // Get the credit hours and quality points and
                // determine if the student is on warning. If so,
                // write the student data to the output file.
                String[] lineText = scan.nextLine().split(" ",0);
                name = lineText[0];
                creditHrs = Integer.parseInt(lineText[1]);
                qualityPts = Double.parseDouble(lineText[2]);
                gpa = qualityPts / creditHrs;
                if (gpa < 1.5 && creditHrs < 30)
                    outFile.write(name + " "+ creditHrs + " " + gpa + "\n");
                else if (gpa < 1.75 && creditHrs < 60)
                    outFile.write(name + " "+ creditHrs + " " + gpa + "\n");
                else if (gpa < 2.0)
                    outFile.write(name + " "+ creditHrs + " " + gpa + "\n");
            }
            // Close output file
            outFile.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("The file " + inputName + " was not found.");
        }
        catch (IOException exception)
        {
            System.out.println (exception);
        }
        catch (NumberFormatException e)
        {
            System.out.println ("Format error in input file: " + e);
        }
    }
}

