package com.example.pickachew;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail, mPasword;
    private Button mLoginBtn;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // this will check for the status of the login
        mAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // this is triggered everytime there is a change in the Auth state
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    // we can go to the next page now
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };



        mEmail = (EditText) findViewById(R.id.email);
        mPasword = (EditText) findViewById(R.id.password);
        mLoginBtn = (Button) findViewById(R.id.loginBtn);

        final String email = mEmail.getText().toString();
        final String password = mPasword.getText().toString();




            mLoginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // we get the email and password
                    final String email = mEmail.getText().toString();
                    final String password = mPasword.getText().toString();
                    if(email.matches("")|| password.matches("")){
                        Toast.makeText(LoginActivity.this,"All Fields must be filled to login",Toast.LENGTH_LONG).show();

                    }
                    else{
                        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // check if the firebase cration was successful or not
                                if(!task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "sign in error", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }
                }
            });



    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }
}