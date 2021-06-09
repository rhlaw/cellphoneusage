package bob.wcf;

import java.io.FileReader;
import java.util.Date;

import com.opencsv.CSVReader;

import bob.wcf.cellphoneusagereport.db.DBMock;
import bob.wcf.cellphoneusagereport.db.DayUsage;
import bob.wcf.cellphoneusagereport.db.PersonData;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		if (args.length != 2) {
			System.out.println("Error: Requires two file names");
			System.exit(1);
		}
		
		DBMock dbMock = new DBMock();
		
		String cellPhones = args[0];
		String cellUsage = args[1];
		
		try (CSVReader reader = new CSVReader(new FileReader(cellPhones))) {
		    String[] lineInArray;
		    while ((lineInArray = reader.readNext()) != null) {
		    	String dateString = lineInArray[2];
		    	Date pDate = new Date(Integer.parseInt(dateString.substring(0,3)), 
		    							Integer.parseInt(dateString.substring(4,5)),
		    							Integer.parseInt(dateString.substring(6,7)));
		        PersonData personData = new PersonData(lineInArray[0], lineInArray[1], lineInArray[3],pDate);
		        
		        dbMock.addPerson(personData.getEmployeeId(), personData);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try (CSVReader reader = new CSVReader(new FileReader(cellUsage))) {
		    String[] lineInArray;
		    while ((lineInArray = reader.readNext()) != null) {
		    	String[] dateParts = lineInArray[1].split("/",3);

		    	DayUsage dayUsage = new DayUsage(dateParts[2] + "-" + dateParts[0], 
		    			Long.parseLong(lineInArray[2]), 
		    			Long.parseLong(lineInArray[3]));
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Now Print the Report
		
		 
	}
}
