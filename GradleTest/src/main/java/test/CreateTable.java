package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;


public class CreateTable {
   
   public static void main(String[] args) {
   
      Connection con = null;
      Statement stmt = null;
      int result = 0;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
         stmt = con.createStatement();
         
         result = stmt.executeUpdate("create table events("+
					"id varchar(100) not null,"+
					"duration int not null,"+
					"type varchar(100),"+
					"host varchar(100)),"+
					"alert boolean,"+
					 "PRIMARY KEY (id) ;");
					 
			  System.out.println("Table created successfully");
      }  catch (Exception e) {
         e.printStackTrace(System.out);
      }finally{
      try{
      con.close();
            }catch(SQLException e){
           
            }
      }
    
   }
}