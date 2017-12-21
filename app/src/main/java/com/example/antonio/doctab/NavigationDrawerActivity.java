package com.example.antonio.doctab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.antonio.doctab.Utils.Constants;
import com.google.firebase.auth.FirebaseAuth;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = NavigationDrawerActivity.class.getSimpleName();

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        onPreRenderMenu(navigationView);
    }

    private void onPreRenderMenu(NavigationView navigationView) {
        /**Carga el item seleccionado**/
        /**0 = Inicio**/
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
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
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_logout:
                closeNavigation();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void closeNavigation() {
        /**Cierra la session actual*/
        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(NavigationDrawerActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        this.closeAllFragment();

        switch (id) {
            case R.id.menu_item_inicio:
                getSupportActionBar().setTitle(getString(R.string.default_item_menu_title_inicio));
                this.openFragment(Constants.ITEM_FRAGMENT.get(id));
                break;
            case R.id.menu_item_consultorios_doctor:
                getSupportActionBar().setTitle(getString(R.string.default_item_menu_title_inicio));
                this.openFragment(Constants.ITEM_FRAGMENT.get(id));
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openFragment(String tag) {
        try {
            FragmentTransaction mainFragment = getSupportFragmentManager().beginTransaction();
            mainFragment.replace(R.id.fragment_main_container, Constants.TAG_FRAGMENT.get(tag), tag);
            mainFragment.addToBackStack(tag);
            mainFragment.commit();
        } catch (Exception e) {
            Toast.makeText(this, "Debe implementrar + " + tag, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Cierra todos los fragmentos actuales
     **/
    private void closeAllFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_main_container);
        if (null != fragment)
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }
}
