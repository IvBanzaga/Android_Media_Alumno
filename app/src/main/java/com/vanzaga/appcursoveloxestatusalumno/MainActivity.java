package com.vanzaga.appcursoveloxestatusalumno;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

public class MainActivity extends AppCompatActivity {

    // Declaramos las variables
    private EditText txt_matematicas;
    private EditText txt_fisica;
    private EditText txt_quimica;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las variables con los elementos de la vista
        txt_matematicas = (EditText) findViewById(R.id.txt_matematicas);
        txt_fisica = (EditText) findViewById(R.id.txt_fisica);
        txt_quimica = (EditText) findViewById(R.id.txt_quimica);
        text_resultado = (TextView) findViewById(R.id.text_resultado);
    }

    public void calcularPromedio(View view) {
        // Obtenemos los valores de los EditText
        String matematicas = txt_matematicas.getText().toString();
        String fisica = txt_fisica.getText().toString();
        String quimica = txt_quimica.getText().toString();


        // Verificamos si los campos están vacios
        if (!matematicas.isEmpty() && !fisica.isEmpty() && !quimica.isEmpty()) {
            // Convertir los valores a dobles
            double num1 = Double.parseDouble(matematicas);
            double num2 = Double.parseDouble(fisica);
            double num3 = Double.parseDouble(quimica);

            // Calcular el promedio de las notas
            double nota = (num1 + num2 + num3) / 3;

            // Convertimos la nota a String
            //String resultado = String.valueOf(nota);

            // Redondeamos la nota a dos decimales
            /*String resultado = String.format("%.2f", nota);


            // Mostramos el resultado en el TextView con el mensaje correspondiente
            if (nota >= 5) {
                text_resultado.setText("Está Aprobado con un " + "<b>" + resultado + "</b>");
            } else {
                text_resultado.setText("Está Suspendido con un " + resultado);
            }*/

            // Redondeamos la nota a dos decimales
            String resultado = String.format("%.2f", nota);
            String aprobado = "<font color='#00FF00'>Está Aprobado</font> con un " + resultado;
            String suspendido = "<font color='#FF0000'>Está Suspendido</font>  5con un " + resultado;

            if (nota >= 5) {
                text_resultado.setText(HtmlCompat.fromHtml(aprobado, HtmlCompat.FROM_HTML_MODE_LEGACY));
            } else {
                text_resultado.setText(HtmlCompat.fromHtml(suspendido, HtmlCompat.FROM_HTML_MODE_LEGACY));
            }

        } else {
            // Mostramos un mensaje de error si los campos están vacíos
            //text_resultado.setText(Html.fromHtml(getString(R.string.mensaje)));
            text_resultado.setText(HtmlCompat.fromHtml(getString(R.string.mensaje), HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }
}