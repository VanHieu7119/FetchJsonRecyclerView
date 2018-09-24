package com.example.admin.jsonrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PassData {
    private fetchData mFetchData;
    private UserAdapter mUserAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserAdapter = new UserAdapter(getApplicationContext());
        mFetchData = new fetchData(this);
        mFetchData.execute();
        mRecyclerView = findViewById(R.id.rv_user);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mUserAdapter);
    }

    @Override
    public void result(List<User> list) {
        mUserAdapter.updateData(list);
    }
}
