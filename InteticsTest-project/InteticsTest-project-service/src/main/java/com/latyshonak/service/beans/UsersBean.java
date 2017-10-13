package com.latyshonak.service.beans;

import com.latyshonak.dao.Entity.Images;

import java.util.List;

public class UsersBean {

    private int id;

    private String password;

    private String retypePassword;

    private String email;

    private String username;

    private Boolean enabled;

    private List<RoleBean> roles;

    private  List<Images> imagesList;

    public UsersBean() {

    }


    public int getId() { return id; }

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

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String repeatPassword) {
        this.retypePassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() { return enabled; }

    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }

    public List<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersBean usersBean = (UsersBean) o;

        if (id != usersBean.id) return false;
        if (password != null ? !password.equals(usersBean.password) : usersBean.password != null) return false;
        if (retypePassword != null ? !retypePassword.equals(usersBean.retypePassword) : usersBean.retypePassword != null)
            return false;
        if (email != null ? !email.equals(usersBean.email) : usersBean.email != null) return false;
        if (username != null ? !username.equals(usersBean.username) : usersBean.username != null) return false;
        if (enabled != null ? !enabled.equals(usersBean.enabled) : usersBean.enabled != null) return false;
        if (roles != null ? !roles.equals(usersBean.roles) : usersBean.roles != null) return false;
        return imagesList != null ? imagesList.equals(usersBean.imagesList) : usersBean.imagesList == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (retypePassword != null ? retypePassword.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (imagesList != null ? imagesList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UsersBean{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", imagesList=" + imagesList +
                '}';
    }
}
