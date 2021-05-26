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

public class PictureAdapter extends BaseAdapter {

        private final Context mContext;
        private final String[] pictures;
       String finalEd;

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
             ImageView imageView = convertView.findViewById(R.id.imageview_cover_art);
            TextView textView=convertView.findViewById(R.id.pictureitemTextView1);
                Picasso.get().load(String.valueOf(picture)) //Load the image
                        .placeholder
                                (R.drawable.placeholder_300x202) //Image resource that act as placeholder
                        .error(R.drawable.placeholder_300x202) //Image resource for error
                        .into(imageView);
                String s=(uri.getLastPathSegment().substring(0, uri.getLastPathSegment().length() - 4));
            if(s.contains("_"))
                {String ed1=null;
                ed1=s.replace("_"," ");
                finalEd = ed1;
            }
            else {finalEd=s;}
                textView.setText(finalEd);



            return convertView;
        }
}
