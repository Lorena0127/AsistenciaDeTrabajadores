package com.asistencia;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private String id;
    private String name;
    private String username;
    private String password;
    private String role;
    private String avatar;
    private String gender;
    private String city;
    private String state;
    private String country;
    private int age;

    public User(String id, String name, String username, String password, String role, String avatar, String gender,
            String city, String state, String country, int age) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
        this.gender = gender;
        this.city = city;
        this.state = state;
        this.country = country;
        this.age = age;
    }

    public void getAll() {
        System.out.println(id);
        System.out.println(name);
        System.out.println(username);
        System.out.println(password);
        System.out.println(role);
        System.out.println(avatar);
        System.out.println(gender);
        System.out.println(city);
        System.out.println(state);
        System.out.println(country);
        System.out.println(age);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password = hashedPass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
