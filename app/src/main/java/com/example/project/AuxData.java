package com.example.project;

public class AuxData {
    private String wiki;
    private String img;

    public AuxData(String wiki, String img) {
        this.wiki = wiki;
        this.img = img;
    }

    public String getWiki() { return wiki; }
    public String getImg() { return img; }

    public void setWiki(String wiki) { this.wiki = wiki; }
    public void setImg(String img) { this.img = img; }
}
