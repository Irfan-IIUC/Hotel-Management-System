
package hotel.management.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        
       try{  
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            
            c = (Connection) DriverManager.getConnection("jdbc:mysql:///projecthms","root","root"); 
            
            s = (Statement) c.createStatement();            
           
        }catch(Exception e){ 
            
            System.out.println(e);
        }  
    }
}
