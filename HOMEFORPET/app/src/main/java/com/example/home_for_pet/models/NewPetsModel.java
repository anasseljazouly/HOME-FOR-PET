package com.example.home_for_pet.models;

import java.io.Serializable;

public class NewPetsModel implements Serializable {
    String description;
    String img_url;
    String localisation;
    Boolean male;
    String name;
    String type;

    public NewPetsModel() {
    }

    public NewPetsModel(String description, String img_url, String localisation, Boolean male, String name, String type) {
        this.description = description;
        this.img_url = img_url;
        this.localisation = localisation;
        this.male = male;
        this.name = name;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
