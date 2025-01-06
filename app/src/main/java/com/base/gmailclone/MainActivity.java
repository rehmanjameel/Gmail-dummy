package com.base.gmailclone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the saved theme before setting the content view
        sharedPreferences = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        boolean isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);

        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

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
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Navigation Item Listener
        binding.navView.setNavigationItemSelectedListener(this);

        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        // Default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new InboxFragment())
                    .commit();
            binding.navView.setCheckedItem(R.id.nav_inbox);
        }

        updateThemeIcon(isDarkMode);

        // Set onClickListener to toggle theme
        binding.themeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean currentMode = sharedPreferences.getBoolean("isDarkMode", false);

                if (currentMode) {
                    // Switch to Light Mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean("isDarkMode", false);
                } else {
                    // Switch to Dark Mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean("isDarkMode", true);
                }
                editor.apply();

                // Update the theme icon
                updateThemeIcon(!currentMode);
            }
        });
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
        } else if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        // Close the drawer after item selection
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Updates the theme icon based on the current mode.
     * @param isDarkMode True if the current mode is Dark Mode, otherwise False.
     */
    private void updateThemeIcon(boolean isDarkMode) {
        if (isDarkMode) {
            binding.themeIcon.setImageResource(R.drawable.baseline_dark_mode_24);
        } else {
            binding.themeIcon.setImageResource(R.drawable.baseline_light_mode_24);
        }
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