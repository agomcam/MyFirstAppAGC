package com.example.myfirstappagc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtenemos los componentes del Activity
        EditText editText = findViewById(R.id.etText);
        EditText editNumber = findViewById(R.id.etNumber);
        EditText editNumberDecimal = findViewById(R.id.etNumberDecimal);
        Switch aSwitch = findViewById(R.id.switch1);
        Button btnActivity3 = findViewById(R.id.btnSendSecond);
        Button btnBack = findViewById(R.id.btnBack);

        // Cambiamos de plantilla
        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentActivity = new Intent(SecondActivity.this, ThirdActivity.class);
                intentActivity.putExtra("etText", editText.getText().toString());
                intentActivity.putExtra("etNumber", editNumber.getText().toString());
                intentActivity.putExtra("etNumberDecimal", editNumberDecimal.getText().toString());
                intentActivity.putExtra("swich1", aSwitch.isChecked());

                // Haacemos las comprobaciones para que no enviemos datos sin estar relleno

                if (editText.getText().toString().equalsIgnoreCase("")){
                    Toast toast = new Toast(SecondActivity.this);
                    toast.setText("El texto tine que tener contenido");
                    toast.show();
                    return;
                }
                if (editNumber.getText().toString().equalsIgnoreCase("")){
                    Toast toast = new Toast(SecondActivity.this);
                    toast.setText("Necesitas poner un número");
                    toast.show();
                    return;
                }
                if (editNumberDecimal.getText().toString().equalsIgnoreCase("")){
                    Toast toast = new Toast(SecondActivity.this);
                    toast.setText("Necesitas poner un número en decimal");
                    toast.show();
                    return;
                }
                Log.i("swich panel","swich Activity 3");
                startActivity(intentActivity);
            }
        });

        // Volvemos hacia atras
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(SecondActivity.this, MainActivity.class);
                Log.i("swich panel","swich Activity 1");
                startActivity(intentBack);
            }
        });

    }
}