package com.example.luizmattos_danielmachado_comp304_sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NurseActivity extends AppCompatActivity {

    private NurseViewModel nurseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_nurse );
    }


    public void nurseAdd (View view){

        nurseViewModel = new ViewModelProvider(this).get(NurseViewModel.class);

        EditText editFirstNameAdd = (EditText) findViewById(R.id.edt_FirstNameAdd);
        EditText editLastNameAdd = (EditText) findViewById(R.id.edt_LastNameAdd);
        EditText editNurseDepartment = (EditText) findViewById(R.id.edt_DepartmentAdd);
        EditText editUserPasswordAdd = (EditText) findViewById(R.id.edt_NursePasswordAdd);

        String userPasswordAdd = editUserPasswordAdd.getText().toString();
        String firstNameAdd = editFirstNameAdd.getText().toString();
        String lastNameAdd = editLastNameAdd.getText().toString();
        String department = editNurseDepartment.getText().toString();

        if (
                userPasswordAdd.isEmpty() ||
                firstNameAdd.isEmpty() ||
                lastNameAdd.isEmpty() ||
                department.isEmpty())

        {


            Toast.makeText(this, "Please, fill all fields.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {

            // Inserting new Nurse
            nurseViewModel.insertNurse(new Nurse(
                    firstNameAdd,
                    lastNameAdd,
                    department,
                    userPasswordAdd
            ));
            nurseViewModel.getAllNurses().observe(this, nurses -> {
                String s="";
                int count=0;

                for (Nurse nurse: nurses)
                {
                    count++;
                    s+= nurse.getNurseID()+"\n";
                }

            Toast.makeText( this, "Nurse ID: " + nurses.get(nurses.size()-1).getNurseID(), Toast.LENGTH_LONG ).show();
            // Redirecting to main page
            Intent intent = new Intent( this, MainActivity.class );
            startActivity( intent );

        });}

    }


}