package ua.com.univer.pulse.lesson02.transaction;

import java.sql.*;
import java.util.Arrays;

/**
 * Created by IShklyar on 04.04.2017.
 */
public class Part04_DatabaseMetaData {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://127.0.0.1:5432/univerlesson01";
        Connection con = DriverManager.getConnection(url, "postgres", "postgres");

        DatabaseMetaData metaData = con.getMetaData();
        System.out.println(metaData.getDatabaseProductName());
        ResultSet resultSet = metaData.getTables("univerlesson01", "public", "clients", null);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(4));
        }

        ResultSet metaDataCatalogs = metaData.getCatalogs();
        while (metaDataCatalogs.next()) {
            System.out.println(metaDataCatalogs.getString(1));
        }

        System.out.println(Arrays.toString(metaData.getNumericFunctions().split(","))); // Список скалярных функций [abs, acos, asin, atan, atan2, ceiling, cos, cot, degrees, exp, floor, log, log10, mod, pi, power, radians, round, sign, sin, sqrt, tan, truncate]

        con.close();
    }
}
