package P2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
	
	public static List<Object> query() {
		Connection conn = Test.getConnection();
		List<Object> gs = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");

			Student g = null;
			while (rs.next()) {
				g = new Student();
				g.setStudentId(rs.getString("StudentId"));
				g.setStudentName(rs.getString("StudentName"));
				g.setStudentSex(rs.getString("StudentSex"));
				g.setStudentAge(rs.getString("StudentAge"));
				g.toString();
				gs.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gs;
	}
	
	public static void add(String id,String name,String sex,String age) throws SQLException {
		Connection conn = Test.getConnection();
		String sql = "insert into student" + "(StudentId,StudentName,StudentSex,StudentAge)" + "values(?,?,?,?)"; // ? 相当于占位符
		// 代表 输入的值
			try {
			// sql语句预处理
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, name);
			ptmt.setString(3, sex);
			ptmt.setString(4, age);
			// 调用此方法后sql语句才会执行
			ptmt.execute();
			} catch (SQLException e) {
			e.printStackTrace();
			}


		
	}
	public static void main(String [] args) throws SQLException {
		List<Object> l = null;
		l = query();
		System.out.println(l);
		add("16201230","张文翾","男","20");
	}
}