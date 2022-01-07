package main.web.entity;

public class Comment {
    private int cid;

    private int cnid;
    private String ccontent;
    private String cdate;
    private String cip;

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    private String cauthor;

    public int getCid() {
        return cid;
    }

    public int getCnid() {
        return cnid;
    }



    public String getCdate() {
        return cdate;
    }

    public String getCip() {
        return cip;
    }

    public String getCauthor() {
        return cauthor;
    }

    public void setCid(int cin) {
        this.cid = cin;
    }

    public void setCnid(int cnid) {
        this.cnid = cnid;
    }



    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public void setCauthor(String cauthor) {
        this.cauthor = cauthor;
    }
}
