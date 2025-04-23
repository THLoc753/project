package com.example.myapplication.model;

import java.io.Serializable;

public class NhanVat implements Serializable {
    private String id;
    private String name;
    private String image;
    private String title;
    private String vision;
    private String weapon;
    private int rarity;
    private String description;

    public NhanVat(String id, String name, String image, String title, String vision, String weapon, int rarity, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.title = title;
        this.vision = vision;
        this.weapon = weapon;
        this.rarity = rarity;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
