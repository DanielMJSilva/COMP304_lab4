package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AppDao {


    // --- Nurse --- \\
    // Create (Insert)
    @Insert
    void createNurse(Nurse nurse);

    // Update
    @Update
    void updateCustomer(Nurse nurse);

    // Read all records
    @Query("SELECT * FROM Nurses")
    LiveData<List<Nurse>> readAllNurses();

    // Read by primary key
    @Query("SELECT * FROM Nurses WHERE NurseID = :nurseID")
    LiveData<Nurse> readNurse(int nurseID);

    // Read by UserName
    @Query("SELECT * FROM Nurses WHERE NurseID = :nurseID")
    LiveData<Nurse> readNurseByID(int nurseID);

    // Validate Nurse
    @Query("SELECT * FROM Nurses WHERE NurseID = (:nurseID) AND nursePassword = (:nursePassword)")
    LiveData<Nurse> validateNurse(int nurseID, String nursePassword);

    //Get last ID
    @Query("SELECT NurseID FROM Nurses ORDER BY NurseID DESC LIMIT 1")
    LiveData<Nurse> getLastNurseID();


    // Delete all records
    @Query("DELETE FROM Nurses")
    void deleteAllNurses();

// ---- Test ---- \\
/*
    // Create (Insert)
    @Insert
    void createTest(Test test);

    // Read all records
    @Query("SELECT * FROM Tests")
    LiveData<List<Test>> readAllTests();

    // Read by primary key
    @Query("SELECT * FROM Tests WHERE TestID = :testID")
    LiveData<Test> readCake(int testID);

    // Update
    @Update
    void updateTest(Test test);

    // Delete all records
    @Query("DELETE FROM Tests")
    void deleteAllTests();

//    // Delete by primary key
//    @Delete
//    void deleteTest(Test test);
*/

    // ---- Patient ---- \\
    // Create (Insert)
    @Insert
    void createPatient(Patient patient);

    // Read all records
    @Query("SELECT * FROM Patients")
    LiveData<List<Patient>> readAllPatients();

    // Read by primary key
    @Query("SELECT * FROM Patients WHERE PatientID = :patientID")
    LiveData<Patient> readPatient(int patientID);

    // Delete all records
    @Query("DELETE FROM Patients")
    void deleteAllPatients();

    // Update status
    @Query("UPDATE Patients SET Status = :patientStatus WHERE PatientID = :patientID")
    void updatePatient(int patientID, String patientStatus);

}