import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        String csvFile = "/home/andrew/Desktop/result-copy.csv";
        try
        {
            //Build reader instance
            //Read result.csv
            //Default separator is comma
            //Default quote character is double quote
            //Start reading from second line
            CSVReader reader = new CSVReader(new FileReader(csvFile));

            //Read all rows
            List<String[]> allResults = reader.readAll();
            for (String[] result : allResults)
            {
                System.out.println(Arrays.toString(result));
            }
            System.out.println("Total records: "  + allResults.size());
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
