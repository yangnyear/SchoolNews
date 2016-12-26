package com.swpuiot.schoolnews.emtity;

/**
 * Created by 羊荣毅_L on 2016/12/9.
 */
public class HradMessages {

    private String MessageTitle;
    private String Messagecontant;
    private String msgImgId;
    private Long mwssageid;

    public String getMessageTitle() {
        return MessageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        MessageTitle = messageTitle;
    }

    public String getMessagecontant() {
        return Messagecontant;
    }

    public void setMessagecontant(String messagecontant) {
        Messagecontant = messagecontant;
    }

    public String getMsgImgId() {
        return msgImgId;
    }

    public void setMsgImgId(String msgImgId) {
        this.msgImgId = msgImgId;
    }

    public Long getMwssageid() {
        return mwssageid;
    }

    public void setMwssageid(Long mwssageid) {
        this.mwssageid = mwssageid;
    }

    public HradMessages(String messageTitle, String messagecontant, String msgImgId, Long mwssageid) {

        MessageTitle = messageTitle;
        Messagecontant = messagecontant;
        this.msgImgId = msgImgId;
        this.mwssageid = mwssageid;
    }
}
