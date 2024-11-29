/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import services.UserServices;

/**
 *
 * @author Guest
 */
public class LoginPageController {

    public void Login(String username , String password) {
        UserServices userServices = new UserServices();
        userServices.Login(username, password);
    }

}
