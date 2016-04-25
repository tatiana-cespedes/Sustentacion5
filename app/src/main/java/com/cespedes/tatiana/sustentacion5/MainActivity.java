package com.cespedes.tatiana.sustentacion5;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] opciones;//
    private ListView listView;//
    private DrawerLayout drawerLayout;//
    private ActionBarDrawerToggle drawerToggle;//

    private CharSequence tituloSec;//
    private ImageView dabeiba1;

    private LinearLayout contenedor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//
        setContentView(R.layout.activity_main);//

        Fragment fragmentoini = new InicioFragment();/////
        FragmentManager fragmana = getSupportFragmentManager();////
        fragmana.beginTransaction().replace(R.id.contenedorFragment, fragmentoini).commit();///////


        opciones = new String[] {getString(R.string.inicio),getString(R.string.sitios),getString(R.string.bares),
                getString(R.string.hoteles), getString(R.string.informacion)};//
        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);//Menú desplazable
        listView = (ListView) findViewById(R.id.menuIzq);//lo que va dentro del menú



        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().
                getThemedContext(), android.R.layout.simple_list_item_1, opciones));//

        final ActionBar ab = getSupportActionBar();//
        if (ab !=null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);//
            ab.setDisplayHomeAsUpEnabled(true);//
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
               // contenedor.setVisibility(View.GONE);

                // imagen.setVisibility(View.GONE);
                switch(position){
                    case 0:
                        fragment = new InicioFragment();
                        break;
                    case 1:
                        fragment = new SitiosFragment();
                        break;
                    case 2:
                        fragment =  new BaresFragment();
                        break;
                    case 3:
                        fragment = new HotelesFragment();
                        break;
                    case 4:
                        fragment = new DemografiaFragment();
                }
                FragmentManager fragmentManager = getSupportFragmentManager();//
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();//
                listView.setItemChecked(position, true);//
                tituloSec = opciones[position];//
                ab.setTitle(tituloSec);//
                drawerLayout.closeDrawer(listView);//
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_menu_white_24dp,R.string.abierto,R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
