package com.s.arithmetic;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etfirst, etSecond;
    Button submit, close;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etfirst = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);
        submit = findViewById(R.id.btncal);
        close = findViewById(R.id.btnclose);

        builder = new AlertDialog.Builder(this);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etfirst.getText())){
                    etfirst.setError("Enter First Number");
                    return;
                }
                if (TextUtils.isEmpty(etSecond.getText())){
                    etSecond.setError("Enter Second Number");
                    return;
                }


                int firstNumber = Integer.parseInt(etfirst.getText().toString());
                int secondNumber = Integer.parseInt(etSecond.getText().toString());

                int result = firstNumber + secondNumber;

                Toast toast = Toast.makeText(MainActivity.this,Integer.toString(result),Toast.LENGTH_LONG);
                toast.show();

            }
        });


//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.super.finish();
//            }
//        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("Do you want to close this application?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(getApplicationContext(),"you clicked Yes",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"You clicked no",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("My app");
                alert.show();

            }
        });



    }
}
