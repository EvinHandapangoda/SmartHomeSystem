package db;

public class DBConnection {
	private static TimeBlockList timeBlockList;
	private static DBConnection dbConnection;
	
	private DBConnection(){
		timeBlockList = new TimeBlockList();
	}
	
	public static DBConnection getInstance(){
		if(dbConnection == null){
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	public static TimeBlockList getTimeBlockList(){
		return timeBlockList;
	}		

}
