package bob.wcf.cellphoneusagereport.db;

public class DayUsage {
	String yearMonth;
	Long minutes;
	Long usage;
	
	public DayUsage(String yearMonth, long minutes, long usage) {
		this.yearMonth = yearMonth;
		this.minutes = minutes;
		this.usage = usage;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Long getMinutes() {
		return minutes;
	}

	public void setMinutes(Long minutes) {
		this.minutes = minutes;
	}

	public Long getUsage() {
		return usage;
	}

	public void setUsage(Long usage) {
		this.usage = usage;
	}

	
	
	
	
}
