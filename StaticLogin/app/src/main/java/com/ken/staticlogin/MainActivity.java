package com.ken.staticlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String s1,s2;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit);
        e2=findViewById(R.id.edit1);
        cb=findViewById(R.id.check);
        b1=findViewById(R.id.btn);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    e2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    e2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();

                if (s1.contentEquals("Ketan") && s2.contentEquals("12345")){

                    Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();

                    Intent i=new Intent(MainActivity.this,Afterlogin.class);
                    startActivity(i);
                }else {
                    Toast.makeText(MainActivity.this, "Invlid Username or password. Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
