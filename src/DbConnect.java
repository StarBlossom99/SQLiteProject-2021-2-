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
		System.out.println("�ҷ��� �����ͺ��̽��� �̸��� �Է��ϼ���: ");
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
