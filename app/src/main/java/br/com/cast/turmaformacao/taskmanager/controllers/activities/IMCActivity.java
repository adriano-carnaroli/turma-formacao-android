package br.com.cast.turmaformacao.taskmanager.controllers.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cast.turmaformacao.taskmanager.R;

/**
 * Created by Administrador on 14/09/2015.
 */
public class IMCActivity extends AppCompatActivity {
    private EditText editTextAltura;
    private EditText editTextPeso;
    private Button buttonCalcular;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        bindEditTextAltura();
        bindEditTextPeso();
        bindButtonCalcular();


    }

    private void bindButtonCalcular() {
        buttonCalcular = (Button) findViewById(R.id.buttonCalcular);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultadoIMC;
                double peso = Double.parseDouble(editTextPeso.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());
                resultadoIMC = peso / (altura * altura);

                String message = getString(R.string.msg_resultadoIMC, resultadoIMC);
                EditText result = (EditText) findViewById(R.id.editTextResult);
                result.setText(message);
                Toast.makeText(IMCActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bindEditTextPeso() {
        editTextPeso = (EditText) findViewById(R.id.editTextPeso);
    }

    private void bindEditTextAltura() {
        editTextAltura = (EditText) findViewById(R.id.editTextAltura);
    }
}
