package ua.com.univer.pulse.lesson02.transaction;

import java.sql.*;

/**
 * Created by IShklyar on 04.04.2017.
 */
public class Part05_ResultSetMetaData {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://127.0.0.1:5432/univerlesson01";
        Connection con = DriverManager.getConnection(url, "postgres", "postgres");

        Statement st = con.createStatement();
        String selectSql = "select * from clients";
        ResultSet rs = st.executeQuery(selectSql);
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("lastname"));
            System.out.println(resultSetMetaData.getColumnName(1));
        }
        st.close();
        con.close();
    }
}
