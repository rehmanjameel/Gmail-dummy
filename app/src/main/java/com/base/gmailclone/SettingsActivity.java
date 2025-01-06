package com.base.gmailclone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.base.gmailclone.adapter.ViewPagerAdapter;
import com.base.gmailclone.databinding.ActivitySettingsBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        // Set up ViewPager Adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        // Connect TabLayout with ViewPager
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("General");
//                        tab.setIcon(R.drawable.ic_tab1); // Replace with your drawable
                    break;
                case 1:
                    tab.setText("Encryption & Keys");
//                        tab.setIcon(R.drawable.ic_tab2);
                    break;
                case 2:
                    tab.setText("Security");
//                        tab.setIcon(R.drawable.ic_tab3);
                    break;
                case 3:
                    tab.setText("Account");
//                        tab.setIcon(R.drawable.ic_tab4);
                    break;
            }
        }).attach();
    }
}