package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Statement st = null;

        try{
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rowsAffected1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            

            int rowsAffected2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            System.out.println("Done! Rows affected: " + rowsAffected1 + rowsAffected2);

            conn.commit();
        }
        catch (SQLException  e) {

            try {
                conn.rollback();
                throw new DbException("Transaction got rolled back! Cause: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to roll back! Cause: " + ex.getMessage());
            }

        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();

        }

    }
}
