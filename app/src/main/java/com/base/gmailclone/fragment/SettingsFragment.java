package com.base.gmailclone.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.base.gmailclone.activities.AccountActivity;
import com.base.gmailclone.activities.EncyptionActivity;
import com.base.gmailclone.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);

        // Access the SharedPreferences used in MainActivity
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("ThemePrefs", getContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Theme Switch Preference
        SwitchPreferenceCompat themeSwitch = findPreference("theme_switch");
        if (themeSwitch != null) {
            // Set the current state of the SwitchPreference based on the SharedPreferences
            boolean isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);
            themeSwitch.setChecked(isDarkMode);

            // Handle theme change
            themeSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                boolean enableDarkMode = (boolean) newValue;

                // Save the selected theme to SharedPreferences
                editor.putBoolean("isDarkMode", enableDarkMode);
                editor.apply();

                // Apply the theme dynamically
                if (enableDarkMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                return true;
            });
        }

        // Update summary for the EditTextPreference
        EditTextPreference userNamePref = findPreference("user_name");
        if (userNamePref != null) {
            userNamePref.setSummaryProvider(preference -> {
                String userName = userNamePref.getText();
                return userName != null && !userName.isEmpty() ? userName : "No name set";
            });
        }

        // Handle Details Screen click
        Preference detailsScreen = findPreference("encryption");
        if (detailsScreen != null) {
            detailsScreen.setOnPreferenceClickListener(preference -> {
                // Open Details Activity
                startActivity(new Intent(getContext(), EncyptionActivity.class));
                return true;
            });
        }

        // Handle More Information click
        Preference infoScreen = findPreference("account");
        if (infoScreen != null) {
            infoScreen.setOnPreferenceClickListener(preference -> {
                // Open Info Activity
                startActivity(new Intent(getContext(), AccountActivity.class));
                return true;
            });
        }
    }
}

