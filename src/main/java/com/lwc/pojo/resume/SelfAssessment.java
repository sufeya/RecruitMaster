package com.lwc.pojo.resume;

import java.io.Serializable;

public class SelfAssessment implements Serializable {
    private String description;
    private Integer tag;

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
