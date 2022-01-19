package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import java.util.SplittableRandom;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PatientUpdateActivity extends AppCompatActivity {

    private PatientViewModel patientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_update);

        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);

        EditText editPatientFirstName = (EditText) findViewById(R.id.updateFirstName);
        EditText editPatientLastName = (EditText) findViewById(R.id.updateLastName);
        EditText editPatientDepartment = (EditText) findViewById(R.id.updateDepartment);
//        EditText editPatientNurse = (EditText) findViewById(R.id.updateNurseID);
//        EditText editPatientRoom = (EditText) findViewById(R.id.updateRoom);

        {
            patientViewModel.getPatient(3).observe(this, new Observer<Patient>() {
                @Override
                public void onChanged(Patient patient) {
                    if (patient == null) {
                        Toast.makeText(getApplicationContext(), "Patient does not exist", Toast.LENGTH_LONG).show();
                    } else {
                        editPatientFirstName.setText(patient.patientFirstName);
                        editPatientLastName.setText(patient.patientLastName);
                        editPatientDepartment.setText(patient.patientDepartment);
//                    editPatientNurse.setText(patient.patientNurse);
//                    editPatientRoom.setText(patient.patientRoom);
                    }
                }
            });

        }
    }

    public void updateConfirm(View view){

        EditText editPatientFirstName = (EditText) findViewById(R.id.updateFirstName);
        EditText editPatientLastName = (EditText) findViewById(R.id.updateLastName);
        EditText editPatientDepartment = (EditText) findViewById(R.id.updateDepartment);
//        EditText editPatientNurse = (EditText) findViewById(R.id.updateNurseID);
//        EditText editPatientRoom = (EditText) findViewById(R.id.updateRoom);

        // updating
        String patientFirstNameUpdate = editPatientFirstName.getText().toString();
        String patientLastNameUpdate = editPatientLastName.getText().toString();
        String patientDepartmentUpdate = editPatientDepartment.getText().toString();
//        String patientNurseIDUpdate = editPatientNurse.getText().toString();
//        String patientRoomUpdate = editPatientRoom.getText().toString();

        if (
                patientFirstNameUpdate.isEmpty() ||
                        patientLastNameUpdate.isEmpty() ||
                        patientDepartmentUpdate.isEmpty()
//                        patientNurseIDUpdate.isEmpty() ||
//                        patientRoomUpdate.isEmpty())
        )
        {
            Toast.makeText(this, "Please, fill all fields.", Toast.LENGTH_LONG).show();
            return;
        } else {

int patientID = 1;
String status = "aaaaa";



            // Updating new Patient
            patientViewModel.updatePatient(new Patient(
                    patientID,
                    "Luiz",
                    "Mattos",
                    "Trauma",
                    status));

//            patientViewModel.updatePatient(new Patient(
//                    patientID,
//                    patientFirstNameUpdate,
//                    patientLastNameUpdate,
//                    patientDepartmentUpdate,
//                    status));
//                    patientNurseIDUpdate,
//                    patientRoomUpdate


            Toast.makeText(this, "Patient added successfully!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, AppManager.class);
            startActivity(intent);
        }
    }


}







