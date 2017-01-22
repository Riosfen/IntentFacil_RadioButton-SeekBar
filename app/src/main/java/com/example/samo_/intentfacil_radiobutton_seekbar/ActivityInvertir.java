package com.example.samo_.intentfacil_radiobutton_seekbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by samo_ on 22/01/2017.
 */

public class ActivityInvertir extends AppCompatActivity {
    private static int MAXIMO_BARRA = 255;
    private TextView txtResultado;
    private Button btnMantener, btnInvertir;
    private int inversoRojo, inversoVerde, inversoAzul, inversoRojoFondo, inversoVerdeFondo, inversoAzulFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invertir);

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnMantener = (Button) findViewById(R.id.btnMantener);
        btnInvertir = (Button) findViewById(R.id.btnInvertir);

////////////////////////////////////////////////////////////////////////////////////////////////////
        // para simplificar esto: getIntent().getExtras()
        // en extras
        Bundle extras = getIntent().getExtras();
        if(extras == null){
            return;
        }

////////////////////////////////////////////////////////////////////////////////////////////////////
        // se obtienen todas las variables para poder invertir colores y mostrar los colores bien
        final int progresoRojo = extras.getInt("rojo");
        final int progresoVerde = extras.getInt("verde");
        final int progresoAzul = extras.getInt("azul");
        final int progresoRojoFondo = extras.getInt("rojoFondo");
        final int progresoVerdeFondo = extras.getInt("verdeFondo");
        final int progresoAzulFondo = extras.getInt("azulFondo");
////////////////////////////////////////////////////////////////////////////////////////////////////

        txtResultado.setTextColor(Color.rgb(progresoRojo, progresoVerde, progresoAzul));
        txtResultado.setBackgroundColor(Color.rgb(progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo));

        btnMantener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inversoRojo = progresoRojo;
                inversoVerde = progresoVerde;
                inversoAzul = progresoAzul;
                inversoRojoFondo = progresoRojoFondo;
                inversoVerdeFondo = progresoVerdeFondo;
                inversoAzulFondo = progresoAzulFondo;
                finish();
            }
        });
        btnInvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inversoRojo = MAXIMO_BARRA - progresoRojo;
                inversoVerde = MAXIMO_BARRA - progresoVerde;
                inversoAzul = MAXIMO_BARRA - progresoAzul;
                inversoRojoFondo = MAXIMO_BARRA - progresoRojoFondo;
                inversoVerdeFondo = MAXIMO_BARRA - progresoVerdeFondo;
                inversoAzulFondo = MAXIMO_BARRA - progresoAzulFondo;
                finish();
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // devolvemos todas las variables
    @Override
    public void finish() {
        // creamos el intent en el finish
        Intent intent = new Intent();

        intent.putExtra("rojo", inversoRojo);
        intent.putExtra("verde", inversoVerde);
        intent.putExtra("azul", inversoAzul);
        intent.putExtra("rojoFondo", inversoRojoFondo);
        intent.putExtra("verdeFondo", inversoVerdeFondo);
        intent.putExtra("azulFondo", inversoAzulFondo);

        setResult(RESULT_OK, intent);

        super.finish();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
}

