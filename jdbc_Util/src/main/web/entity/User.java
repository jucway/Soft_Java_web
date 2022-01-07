package main.web.entity;
// 用户实体
public class User {

    private int usid;
    private String uname;
    private String upwd;
    public int getUid() {
        return usid;
    }

    public String getUname() {
        return uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUid(int uid) {
        this.usid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
