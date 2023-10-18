package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class chatActivity extends AppCompatActivity {

    String receiverimg,receiverid,receivername,senderid;
    CircleImageView profilePic;
    TextView receiverName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        receivername=getIntent().getStringExtra("nameeee");
        receiverid=getIntent().getStringExtra("id");
        receiverimg=getIntent().getStringExtra("receiverimg");

        profilePic=findViewById(R.id.profilerg0);
        receiverName=findViewById(R.id.chatText);

        Picasso.get().load(receiverimg).into(profilePic);
        receiverName.setText(""+receivername);
    }
}