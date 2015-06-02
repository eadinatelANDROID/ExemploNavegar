package com.example.exemploead_parametros;

import com.example.exemploead_paramentros.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	
//Declaração dos elementos para vinculação	
private EditText txtParametros;
private Button btnComParametros;
private Button btnSemParametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         //Vinculando os elementos da VIEW com o código de lógica Java
         txtParametros = (EditText)findViewById(R.id.txtParametros);
         btnComParametros = (Button)findViewById(R.id.btnComParametros);
         btnSemParametros = (Button)findViewById(R.id.btnSemParametros);
        
        //Criação do Evento de Click do botão btnComParametros
        btnComParametros.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Get Texto do elemento txtParametros referenciado na View
				String parametro = txtParametros.getText().toString();
				
				//Cria-se um objeto Bundle para armazenar o parâmetro a ser enviado através na navegação entre páginas
				Bundle bundle = new Bundle();
				//Armazena no obj.Bundle uma Chave / Valor , onde a chave "dados" irá conter o valor da variável parâmetro
				bundle.putString("dados", parametro);
				
				Intent intent = new Intent(getApplicationContext(), Page2.class);
				//Associa-se o obj Bundle com a intent de navegação.
				intent.putExtras(bundle);
				
				startActivity(intent);
			}
		});//Fim do Listener btnComParametros
        
    
        btnSemParametros.setOnClickListener( new View.OnClickListener() {
					@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Cria-se o obj de intenção de navegação, com destino da navegação sendo classe Page2  
				Intent intent = new Intent(getApplicationContext(), Page2.class);
				startActivity(intent);
			}
		});//Fim do Listener btnSemParametros
        
    }//Fim do Método OnCreate()
    



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
