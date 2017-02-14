package com.example.administrador.aulajonas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AulaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula);

        final Button button = (Button) findViewById(R.id.buttonMensagem);
        final EditText editText = (EditText) findViewById(R.id.editMensagem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMensagem = new Intent(Intent.ACTION_VIEW);
                intentMensagem.setData(Uri.parse("sms:" + editText.getText()));
                startActivity(intentMensagem);
            }
        });


        final Button button1 = (Button) findViewById(R.id.buttonSite);
        final EditText editText1 = (EditText) findViewById(R.id.editSite);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String site = editText1.getText().toString();
                if (!site.startsWith("http://")) {
                    site = "http://" + site;
                }
                Intent intentSite = new Intent(Intent.ACTION_VIEW);
                intentSite.setData(Uri.parse(site));
                startActivity(intentSite);

            }
        });


        final Button buttonLocaliz = (Button) findViewById(R.id.buttonLocaliz);
        final EditText editTextLatit = (EditText) findViewById(R.id.editLatit);
        final EditText editTextLong = (EditText) findViewById(R.id.editLong);
        buttonLocaliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentMapa = new Intent(Intent.ACTION_VIEW);
                intentMapa.setData(Uri.parse("geo:" + editTextLatit.getText()+","+editTextLong.getText()));
                startActivity(intentMapa);

            }
        });

    }

}
