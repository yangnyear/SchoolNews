package com.swpuiot.schoolnews.emtity;

/**
 * Created by 羊荣毅_L on 2016/12/11.
 */
public class UserEntity {
    private String content;
    int idOfImage;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdOfImage() {
        return idOfImage;
    }

    public void setIdOfImage(int idOfImage) {
        this.idOfImage = idOfImage;
    }

    public UserEntity(String content, int idOfImage) {

        this.content = content;
        this.idOfImage = idOfImage;
    }
}
