package com.example.apecsapp;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
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
            Uri uri=Uri.parse(picture);

            if (convertView == null) {
                final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
                convertView = layoutInflater.inflate(R.layout.picturelayout, null);
            }
            final ImageView imageView =
                    (ImageView)convertView.findViewById(R.id.imageview_cover_art);
            final TextView textView=(TextView)convertView.findViewById(R.id.pictureitemTextView1);
                Picasso.get().load(String.valueOf(picture)) //Load the image
                        .placeholder
                                (R.drawable.placeholder_300x202) //Image resource that act as placeholder
                        .error(R.drawable.placeholder_300x202) //Image resource for error
                        .into(imageView);
                textView.setText((CharSequence) uri.getLastPathSegment().toString().substring(0, uri.getLastPathSegment().toString().length() - 4));



            return convertView;
        }
}
