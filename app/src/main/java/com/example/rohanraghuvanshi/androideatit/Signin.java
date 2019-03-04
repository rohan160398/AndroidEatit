package com.example.rohanraghuvanshi.androideatit;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rohanraghuvanshi.androideatit.Model.User;
import com.google.android.gms.signin.SignIn;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Signin extends AppCompatActivity {
    MaterialEditText edtPhone,edtPassword;
    Button btnSignIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        edtPhone = (MaterialEditText)findViewById(R.id.edtPhone);
        btnSignIn = (Button) findViewById(R.id. btnSignIn);


        //Init Firebase


        FirebaseDatabase database =FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");




        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(Signin.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();




                table_user.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        //Check if user not exist in Database


                        if(dataSnapshot.child(edtPhone.getText().toString()).exists())
                        {

                        //Get user information
                        mDialog.dismiss();

                        User user =dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);

                        if(user.getPassword().equals(edtPassword.getText().toString()))
                        {
                            Toast.makeText(Signin.this,"sign in successful !!",Toast.LENGTH_SHORT).show();
                        }
                        else
                            {
                                Toast.makeText(Signin.this,"wrong Password !!!",Toast.LENGTH_SHORT).show();
                            }


                        }
                        else
                        {   mDialog.dismiss();
                            Toast.makeText(Signin.this,"User not exist in Database",Toast.LENGTH_SHORT).show();;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });




    }
}
