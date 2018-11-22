package jtm.activity14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import jtm.activity14.Student;

public class StudentManager {

	protected Connection conn;
	private static Logger log = Logger.getLogger(StudentManager.class);
	final String url = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false";
	final String user = "root";
	final String pw = "abcd1234";

	public StudentManager() {
		try {
			conn = DriverManager.getConnection(url, user, pw);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
		}
	}

	// #1 When new StudentManager is created, create connection to the
	// database server:
	// url = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false"
	// user = "root"
	// pass = "abcd1234"
	// Hints:
	// 1. Do not pass database name into url, because some statements
	// for tests need to be executed server-wise, not just database-wise.
	// 2. Set AutoCommit to false and use conn.commit() where necessary in
	// other methods

	/**
	 * Returns a Student instance represented by the specified ID.
	 * 
	 * @param id
	 *            the ID of teacher
	 * @return a Student object
	 */
	public Student findStudent(int id) throws SQLException {
		Student student = new Student(0, null, null);
		String sql = "select * from database_activity.Student where ID=?";
		PreparedStatement pS = conn.prepareStatement(sql);
		pS.setInt(1, id);
		conn.commit();
		ResultSet rS = pS.executeQuery();

		if (rS.next()) {
			student = new Student(rS.getInt(1), rS.getString(2), rS.getString(3));

		} else {

		}
		return student;

		// #2 Write an sql statement that searches teacher by ID.
		// If teacher is not found return Student object with zero or null in
		// its fields!
		// Hint: Because default database is not set in connection,
		// use full notation for table "database_activity.Student"
	}

	/**
	 * Returns a list of Student object that contain the specified first name
	 * and last name. This will return an empty List of no match is found.
	 * 
	 * @param firstName
	 *            the first name of teacher.
	 * @param lastName
	 *            the last name of teacher.
	 * @return a list of Student object.
	 */
	public List<Student> findStudent(String firstName, String lastName) {
		List<Student> studentList = new ArrayList<>();
		String sql = "select * from database_activity.Student where firstname like ? and lastname like ?";
		try {
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, "%" + firstName + "%");
			pS.setString(2, "%" + lastName + "%");
			ResultSet rS = pS.executeQuery();
			conn.commit();
			while (rS.next()) {
				studentList.add(new Student(rS.getInt(1), rS.getString(2), rS.getString(3)));
			}

		} catch (SQLException e) {
		}
		return studentList;

	}

	/**
	 * This method will attempt to insert an new teacher (first name and last
	 * name) into the repository.
	 * 
	 * @param firstName
	 *            the first name of teacher
	 * @param lastName
	 *            the last name of teacher
	 * @return true if insert, else false.
	 */

	public boolean insertStudent(String firstName, String lastName) {
		try {
			String sql = "INSERT INTO database_activity.Student (`firstname`, `lastname`) VALUES (?, ?);";
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
	 * Try to insert Student in database
	 * 
	 * @param student
	 * @return true on success, false on error (e.g. non-unique id)
	 */
	public boolean insertStudent(Student student) {
		try {
			String sql = "insert into database_activity.Student values (?, ?, ?)";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, student.getID());
			pS.setString(2, student.getFirstName());
			pS.setString(3, student.getLastName());

			int result = pS.executeUpdate();
			conn.commit();
			return result != 0;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Updates an existing Student in the repository with the values represented
	 * by the Student object.
	 * 
	 * @param student
	 *            a Student object, which contain information for updating.
	 * @return true if row was updated.
	 */
	public boolean updateStudent(Student student) {
		try {
			String sql = "update database_activity.Student set firstname = ?, lastname = ? where id = ?";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, student.getFirstName());
			pS.setString(2, student.getLastName());
			pS.setInt(3, student.getID());

			int result = pS.executeUpdate();
			conn.commit();
			return result != 0;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Delete an existing Student in the repository with the values represented
	 * by the ID.
	 * 
	 * @param id
	 *            the ID of teacher.
	 * @return true if row was deleted.
	 */
	public boolean deleteStudent(int id) {
		try {
			String sql = "DELETE FROM database_activity.Student WHERE id = ?";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, id);

			int result = pS.executeUpdate();
			conn.commit();

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
			// e.printStackTrace();
		}
	}
}
