package com.example.chatapplication;

public class Users {
    String profilepic,useremail,userName,password,userId,lastMessage,status;
    public Users(){};
    public Users(String userId, String userName, String useremail, String password, String profilepic, String status) {
        this.userId = userId;
        this.userName = userName;
        this.useremail = useremail;
        this.password = password;
        this.profilepic = profilepic;
        this.status = status;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getEmail() {
        return useremail;
    }

    public void setEmail(String email) {
        this.useremail = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
