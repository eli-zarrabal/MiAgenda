package itsco.edu.miagenda;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detalle extends AppCompatActivity implements View.OnClickListener {

    private TextView txtnombre, txtmovil, txtcasa, txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txtnombre = (TextView) findViewById(R.id.txtnombre);
        txtmovil = (TextView) findViewById(R.id.txtmovil);
        txtcasa = (TextView) findViewById(R.id.txtcasa);
        txtemail = (TextView) findViewById(R.id.txtemail);

        Intent intent = getIntent();

        String nombre = intent.getStringExtra("NOMBRE");
        String movil = intent.getStringExtra("MOVIL");
        String casa = intent.getStringExtra("CASA");
        String email = intent.getStringExtra("EMAIL");

        txtnombre.setText(nombre);
        txtmovil.setText(movil);
        txtcasa.setText(casa);
        txtemail.setText(email);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onClick(View v) {






        if (v.getId() == txtmovil.getId()) {

            String number = txtmovil.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" +number));
            startActivity(intent);

        }

        else if(v.getId()==txtcasa.getId()){

            String numero2=txtcasa.getText().toString();
            Intent in=new Intent(Intent.ACTION_DIAL);
            in.setData(Uri.parse("tel:"+numero2));
            startActivity(in);



        }
    }
}

