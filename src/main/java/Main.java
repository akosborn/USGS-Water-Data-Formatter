import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
            CSVReader reader = new CSVReader(new FileReader(inputCSV), ',', '"', 1);

            //Build writer instance
            //Create new csv file
            CSVWriter writer = new CSVWriter(new FileWriter(outputCSV));

            List<Result> results = new ArrayList<>();

            String[] record;
            while ((record =  reader.readNext()) != null)
            {
                Result result = new Result();
                result.setOrgId(record[0]);
                result.setDate(stringToDate(record[6]));
                result.setSiteId(record[21]);

                if (record[31].equals(""))
                {
                    result.setCharacteristic(record[32]);

                    if (record[35].equals(""))
                    {
                        result.setConcentration(0.0);
                    }
                    else if (record[35].equals("mg/l"))
                    {
                        result.setConcentration(mgPerLiterToPPB(Double.valueOf(record[34])));
                    }
                    else
                        result.setConcentrationUnit(record[35]);
                    result.setConcentrationUnit("ppb");

                    if (record[34].equals(""))
                        result.setConcentration(0.0);
                    else
                        result.setConcentration(Double.valueOf(record[34]));

                    result.setProvider(record[63]);
                }
                else
                {
                    result.setCharacteristic(record[31]);

                    if (record[34].equals(""))
                    {
                        result.setConcentration(0.0);
                    }
                    else if (record[34].equals("mg/l"))
                    {
                        result.setConcentration(mgPerLiterToPPB(Double.valueOf(record[33])));
                    }
                    else
                        result.setConcentrationUnit(record[34]);
                    result.setConcentrationUnit("ppb");

                    if (record[33].equals(""))
                        result.setConcentration(0.0);
                    else
                        result.setConcentration(Double.valueOf(record[33]));

                    result.setProvider(record[62]);
                }
                results.add(result);
            }
            
            List<String[]> data = toStringArray(results);
            writer.writeAll(data);

            reader.close();
        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private static LocalDate stringToDate(String dateString) throws ParseException
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

        return LocalDate.parse(dateString, dateTimeFormatter);
    }

    private static List<String[]> toStringArray(List<Result> resultList)
    {
        List<String[]> results = new ArrayList<String[]>();

        // add header record
        results.add(new String[] {"org_id", "site_id", "date", "characteristic", "concentration", "conc_unit", "provider"});
        for (Result result : resultList)
        {
            results.add(new String[] {result.getOrgId(), result.getSiteId(), result.getDate().toString(),
                    result.getCharacteristic(), result.getConcentration().toString(), result.getConcentrationUnit(),
                    result.getProvider()});
        }

        return results;
    }

    private static Double mgPerLiterToPPB(Double concentration)
    {
        return concentration * 1000;
    }
}
