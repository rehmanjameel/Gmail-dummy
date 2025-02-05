package com.base.gmailclone.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.gmailclone.activities.ComposeActivity;
import com.base.gmailclone.databinding.FragmentBinBinding;


public class BinFragment extends Fragment {

    private FragmentBinBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBinBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment

        binding.sendMail.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), ComposeActivity.class);
            startActivity(intent);
        });

        return binding.getRoot();
    }
}