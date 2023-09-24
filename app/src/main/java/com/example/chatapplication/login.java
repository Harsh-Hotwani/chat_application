package com.example.chatapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    Button button;
    EditText username,password;
    TextView text;
    FirebaseAuth auth;

    android.app.ProgressDialog progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait");
        progressDialog.setCancelable(false);
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.Loginbutton);
        username = findViewById(R.id.editTextLogEmailAddress);
        password = findViewById(R.id.editTextLogPassword);
        text = findViewById(R.id.textView6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = username.getText().toString();
                String loginPass = password.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                progressDialog.show();
                if (TextUtils.isEmpty(loginEmail))
                {
                    progressDialog.dismiss();
                    Toast.makeText(login.this, "enter the email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(loginPass))
                {
                    progressDialog.dismiss();
                    Toast.makeText(login.this, "enter your password", Toast.LENGTH_SHORT).show();
                } else if (!loginEmail.matches(emailPattern)) {
                    progressDialog.dismiss();
                    username.setError("please enter a valid email");
                } else if (loginPass.length()<6) {
                    progressDialog.dismiss();
                    password.setError("more than 6 characters");
                    Toast.makeText(login.this, "password must be greater than 6 characters", Toast.LENGTH_SHORT).show();
                }
                else {
                    auth.signInWithEmailAndPassword(loginEmail, loginPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
//                                progressDialog.show();
                                try {
                                    Intent intent = new Intent(login.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } catch (Exception e) {
                                    progressDialog.dismiss();
                                    Toast.makeText(login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,registration.class);
                startActivity(intent);
                finish();
            }
        });
    }
}