package com.swpuiot.schoolnews.emtity;

/**
 * Created by 羊荣毅_L on 2016/12/6.
 */
public class StudentsUnition {
    private String UnitionName;
    private String imageid;
    private int id;

    public String getUnitionName() {
        return UnitionName;
    }

    public void setUnitionName(String unitionName) {
        UnitionName = unitionName;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentsUnition(String unitionName, String imageid, int id) {

        UnitionName = unitionName;
        this.imageid = imageid;
        this.id = id;
    }
}

