package com.base.gmailclone;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.base.gmailclone.databinding.ActivityMainBinding;
import com.base.gmailclone.fragment.BinFragment;
import com.base.gmailclone.fragment.InboxFragment;
import com.base.gmailclone.fragment.SpamFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup ActionBar toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Enable hamburger menu icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Navigation Item Listener
        binding.navView.setNavigationItemSelectedListener(this);

        // Default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new InboxFragment())
                    .commit();
            binding.navView.setCheckedItem(R.id.nav_inbox);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_inbox) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new InboxFragment())
                    .commit();
        } else if (id == R.id.nav_spam) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SpamFragment())
                    .commit();
        } else if (id == R.id.nav_bin) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new BinFragment())
                    .commit();
        }

        // Close the drawer after item selection
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}