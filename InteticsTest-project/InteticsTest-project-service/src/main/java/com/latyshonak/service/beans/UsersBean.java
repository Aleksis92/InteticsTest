package com.latyshonak.service.beans;

import java.util.List;

public class UsersBean {

    private int id;

    private String password;

    private String retypePassword;

    private String email;

    private String username;

    private Boolean enabled;

    private List<RoleBean> roles;


    public UsersBean() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersBean usersBean = (UsersBean) o;

        if (id != usersBean.id) return false;
        if (!password.equals(usersBean.password)) return false;
        if (retypePassword != null ? !retypePassword.equals(usersBean.retypePassword) : usersBean.retypePassword != null)
            return false;
        if (!email.equals(usersBean.email)) return false;
        if (username != null ? !username.equals(usersBean.username) : usersBean.username != null) return false;
        if (enabled != null ? !enabled.equals(usersBean.enabled) : usersBean.enabled != null) return false;
        return roles.equals(usersBean.roles);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + password.hashCode();
        result = 31 * result + (retypePassword != null ? retypePassword.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + roles.hashCode();
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
                '}';
    }
}
