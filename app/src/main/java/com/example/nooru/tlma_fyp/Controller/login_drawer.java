package com.example.nooru.tlma_fyp.Controller;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nooru.tlma_fyp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_drawer extends User_Main
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get firebase auth instance
        auth1 = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(login_drawer.this, LoginActivity.class));
                    finish();
                }
            }
        };
Button Checkgpsstatusbutton=(Button)findViewById(R.id.btn_GPS);
        Checkgpsstatusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LocationManager manager = (LocationManager)getApplicationContext().getSystemService(Context.LOCATION_SERVICE );

                if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) )
                    Toast.makeText(getApplicationContext(), "GPS is disable!Please enable GPS", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "GPS is Enable!", Toast.LENGTH_LONG).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_drawer.this,MainActivity.class);
                startActivity(intent);
              /*  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.login_drawer, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch ( item.getItemId() ) {
            case R.id.action_settings: {
                Intent intent = new Intent(login_drawer.this,User_Main.class);
                startActivity(intent);

                return true;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.hom) {

        } else if (id == R.id.mapview) {
            Intent intent = new Intent(login_drawer.this,MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.Taskssettings) {
            Intent intent = new Intent(login_drawer.this,settings_main.class);
            startActivity(intent);



        } else if (id == R.id.help) {
            Toast.makeText(getApplicationContext(),"help",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(login_drawer.this,GetHelp.class);
            startActivity(intent);

        }
        else if (id == R.id.appratings) {
            Toast.makeText(getApplicationContext(),"RateApp",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(login_drawer.this,appstars.class);
            startActivity(intent);

        } else if (id == R.id.logout) {

         signOut();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
   /* public void signOut() {
        auth1.signOut();
    }*/

}
