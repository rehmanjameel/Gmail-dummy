package com.base.gmailclone.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.gmailclone.ComposeActivity;
import com.base.gmailclone.R;
import com.base.gmailclone.adapter.ItemAdapter;
import com.base.gmailclone.databinding.FragmentInboxBinding;
import com.base.gmailclone.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


public class InboxFragment extends Fragment {
    private FragmentInboxBinding binding;
    private ItemAdapter adapter;
    private List<ItemModel> itemList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInboxBinding.inflate(inflater, container, false);

// Initialize RecyclerView
        binding.inboxRV.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize Data
        initializeData();

        // Set Adapter
        adapter = new ItemAdapter(getContext(), itemList);
        binding.inboxRV.setAdapter(adapter);

        binding.sendMail.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), ComposeActivity.class);
            startActivity(intent);
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void initializeData() {
        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.amazon_icon, "Amazon Support", "6 Nov",
                "Your recent Amazon order - Thank you for your purchase! Your order is currently being processed and will be..."));
        itemList.add(new ItemModel(R.drawable.google, "Google Support", "5 Nov",
                "Unusual sign-in detected - We noticed a sign-in attempt from a new device or location. If this wasn’t you.."));
        itemList.add(new ItemModel(R.drawable.paypal, "Paypal", "5 Nov",
                "DPayment Received - Congratulations! Youve received a payment in your PayPal account. Please review the..."));
        itemList.add(new ItemModel(R.drawable.fb, "Facebook", "4 Nov",
                "Account Security Update - We’ve recently updated securities measures to keep your account protected..."));
        itemList.add(new ItemModel(R.drawable.netflix, "Netflix", "3 Nov",
                "Subscription renewal - Your subscription has been successfully renewed. Enjoy uninterrupted access to y..."));
        itemList.add(new ItemModel(R.drawable.slack, "Slack", "3 Nov",
                "Workspace Invitation - Youve been invited to join a new workspace for team collaboration. Click here to accept..."));
        itemList.add(new ItemModel(R.drawable.linkedin, "LinkedIN", "2 Nov",
                "Workspace Invitation - Youve been invited to join a new workspace for team collaboration. Click here to accept..."));
        itemList.add(new ItemModel(R.drawable.microsoft, "Paypal", "1 Nov",
                "Account Security Update - We’ve recently enhanced our security options for your account. Please log in to..."));
        itemList.add(new ItemModel(R.drawable.paypal, "Paypal", "31 Oct",
                "DPayment Received - Congratulations! Youve received a payment in your PayPal account. Please review the..."));
        // Add more static data as needed
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}