package com.latyshonak.dao.Entity;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class Users {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "login", unique = true, nullable = false, length = 20 )
        private String login;

        @Column(name = "password", nullable = false, length = 20)
        private String password;

        @Column( name = "e_mail", length = 50)
        private String email;

        public Users() {

        }


    public Users(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (!login.equals(users.login)) return false;
        if (!password.equals(users.password)) return false;
        return email.equals(users.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
