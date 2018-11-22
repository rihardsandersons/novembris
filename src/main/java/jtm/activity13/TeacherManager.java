package jtm.activity13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

public class TeacherManager {

	protected Connection conn;

	public TeacherManager() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?autoReconnect=true&useSSL=false", "root",
					"abcd1234");
			conn.setAutoCommit(false);
		} catch (Exception e) {
		}
	}

	/**
	 * Returns a Teacher instance represented by the specified ID.
	 * 
	 * @param id
	 *            the ID of teacher
	 * @return a Teacher object
	 * @throws SQLException
	 */
	// #2 Write an sql statement that searches teacher by ID.
	// If teacher is not found return Teacher object with zero or null in
	// its fields!
	// Hint: Because default database is not set in connection,
	// use full notation for table "database_activity.Teacher"

	public Teacher findTeacher(int id) throws SQLException {
		Teacher teacher = null;
		String sql = "select * from database_activity.Teacher where ID=?";
		PreparedStatement pS = conn.prepareStatement(sql);
		pS.setInt(1, id);
		ResultSet rS = pS.executeQuery();

		if (rS.next()) {
			teacher = new Teacher(rS.getInt(1), rS.getString(2), rS.getString(3));

		} else {
			teacher = new Teacher(0, null, null);

		}
		rS.close();
		pS.close();
		return teacher;
	}

	/**
	 * Returns a list of Teacher object that contain the specified first name
	 * and last name. This will return an empty List of no match is found.
	 * 
	 * @param firstName
	 *            the first name of teacher.
	 * @param lastName
	 *            the last name of teacher.
	 * @return a list of Teacher object.
	 * @throws SQLException
	 */
	public List<Teacher> findTeacher(String firstName, String lastName) {

		List<Teacher> teacherList = new ArrayList<>();
		String sql = "select * from database_activity.Teacher where firstname like ? and lastname like ?";
		try {
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, "%" + firstName + "%");
			pS.setString(2, "%" + lastName + "%");
			ResultSet rS = pS.executeQuery();

			while (rS.next()) {
				teacherList.add(new Teacher(rS.getInt(1), rS.getString(2), rS.getString(3)));
			}
			rS.close();
			pS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teacherList;

		// #3 Write an sql statement that searches teacher by first and
		// last name and returns results as ArrayList<Teacher>.
		// Note that search results of partial match
		// in form ...like '%value%'... should be returned
		// Note, that if nothing is found return empty list!

	}

	/**
	 * Insert an new teacher (first name and last name) into the repository.
	 * 
	 * @param firstName
	 *            the first name of teacher
	 * @param lastName
	 *            the last name of teacher
	 * @return true if success, else false.
	 */

	public boolean insertTeacher(String firstName, String lastName) {

		try {
			String sql = "INSERT INTO database_activity.Teacher (`firstname`, `lastname`) VALUES (?, ?);";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, firstName);
			pS.setString(2, lastName);

			int result = pS.executeUpdate();
			conn.commit();
			return result != 0;
		} catch (SQLException e) {
			return false;
		}

	}

	/**
	 * Insert teacher object into database
	 * 
	 * @param teacher
	 * @return true on success, false on error (e.g. non-unique id)
	 */
	public boolean insertTeacher(Teacher teacher) {
		try {
			String sql = "insert into database_activity.Teacher values (?, ?, ?)";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, teacher.getID());
			pS.setString(2, teacher.getFirstName());
			pS.setString(3, teacher.getLastName());

			int result = pS.executeUpdate();
			conn.commit();
			return result != 0;
		} catch (SQLException e) {
			return false;
		}

		// #5 Write an sql statement that inserts teacher in database.
	}

	/**
	 * Updates an existing Teacher in the repository with the values represented
	 * by the Teacher object.
	 * 
	 * @param teacher
	 *            a Teacher object, which contain information for updating.
	 * @return true if row was updated.
	 */
	public boolean updateTeacher(Teacher teacher) {

		try {
			String sql = "update database_activity.Teacher set firstname = ?, lastname = ? where id = ?";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, teacher.getFirstName());
			pS.setString(2, teacher.getLastName());
			pS.setInt(3, teacher.getID());

			int result = pS.executeUpdate();
			conn.commit();
			return result != 0;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Delete an existing Teacher in the repository with the values represented
	 * by the ID.
	 * 
	 * @param id
	 *            the ID of teacher.
	 * @return true if row was deleted.
	 */
	public boolean deleteTeacher(int id) {
		try {
			String sql = "DELETE FROM database_activity.Teacher WHERE id = ?";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, id);

			int result = pS.executeUpdate();
			conn.commit();
			pS.close();

			return result != 0;
		} catch (SQLException e) {
			return false;
		}
	}

	public void closeConnecion() {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {

		}
		// Close connection if and reset it to release connection to the
		// database server
	}
}
