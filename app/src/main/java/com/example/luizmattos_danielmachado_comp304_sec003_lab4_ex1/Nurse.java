package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;


@Entity(tableName = "Nurses")
public class Nurse {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "NurseID")
    public int nurseID;

    @ColumnInfo(name = "firstName")
    public String firstName;

    @ColumnInfo(name = "NurseLastName")
    public String lastName;

    @ColumnInfo(name = "NurseDepartment")
    public String department;

    @ColumnInfo(name = "NursePassword")
    public String nursePassword;

    // Registration for Nurse
    public Nurse(
                    String firstName,
                    String lastName,
                    String department,
                    String nursePassword)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.nursePassword = nursePassword;
    }

    // Nurse Setter for UPDATE
    @Ignore
    public Nurse(int nurseID,
                 String firstName,
                 String lastName,
                 String department,
                 String nursePassword)

    {
        this.nurseID = nurseID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.nursePassword = nursePassword;

    }

    // Getters
    public int getNurseID() {return nurseID; }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDepartment() {
        return department;
    }
    public String getNursePassword() {
        return nursePassword;
    }

}
