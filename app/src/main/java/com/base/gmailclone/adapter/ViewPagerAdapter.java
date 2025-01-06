package com.base.gmailclone.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.base.gmailclone.fragment.AccountFragment;
import com.base.gmailclone.fragment.EncryptionFragment;
import com.base.gmailclone.fragment.GeneralFragment;
import com.base.gmailclone.fragment.SecurityFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new EncryptionFragment();
            case 2:
                return new SecurityFragment();
            case 3:
                return new AccountFragment();
            default:
                return new GeneralFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4; // Number of tabs
    }
}

