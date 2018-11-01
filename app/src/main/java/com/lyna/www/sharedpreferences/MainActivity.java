package com.lyna.www.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonMainInput, buttonMainInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMainInput = (Button)findViewById(R.id.buttonMainInput);
        buttonMainInfo = (Button)findViewById(R.id.buttonMainInfo);

        buttonMainInput.setOnClickListener(this);
        buttonMainInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch(v.getId()) {
            case R.id.buttonMainInput:
                intent = new Intent(this, InputActivity.class);
                break;
            case R.id.buttonMainInfo:
                intent = new Intent(this, SavedActivity.class);
                break;
        }
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);
    }
}
