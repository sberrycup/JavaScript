package com.bitc.java505_team4.dto.food2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class Food2Body {
    private Food2Items items2;

    @XmlElement(name = "items")
    public Food2Items getItems2() {
        return items2;
    }

    public void setItems2(Food2Items items2) {
        this.items2 = items2;
    }
}
