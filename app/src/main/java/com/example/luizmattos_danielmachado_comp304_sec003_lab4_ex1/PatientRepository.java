package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import android.app.Application;
import android.os.Bundle;

import java.util.List;

public class PatientRepository {

    public AppDao dao;
    private LiveData<List<Patient>> allPatients;

    public PatientRepository(Application application)
    {
        AppDatabase db = AppDatabase.getDatabase(application);
        dao = db.appDao();
        allPatients = dao.readAllPatients();
    }

    public LiveData<List<Patient>> getAllPatients() {return allPatients;}
    public LiveData<Patient> getPatient(int patientID) {return dao.readPatient(patientID); }

    public void insertPatient(Patient patient) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            dao.createPatient(patient);
        });
    }

    public void updatePatient(Patient patient) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            dao.createPatient(patient);
        });
    }

}


