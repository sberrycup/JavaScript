package com.bitc.java505_team4.dto.food2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class Food2DB {
    private Food2Body body;

    @XmlElement(name = "body")
    public Food2Body getBody() {
        return body;
    }

    public void setBody(Food2Body body) {
        this.body = body;
    }
}
