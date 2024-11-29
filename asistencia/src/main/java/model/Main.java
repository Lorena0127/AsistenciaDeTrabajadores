package model;

import views.Login;

public class Main {

    public static void main(String[] args) {
        DB db = new DB();
        db.DBconnect();

        Login login_frame = new Login();
        login_frame.setVisible(true);

    }
}
