package com.chia.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edWeight;
    EditText edHeight;
    Button help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "onClick:help");
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(R.string.BMI_info)
                        .setTitle("What is BMI?")
                        .setPositiveButton("I KNOW",null)
                        .show();



            }
        });
    }

    public void bmi(View view){
        Log.d("MainActivity","bmi");
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        Log.d("MainActivity",w+"/"+h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);
        Log.d("MainActivity", bmi+" ");
        Toast.makeText(this,"Your Bmi is  " + String.valueOf(bmi), Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi_is)+bmi)
                .setTitle("BMI")
                .setPositiveButton("OK",null)
                .setNegativeButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edHeight.setText(" ");
                        edWeight.setText(" ");
                    }
                })
                .show();
    }
}
