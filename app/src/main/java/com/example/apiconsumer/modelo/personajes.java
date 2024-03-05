package com.example.apiconsumer.modelo;

public class personajes {

    private String id;
    private String born;
    private String gender;
    private String house;
    private Sprites sprites = new  Sprites();
    private String slug = sprites.getSlug();
    public personajes(){}
    public String getId(){return id;}
    public String getBorn(){return born;}
    public String getGender(){return gender;}
    public String getHouse(){return house;}
    public Sprites getSprites(){return sprites;}
    public String getSlug(){return slug;}
    public void setId(String id){this.id = id;}
    public void setBorn(String born){this.born = born;}
    public void setGender(String gender){this.gender = gender;}
    public void setHouse(String house){this.house = house;}
    public void setSprites(Sprites sprites){this.sprites = sprites;}
    public void setSlug(String slug){this.slug = slug;}
}
