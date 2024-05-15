package com.nyear.svr.roomdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText title, amount;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        amount = findViewById(R.id.amount);
        btnSave = findViewById(R.id.btnSave);
        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseHelper.expenseDao().addTx(
                        new Expense(title.getText().toString(), amount.getText().toString())
                );
                ArrayList<Expense> expenseArrayList = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpense();
                for (int i = 0; i < expenseArrayList.size(); i++) {
                    Log.d("Data", "Title: " + expenseArrayList.get(i).getTitle() + "\n Amount: " + expenseArrayList.get(i).getAmount());

                }
            }
        });

    }
}