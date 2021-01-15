package com.blogspot.riteshcodejava.savethenote.ShowDataActivity;

public class DataModels {
    int Id;
    String data;

    public DataModels() {}

    public DataModels(int id, String data) {
        Id = id;
        this.data = data;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
