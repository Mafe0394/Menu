package com.mfvargas.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.LocaleSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos TextView
        TextView tvNombre=findViewById(R.id.nombrePersona);
        //Disponible para levantar view de contexto
        registerForContextMenu(tvNombre);
    }

    //Menu de opciones
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

    //Menu de contexto

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //Inflamos el menú de contexto
        MenuInflater inflater=new MenuInflater(this);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_edit:
                Toast.makeText(this,getResources().getString(R.string.menu_edit),Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_delete:
                Toast.makeText(this,getResources().getString(R.string.menu_delete),Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //Menu Popup
    public void levantarMenuPopUp(View v){
        PopupMenu popupMenu=new PopupMenu(this,v);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_view:
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_view),
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_view_detail:
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.menu_view_detail),
                                Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
        popupMenu.show();
    }
}
