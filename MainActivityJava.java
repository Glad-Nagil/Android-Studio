package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityJava extends AppCompatActivity {

    private LinearLayout myLayout;
    private TextView title_tv;
    private EditText value_et;
    private RadioGroup type_conversation_rg;
    private RadioButton euro2dinar_rb;
    private RadioButton dinar2euro_rb;
    private RadioButton dinar2fcfa_rb;
    private RadioButton fcfa2dinar_rb;
    private RadioButton fcfa2euro_rb;
    private RadioButton euro2fcfa_rb;
    private Button button_covert;
    private TextView text_final;
    private Button button_quitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creation du layout (viewGroup) de la vue :
        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        myLayout.setLayoutParams(layoutParams);
        myLayout.setBackgroundColor(Color.WHITE);
        //myLayout.setBackground(R.drawable.change);

        //Création des differentes view (Composants graphiques) de l'interface:
        title_tv = new TextView(this);
        title_tv.setText(R.string.title_lab);
        title_tv.setTextSize(30);
        title_tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        title_tv.setTextColor(Color.BLUE);
        value_et = new EditText(this);
        value_et.setHint(R.string.value_et_lab);
        type_conversation_rg = new RadioGroup(this);
        euro2dinar_rb = new RadioButton(this);
        euro2dinar_rb.setText(R.string.euro2dinar_lab);
        euro2dinar_rb.setTextSize(20);
        dinar2euro_rb = new RadioButton(this);
        dinar2euro_rb.setText(R.string.dinar2euro_lab);
        dinar2euro_rb.setTextSize(20);
        fcfa2euro_rb = new RadioButton(this);
        fcfa2euro_rb.setText(R.string.fcfa2euro_lab);
        fcfa2euro_rb.setTextSize(20);
        fcfa2dinar_rb = new RadioButton(this);
        fcfa2dinar_rb.setText(R.string.fcfa2dinar_lab);
        fcfa2dinar_rb.setTextSize(20);
        dinar2fcfa_rb = new RadioButton(this);
        dinar2fcfa_rb.setText(R.string.dinar2fcfa_lab);
        dinar2fcfa_rb.setTextSize(20);
        euro2fcfa_rb = new RadioButton(this);
        euro2fcfa_rb .setText(R.string.euro2fcfa_lab);
        euro2fcfa_rb .setTextSize(20);

        //Ajouter les 2 bouttons radio à leur conteneur (viewgoup)
        type_conversation_rg.addView(euro2dinar_rb);
        type_conversation_rg.addView(dinar2euro_rb);
        type_conversation_rg.addView(fcfa2euro_rb);
        type_conversation_rg.addView(fcfa2dinar_rb);
        type_conversation_rg.addView(euro2fcfa_rb);
        type_conversation_rg.addView(dinar2fcfa_rb);

        //Création d'un boutton de commande
        button_covert = new Button(this);
        button_covert.setText(R.string.button_convert_lab);
        button_covert.setBackgroundColor(Color.GREEN);

       // button_covert.setTextColor(Color.WHITE);
        //Création de la zone d'affichage du resultat
        text_final = new TextView(this);
        text_final.setText(R.string.text_final_lab);
        text_final.setTextSize(24);
        text_final.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        text_final.setTextColor(Color.BLACK);

        //Création d'un boutton quitter
        button_quitter = new Button(this);
        button_quitter.setText(R.string.button_quitter_lab);
        button_quitter.setBackgroundColor(Color.RED);
        //button_quitter.setTextColor(Color.WHITE);
        //On ajoute les différentes views crées dans le layout principal :
        myLayout.addView(title_tv);
        myLayout.addView(value_et);
        myLayout.addView(type_conversation_rg);
        myLayout.addView(button_covert);
        myLayout.addView(text_final);
        myLayout.addView(button_quitter);

        //Affichage de la vue associée à l'activité :
        setContentView(myLayout);
        button_covert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // view est le coposant graphique qui a recu l'action
                if(view.getId() == button_covert.getId())
                {  //on ecrit ici le code d'execution de la conversion:
                    double resultat=0;
                    double val =0;
                    //les etapes:
                    // 1. on recupere la valeur saisie:
                    try {
                        val = Double.parseDouble(value_et.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivityJava.this, "Please give one numeric value", Toast.LENGTH_LONG).show();
                        return;
                    }

                    //2. savoir quel est le bouton radio qui a été selectionné,
                    // si un bouton a été selectionné, on calculer le resulat,
                    // sinon, on affiche un message d'erreur via une notification
                    if(euro2dinar_rb.isChecked()==true)
                    {
                        resultat = val * 3.4;

                    }
                    else if(fcfa2dinar_rb.isChecked()==true){
                        resultat = val * 0.0051;

                    }
                    else if(dinar2fcfa_rb.isChecked()==true){
                        resultat = val * 193.73;

                    }
                    else if(fcfa2euro_rb.isChecked()==true){
                        resultat = val * 0.00152;

                    }
                    else if(euro2fcfa_rb.isChecked()==true){
                        resultat = val * 655.957;

                    }
                    else {
                        if (dinar2euro_rb.isChecked() == true) {
                            resultat = val / 3.4;

                        }
                        else {
                            Toast.makeText(MainActivityJava.this, "Please select one choice", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
//3. on affetce le resultat au la zone de type TextView : result_tv

                    text_final.setText(resultat+"");
                    String formattedValue = String.format("%.3f", resultat, "");
                    text_final.setText(formattedValue);
                }


            }
        });
        button_quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

}