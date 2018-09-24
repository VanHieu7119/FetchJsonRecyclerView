package com.example.admin.jsonrecyclerview;

public class User {
    private String name;
    private String id;
    private String avatar_url;

    public User(String name, String id, String avatar_url) {
        this.name = name;
        this.id = id;
        this.avatar_url = avatar_url;
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
