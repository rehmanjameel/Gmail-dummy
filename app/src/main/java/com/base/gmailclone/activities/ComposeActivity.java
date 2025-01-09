package com.base.gmailclone.activities;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.base.gmailclone.R;
import com.base.gmailclone.databinding.ActivityComposeBinding;

public class ComposeActivity extends AppCompatActivity {

    private ActivityComposeBinding binding;
    private Boolean isEncrypted = true;
    private Boolean isSigned = false;
    private Boolean isMoreHor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComposeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCc.setOnClickListener(v -> {
            binding.buttonCc.setVisibility(View.GONE);
            binding.editTextCc.setVisibility(View.VISIBLE);
        });

        binding.buttonBcc.setOnClickListener(v -> {
            binding.buttonBcc.setVisibility(View.GONE);
            binding.editTextBcc.setVisibility(View.VISIBLE);
        });

        binding.encryptedBT.setOnClickListener(v -> {
            if (!isEncrypted) {
                binding.encryptedBT.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.light_green)));
                binding.encryptedBT.setTextColor(ContextCompat.getColor(this, R.color.dark_green));
                binding.encryptedBT.setIconTint(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.dark_green)));
                isEncrypted = true;
            } else {
                binding.encryptedBT.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.grey)));
                binding.encryptedBT.setTextColor(ContextCompat.getColor(this, R.color.black));
                binding.encryptedBT.setIconTint(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.black)));

                isEncrypted = false;

            }
        });

        binding.signedBT.setOnClickListener(v -> {
            if (!isSigned) {
                binding.signedBT.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.light_green)));
                binding.signedBT.setTextColor(ContextCompat.getColor(this, R.color.dark_green));
                binding.signedBT.setIconTint(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.dark_green)));
                isSigned = true;
            } else {
                binding.signedBT.setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.grey)));
                binding.signedBT.setTextColor(ContextCompat.getColor(this, R.color.black));
                binding.signedBT.setIconTint(ColorStateList.valueOf(
                        ContextCompat.getColor(this, R.color.black)));

                isSigned = false;
            }
        });

        binding.moreHor.setOnClickListener(v -> {
            if (!isMoreHor) {
                binding.boldLayout.setVisibility(View.VISIBLE);
                binding.alignmentImagesLayout.setVisibility(View.VISIBLE);
                isMoreHor = true;
            } else {
                binding.boldLayout.setVisibility(View.GONE);
                binding.alignmentImagesLayout.setVisibility(View.GONE);
                isMoreHor = false;
            }
        });

        binding.cross.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.minus.setOnClickListener(v -> {
            onBackPressed();
        });

        // Set an OnClickListener to display the menu when clicked
        binding.moreOptions.setOnClickListener(v -> {
            // Create a custom dialog
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom_popup_menu); // Use a custom layout for the menu
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            // Get the location of the clicked view (binding.moreOptions)
            int[] location = new int[2];
            v.getLocationOnScreen(location);

            // Get the dialog window and set its position
            Window window = dialog.getWindow();
            if (window != null) {
                WindowManager.LayoutParams params = window.getAttributes();
                params.gravity = Gravity.TOP | Gravity.START; // Position near the top-left of the screen
                params.x = location[0]; // X coordinate of the clicked view
                params.y = location[1] + v.getHeight(); // Y coordinate (below the clicked view)
                window.setAttributes(params);
            }

            // Find menu items in the custom layout
            RadioButton normal = dialog.findViewById(R.id.normal);
            RadioButton plainText = dialog.findViewById(R.id.plainTxt);

            CheckBox attachPK = dialog.findViewById(R.id.attachPK);
            CheckBox requestRR = dialog.findViewById(R.id.requestRR);

            // Show the dialog
            dialog.show();

            // Dismiss the dialog when clicking outside
            dialog.setCanceledOnTouchOutside(true);
        });
    }
}