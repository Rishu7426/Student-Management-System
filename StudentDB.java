//MySQL
package com.student.manage;

import java.sql.*;

public class StudentDB {

	public static boolean insertStudentToDB(Student st) {

		boolean flag = false;
		try {

			// jdbc code...
			Connection con = CP.createC();
			String q = "insert into students(sname, sphone, scity) values(?, ? , ? )";

			// PreparedStatement
			PreparedStatement ps = con.prepareStatement(q);

			// set the values of parameters
			ps.setString(1, st.getStudentname());
			ps.setString(2, st.getstudentPhone());
			ps.setString(3, st.getStudentCity());

			// execute....
			ps.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		boolean flag = false;
		try {

			// jdbc code...
			Connection con = CP.createC();
			String q = "delete from students where sid= ?";

			// PreparedStatement
			PreparedStatement ps = con.prepareStatement(q);

			// set the values of parameters
			ps.setInt(1, userId);

			// execute....
			ps.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub
		try {

			// jdbc code...
			Connection con = CP.createC();
			String q = "select * from students";

			Statement s = con.createStatement();
			ResultSet set = s.executeQuery(q);

			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");

				System.out.println("ID :" + id);
				System.out.println("Name :" + name);
				System.out.println("Phone :" + phone);
				System.out.println("City :" + city);
				System.out.println("+++++++++++++++++++++++++++++++++");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean updateStudent(int id, String name, String phone, String city) {
        boolean flag = false;
        try {
            Connection con = CP.createC();

            // Prepare the SQL query dynamically based on input values
            StringBuilder q = new StringBuilder("UPDATE students SET ");
            boolean hasPrev = false;

            if (!name.isEmpty()) {
                q.append("sname = ?");
                hasPrev = true;
            }
            if (!phone.isEmpty()) {
                if (hasPrev) q.append(", ");
                q.append("sphone = ?");
                hasPrev = true;
            }
            if (!city.isEmpty()) {
                if (hasPrev) q.append(", ");
                q.append("scity = ?");
            }
            q.append(" WHERE sid = ?");

            PreparedStatement ps = con.prepareStatement(q.toString());

            int index = 1;
            if (!name.isEmpty()) ps.setString(index++, name);
            if (!phone.isEmpty()) ps.setString(index++, phone);
            if (!city.isEmpty()) ps.setString(index++, city);
            ps.setInt(index, id);

            int rowsAffected = ps.executeUpdate();
            flag = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
