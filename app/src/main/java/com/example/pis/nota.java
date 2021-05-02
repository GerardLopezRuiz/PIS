package com.example.pis;

import android.util.Log;

import java.util.UUID;

public class nota{
    private String text;
    private String title;
    private String id;
    private String path;
    private final DataBaseAdapter adapter = DataBaseAdapter.databaseAdapter;


    public nota(String title, String text){
        this.text = text;
        this.title = title;
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.path = path;
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }
    public void saveCard() {
        Log.d("saveCard", "saveCard-> saveDocument");
        adapter.saveDocument(this.id, this.text, this.title);
    }

}
