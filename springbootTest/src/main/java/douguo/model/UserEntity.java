package douguo.model;

import java.io.Serializable;

/**
 * Created by lcyanxi on 2018/2/26.
 */
public class UserEntity implements Serializable{

    private static final long serialVersionUID = 23458641759842411L;
    private Long id;
    private String userName;
    private String passWord;
    private String userSex;
    private String nickName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserEntity() {
    }

    public UserEntity(Long id, String userName, String passWord, String userSex, String nickName) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
        this.nickName = nickName;
    }
}
