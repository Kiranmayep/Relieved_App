package com.example.relieved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class HelpLineActivity extends AppCompatActivity {
    Button buttoncall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_line);

        buttoncall = findViewById(R.id.btncall);

        buttoncall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:4066202000"));
            startActivity(intent);


        });
        buttoncall = findViewById(R.id.btn1call);

        buttoncall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:7893078930"));
            startActivity(intent);
        } );


        buttoncall = findViewById(R.id.btn2call);

        buttoncall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:040-46004600"));
            startActivity(intent);
        } );

        buttoncall = findViewById(R.id.btn3call);

        buttoncall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:104"));
            startActivity(intent);
        } );






    }
}