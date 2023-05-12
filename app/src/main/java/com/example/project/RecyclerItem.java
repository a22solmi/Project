package com.example.project;

import com.google.gson.annotations.SerializedName;

public class RecyclerItem {
    private String name;
    @SerializedName("company")
    private String use;

    @SerializedName("location")
    private String paradigm;
    @SerializedName("category")
    private String example;
    @SerializedName("size")
    private int collector;

    @SerializedName("auxdata")
    private AuxData aux;

    public String getName() { return name; }

    public String[] getParadigm() { return paradigm.split("\\s+"); }
    public String getUse() { return use; }
    public String getExample() { return example; }
    public int getCollector() { return collector; }
    public String getImg() { return aux.getImg(); }

}
