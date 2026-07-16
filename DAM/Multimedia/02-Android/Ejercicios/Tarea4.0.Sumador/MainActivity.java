package com.example.dam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button btnSumar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Enlazar con el XML
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnSumar = findViewById(R.id.btnSumar);
        txtResultado = findViewById(R.id.txtResultado);

        // Evento
        btnSumar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String valor1 = num1.getText().toString();
                String valor2 = num2.getText().toString();

                // Validación
                if (valor1.isEmpty() || valor2.isEmpty()){
                    txtResultado.setText("No puede estar vacío");
                }else {
                    double n1 = Double.parseDouble(valor1);
                    double n2 = Double.parseDouble(valor2);
                    double sumaFinal = n1 + n2;
                    txtResultado.setText("" + sumaFinal);
                }
            }
        });
    }
}