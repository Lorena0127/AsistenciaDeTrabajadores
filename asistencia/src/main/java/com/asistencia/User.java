package com.asistencia;

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

}
