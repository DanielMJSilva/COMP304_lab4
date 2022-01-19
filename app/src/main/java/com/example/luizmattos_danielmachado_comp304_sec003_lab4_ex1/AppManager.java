package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AppManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_app_manager );

//        TextView textWelcomeMessage = findViewById(R.id.txt_WelcomeMessage);
//        SharedPreferences loginPreferences= getSharedPreferences("LoginPreferences", MODE_PRIVATE);
//        String welcomeMessage = "Welcome, " + loginPreferences.getString("customerFirstName","") + ".";
//        textWelcomeMessage.setText(welcomeMessage);
    }


    // Menu options

    public void viewPatient(View view) {
        Intent intent = new Intent(this, PatientListActivity.class);
        startActivity(intent);
    }

    public void newPatient (View view) {
        Intent intent = new Intent(this, PatientActivity.class);
        startActivity(intent);
    }

    public void addTest(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    public void updatePatient(View view) {
        Intent intent = new Intent(this, PatientUpdateActivity.class);
        startActivity(intent);
    }




}