package com.latyshonak.dao.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class Users {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "username", unique = true, nullable = false, length = 20 )
        private String username;

        @Column(name = "password", nullable = false, length = 20)
        private String password;

        @Column( name = "email", length = 50)
        private String email;

        @Column(name = "enabled")
        private Boolean enabled;

        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
        private List<Role> roles;

        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
        private List<Images> images;


        public Users() {

        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (!username.equals(users.username)) return false;
        if (!password.equals(users.password)) return false;
        if (!email.equals(users.email)) return false;
        if (!enabled.equals(users.enabled)) return false;
        if (!roles.equals(users.roles)) return false;
        return images != null ? images.equals(users.images) : users.images == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + enabled.hashCode();
        result = 31 * result + roles.hashCode();
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", images=" + images +
                '}';
    }
}
