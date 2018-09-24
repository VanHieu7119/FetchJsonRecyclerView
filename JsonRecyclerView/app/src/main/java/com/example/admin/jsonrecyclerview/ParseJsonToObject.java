package com.example.admin.jsonrecyclerview;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJsonToObject {

    public List<User> pareJsonToObject(String data) throws JSONException {
        List<User> mUserList = new ArrayList<>();
        JSONArray jsonArray;
        jsonArray = new JSONArray(data);
        for (int i = 0; i < jsonArray.length(); i++) {
            User user = new User();
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            user.setId(jsonObject.get("id").toString());
            user.setName(jsonObject.get("login").toString());
            user.setAvatar_url (jsonObject.get("avatar_url").toString());
            mUserList.add(user);
        }
        return mUserList;
    }
}
