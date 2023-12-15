package com.ecloset.Bean;

public class clothes {
    private String name;
    private String category;
    private String img_clothes;
    private Boolean is_deleted;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getImg_clothes() {
        return img_clothes;
    }

    public void setImg_clothes(String img_clothes) {
        this.img_clothes = img_clothes;
    }

    public clothes(String name, String category, String img_clothes) {
        this.name = name;
        this.category = category;
        this.img_clothes = img_clothes;
    }
}
