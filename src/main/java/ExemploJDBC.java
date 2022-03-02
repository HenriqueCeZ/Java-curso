import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploJDBC {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
		String username = "root";
		String password = "admin";
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");
			
			while(resultado.next()) {
				System.out.println(resultado.getString("nome"));
			}
			
			resultado.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
