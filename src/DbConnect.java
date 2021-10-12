import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DriverManager;


public class DbConnect {
	private static Connection conn = null;
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		Scanner kb = new Scanner(System.in);
		String filename;
		System.out.println("불러올 데이터베이스의 이름을 입력하세요: ");
		filename = kb.next();
		
		if(conn == null) {
			try {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:" + filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
