package com.base.gmailclone.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.base.gmailclone.databinding.ActivityEncyptionBinding;

public class EncyptionActivity extends AppCompatActivity {

    private ActivityEncyptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEncyptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.backButton.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}