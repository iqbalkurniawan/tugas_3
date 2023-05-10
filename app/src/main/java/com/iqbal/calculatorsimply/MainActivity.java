package com.iqbal.calculatorsimply;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBilangan1, editTextBilangan2;
    private TextView textViewHasilPerhitunganValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBilangan1 = findViewById(R.id.editTextBilangan1);
        editTextBilangan2 = findViewById(R.id.editTextBilangan2);
        textViewHasilPerhitunganValue = findViewById(R.id.textViewHasilPerhitunganValue);

        Button buttonPenjumlahan = findViewById(R.id.penjumlahan);
        Button buttonPengurangan = findViewById(R.id.pengurangan);
        Button buttonPerkalian = findViewById(R.id.perkalian);
        Button buttonPembagian = findViewById(R.id.pembagian);

        buttonPenjumlahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        buttonPengurangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('-');
            }
        });

        buttonPerkalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });

        buttonPembagian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });
    }

    private void hitung(char operator) {
        double bilangan1 = Double.parseDouble(editTextBilangan1.getText().toString());
        double bilangan2 = Double.parseDouble(editTextBilangan2.getText().toString());
        double hasil = 0;

        switch (operator) {
            case '+':
                hasil = bilangan1 + bilangan2;
                break;
            case '-':
                hasil = bilangan1 - bilangan2;
                break;
            case '*':
                hasil = bilangan1 * bilangan2;
                break;
            case '/':
                if (bilangan2 != 0) {
                    hasil = bilangan1 / bilangan2;
                } else {
                    textViewHasilPerhitunganValue.setText("Tidak dapat dibagi oleh 0");
                    return;
                }
                break;
        }

        textViewHasilPerhitunganValue.setText(String.valueOf(hasil));
    }
}