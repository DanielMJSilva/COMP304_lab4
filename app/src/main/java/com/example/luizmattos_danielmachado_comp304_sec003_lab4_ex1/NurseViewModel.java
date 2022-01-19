package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import android.app.Application;
import android.os.Bundle;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {

    private NurseRepository nurseRepository;
    private final LiveData<List<Nurse>> allNurses;


    public NurseViewModel (Application application) {
        super(application);
        nurseRepository = new NurseRepository(application);
        allNurses = nurseRepository.getAllNurses();

    }

    public LiveData<List<Nurse>> getAllNurses() { return allNurses; }

    public LiveData<Nurse> getNurseById(Integer nurseID) { return nurseRepository.getNurseById(nurseID); }

    public LiveData<Nurse> checkNurse(Integer nurseID, String userPassword) { return nurseRepository.checkNurse(nurseID, userPassword); }

    public void insertNurse(Nurse nurse) { nurseRepository.insertNurse(nurse); }

    public void updateNurse(Nurse nurse) { nurseRepository.updateNurse(nurse); }

    public LiveData<Nurse> getLastNurseID() { return nurseRepository.getLastNurseID(); }
}