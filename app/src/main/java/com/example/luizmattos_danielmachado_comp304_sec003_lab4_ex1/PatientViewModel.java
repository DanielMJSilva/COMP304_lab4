package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import android.app.Application;
import android.os.Bundle;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {

    private PatientRepository patientRepository;
    private final LiveData<List<Patient>> allPatients;

    public PatientViewModel (Application application) {
        super(application);
        patientRepository = new PatientRepository(application);
        allPatients = patientRepository.getAllPatients();
    }

    public LiveData<List<Patient>> getAllPatients() { return allPatients; }

    public LiveData<Patient> getPatient(int patientID) { return patientRepository.getPatient(patientID); }

    public void insertPatient(Patient patient) { patientRepository.insertPatient(patient); }

    public void updatePatient(Patient patient) { patientRepository.updatePatient(patient);}


}