package com.base.gmailclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.base.gmailclone.R;

public class ImageSpinnerAdapter extends BaseAdapter {
    private Context context;
    private int[] images; // Array of image resources

    public ImageSpinnerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        return convertView;
    }
}
