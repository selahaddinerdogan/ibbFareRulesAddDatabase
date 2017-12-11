/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoncacbs.ibbfareadddb;

import java.sql.*;

public class DBTool {

    public static void main(String[] args) {

    }
    private java.sql.Connection conn;

    public DBTool() {
        connect();
    }

    public final void connect() {
        try {
            /*
             * Load the JDBC driver and establish a connection.
             */

            String ip = "localhost";
            String usr = "postgres";
            String pass = "1618";
            String db = "gtfs";

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + ip + "/" + db;

            conn = DriverManager.getConnection(url, usr, pass);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (Exception e) {
            System.out.println("Veri Tabanı Hatası: " + e);
        }
    }

    public boolean isClosed() {
        try {
            return conn.isClosed();
        } catch (Exception e) {
            return true;
        }
    }

    public boolean execute(String query) {
        try {
            if (conn.isClosed()) {
                connect();
            }
            conn.createStatement().execute(query);
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getDataCount(String query) {

        try {
            if (conn.isClosed()) {
                connect();
            }
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(query);
            ResultSetMetaData rsmd = r.getMetaData();
            int count = 0;
            while (r.next()) {
                count++;
            }
            s.close();
            conn.close();

            return count;
        } catch (Exception e) {
            return -1;
        }
    }

    public String executeUpdate(String query) {
        try {
            // System.out.println(query);
            // query = query.replaceAll("\\", "/");

            //query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            Statement s = conn.createStatement();
            int i = s.executeUpdate(query);

            s.close();
            //conn.close();

            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public ResultSet getResultSet(String query) {
        try {
            if (conn.isClosed()) {
                connect();
            }
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(query);

//            if (r!=null) {
//                if (r.next()) {
//                    System.out.println(r.getInt("cnt"));
//                }
//            }
            conn.close();
            return r;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
        }
    }

    public Statement getConnStatement() {
        try {
            Statement s = conn.createStatement();
            return s;
        } catch (Exception e) {
            return null;
        }
    }

    public void closeConn() {

        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public PreparedStatement prepareStatement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
