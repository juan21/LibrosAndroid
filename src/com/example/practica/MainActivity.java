package com.example.practica;

import android.support.v7.app.ActionBarActivity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView lista;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ArrayList<Libro> datos = new ArrayList<Libro>();  
        
        datos.add(new Libro(R.drawable.sistars, "Grupo Sistar", "Grupo de Musica japonesa que su genero es pop.. "));
        datos.add(new Libro (R.drawable.deseo,"Deseo","En la película, que se filmó en San Miguel de Allende, la actriz realizó escenas ... El Deseo de regresar a la pantalla grande de México se hará realidad para .. "));
	   	datos.add(new Libro (R.drawable.perfume,"El Perfume","Su segundo encuentro con los aromas fue un dia en el que lo mandan a llevar unas pieles a la casa del fabricante de perfumes mas famoso y renombrado de Paris, el señor Baldini...alli se ecuentra con una infinidad de fragancias que lo enloquecen y comienza a mezclar aromas logrando a partir de oler un perfume ya hecho fabricar el mismo perfume y mejorarlo, el perfumista que estaba ya decayendo en su fama y creatividad lo compra para que sea quien colabore en la fabricacion de perfumes, a la muerte de Baldini Grenouille se dirige hacia provenza para buscar aromas de aceites escenciales ya que solo podia hacer perfumes a partir de flores y esto lo cansaba.... "));
	   	datos.add(new Libro (R.drawable.marianela,"Marianela","La novela, transcurre en un pueblo llamado Aldearoba, donde trata de la vida de una adolescente, María, una joven fea, llamada Marianela en honor a su madre Canela, quien se suicidó cuando ella era apenas un bebé. Desde ese entonces vivió con una familia adoptiva, los Centenos, que nunca se preocupó por ella ni por lo que sentía. Sus ratos alegres eran aquellos con los que salía a pasear con Pablo un muchacho ciego, este que le daba sentido a la vida de la pobre Nela, pero que luego la dejaría de lado. ...."));
	   	datos.add(new Libro (R.drawable.android,"Android","Aplicaciones en android"));
	   	datos.add(new Libro (R.drawable.algoritphp,"Algoritmos PHP","Desarrollador de PHP"));
	   	datos.add(new Libro (R.drawable.progra2,"Programacion2 en C++","Programacion en aplicaciones"));
	   	datos.add(new Libro (R.drawable.programacion,"Programacion en C++","Programacion basica"));
	   	datos.add(new Libro (R.drawable.lenguaje,"Lenguaje C","historia de de dos amigas"));
	   	datos.add(new Libro (R.drawable.principito,"El Principito","La trayectoria por todos los planetas, fue necesaria para que el principito llegara a conocer ese secreto que le haría comprender, la esencia de su vida, lo mismo sucede con nosotros, en nuestra vida pasamos por muchas situaciones y por muchas personas que no siempre son las que deseamos tener en nuestras vidas, pero en el transcurso de nuestra vida aparecen seres especiales, es ahí donde los sentimientos, el amor no pueden verse con los ojos, debemos prepáranos para verlos con el corazón, aprender a domesticar y ser domesticados...."));
	   	 
        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new LibrosAdapter(this, R.layout.listview_item, datos){
			@Override
			public void onEntrada(Object listview_item, View view) {
		        if (listview_item != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Libro) listview_item).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Libro) listview_item).get_textoDebajo()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Libro) listview_item).get_idImagen());
		        }
			}
		});
        
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Libro elegido = (Libro) pariente.getItemAtPosition(posicion); 
                
                CharSequence texto = "Abriendo: " + elegido.get_textoEncima();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();

                nuevo(pariente,view,posicion,id);
			}
        });

    }
    public void nuevo(AdapterView<?> pariente, View view, int posicion, long id){
    	Intent intent = new Intent(this, ItemActivity.class );
    	Libro item = (Libro) lista.getAdapter().getItem(posicion);
    	intent.putExtra("imagen",item.get_idImagen());
    	intent.putExtra("debajo",item.get_textoDebajo().toString());
    	intent.putExtra("encima",item.get_textoEncima().toString()); 
        startActivity(intent);
 
    }
}

