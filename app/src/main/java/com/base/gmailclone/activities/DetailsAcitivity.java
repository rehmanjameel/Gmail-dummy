package com.base.gmailclone.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.base.gmailclone.databinding.ActivityDetailsAcitivityBinding;

public class DetailsAcitivity extends AppCompatActivity {

    private ActivityDetailsAcitivityBinding binding;
    private Boolean isVisible = false;
    private Boolean isVisible2 = false;
    private Boolean isVisible3 = false;
    private Boolean isVisible4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsAcitivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String itemTitle = getIntent().getStringExtra("title");

        assert itemTitle != null;

        if (!itemTitle.equals("Amazon Support")) {
            binding.hideDes.setVisibility(View.GONE);
            binding.fbhide1.setVisibility(View.VISIBLE);

            binding.fbDetails1.setVisibility(View.GONE);
            binding.fbDetails2.setVisibility(View.GONE);
            binding.fbDetails3.setVisibility(View.GONE);

            binding.view2.setVisibility(View.GONE);
            binding.view3.setVisibility(View.GONE);
            binding.view4.setVisibility(View.GONE);
        }
        binding.fbDetails.setOnClickListener(view -> {
            if (!isVisible) {
                binding.hideDes.setVisibility(View.GONE);
                binding.fbhide1.setVisibility(View.VISIBLE);
                isVisible = true;
            } else {
                binding.hideDes.setVisibility(View.VISIBLE);
                binding.fbhide1.setVisibility(View.GONE);
                isVisible = false;
            }
        });

        binding.fbDetails1.setOnClickListener(view -> {
            if (!isVisible2) {
                binding.hideDes2.setVisibility(View.GONE);
                binding.fbhide2.setVisibility(View.VISIBLE);
                isVisible2 = true;
            } else {
                binding.hideDes.setVisibility(View.VISIBLE);
                binding.fbhide2.setVisibility(View.GONE);
                isVisible2 = false;

            }
        });

        binding.fbDetails2.setOnClickListener(view -> {
            if (!isVisible3) {
                binding.hideDes3.setVisibility(View.GONE);
                binding.fbhide3.setVisibility(View.VISIBLE);
                isVisible3 = true;
            } else {
                binding.hideDes3.setVisibility(View.VISIBLE);
                binding.fbhide3.setVisibility(View.GONE);
                isVisible3 = false;

            }
        });

        binding.fbDetails3.setOnClickListener(view -> {
            if (!isVisible4) {
                binding.hideDes4.setVisibility(View.GONE);
                binding.fbhide4.setVisibility(View.VISIBLE);
                isVisible4 = true;
            } else {
                binding.hideDes4.setVisibility(View.VISIBLE);
                binding.fbhide4.setVisibility(View.GONE);
                isVisible4 = false;

            }
        });


        binding.backButton.setOnClickListener(view -> {
            onBackPressed();
        });
    }
}