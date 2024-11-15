package com.asistencia;

import java.util.Scanner;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        Api api = new Api();
        String[] genders = { "female", "male" };
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese los siguientes datos:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("Type a number (1.Female / 2.Male): ");
            int indexGender = Integer.valueOf(scanner.nextLine());
            scanner.close();

            String gender = genders[indexGender - 1];

            JSONObject response = api.apiConnect(gender);
            User newUser = api.createUserFromResponse(response);
            newUser.setName(name);
            newUser.setUsername(username);
            newUser.setPassword(password);

            // newUser.getAll();

            DB database = new DB();
            database.createUserRow(newUser);
        } catch (Exception e) {
            System.err.println("Error al conectar con la API: " + e.getMessage());
        }
    }
}
