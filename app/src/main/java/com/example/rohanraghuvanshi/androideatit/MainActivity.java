package com.example.rohanraghuvanshi.androideatit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.signin.SignIn;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn,btnSignUp;
    TextView txtSlogan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
        txtSlogan = (TextView)findViewById(R.id.txtslogan);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/NABILA.TTF");
        txtSlogan.setTypeface(face);



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn = new Intent(MainActivity.this,Signin.class);
                startActivity(signIn);


            }
        });



        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUn = new Intent(MainActivity.this,SignUp.class);
                startActivity(signUn);

            }
        });


    }
}
