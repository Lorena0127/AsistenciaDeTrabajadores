/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import entities.Historico;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.HistoricoServices;
import services.UserServices;

/**
 *
 * @author Guest
 */
public class LoginPageController {

    public void Login(String username , String password) {
        
        
        
        UserServices userServices = new UserServices();
        
        boolean usuarioExistente = userServices.Login(username, password);
        

        
    }

}
