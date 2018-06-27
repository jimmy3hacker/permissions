package com.acadview.permissions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText phone,message;
    Button send;

    private static final int REQUEST_CODE_SMS = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.ph);
        message = findViewById(R.id.msg);
        send = findViewById(R.id.send);

        String[] permissions = {
                Manifest.permission.SEND_SMS
        };

        //CHECK  IF MSG PERMISSION IS GRANTED

        if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){

            // if permission is not granted then request for permission

            ActivityCompat.requestPermissions(MainActivity.this,new
            String[]{Manifest.permission.SEND_SMS},123);
        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phone = phone.getText().toString().trim();
                String Message = message.getText().toString().trim();

                SmsManager sms  = SmsManager.getDefault();
                Random r = new Random();
                int i1 = r.nextInt(9999-1111) + 1111;
                String MessageNumber = i1+"";
                sms.sendTextMessage(Phone,null,MessageNumber,null,null);

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("message",MessageNumber);
                startActivity(intent);


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 123){
            if(grantResults.length>0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"Permission Granted !",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,"permission not granted",Toast.LENGTH_SHORT).show();
            }
        }


    }
}
