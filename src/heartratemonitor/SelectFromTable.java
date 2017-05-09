/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oliver
 */
public class SelectFromTable {
    public SelectFromTable(){
        
    }
        
    /**
     * check inputs if it is existed from table results 
     * one combined primary key from two column values
     * @param t1 user name 
     * @param t2 test date
     * @return boolean
     * @throws java.sql.SQLException
     */
    public Boolean isExist(String t1, String t2) throws SQLException{
        ConnectLocalDatabase cn = new ConnectLocalDatabase();
        if (cn.connectDB()) {
            PreparedStatement pst = cn.conn.prepareStatement("Select * from results "
                + "where username=? and testdate=?");
            pst.setString(1, t1);
            pst.setString(2, t2);
            try (ResultSet rs = pst.executeQuery()) {
                //if (rs.equals(NULL)) return FALSE;
                while (rs.next()) {
                    if (rs.equals(NULL)) {
                        return FALSE;
                    } else {
                        return TRUE;
                    }
                }
            }
        } else {
            return FALSE;            
        }
        cn.closeConnection();
        return FALSE;        
    } 
    
    /**
     * check inputs if it is existed from table (only one primary key in table)
     * @param table table name
     * @param columnName column name
     * @param arg table primary key 
     * @return boolean 
     * @throws java.sql.SQLException
     */
    public Boolean isRowExist(String table, String columnName, String arg) throws SQLException{
        ConnectLocalDatabase cn = new ConnectLocalDatabase();
        if (cn.connectDB()) {            
            PreparedStatement pst = cn.conn.prepareStatement("Select * from ? where ?=?");
            pst.setString(1, table);
            pst.setString(2, columnName);
            pst.setString(3, arg);
            try (ResultSet rs = pst.executeQuery()) {
                //if (rs.equals(NULL)) return FALSE;
                while (rs.next()) {
                    if (rs.equals(NULL)) {
                        return FALSE;
                    } else {
                        return TRUE;
                    }
                }
            }
        } else {
            //return FALSE;            
        }
        cn.closeConnection();
        return FALSE;        
    } 
}
