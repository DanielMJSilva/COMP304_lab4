package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;


@Entity(tableName = "Tests")
public class Test {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "TestID")
    public int testID;

    @ColumnInfo(name = "PatientID")
    public String testPatientID;
//
//    @ColumnInfo(name = "NurseID")
//    public String testNurseID;
//
//    @ColumnInfo(name = "BPL")
//    public int testBPL;
//
//    @ColumnInfo(name = "BPH")
//    public int testBPH;
//
//    @ColumnInfo(name = "Temperature")
//    public int testTemperature;


    // Cake Setter
    public Test(String testPatientID)

    {
        this.testPatientID = testPatientID;

    }


    // Getters
    public String testPatientID() {
        return testPatientID;
    }


}