package test;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Statement;
import java.util.ArrayList;  

public class alertEvents {
   public static void inserAlertedEvents(ArrayList<EventData> obj) { 
      Connection con = null; 
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/test", "SA", ""); 
         stmt = con.createStatement(); 
         
         for(int j=0; j<obj.size();j++){
     		
        System.out.println(obj.get(j).getId());
        System.out.println(obj.get(j).getTimestamp());
        System.out.println(obj.get(j).getType());
        System.out.println(obj.get(j).getHost());
        System.out.println(obj.get(j).isAlert());
        
          result = stmt.executeUpdate("INSERT INTO alert(id,duration,type,host,alert) VALUES ("+obj.get(j).getId()+","+obj.get(j).getTimestamp()+","+obj.get(j).getType()+", "+obj.get(j).getHost()+","+obj.get(j).isAlert()+")"); 
        }
         
            
            con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
   } 
   
   
} 