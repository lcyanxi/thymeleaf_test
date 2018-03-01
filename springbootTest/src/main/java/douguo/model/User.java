package douguo.model;

import java.io.Serializable;

/**
 * Created by lichang on 2018/3/1
 */
public class User implements Serializable{
    private static final long serialVersionUID = -5474478712246304909L;
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
