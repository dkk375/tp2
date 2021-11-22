package com.example.tp2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.AlertDialog.Builder;
import android.util.Log;
import android.view.View;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaisirActivity extends Activity implements View.OnClickListener {

   private static final int Alert = 10;

   public EditText tNom, tPrenom;
   public Button bAnnuler, bOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.formulaire);


         bAnnuler = (Button) findViewById(R.id.btnAnnuler);
        bOk = (Button) findViewById(R.id.btnOk);


        tNom = (EditText) findViewById(R.id.txtNom);
        tPrenom = (EditText) findViewById(R.id.txtPrenom);

        bOk.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        showDialog(Alert);

    }

    public void onClic(View v) {

        tNom.setText("");
        tPrenom.setText("");



    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case Alert:
                // Create out AlterDialog
                Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Je suis "  + tNom.getText().toString() +""+ tPrenom.getText().toString());

                builder.setCancelable(true);
                builder.setPositiveButton("Valider", new OkOnClickListener());
                builder.setNegativeButton("Annuler", new AnnulerOnClickListener());
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        return super.onCreateDialog(id);
    }

    private final class AnnulerOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "Retour à la page d'accueil",
                    Toast.LENGTH_LONG).show();
        }
    }

    private final class OkOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            SaisirActivity.this.finish();
        }
    }
}
