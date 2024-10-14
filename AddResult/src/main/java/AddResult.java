

//Collecting details through table and adding into the table

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		String name = request.getParameter("name");
		// name is required in String format, so we are not using parseInt() function

		int Marks1 = Integer.parseInt(request.getParameter("Marks1"));
		int Marks2 = Integer.parseInt(request.getParameter("Marks2"));
		int Marks3 = Integer.parseInt(request.getParameter("Marks2"));

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "root");

			String s = "Insert into student values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, Marks1);
			pstmt.setInt(4, Marks2);
			pstmt.setInt(5, Marks3);
			int rows = pstmt.executeUpdate();
			PrintWriter out = response.getWriter();
			if (rows == 0) {
				out.println("Student data not Added");
			} else {
				out.println("Student data is Added");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
