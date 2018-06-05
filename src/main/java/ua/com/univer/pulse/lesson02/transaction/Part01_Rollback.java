package ua.com.univer.pulse.lesson02.transaction;

import java.sql.*;

/**
 * Created by IShklyar on 04.04.2017.
 */
public class Part01_Rollback {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://127.0.0.1:5432/univerlesson01";
        Connection con = DriverManager.getConnection(url, "postgres", "postgres");

        con.setAutoCommit(false);

        Statement st1 = con.createStatement();
        Statement st2 = con.createStatement();
        try {
            st1.execute("insert into clients(name, lastname) values ('aaa2', 'aaa2')");
            st1.execute("insert into clients(name, lastname) valuesaa ('bbb2', 'bbb2')");
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        } finally {
            con.commit();
        }

        String selectSql = "select * from clients";
        ResultSet rs = st1.executeQuery(selectSql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("lastname"));
        }

        con.close();
    }
}
