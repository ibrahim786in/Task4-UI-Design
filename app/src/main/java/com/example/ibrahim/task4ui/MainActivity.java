package com.example.ibrahim.task4ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button begin, cancel;
    Spinner sp1, sp2, sp3;
    LinearLayout L1, L2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin = (Button) findViewById(R.id.begin);
        cancel = (Button) findViewById(R.id.cancel);
        sp1 = (Spinner) findViewById(R.id.spinner1);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp3 = (Spinner) findViewById(R.id.spinner3);
        L1 = (LinearLayout) findViewById(R.id.newAlarm);
        L2 = (LinearLayout) findViewById(R.id.repleableLayout);

        final FloatingActionButton floatBtn = (FloatingActionButton) findViewById(R.id.floatBtn);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                L1.setVisibility(View.GONE);
                L2.setVisibility(View.VISIBLE);
                floatBtn.setVisibility(View.GONE);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                L1.setVisibility(View.VISIBLE);
                L2.setVisibility(View.GONE);
                floatBtn.setVisibility(View.VISIBLE);
            }
        });
    }
}
