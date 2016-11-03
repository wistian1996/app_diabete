package br.com.drugstore.www.diabetes.Activitys;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

import br.com.drugstore.www.diabetes.Domain.BroadcastReceiver1;
import br.com.drugstore.www.diabetes.Fragments.FragmentDiario;
import br.com.drugstore.www.diabetes.Fragments.FragmentHome;
import br.com.drugstore.www.diabetes.Fragments.FragmentMedicamentos;
import br.com.drugstore.www.diabetes.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment;
    // boolean para verificar se entrou pela primeira vez
    private boolean inicio = true;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  botao flutuante
        fab = (FloatingActionButton) findViewById(R.id.fab);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        chamarTelaHome();
        fecharNotificacao();
    }

    private void chamarTelaHome() {
        //iniciando com a tela home
        MenuItem m = (MenuItem) findViewById(R.id.nav_home);
        onNavigationItemSelected(m);
    }

    private void fecharNotificacao() {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(R.drawable.icon_relogio);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        fragment = null;
        int id;
        // verifica se foi iniciado pela primeira vez
        if (inicio) {
            inicio = false;
            id = R.id.nav_home;
        } else {
            id = item.getItemId();
        }

        if (id == R.id.nav_home) {
            fragment = new FragmentHome();
            android.support.v4.app.FragmentTransaction fragmentTrasaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTrasaction.replace(R.id.LayoutFragments, fragment);
            fragmentTrasaction.commit();
            fab.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_medicamentos) {
            fragment = new FragmentMedicamentos();
            fab.setImageResource(R.drawable.icon_relogio);
            android.support.v4.app.FragmentTransaction fragmentTrasaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTrasaction.replace(R.id.LayoutFragments, fragment);
            fragmentTrasaction.commit();

            // setando o botao flutuante
            fab.setVisibility(View.VISIBLE);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, ActivityConfigAlarme.class);
                    startActivity(intent);
                }
            });

        } else if (id == R.id.nav_classificar) {

        } else if (id == R.id.nav_consumo) {
            fragment = new FragmentDiario();
            // alterando o icone do botao flutuante
            fab.setImageResource(R.drawable.calendario_icon);

            android.support.v4.app.FragmentTransaction fragmentTrasaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTrasaction.replace(R.id.LayoutFragments, fragment);
            fragmentTrasaction.commit();


            // setando o botao flutuante
            fab.setVisibility(View.VISIBLE);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, ActivityConfigDiario.class);
                    startActivity(intent);
                }
            });


        } else if (id == R.id.nav_prefer) {

        } else if (id == R.id.nav_semaforo) {

        } else if (id == R.id.nav_sobre) {

        } else if (id == R.id.nav_compartilhar) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
