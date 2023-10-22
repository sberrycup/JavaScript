package com.bitc.java505_team4.dto.food2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "idnt_List")
public class Food2 {
    private String food_Code;
    private String food_Name;
    private float food_Weight;
    private float energy_Qy;
    private float carbohydrate_Qy;
    private float prot_Qy;
    private float fafref_Qy;

    @XmlElement
    public String getFood_Code() {
        return food_Code;
    }

    public void setFood_Code(String food_Code) {
        this.food_Code = food_Code;
    }

    public String getFood_Name() {
        return food_Name;
    }

    public void setFood_Name(String food_Name) {
        this.food_Name = food_Name;
    }

    public float getFood_Weight() {
        return food_Weight;
    }

    public void setFood_Weight(float food_Weight) {
        this.food_Weight = food_Weight;
    }

    public float getEnergy_Qy() {
        return energy_Qy;
    }

    public void setEnergy_Qy(float energy_Qy) {
        this.energy_Qy = energy_Qy;
    }

    public float getCarbohydrate_Qy() {
        return carbohydrate_Qy;
    }

    public void setCarbohydrate_Qy(float carbohydrate_Qy) {
        this.carbohydrate_Qy = carbohydrate_Qy;
    }

    public float getProt_Qy() {
        return prot_Qy;
    }

    public void setProt_Qy(float prot_Qy) {
        this.prot_Qy = prot_Qy;
    }

    public float getFafref_Qy() {
        return fafref_Qy;
    }

    public void setFafref_Qy(float fafref_Qy) {
        this.fafref_Qy = fafref_Qy;
    }
}
