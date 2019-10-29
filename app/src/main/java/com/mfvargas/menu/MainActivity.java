package com.mfvargas.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Se sobreescribe este método para inflar el menu de opciones
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
        // return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Se sobreescribe este método para decidir que acciones va a tomar
        //dependiendo de la opción seleccionada
        switch (item.getItemId()){
            case R.id.menuAbout:
                Intent intent=new Intent(this,ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.menuSettings:
                Intent intent1=new Intent(this,ActivitySettings.class);
                startActivity(intent1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
