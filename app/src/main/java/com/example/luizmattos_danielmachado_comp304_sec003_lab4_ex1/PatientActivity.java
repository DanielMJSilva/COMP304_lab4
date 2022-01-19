package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PatientActivity extends AppCompatActivity {
    private PatientViewModel patientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);


    }

    public void patientAdd(View view) {
        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);


        EditText editPatientID = (EditText) findViewById(R.id.P_ID);
        EditText editPatientFirstName = (EditText) findViewById(R.id.P_firstName);
        EditText editPatientLastName = (EditText) findViewById(R.id.P_lastName);
        EditText editPatientDepartment = (EditText) findViewById(R.id.P_department);
//        EditText editNursePatientID = (EditText) findViewById(R.id.P_nurseID);
//        EditText editPatientRoom = (EditText) findViewById(R.id.P_room);

        String patientIDAdd = editPatientID.getText().toString();
        String patientFirstNameAdd = editPatientFirstName.getText().toString();
        String patientLastNameAdd = editPatientLastName.getText().toString();
        String patientDepartment = editPatientDepartment.getText().toString();
//        String patientNurseIDAdd = editNursePatientID.getText().toString();
//        String patientRoomAdd = editPatientRoom.getText().toString();

        if (
                patientIDAdd.isEmpty() ||
                        patientFirstNameAdd.isEmpty() ||
                        patientLastNameAdd.isEmpty() ||
                        patientDepartment.isEmpty())
//                        patientNurseIDAdd.isEmpty() ||
//                        patientRoomAdd.isEmpty())
         {
            Toast.makeText(this, "Please, fill all fields.", Toast.LENGTH_LONG).show();
            return;
        } else {

            // Inserting new Patient
            patientViewModel.insertPatient(new Patient(
                    patientIDAdd,
                    patientFirstNameAdd,
                    patientLastNameAdd,
                    patientDepartment
//                    patientNurseIDAdd,
//                    patientRoomAdd
            ));


            Toast.makeText(this, "Patient added successfully!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, AppManager.class);
            startActivity(intent);


        }

    }
}