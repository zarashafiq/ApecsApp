package com.example.apecsapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;

public class PictureAdapter extends BaseAdapter {

        private final Context mContext;
        private final String[] pictures;

        public PictureAdapter(Context context, String[] movies) {
            this.mContext = context;
            this.pictures = movies;
        }
        @Override
        public int getCount() {
            return pictures.length;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final String picture = pictures[position];
            if (convertView == null) {
                final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
                convertView = layoutInflater.inflate(R.layout.picturelayout, null);
            }
            final ImageView imageView =
                    (ImageView)convertView.findViewById(R.id.imageview_cover_art);

                Picasso.get().load(String.valueOf(picture)) //Load the image
                        .placeholder
                                (R.drawable.animals1) //Image resource that act as placeholder
                        .error(R.drawable.activities1) //Image resource for error
                        .into(imageView);
            // View where image is loaded.



            return convertView;
        }
}
