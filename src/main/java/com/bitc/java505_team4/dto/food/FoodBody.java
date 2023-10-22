package com.bitc.java505_team4.dto.food;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class FoodBody {
    private int rcdcnt;
    private int page_No;
    private int total_Count;
    private FoodItems items;

    @XmlElement
    public int getRcdcnt() {
        return rcdcnt;
    }

    public void setRcdcnt(int rcdcnt) {
        this.rcdcnt = rcdcnt;
    }

    public int getPage_No() {
        return page_No;
    }

    public void setPage_No(int page_No) {
        this.page_No = page_No;
    }

    public int getTotal_Count() {
        return total_Count;
    }

    public void setTotal_Count(int total_Count) {
        this.total_Count = total_Count;
    }

    @XmlElement(name = "items")
    public FoodItems getItems() {
        return items;
    }

    public void setItems(FoodItems items) {
        this.items = items;
    }
}
