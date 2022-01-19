package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PatientListActivity extends AppCompatActivity {

    private PatientViewModel patientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        TextView listPatient = findViewById(R.id.patientList);

        patientViewModel = new
                ViewModelProvider(this).get(PatientViewModel.class);
        patientViewModel.getAllPatients().observe( this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                String patientList = "";
                for (Patient patient: patients){

                    patientList  += "patientID: " + patient.getPatientID() +
                            "\n First Name: " + patient.getPatientFirstName() +
                            "\n Last Name: " + patient.getPatientLastName() +
                            "\n Department: " + patient.getPatientDepartment() +
//                            "\n Department: " + patient.getPatientNurseID() +
//                            "\n Department: " + patient.getPatientRoom() +
                            "\n " + patient.getPatientStatus() + "\n\n";
                }
                listPatient.setText(patientList);
            }
        } );
    }

}
