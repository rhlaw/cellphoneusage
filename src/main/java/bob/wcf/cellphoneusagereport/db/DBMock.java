package bob.wcf.cellphoneusagereport.db;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DBMock<PersonData> {

	
	private Map<String,PersonData> dataBase = new HashMap<>();
	
	public Set<String> getPeopleIds() {
		return dataBase.keySet();
	}
	
	public  PersonData getPersonData(String key) {
		return dataBase.get(key);
	}
	
	public void  addPerson(String key, PersonData personData) {
		dataBase.put(key, personData);
	}
	
	
}
