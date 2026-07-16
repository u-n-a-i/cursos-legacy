package com.example.dam;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroupOS;
    CheckBox checkProgramacion, checkDisenio, checkAdministracion;
    TextView resultado;
    Button btnAceptar;

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

        // Elementos del Layout
         radioGroupOS = findViewById(R.id.radioGroupOS);
         checkProgramacion = findViewById(R.id.checkProgramacion);
        checkAdministracion = findViewById(R.id.checkAdministracion);
        resultado = findViewById(R.id.resultado);
        btnAceptar = findViewById(R.id.btnAceptar);

        //Evento BTN
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Bloque SO
                String sistemaOperativo = "Ninguno";
                int selectedId = radioGroupOS.getCheckedRadioButtonId();

                if (selectedId == R.id.radioLinux) {
                    sistemaOperativo = "Linux";
                } else if (selectedId == R.id.radioWindows) {
                    sistemaOperativo = "Windows";
                } else if (selectedId == R.id.radioMac) {
                    sistemaOperativo = "Mac";
                }

                // Bloque especialidad
                String especialidad = "Ninguna";
                if (checkProgramacion.isChecked()) {
                    especialidad = "Programación";
                } else if (checkDisenio.isChecked()) {
                    especialidad = "Diseño gráfico";
                } else if (checkAdministracion.isChecked()) {
                    especialidad = "Administración";
                }

                String mensaje = "Tu sistema operativo preferido es " + sistemaOperativo +
                        " y tu especialidad es " + especialidad + ".";

                resultado.setText(mensaje);
            }
        });
    }
}