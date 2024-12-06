/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import entities.User;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import services.ApiServices;
import services.UserServices;
import views.AdminHome;
import views.HomePage;

/**
 *
 * @author Guest
 */
public class LoginPageController {

    private final ApiServices api = new ApiServices();

    public Boolean Login(String username, String password) {

        username = username.trim();
        password = password.trim();

        if (username.length() <= 0 || password.length() <= 0) {
            JOptionPane.showMessageDialog(null, "Incomplete form", "Login failed", 0);
            return null;
        } else {
            UserServices userServices = new UserServices();
            JSONObject data = userServices.Login(username, password);
            if (data != null && data.getString("role").equals("general")) {
                new HomePage(data).setVisible(true);
                return true;
            } else {
                new AdminHome().setVisible(true);
                System.out.println(data.getString("role"));
            }

            return true;

        }

    }

    public void SignUp(String name, String username, String gender, String password) {
        username = username.trim();
        password = password.trim();
        name = name.trim();

        if (username.length() <= 0 || password.length() <= 0 || name.length() <= 0) {
            JOptionPane.showMessageDialog(null, "Incomplete form", "Sign up failed", 0);
        } else {
            JSONObject apiData = api.GetApiData(gender);
            User newUser = new User(name, username, password, apiData, gender);
            UserServices userServices = new UserServices();
            String message = userServices.Create(newUser);
            JOptionPane.showMessageDialog(null, message, "Message", 1);
        }

    }

}
