package com.swpuiot.schoolnews.emtity;

/**
 * Created by 羊荣毅_L on 2016/12/9.
 */
public class HradMessages {
    private String MessageTitle;
    private String Messagecontant;

    public HradMessages(String messageTitle, String messagecontant) {
        MessageTitle = messageTitle;
        Messagecontant = messagecontant;
    }

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
}
