package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Employees?useSSL=false";

    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

        // Set the JDBC URL to the HikariConfig
        config.setJdbcUrl(DB_URL);

        config.setUsername(DB_USERNAME);
        config.setPassword(DB_PASSWORD);

        // Rest of your data source properties

        config.addDataSourceProperty("cachePrepStmts", "false");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.addDataSourceProperty("useLocalSessionState", "true");
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.addDataSourceProperty("cacheResultSetMetadata", "true");
        config.addDataSourceProperty("elideSetAutoCommits", "true");
        config.addDataSourceProperty("maintainTimeStats", "false");

        dataSource = new HikariDataSource(config);

    }






    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO EMP(name, job, salary) VALUES(?,?,?)";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getJob());
            statement.setDouble(3, employee.getSalary());

            statement.executeUpdate();
        }
    }

    public static Employee getEmployee(int id) throws SQLException {
        String query = "SELECT * FROM emp WHERE id=?";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setJob(resultSet.getString("job"));
                    employee.setSalary(resultSet.getDouble("salary"));

                    return employee;
                }
            }
        }

        return null;
    }
}