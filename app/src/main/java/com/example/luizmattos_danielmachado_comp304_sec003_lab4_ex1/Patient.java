package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;


@Entity(tableName = "Patients")
public class Patient {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "PatientID")
    public int patientID;

    @ColumnInfo(name = "patientFirstName")
    public String patientFirstName;

    @ColumnInfo(name = "patientLastName")
    public String patientLastName;

    @ColumnInfo(name = "patientDepartment")
    public String patientDepartment;

//    @ColumnInfo(name = "patientNurseID")
//    public String patientNurseID;
//
//    @ColumnInfo(name = "room")
//    public String room;

    @ColumnInfo(name = "status")
    public String status;

    // Patient Setter
    public Patient(String patientFirstName,
                   String patientLastName,
                   String patientDepartment,
//                   String patientNurseID,
//                   String room,
                   String status)
    {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDepartment = patientDepartment;
//        this.patientNurseID = patientNurseID;
//        this.room = room;
        this.status = status;
    }

    // Patient Update
    @Ignore
    public Patient(int patientID,
            String patientFirstName,
                   String patientLastName,
                   String patientDepartment,
//                   String patientNurseID,
//                   String room,
                   String status)
    {
        this.patientID = patientID;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDepartment = patientDepartment;
//        this.patientNurseID = patientNurseID;
//        this.room = room;
        this.status = status;
    }

    // Getters
    public int getPatientID() {
        return patientID;
    }
    public String getPatientFirstName() {return patientFirstName; }
    public String getPatientLastName() {
        return patientLastName;
    }
    public String getPatientDepartment() {
        return patientDepartment;
    }

//    public String getPatientNurseID() {
//        return patientNurseID;
//    }
//    public String getPatientRoom() {
//        return room;
//    }
    public String getPatientStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}