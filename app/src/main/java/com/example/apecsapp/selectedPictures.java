package com.example.apecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class selectedPictures extends AppCompatActivity {

    ImageView imageView1;
        ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    Uri Imageuri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_pictures);
        imageView1 = findViewById(R.id.imageView3);
        imageView2 = findViewById(R.id.imageView4);
        imageView3 = findViewById(R.id.imageView5);
        imageView4 = findViewById(R.id.imageView6);
        imageView5 = findViewById(R.id.imageView7);
        imageView6 = findViewById(R.id.imageView8);
        final ImageView[] imageViews = {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6};

        for (ImageView imageView : imageViews) {
            if (imageView.getDrawable() == null) {
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    if (bundle.containsKey("liburi")) {
                        String resId = bundle.getString("liburi");
                        //Imageuri = Uri.parse(resId);
                        Picasso.get().load(resId).into(imageView);
                    } else {
                        String resId = bundle.getString("imageuri");
                        Imageuri = Uri.parse(resId);
                        imageView.setImageURI(Imageuri);
                    }
                }
                break;
            }

        }

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });



        }




    }
