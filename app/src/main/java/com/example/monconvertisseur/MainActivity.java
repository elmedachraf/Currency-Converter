package com.example.monconvertisseur;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public double maSomme ;

    public double maSommeConvertie ;
    public String[] devises = { "Euro €", "Dollar $", "Yen ¥", "livre sterling £", "Dirham MAD"};

    public double MadToEuro = 0.093 ;
    public double DollarToEuro = 1.02 ;
    public double YenToEuro = 0.0068 ;
    public double LivreToEuro = 1.15 ;

    public double entree = 1 ;
    public double sortie = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin1 = (Spinner) findViewById(R.id.spinner1);
        spin1.setOnItemSelectedListener(this);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the devises list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,devises);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin1.setAdapter(aa);
        spin2.setAdapter(aa);
    }
    public void Convert_Money(View view) {
        System.out.print("On passe ici après un appui sur le bouton ENVOI");
        EditText editTexte = (EditText) findViewById(R.id.chp_saisie);
        String message = editTexte.getText().toString();
        maSomme = Double.parseDouble(message);
        maSommeConvertie = maSomme*(entree/sortie) ;
        TextView monResultat = (TextView) findViewById(R.id.chp_view);
        monResultat.setText(Double.toString(maSommeConvertie));

    }

    @Override

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        // Toast.makeText(getApplicationContext(), devises[position], Toast.LENGTH_LONG).show();
        switch (adapterView.getId()){
            case R.id.spinner1:
                //Do something
                switch (position) {
                    case 0:
                        entree = 1;
                        break;
                    case 1:
                        entree = DollarToEuro;
                        break;
                    case 2:
                        entree = YenToEuro;
                        break;
                    case 3:
                        entree = LivreToEuro;
                        break;
                    case 4:
                        entree = MadToEuro;
                        break;
                }
                break;
            case R.id.spinner2:
                //Do another thing
                //Toast.makeText(this, "Option Selected: " + adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        sortie = 1;
                        break;
                    case 1:
                        sortie = DollarToEuro;
                        break;
                    case 2:
                        sortie = YenToEuro;
                        break;
                    case 3:
                        sortie = LivreToEuro;
                        break;
                    case 4:
                        sortie = MadToEuro;
                        break;
                }
                break;
            //default:
                //Toast.makeText(getApplicationContext(), devises[position], Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}