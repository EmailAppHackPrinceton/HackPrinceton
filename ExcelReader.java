
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ExcelReader {
    static ArrayList<Family> arrayOfFamily = new ArrayList<Family>();

    public static void starter() {

        FileInputStream file = null;
        BufferedReader reader = null;
        try {
            //Get the workbook instance for XLS file
            file = new FileInputStream(new File(""));
            reader = new BufferedReader(new InputStreamReader(file));

            //Iterate through each rows from first sheet
            String row = reader.readLine();
            Family tempFamily = new Family();
            boolean isChild = false;
            while(true) {
                row = reader.readLine();
                if ( row == null ) {
                    break;
                }
                //For each row, iterate through each columns
                List<String> cells = split(row,',');
                if(cells.get(0).equals("1")) {
                    arrayOfFamily.add(tempFamily);
                    tempFamily = new Family();
                }
                String lastName = cells.get(2);
                String firstName = cells.get(3);
                isChild = cells.get(6).equals("G1-6") || cells.get(6).equals("13-17") || cells.get(6).equals("18-64");
                double amountToPay = 0; // cells[13] - cells[16]
                String amountToPayString = cells.get(13);
                amountToPayString = StringUtils.strip(amountToPayString,"$");
                amountToPayString = StringUtils.strip(amountToPayString,",");
                amountToPayString = StringUtils.strip(amountToPayString," ");
                if ( amountToPayString != null && amountToPayString.length() != 0   ) {
                    try {
                        amountToPay = Double.valueOf(amountToPayString);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                double amountPaid = 0;
                String amountPaidString = StringUtils.strip(cells.get(16),"$");
                amountPaidString = StringUtils.strip(amountPaidString," ");
                if ( amountPaidString != null && amountPaidString.length() != 0 ) {
                    amountPaid = Double.valueOf(amountPaidString);
                }
                String email = cells.get(19);
                Person person = new Person(firstName, lastName, email, isChild, amountToPay - amountPaid, amountPaid);
                tempFamily.addPerson(person);
            }
            arrayOfFamily.add(tempFamily);
            arrayOfFamily.remove(0);
            file.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                file.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> split(String value, char delimeter) {
        if ( value == null ) {
            System.out.println("debug");
        }
        List<String> result = new ArrayList<String>();
        int currentIndex = 0;
        int nextIndex = -1;
        while ( true ) {
            nextIndex = value.indexOf('\t', currentIndex);
            if ( nextIndex < 0 ) {
                result.add(value.substring(currentIndex, value.length()));
                break;
            }
            result.add(value.substring(currentIndex, nextIndex));
            currentIndex = nextIndex+1;
        }
        return result;
    }
}