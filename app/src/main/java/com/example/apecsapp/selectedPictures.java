package com.example.apecsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class selectedPictures extends AppCompatActivity {


    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView;
    String image1uri;
    String image2uri;
    String image3uri;
    String image4uri;
    String image5uri;
    String image6uri;
    Uri Imageuri;
    Intent intent;





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
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String value = sharedPreferences.getString("value","");
        int level=sharedPreferences.getInt("level",2);
        String image1uri=sharedPreferences.getString("image1value","");
        String image2uri=sharedPreferences.getString("image2value","");
        String image3uri=sharedPreferences.getString("image3value","");
        String image4uri=sharedPreferences.getString("image4value","");
        String image5uri=sharedPreferences.getString("image5value","");
        String image6uri=sharedPreferences.getString("image6value","");
        SharedPreferences.Editor editor=sharedPreferences.edit();
        int imageNumber=sharedPreferences.getInt("tobeadded",1);
        String imagetitle=sharedPreferences.getString("title","");
        if(level==2)
        { imageView3.setEnabled(false);
            imageView4.setEnabled(false);
            imageView5.setEnabled(false);
            imageView6.setEnabled(false);
        }
        if(imageNumber==1)
        {imageView=imageView1;
        editor.putString("image1value",value);
        editor.putString("imagetitle1",imagetitle);
        editor.apply();}
        if(imageNumber==2)
        {imageView=imageView2;
        editor.putString("image2value",value);
        editor.putString("imagetitle2",imagetitle);
        editor.apply();}
        if(imageNumber==3)
        {imageView=imageView3;
            editor.putString("image3value",value);
            editor.putString("imagetitle3",imagetitle);
            editor.apply();}
        if(imageNumber==4)
        {imageView=imageView4;
            editor.putString("image4value",value);
            editor.putString("imagetitle4",imagetitle);
            editor.apply();}
        if(imageNumber==5)
        {imageView=imageView5;
            editor.putString("image5value",value);
            editor.putString("imagetitle5",imagetitle);
            editor.apply();}
        if(imageNumber==6)
        {imageView=imageView6;
            editor.putString("image6value",value);
            editor.putString("imagetitle6",imagetitle);
            editor.apply();}
        Picasso.get().load(value).into(imageView);
        if(!image1uri.equals(""))
        {Picasso.get().load(image1uri).into(imageView1);}
        if(!image2uri.equals(""))
        {Picasso.get().load(image2uri).into(imageView2);}
        if(!image3uri.equals(""))
        {Picasso.get().load(image3uri).into(imageView3);}
        if(!image4uri.equals(""))
        {Picasso.get().load(image4uri).into(imageView4);}
        if(!image5uri.equals(""))
        {Picasso.get().load(image5uri).into(imageView5);}
        if(!image6uri.equals(""))
        {Picasso.get().load(image6uri).into(imageView6);}
//



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("tobeadded",1);
                editor.apply();
                Intent intent = new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("tobeadded",2);
                editor.apply();
                Intent intent = new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("tobeadded",3);
                editor.apply();
                Intent intent = new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("tobeadded",4);
                editor.apply();
                Intent intent = new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("tobeadded",5);
                editor.apply();
                Intent intent = new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("tobeadded",6);
                editor.apply();
                Intent intent = new Intent(selectedPictures.this, PictureFolders.class);
                startActivity(intent);

            }
        });


    }
    public void ContinueWithPictures(View view)
    {SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        int i = sharedPreferences.getInt("level",1);
        Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_LONG);
        if(i==2)
        {
            intent=new Intent (selectedPictures.this,CommunicationInterface2.class);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("counter2",0);
        editor.apply();}
        if(i==3)
        {intent=new Intent(selectedPictures.this,CommunicationInterface3.class);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("counter3",0);
            editor.apply();
        }
        if(i==4)
        {intent=new Intent(selectedPictures.this,CommunicationInterface4.class); }
        startActivity(intent);
    }
}


