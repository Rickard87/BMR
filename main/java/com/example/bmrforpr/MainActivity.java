package com.example.bmrforpr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtHeadline, txtWeight, txtLength, txtKg, txtCm, txtResult;
    EditText edtWeight, edtLength;
    Button btnCal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHeadline = findViewById(R.id.txtHeadline);
        txtWeight = findViewById(R.id.txtWeight);
        txtLength = findViewById(R.id.txtLength);
        edtWeight = findViewById(R.id.edtWeight);
        edtLength = findViewById(R.id.edtLength);
        btnCal = findViewById(R.id.btnCal);
        txtResult = findViewById(R.id.txtResult);
        /* Double.toString(BMR) */

        //Button function

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if (TextUtils.isEmpty(edtLength.getText()) || TextUtils.isEmpty(edtWeight.getText()))
                    {txtResult.setText("Fyll i Vikt och Längd");}

                    else {

                        double weight = Double.parseDouble(edtWeight.getText().toString()); /* Takes EditText value into int weight */
                        int length = Integer.parseInt(edtLength.getText().toString()); /* Takes EditText value into int length */
                        double BMR = (9.247 * weight) + (3.098 * length) - (4.330 * 34) + 447.593; /* Calculates the BMR with decimals */
                        int BMRint = (int) Math.round(BMR); /* Makes BMR (double) into an int by rounding the number */

                        txtResult.setText("Ditt BMR blir " + Integer.toString(BMRint) + " kcal." + "\n"
                                + "Ett överskott på ca 350-500kcal/dag bör ge en viktökning på ca 0,5kg/v." + "\n"
                                + "Ett underskott på ca 350-500kcal/dag bör ge en viktminskning på ca 0,5kg/v." + "\n"
                                + "\n"
                                + "Dessa är ungefärliga siffror och rekommendationer och vi har alla lite olika förutsättningar."
                        );

                        view.clearFocus();

                    }
                }

                catch (Exception e)
                {
                    txtResult.setText(e.toString());
                }


            }
        });


    }
}