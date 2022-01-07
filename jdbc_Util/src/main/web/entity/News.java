package main.web.entity;

import com.mysql.cj.util.DnsSrv;

public class News {
    private int nid;
    private int ntid;
    private String ntitle;
    private String nauthor;
    private String ncreatedate;
    private String ncontent;
    private String npicpath;
    private String nmodifydate;
    private String nsummary;


    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public void setNtid(int ntid) {
        this.ntid = ntid;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public void setNcreatedate(String ncreatedate) {
        this.ncreatedate = ncreatedate;
    }

    public void setNpicpath(String npicpath) {
        this.npicpath = npicpath;
    }

    public void setNmodifydate(String nmodifydate) {
        this.nmodifydate = nmodifydate;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }


    public int getNid() {
        return nid;
    }

    public int getNtid() {
        return ntid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public String getNauthor() {
        return nauthor;
    }

    public String getNcreatedate() {
        return ncreatedate;
    }

    public String getNpicpath(String npicpath) {
        return this.npicpath;
    }

    public String getNmodifydate() {
        return nmodifydate;
    }

    public String getNsummary(String nsummary) {
        return this.nsummary;
    }
}
