package com.example.apecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class PictureFolders extends AppCompatActivity {
    private GridView gridview1;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_folders);
        gridview1 = (GridView) findViewById(R.id.mainGridView1);
        gridview1.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
                Toast.makeText(getApplicationContext(), maplist.get(p3).get("title").toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PictureFolders.this, Pictures.class);
                startActivity(intent);


            }
        });
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Activities");
            _item.put("icon", R.drawable.activities1);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Animals");
            _item.put("icon", R.drawable.animals1);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Basic");
            _item.put("icon", R.drawable.basic1);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Clothes");
            _item.put("icon", R.drawable.clothes);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Communicatiom");
            _item.put("icon", R.drawable.communication);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Foods");
            _item.put("icon", R.drawable.foods);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Household");
            _item.put("icon", R.drawable.home1);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "People");
            _item.put("icon", R.drawable.people1);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Places");
            _item.put("icon", R.drawable.places);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Selfhelp");
            _item.put("icon", R.drawable.selfhelp1);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Tools");
            _item.put("icon", R.drawable.tools1);
            maplist.add(_item);
        }
        {
            HashMap<String, Object> _item = new HashMap<>();
            _item.put("title", "Transportation");
            _item.put("icon", R.drawable.transportation1);
            maplist.add(_item);
        }
        GridAdapter adapter = new GridAdapter(this);
        gridview1.setAdapter(adapter);
    }

    public class GridAdapter extends BaseAdapter {
        private Context mContext;

        public GridAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return maplist.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;

            LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (v == null) {
                v = _inflater.inflate(R.layout.list_item, null);
            }

            TextView txtview = (TextView) v.findViewById(R.id.listitemTextView1);
            ImageView imgview = (ImageView) v.findViewById(R.id.listitemImageView1);


            txtview.setText(maplist.get(position).get("title").toString());
            imgview.setImageResource((Integer) maplist.get(position).get("icon"));
            return v;
        }

    }
}
