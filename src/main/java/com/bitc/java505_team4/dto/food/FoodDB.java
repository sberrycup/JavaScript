package com.bitc.java505_team4.dto.food;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class FoodDB {
    private FoodBody body;
    private FoodHeader header;

    @XmlElement(name = "body")
    public FoodBody getBody() {
        return body;
    }

    public void setBody(FoodBody body) {
        this.body = body;
    }

    @XmlElement(name = "header")
    public FoodHeader getHeader() {
        return header;
    }

    public void setHeader(FoodHeader header) {
        this.header = header;
    }
}
