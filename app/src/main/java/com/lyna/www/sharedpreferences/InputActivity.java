package com.lyna.www.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextInputId, editTextInputPassword, editTextInputEmail;
    Button buttonInputSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        editTextInputId = (EditText)findViewById(R.id.editTextInputId);
        editTextInputPassword = (EditText)findViewById(R.id.editTextInputPassword);
        editTextInputEmail = (EditText)findViewById(R.id.editTextInputEmail);

        buttonInputSave = (Button)findViewById(R.id.buttonInputSave);
        buttonInputSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = getSharedPreferences("AWEPrefs", Context.MODE_PRIVATE).edit();
        editor.putString("idKey", editTextInputId.getText().toString());
        editor.putString("pwdKey", editTextInputPassword.getText().toString());
        editor.putString("emailKey", editTextInputEmail.getText().toString());
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, Activity.RESULT_FIRST_USER);
    }
}
