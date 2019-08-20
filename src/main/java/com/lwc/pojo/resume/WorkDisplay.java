package com.lwc.pojo.resume;

import org.bson.types.ObjectId;

import java.io.Serializable;

public class WorkDisplay  implements Serializable {
    private String workUrl;
    private String workDescription;
    private Integer tag;
    private ObjectId wId;

    public ObjectId getwId() {
        return wId;
    }

    public void setwId(ObjectId wId) {
        this.wId = wId;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getWorkUrl() {
        return workUrl;
    }

    public void setWorkUrl(String workUrl) {
        this.workUrl = workUrl;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }
}
