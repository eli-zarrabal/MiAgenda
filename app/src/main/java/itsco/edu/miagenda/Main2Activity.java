package itsco.edu.miagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btnok,btnCancel;

    private EditText txtnombre, txtmovil,txtcasa,txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnok=(Button) findViewById(R.id.btn_guardar);
        btnCancel=(Button)findViewById(R.id.btn_cancelar);
        txtnombre =(EditText) findViewById(R.id.txt_nombre);
        txtmovil=(EditText)findViewById(R.id.txt_movil);
        txtcasa=(EditText)findViewById(R.id.txt_casa);
        txtemail=(EditText)findViewById(R.id.txt_email);

        btnok.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==btnok.getId()){
            Contacto c= new Contacto();

            c.setNombre(txtnombre.getText().toString());
            c.setMovil(txtmovil.getText().toString());
            c.setCasa(txtcasa.getText().toString());
            c.setEmail(txtemail.getText().toString());

            Intent data=getIntent();
            data.putExtra("NOMBRE",txtnombre.getText().toString());
            setResult(RESULT_OK,data);
            data.putExtra("MOVIL",txtmovil.getText().toString());
            setResult(RESULT_OK,data);
            data.putExtra("CASA",txtcasa.getText().toString());
            setResult(RESULT_OK,data);
            data.putExtra("EMAIL",txtemail.getText().toString());

            finish();
        }
        if (v.getId()==btnCancel.getId()){
            setResult(RESULT_CANCELED);
            finish();
        }

    }
}
