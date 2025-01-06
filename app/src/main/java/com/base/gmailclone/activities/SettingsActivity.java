package com.base.gmailclone.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.base.gmailclone.R;
import com.base.gmailclone.databinding.ActivitySettingsBinding;
import com.base.gmailclone.fragment.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // Load the settings fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settingContainer, new SettingsFragment())
                .commit();

        binding.backIcon.setOnClickListener(v -> {onBackPressed();});
//        // Set up ViewPager Adapter
//        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
//        binding.viewPager.setAdapter(adapter);
//
//        // Connect TabLayout with ViewPager
//        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
//            switch (position) {
//                case 0:
//                    tab.setText("General");
////                        tab.setIcon(R.drawable.ic_tab1); // Replace with your drawable
//                    break;
//                case 1:
//                    tab.setText("Encryption & Keys");
////                        tab.setIcon(R.drawable.ic_tab2);
//                    break;
//                case 2:
//                    tab.setText("Security");
////                        tab.setIcon(R.drawable.ic_tab3);
//                    break;
//                case 3:
//                    tab.setText("Account");
////                        tab.setIcon(R.drawable.ic_tab4);
//                    break;
//            }
//        }).attach();
    }
}