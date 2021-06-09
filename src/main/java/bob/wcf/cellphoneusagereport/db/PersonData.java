package bob.wcf.cellphoneusagereport.db;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PersonData {
	String employeeId;
	String employeeName;
	String model;
	Date purchaseDate;
	Map<Integer,DayUsage> minutesUsed;
	Map<Integer,DayUsage> dataUsed;
	
	public PersonData() {}
	
	public PersonData(String employeeId, String employeeName, String model, Date purchaseDate) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.model = model;
		this.purchaseDate = purchaseDate;
		minutesUsed = new HashMap<>();
		dataUsed = new HashMap<>();
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	void addDay(String yearMonth, long minutes, long usage) {
		
		DayUsage dayUsage = minutesUsed.get(yearMonth);
		if (dayUsage == null) {
			dayUsage = new DayUsage(yearMonth, minutes, usage);
		} else {
			dayUsage.setUsage( dayUsage.getUsage() + usage);
			dayUsage.setMinutes(dayUsage.getMinutes() + minutes);
		}
	}
	

}
