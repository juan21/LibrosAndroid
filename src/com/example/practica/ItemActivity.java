package com.example.practica;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends ActionBarActivity {

	ImageView idImagen; 
	TextView textoEncima; 
	TextView textoDebajo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item);
		
		textoEncima = (TextView) findViewById(R.id.textView_superior);
		textoDebajo = (TextView) findViewById(R.id.textView_inferior);
		idImagen = (ImageView) findViewById(R.id.imageView_imagen);
		
		Bundle bundle = getIntent().getExtras();
		textoEncima.setText(bundle.getString("encima"));
		textoDebajo.setText(bundle.getString("debajo"));
		idImagen.setImageResource(getIntent().getExtras().getInt("imagen"));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
