package com.example.myapp;

import android.view.View;
import android.widget.Toast;
public class MyListener implements View.OnClickListener{
    ConvertActivity currentActivity;
    public MyListener(ConvertActivity currentActivity){
        this.currentActivity = currentActivity;
    }
    @Override
    public void onClick(View view) {

        if(view.getId() == currentActivity.getButton_covert().getId()){

            double resultat=0;
            double val = 0;
            // on ecrit ici le code d'excution de la convertion
            // 1 On recuper les valaur

            try {
                val = Double.parseDouble(currentActivity.getValue_et().getText().toString());
            }catch (NumberFormatException e)
            {
                Toast.makeText(currentActivity, "Merci de fournir une valaur numérique ", Toast.LENGTH_LONG).show();
                return;
            }
            // 2 savoir quel est le bouton radio qui été selectionné
            if(currentActivity.getEuro2dinar_rb().isChecked()==true){
                resultat = val * 3.4;
            }else {
                if (currentActivity.getDinar2euro_rb().isChecked()==true) {
                    resultat = val / 3.4;
                }
                else{
                    Toast.makeText(currentActivity,
                            "Merci de choisir un Button", Toast.LENGTH_LONG).show();
                    return;
                }
            }
            // 3 on affecte le resultat au
            currentActivity.getText_final().setText(resultat+"");
        }

        if(view.getId() == currentActivity.getButton_quitter().getId()){

            // on ecrit ici le code d'excution de la Fermeture (Quitter)
            System.exit(0);
        }
    }
}
