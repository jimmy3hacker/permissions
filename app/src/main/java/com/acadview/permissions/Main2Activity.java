package com.acadview.permissions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText otp;
    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.otp);
        otp = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        //sended otp

        final String number = getIntent().getStringExtra("message");
        final int x = Integer.valueOf(number);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // enter otp
                String userotp = otp.getText().toString();
                int y = Integer.valueOf(userotp);

                if ( x == y)
                {
                    Toast.makeText(Main2Activity.this, "successful", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Main2Activity.this, "wrong otp", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}


