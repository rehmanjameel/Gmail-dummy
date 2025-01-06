package com.base.gmailclone.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.base.gmailclone.R;
import com.base.gmailclone.databinding.ActivityComposeBinding;

public class ComposeActivity extends AppCompatActivity {

    private ActivityComposeBinding binding;

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

        // Set an OnClickListener to display the menu when clicked
//        binding.moreHor.setOnClickListener(v -> {
//            // Create a PopupMenu
//            PopupMenu popupMenu = new PopupMenu(this,  binding.moreHor);
//
//            // Inflate the menu resource (create a menu XML for options)
//            popupMenu.getMenuInflater().inflate(R.menu.more_menu, popupMenu.getMenu());
//
//            // Set click listener for menu items
//            popupMenu.setOnMenuItemClickListener(item -> {
//                int itemId = item.getItemId();
//
//                if (itemId == R.id.option1) {
//                    // Handle "Option 1" click
//                    Toast.makeText(this, "Option 1 clicked", Toast.LENGTH_SHORT).show();
//                    return true;
//                } else if (itemId == R.id.option2) {
//                    // Handle "Option 2" click
//                    Toast.makeText(this, "Option 2 clicked", Toast.LENGTH_SHORT).show();
//                    return true;
//                } else if (itemId == R.id.option3) {
//                    // Handle "Option 3" click
//                    Toast.makeText(this, "Option 3 clicked", Toast.LENGTH_SHORT).show();
//                    return true;
//                } else if (itemId == R.id.option4) {
//                    // Handle "Option 3" click
//                    Toast.makeText(this, "Option 4 clicked", Toast.LENGTH_SHORT).show();
//                    return true;
//                } else {
//                    return false;
//                }
//            });
//
//            // Show the popup menu
//            popupMenu.show();
//        });

        // Set an OnClickListener to display the menu when clicked
        binding.moreOptions.setOnClickListener(v -> {
            // Create a PopupMenu
            PopupMenu popupMenu = new PopupMenu(this,  binding.moreOptions);

            // Inflate the menu resource (create a menu XML for options)
            popupMenu.getMenuInflater().inflate(R.menu.more_menu, popupMenu.getMenu());

            // Set click listener for menu items
            popupMenu.setOnMenuItemClickListener(item -> {
                int itemId = item.getItemId();

                if (itemId == R.id.option1) {
                    // Handle "Option 1" click
//                    Toast.makeText(this, "Option 1 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.option2) {
                    // Handle "Option 2" click
//                    Toast.makeText(this, "Option 2 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.option3) {
                    // Handle "Option 3" click
//                    Toast.makeText(this, "Option 3 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.option4) {
                    // Handle "Option 3" click
//                    Toast.makeText(this, "Option 4 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            });

            // Show the popup menu
            popupMenu.show();
        });
    }
}