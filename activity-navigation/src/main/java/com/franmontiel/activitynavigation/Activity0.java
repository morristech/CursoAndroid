package com.franmontiel.activitynavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.OnClick;

public class Activity0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);
        butterknife.ButterKnife.bind(this);
    }

    @OnClick(R.id.toNext)
    public void onClick() {
        NavigationHelper.open(this, Activity1.class, null);
    }
}
