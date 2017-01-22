package com.example.samo_.intentfacil_radiobutton_seekbar;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

////////////////////////////////////////////////////////////////////////////////////////////////////
// en el Manifest hay que poner el
public class MainActivity extends AppCompatActivity {

    // Constante para ver si ha ido bien
    private static final int REQUEST_CODE = 10;

    private SeekBar barRojo, barVerde, barAzul;
    private RadioGroup rdbGrupo;
    private RadioButton rdbFondo, rdbLetra;
    private Button btnAceptar;
    private TextView txtDevuelto;
    private int progresoRojo, progresoVerde, progresoAzul, progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdbGrupo = (RadioGroup) findViewById(R.id.rdbGrupo);
        rdbFondo = (RadioButton) findViewById(R.id.rdbFondo);
        rdbLetra = (RadioButton) findViewById(R.id.rdbLetra);
        barRojo = (SeekBar) findViewById(R.id.barRojo);
        barVerde = (SeekBar) findViewById(R.id.barVerde);
        barAzul = (SeekBar) findViewById(R.id.barAzul);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        txtDevuelto = (TextView) findViewById(R.id.txtDevuelto);

        barRojo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(rdbGrupo.getCheckedRadioButtonId()){
                    case R.id.rdbFondo:
                        progresoRojoFondo = progress;
                        txtDevuelto.setBackgroundColor(Color.rgb(progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo));
                        txtDevuelto.setTextColor(Color.rgb(progresoRojo, progresoVerde, progresoAzul));
                        break;
                    case R.id.rdbLetra:
                        progresoRojo = progress;
                        txtDevuelto.setBackgroundColor(Color.rgb(progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo));
                        txtDevuelto.setTextColor(Color.rgb(progresoRojo, progresoVerde, progresoAzul));
                        break;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        barVerde.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(rdbGrupo.getCheckedRadioButtonId()){
                    case R.id.rdbFondo:
                        progresoVerdeFondo = progress;
                        txtDevuelto.setBackgroundColor(Color.rgb(progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo));
                        txtDevuelto.setTextColor(Color.rgb(progresoRojo, progresoVerde, progresoAzul));
                        break;
                    case R.id.rdbLetra:
                        progresoVerde = progress;
                        txtDevuelto.setBackgroundColor(Color.rgb(progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo));
                        txtDevuelto.setTextColor(Color.rgb(progresoRojo, progresoVerde, progresoAzul));
                        break;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        barAzul.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(rdbGrupo.getCheckedRadioButtonId()){
                    case R.id.rdbFondo:
                        progresoAzulFondo = progress;
                        txtDevuelto.setBackgroundColor(Color.rgb(progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo));
                        txtDevuelto.setTextColor(Color.rgb(progresoRojo, progresoVerde, progresoAzul));
                        break;
                    case R.id.rdbLetra:
                        progresoAzul = progress;
                        txtDevuelto.setBackgroundColor(Color.rgb(progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo));
                        txtDevuelto.setTextColor(Color.rgb(progresoRojo, progresoVerde, progresoAzul));
                        break;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        rdbGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rdbFondo:
                        barAzul.setProgress(progresoAzulFondo);
                        barVerde.setProgress(progresoVerdeFondo);
                        barRojo.setProgress(progresoRojoFondo);
                        break;
                    case R.id.rdbLetra:
                        barAzul.setProgress(progresoAzul);
                        barVerde.setProgress(progresoVerde);
                        barRojo.setProgress(progresoRojo);
                        break;
                }
            }
        });
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityInvertir.class);

                intent.putExtra("rojo", progresoRojo);
                intent.putExtra("verde", progresoVerde);
                intent.putExtra("azul", progresoAzul);
                intent.putExtra("rojoFondo", progresoRojoFondo);
                intent.putExtra("verdeFondo", progresoVerdeFondo);
                intent.putExtra("azulFondo", progresoAzulFondo);

////////////////////////////////////////////////////////////////////////////////////////////////////
                // lanzamos la actividad
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // si se recive se obtienen todas las variables y se le vuelve a poner el color
        if(RESULT_OK == resultCode && REQUEST_CODE == requestCode){
            progresoRojo = data.getExtras().getInt("rojo");
            progresoVerde = data.getExtras().getInt("verde");
            progresoAzul = data.getExtras().getInt("azul");
            progresoRojoFondo = data.getExtras().getInt("rojoFondo");
            progresoVerdeFondo = data.getExtras().getInt("verdeFondo");
            progresoAzulFondo = data.getExtras().getInt("azulFondo");

            txtDevuelto.setBackgroundColor(Color.rgb(progresoRojoFondo, progresoVerdeFondo, progresoAzulFondo));
            txtDevuelto.setTextColor(Color.rgb(progresoRojo, progresoVerde, progresoAzul));
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
}

