package itsco.edu.miagenda;

import android.content.ComponentCallbacks;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{

    public static final int NUEVA_CONTACTO=10;

    ListView Lista;
    private ArrayList<Contacto> data;
    private ArrayAdapter<Contacto> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.boton_agregar);

        fab.setOnClickListener(this);
        Lista=(ListView)findViewById(R.id.lista_contacto);
        data=new ArrayList<>();
        adapter=new ArrayAdapter<Contacto>(this,android.R.layout.simple_list_item_1,android.R.id.text1,data);

        Lista.setAdapter(adapter);
        Lista.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(this,Main2Activity.class);
        startActivityForResult(i,NUEVA_CONTACTO);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Contacto c=new Contacto();
        c=data.get(position);

        Intent intent=new Intent(this,Detalle.class);
        intent.putExtra("NOMBRE",c.getNombre());
        intent.putExtra("MOVIL",c.getMovil());
        intent.putExtra("CASA",c.getCasa());
        intent.putExtra("EMAIL",c.getEmail());

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if (requestCode==NUEVA_CONTACTO){
                Contacto c=new Contacto();

                String nombre=data.getStringExtra("NOMBRE");
                String movil=data.getStringExtra("MOVIL");
                String casa=data.getStringExtra("CASA");
                String email=data.getStringExtra("EMAIL");

                c.setNombre(nombre);
                c.setMovil(movil);
                c.setCasa(casa);
                c.setEmail(email);

                this.data.add(c);

                adapter.notifyDataSetChanged();
            }
        }


    }
}
