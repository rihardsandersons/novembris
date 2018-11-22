/**
 * 
 */
package jtm.activity14;

import static org.junit.Assert.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * @author student
 *
 */
public class DatabaseUnitTest1 extends StudentManager {
	StudentManager manager = new StudentManager();

	@Before
	public void setUp() throws Exception {

		final String url = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false";
		final String user = "root";
		final String pw = "abcd1234";
		try {
			conn = DriverManager.getConnection(url, user, pw);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
		}
	}

	/**
	 * Test method for {@link jtm.activity14.StudentManager#StudentManager()}.
	 */
	@Test
	public final void testStudentManager() {

		try {
			boolean closed = manager.conn.isClosed();
		} catch (SQLException e) {
		}

		assertNotEquals(true, manager.conn);
	}

	/**
	 * Test method for {@link jtm.activity14.StudentManager#findStudent(int)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testFindStudentInt() throws SQLException {
		Student student = new Student(9, "abbbbbb", "hhhhhh");
		manager.insertStudent(student);
		manager.findStudent(9);

		// assertEquals(sExpected, student);
	}

	/**
	 * Test method for
	 * {@link jtm.activity14.StudentManager#findStudent(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testFindStudentStringString() {
		manager.findStudent("anna", "tress");
	}

	/**
	 * Test method for
	 * {@link jtm.activity14.StudentManager#insertStudent(java.lang.String, java.lang.String)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testInsertStudentStringString() throws SQLException {
		Student student = new Student(5, "Rihards", "A");
		manager.insertStudent(student);
	}

	/**
	 * Test method for
	 * {@link jtm.activity14.StudentManager#insertStudent(jtm.activity14.Student)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testInsertStudentStudent() throws SQLException {

		manager.insertStudent("Rihards", "Andersons");

	}

	/**
	 * Test method for
	 * {@link jtm.activity14.StudentManager#updateStudent(jtm.activity14.Student)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testUpdateStudent() throws SQLException {
		Student student2 = new Student(11, "Rihards", "Andersons");

		manager.updateStudent(student2);
	}

	/**
	 * Test method for {@link jtm.activity14.StudentManager#deleteStudent(int)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testDeleteStudent() throws SQLException {
		Student student = new Student(8, "ttest", "test");
		manager.insertStudent(student);
		manager.deleteStudent(8);

	}

	/**
	 * Test method for {@link jtm.activity14.StudentManager#closeConnecion()}.
	 */
	@Test
	public final void testCloseConnecion() {
		manager.closeConnecion();
		assertEquals(null, manager.conn);
	}

}
