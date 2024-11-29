
package services;

import entities.User;
import java.sql.Connection;
import model.DB;


public class UserServices {
    private DB db = new DB();
    private Connection connection = db.DBconnect();
    
    public void Create(User user){
        
        
    }
    
}
