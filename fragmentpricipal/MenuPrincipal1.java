package com.pierogranda.proyectointegrador12.fragmentpricipal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pierogranda.proyectointegrador12.DescripcionActivity;
import com.pierogranda.proyectointegrador12.EstadisticaActivity;
import com.pierogranda.proyectointegrador12.PasantiasActivity;
import com.pierogranda.proyectointegrador12.R;

public class MenuPrincipal1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal1, menu);
        return true;
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
       FragmentManager fragmentManager=getSupportFragmentManager();

        if (id == R.id.nav_pasantias) {

            Intent a=new Intent(MenuPrincipal1.this, PasantiasActivity.class);
            startActivity(a);
        } else if (id == R.id.nav_perfil) {
            Intent b=new Intent(MenuPrincipal1.this, DescripcionActivity.class);
            startActivity(b);

        } else if (id == R.id.nav_caledario) {

            fragmentManager.beginTransaction().replace(R.id.contenedor, new frangmentCalendar()).commit();

        }
        else if (id == R.id.nav_estadisticas) {

            Intent i= new Intent(MenuPrincipal1.this,EstadisticaActivity.class);
            startActivity(i);

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    }

