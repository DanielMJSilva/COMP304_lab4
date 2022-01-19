package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.lifecycle.LiveData;

import android.app.Application;
import java.util.List;

public class NurseRepository {

    public AppDao dao;
    private LiveData<List<Nurse>> allNurses;
    private LiveData<Nurse> lastNurseID;

    public NurseRepository(Application application)
    {
        AppDatabase db = AppDatabase.getDatabase(application);
        dao = db.appDao();
        allNurses = dao.readAllNurses();
        lastNurseID = dao.getLastNurseID();
    }

    public LiveData<List<Nurse>> getAllNurses() {return allNurses;}
    public LiveData<Nurse> getNurse(int nurseID) {return dao.readNurse(nurseID); }
    public LiveData<Nurse> getNurseById(Integer nurseID) {return dao.readNurseByID(nurseID); }
    public LiveData<Nurse> checkNurse(Integer nurseID, String userPassword) {return dao.validateNurse(nurseID, userPassword); }
    public LiveData<Nurse> getLastNurseID() {return lastNurseID;}

    public void insertNurse(Nurse nurse) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            dao.createNurse(nurse);
        });
    }

    public void updateNurse(Nurse nurse) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            dao.updateCustomer(nurse);
        });
    }

}