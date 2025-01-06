package com.base.gmailclone.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.base.gmailclone.databinding.ActivitySigupBinding;


public class SigupActivity extends AppCompatActivity {
    private ActivitySigupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.signupButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.loginButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        });
    }
}