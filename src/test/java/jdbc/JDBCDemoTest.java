package jdbc;

import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDemoTest {

    JDBCDemo demo = new JDBCDemo();

    @Test
    public void testDriver() throws SQLException {
        demo.testDriver();
    }

    @Test
    public void getConnection() throws Exception {
        demo.getConnection();
    }

    @Test
    public void getFile() throws IOException {
        demo.getFile();
    }

    @Test
    public void testDriverManager() throws Exception {
        demo.testDriverManager();
    }

    @Test
    public void testStatement() throws Exception {
        Connection conn = null;
        conn = demo.getConnection();
        demo.testStatement(conn);
        conn.close();
    }
}