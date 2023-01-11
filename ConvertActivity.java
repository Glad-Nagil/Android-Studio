package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertActivity extends AppCompatActivity {

    private TextView title_tv;
    private EditText value_et;
    private RadioGroup type_conversation_rg;
    private RadioButton euro2dinar_rb;
    private RadioButton dinar2euro_rb;
    private Button button_covert;
    private TextView text_final;
    private Button button_quitter;

    public TextView getTitle_tv() {
        return title_tv;
    }

    public EditText getValue_et() {
        return value_et;
    }

    public RadioGroup getType_conversation_rg() {
        return type_conversation_rg;
    }

    public RadioButton getEuro2dinar_rb() {
        return euro2dinar_rb;
    }

    public RadioButton getDinar2euro_rb() {
        return dinar2euro_rb;
    }

    public Button getButton_covert() {
        return button_covert;
    }

    public TextView getText_final() {
        return text_final;
    }

    public Button getButton_quitter() {
        return button_quitter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        //On fait référence aux composantes graphiques (view) avec les objets java :
        title_tv = findViewById(R.id.title_tv);
        value_et = findViewById(R.id.value_et);
        type_conversation_rg = findViewById(R.id.type_conversation_rg);
        euro2dinar_rb = findViewById(R.id.euro2dinar_rb);
        dinar2euro_rb = findViewById(R.id.dinar2euro_rb);
        button_covert = findViewById(R.id.button_covert);
        text_final = findViewById(R.id.text_final);
        button_quitter = findViewById(R.id.button_quitter);


        // Programmer l'action click sur les boutons
        button_covert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == button_covert.getId()){

                    double resultat=0;
                    double val = 0;
                    // on ecrit ici le code d'excution de la convertion
                    // 1 On recuper les valaur

                    try {
                        val = Double.parseDouble(value_et.getText().toString());
                    }catch (NumberFormatException e)
                    {
                        Toast.makeText(ConvertActivity.this,"Merci de fournir une valaur numérique ", Toast.LENGTH_LONG).show();
                        return;
                    }
                    // 2 savoir quel est le bouton radio qui été selectionné
                    if(euro2dinar_rb.isChecked()==true){
                        resultat = val * 3.4;
                    }else {
                        if (dinar2euro_rb.isChecked()==true) {
                            resultat = val / 3.4;
                        }
                        else{
                            Toast.makeText(ConvertActivity.this, "Merci de choisir un Button", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                    // 3 on affecte le resultat au
                    text_final.setText(resultat+"");
                }

                if(view.getId() == button_quitter.getId()){

                    // on ecrit ici le code d'excution de la Fermeture (Quitter)
                    System.exit(0);
                }
            }
        });
        //button_covert.setOnClickListener(this);
        //button_quitter.setOnClickListener(this);
    }
}