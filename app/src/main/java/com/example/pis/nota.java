package com.example.pis;

import android.util.Log;

import java.io.Serializable;
import java.util.UUID;

public class nota{
    private String text;
    private String title;
    private String id;
    private int password;
    private String Passwords;
    private final DataBaseAdapter adapter = DataBaseAdapter.databaseAdapter;


    public nota(String title, String text, String Password){
        this.Passwords = Password;
        this.text = text;
        this.title = title;
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        initpassw();
    }
    public nota(String title, String text, String Password, String id){
        this.Passwords = Password;
        this.text = text;
        this.title = title;
        this.id = id;
        initpassw();
    }

    public void setPasswords(String password) {
        Passwords = password;
    }

    public String getPasswords() {
        return Passwords;
    }

    private void initpassw(){
        if (this.Passwords == "True"){
            setPassword(1);
        }else{
            setPassword(0);
        }

    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public void saveCard() {
        Log.d("saveCard", "saveCard-> saveDocument");
        adapter.saveDocument(this.id, this.text, this.title, this.Passwords);
    }
    public void deleteCard(){
        adapter.deleteDocument(this.id);
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
