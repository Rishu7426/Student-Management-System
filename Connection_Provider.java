//MySQL
package com.student.manage;

import java.sql.DriverManager;
import java.sql.Connection;

public class CP {

	static Connection con;

	public static Connection createC() {

		try {
			// load the driver, it throws
			Class.forName("com.mysql.cj.jdbc.Driver");


			// create the connection...
			String user = "root";
			String password = "Rishu@2003";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
