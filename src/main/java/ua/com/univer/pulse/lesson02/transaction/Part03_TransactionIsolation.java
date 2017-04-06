package ua.com.univer.pulse.lesson02.transaction;

import java.sql.*;

/**
 * Created by IShklyar on 04.04.2017.
 */
public class Part03_TransactionIsolation {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://127.0.0.1:5432/univerlesson01";
        Connection con = DriverManager.getConnection(url, "postgres", "postgres");

        con.setAutoCommit(false);
        System.out.println(con.getTransactionIsolation() == Connection.TRANSACTION_READ_COMMITTED);
        con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

        con.close();
    }
}
