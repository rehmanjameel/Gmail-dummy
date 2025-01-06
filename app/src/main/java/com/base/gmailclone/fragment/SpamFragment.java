package com.base.gmailclone.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.gmailclone.activities.ComposeActivity;
import com.base.gmailclone.databinding.FragmentSpamBinding;


public class SpamFragment extends Fragment {

   private FragmentSpamBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSpamBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        binding.sendMail.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), ComposeActivity.class);
            startActivity(intent);
        });

        return binding.getRoot();
    }
}