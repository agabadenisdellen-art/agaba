package com.example.taxcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText incomeEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incomeEditText = findViewById(R.id.incomeEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String incomeStr = incomeEditText.getText().toString();
                if (!incomeStr.isEmpty()) {
                    double income = Double.parseDouble(incomeStr);
                    double tax = Incometax.calculateTax(income);
                    resultTextView.setText("Tax: " + tax);
                }
            }
        });
    }
}
