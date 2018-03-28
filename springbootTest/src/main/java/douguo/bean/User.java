package douguo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lichang on 2018/3/5
 */
public class User implements Serializable {
    private int id;
    private String nickname;
    private String username;
    private String sex;

    @JsonIgnore
    private String password;
    private String email;
    private String mobile;
    private String birthday;
    private String type;
    private Date registerTime;

    private List<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override public String toString() {
        return "User{" + "id=" + id + ", nickname='" + nickname + '\'' + ", username='" + username + '\'' + ", sex='"
            + sex + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", mobile='" + mobile + '\''
            + ", birthday='" + birthday + '\'' + ", type='" + type + '\'' + ", roles=" + roles + '}';
    }
}

