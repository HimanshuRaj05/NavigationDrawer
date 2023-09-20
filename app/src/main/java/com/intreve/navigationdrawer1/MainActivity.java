package com.intreve.navigationdrawer1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout, R.string.nav_open, R.string.nav_close );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle the ActionBarDrawerToggle clicks
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation item clicks here
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(MainActivity.this , "Home selected", Toast.LENGTH_SHORT).show();
                // Add code to navigate to the "Home" screen if desired.
                break;

            case R.id.about:
                Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show();
                // Add code to navigate to the "About" screen if desired.
                break;
        }

        // Close the drawer when an item is selected
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}