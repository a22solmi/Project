package com.example.project;

import com.google.gson.annotations.SerializedName;

public class RecyclerItem {
    private String name;
    @SerializedName("company")
    private String use;

    @SerializedName("location")
    private String paradigm;
    @SerializedName("auxdata")
    private String example;

    @SerializedName("category")
    private String aux;

    public String getName() { return name; }

    public String[] getParadigm() { return paradigm.split("\\s+"); }
    public String getUse() { return use; }
    public String getExample() {
        return example.replace("\\n", System.getProperty("line.separator"));
    }
    public String getAux() { return aux; }

}
