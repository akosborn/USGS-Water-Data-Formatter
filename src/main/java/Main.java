import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        String inputCSV = "/home/andrew/Desktop/result-copy.csv";
        String outputCSV = "/home/andrew/Desktop/result-formatted.csv";
        try
        {
            //Build reader instance
            //Default separator is comma
            //Default quote character is double quote
            CSVReader reader = new CSVReader(new FileReader(inputCSV));

            //Build writer instance
            //Create new csv file
            CSVWriter writer = new CSVWriter(new FileWriter(outputCSV));

            //Read all rows
            List<String[]> allResults = reader.readAll();
            for (String[] result : allResults)
            {
                System.out.println(Arrays.toString(result));
            }
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
