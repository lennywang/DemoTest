import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		try {
			// 调用Class.forName()方法加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动！");
		} catch (ClassNotFoundException e1) {
			System.out.println("找不到MySQL驱动!");
			e1.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/test"; // JDBC的URL
		// 调用DriverManager对象的getConnection()方法，获得一个Connection对象
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, "root", "wll0913");
			// 创建一个Statement对象
			Statement stmt = conn.createStatement(); // 创建Statement对象
			System.out.println("成功连接到数据库！");

			String sql = "select * from student"; // 要执行的SQL
			ResultSet rs = stmt.executeQuery(sql);// 创建数据对象
			System.out.println("编号" + "\t" + "姓名" + "\t" + "性别"+"\t"+"分数");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.println();
			}
			rs.close();
			stmt.close();
			conn.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
