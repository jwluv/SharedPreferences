package com.lyna.www.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SavedActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textViewSavedId, textViewSavedPassword, textViewSavedEmail;
    Button buttonSavedOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        textViewSavedId = (TextView)findViewById(R.id.textViewSavedId);
        textViewSavedPassword = (TextView)findViewById(R.id.textViewSavedPassword);
        textViewSavedEmail = (TextView)findViewById(R.id.textViewSavedEmail);

        buttonSavedOk = (Button)findViewById(R.id.buttonSavedOk);
        buttonSavedOk.setOnClickListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences("AWEPrefs", Context.MODE_PRIVATE);
        textViewSavedId.setText(sharedPreferences.getString("idKey", null));
        textViewSavedPassword.setText(sharedPreferences.getString("pwdKey", null));
        textViewSavedEmail.setText(sharedPreferences.getString("emailKey", null));


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);
    }
}
