package com.swpuiot.schoolnews.emtity;

/**
 * Created by 羊荣毅_L on 2016/12/25.
 */
public class GridViewentity {
    private int imageId;
    private String counten;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getCounten() {
        return counten;
    }

    public void setCounten(String counten) {
        this.counten = counten;
    }

    public GridViewentity(int imageId, String counten) {

        this.imageId = imageId;
        this.counten = counten;
    }
}
