package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class registration extends AppCompatActivity {

    TextView loginbut;
    EditText rg_username , rg_email , rg_password, rg_repassword;
    Button singup;
    CircleImageView img;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        rg_email=findViewById(R.id.rgemail);
        rg_username=findViewById(R.id.rgusername);
        rg_password=findViewById(R.id.rgpassword);
        rg_repassword=findViewById(R.id.rgrepassword);
        singup=findViewById(R.id.signupbutton);
        img=findViewById(R.id.profilerg0);
        loginbut=findViewById(R.id.loginbut);

        loginbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registration.this,login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}