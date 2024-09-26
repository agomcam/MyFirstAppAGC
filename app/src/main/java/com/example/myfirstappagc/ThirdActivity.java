package com.example.myfirstappagc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtenemos todos los componentes
        TextView tvTexto = findViewById(R.id.tvText);
        TextView tvNumber = findViewById(R.id.tvNumber);
        TextView tvNumberDecimal = findViewById(R.id.tvNumberDecimal);
        TextView tvSwich = findViewById(R.id.tvSwich);
        Button btnBackToHome = findViewById(R.id.btnHome);


        Intent intentSecondActivity = getIntent();
        // Ponemos todos los datos correspondientes
        tvTexto.setText(intentSecondActivity.getStringExtra("etText"));
        tvNumber.setText(intentSecondActivity.getStringExtra("etNumber"));
        tvNumberDecimal.setText(intentSecondActivity.getStringExtra("etNumberDecimal"));
        // Obtenemos el valor del swich para cambiarle luego el tipo
        Boolean bol = intentSecondActivity.getBooleanExtra("swich1",true);
        // ahora si podemos poner el valor en el swich
        tvSwich.setText(bol.toString());

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(ThirdActivity.this, MainActivity.class);

                startActivity(intentHome);
            }
        });
    }
}