package controllers;

import entities.User;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import services.ApiServices;
import services.UserServices;

public class LoginPageController {

    private final ApiServices api = new ApiServices();

    public void SignUp(String name, String username, String gender, String password) {
        JSONObject apiData = api.GetApiData(gender);
        User newUser = new User(name, username, password, apiData, gender);
        UserServices userServices = new UserServices();
        String message = userServices.Create(newUser);
        JOptionPane.showMessageDialog(null, message ,"Message", 1);

    }

}
