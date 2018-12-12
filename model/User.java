package com.pierogranda.proyectointegrador12.model;

public class User  {
    private int id;
    private String email;
    private String name;
    private String password;
    private String username;
    private int career_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCareer_id() {
        return career_id;
    }

    public void setCareer_id(int career_id) {
        this.career_id = career_id;
    }



   @Override
   public String toString()
   {return "User " +
            "[id=" + id +
            ", email=" + email +
            ", name=" + name +
            ", password=" + password +
            ", username=" + username +
            ", career_id=" + career_id +
           ", estado=" + career_id +
            "]";
   }



}
