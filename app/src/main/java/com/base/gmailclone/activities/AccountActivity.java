package com.base.gmailclone.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.base.gmailclone.databinding.ActivityAccountBinding;

public class AccountActivity extends AppCompatActivity {

    private ActivityAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.backButton.setOnClickListener(v -> {
            onBackPressed();
        });

    }
}