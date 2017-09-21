package com.latyshonak.service.beans;

public class UsersBean {

    private int id;

    private String login;

    private String password;

    private String repeatPassword;

    private String email;

    public UsersBean(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public UsersBean() {

    }

    @Override
    public String toString() {
        return "UsersBean{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", e_mail='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersBean usersBean = (UsersBean) o;

        if (id != usersBean.id) return false;

        if (!login.equals(usersBean.login)) return false;
        if (!password.equals(usersBean.password)) return false;
        if (repeatPassword != null ? !repeatPassword.equals(usersBean.repeatPassword) : usersBean.repeatPassword != null)
            return false;
        return email.equals(usersBean.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (repeatPassword != null ? repeatPassword.hashCode() : 0);
        result = 31 * result + email.hashCode();
        return result;
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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
