package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NurseViewModel nurseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void validateUser(View view) {

        EditText editLoginUser = (EditText) findViewById(R.id.edt_LoginUser);
        EditText editLoginPassword = (EditText) findViewById(R.id.edt_LoginPassword);
        String loginUser = editLoginUser.getText().toString();
        String loginPassword = editLoginPassword.getText().toString();
        String validationMessage = getString(R.string.text_validation);

        // Storing user name
        SharedPreferences loginPreferences = getSharedPreferences("LoginPreferences",0);
        SharedPreferences.Editor loginEdit = loginPreferences.edit();

        // Validating user
        if ( loginUser.isEmpty() || loginPassword.isEmpty() )
        {
            Toast.makeText(this, validationMessage, Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            nurseViewModel = new
                    ViewModelProvider(this).get(NurseViewModel.class);
            nurseViewModel.checkNurse(Integer.parseInt(loginUser), loginPassword).observe( this, new Observer<Nurse>() {
                @Override
                public void onChanged(Nurse nurse) {
                    if (nurse == null){
                        Toast.makeText(getApplicationContext(), "Invalid User or Password.", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        // Storing Customer's data in Shared Preferences
                        loginEdit.putString("NurseUserID", String.valueOf(nurse.nurseID));
                        loginEdit.putString("NurseUserName", nurse.firstName);
                        loginEdit.putString("NursePassword", nurse.nursePassword);
                        loginEdit.putString("NurseFirstName", nurse.firstName);
                        loginEdit.putString("NurseLastName", nurse.lastName);
                        loginEdit.commit();

                        Intent intent = new Intent(getApplicationContext(), AppManager.class);
                        startActivity(intent);
                    }
                }
            } );

        }
    }

    // NurseActivity to insert new nurse
    public void newNurse (View view) {
        Intent intent = new Intent(this, NurseActivity.class);
        startActivity(intent);
    }


}