package jdbc;

import com.mysql.cj.jdbc.Driver;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDemo {

    public void testDriver() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db_test?serverTimezone=UTC";

        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "123456");

        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    public Connection getConnection() throws Exception {
        String driverClass;
        String jdbcUrl;
        String user;
        String password;
        // 读取配置文件jdbc.properties，注意要放在resource目录下，不然在target中没有该文件
        InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);
        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        Properties info = new Properties();
        info.put("user", user);
        info.put("password", password);

        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Connection conn = driver.connect(jdbcUrl, info);
        return conn;

    }

    public void testDriverManager() throws Exception {
        String driverClass;
        String jdbcUrl;
        String user;
        String password;
        // 读取配置文件jdbc.properties，注意要放在resource目录下，不然在target中没有该文件
        InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);
        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        // 注意这里和getConnection()方法不同的地方
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
        System.out.println(conn);
    }

    // update和delete和insert操作
    public void testStatement(Connection conn) throws Exception {
        String sql = "insert into customers (name, email, birth) " +
                "values('XYZ', 'xyz@qq.com', '1990-10-13');";
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } finally {

            statement.executeUpdate(sql);
            statement.close();
        }
    }

    public File getFile() throws IOException {
        File file = new File("jdbc.properties");
        InputStream in = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String buf;
        while ((buf = reader.readLine()) != null) {
            System.out.println(buf);
        }
        return file;
    }

}
