package com.example.apecsapp;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.Locale;
import java.util.TimerTask;

public class CommunicationInterface extends AppCompatActivity {
    TextToSpeech t1;
    ImageButton b1;
    ImageView imageView;
    Uri imageUri;
    SharedPreferences sharedPreferences;
     String finalEd;
    TimerTask t2;
    ImageButton b2;
    String resId;
    int l;
    boolean fromdevice;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coomunication_interface);
        imageView=findViewById(R.id.myimage);
        b1=findViewById(R.id.imageButton2);
        b2=findViewById(R.id.imageButton3);
        sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        l=sharedPreferences.getInt("level",1);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        Bundle bundle = getIntent().getExtras();
//
        if (bundle != null) {
            if (bundle.containsKey("imageuri")) {
                fromdevice=true;
                String resId = bundle.getString("imageuri");
                imageUri = Uri.parse(resId);
                imageView.setImageURI(imageUri);
            }
            if (!bundle.containsKey("imageuri")) {
                if (sharedPreferences.contains("liburi")) {
                    resId = sharedPreferences.getString("liburi", "");
                    imageUri = Uri.parse(resId);
                    Picasso.get().load(resId).into(imageView);
                }
//

//
            }
            t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        t1.setLanguage(Locale.UK);
                    }
                }
            });
            if(!fromdevice) {
                if (sharedPreferences.contains("title")) {
                    String ed = sharedPreferences.getString("title", "");
                    if (ed.contains("_")) {
                        String ed1 = null;
                        ed1 = ed.replace("_", " ");
                        finalEd = ed1;
                    } else {
                        finalEd = ed;
                    }
                }
            }
                else
                {finalEd=bundle.getString("devicetitle");}
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), finalEd, Toast.LENGTH_SHORT).show();
                        t1.speak(finalEd, TextToSpeech.QUEUE_FLUSH, null);
                    }
                });

            SharedPreferences.Editor editor = sharedPreferences.edit();
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int calcualatecounter = sharedPreferences.getInt("counter", 0);
                    if (calcualatecounter == 10) {
                        //Toast.makeText(getApplicationContext(), "Move to next Activity", Toast.LENGTH_SHORT).show();
                        builder.setMessage("It looks like you should move to the next phase")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (l == 1) {
                                            l = 2;
                                            editor.putInt("level", l);
                                            editor.apply();
                                        }
                                        Toast.makeText(getApplicationContext(), String.valueOf(l), Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(CommunicationInterface.this, selectedPictures.class);
                                        editor.putString("image1uri", resId);
                                        editor.apply();
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();


                    } else {
                        calcualatecounter++;
                        editor.putInt("counter", calcualatecounter);
                        editor.apply();
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }


                }
            });

//        else{ Toast.makeText(getApplicationContext(), "no title", Toast.LENGTH_SHORT).show();}


            imageView.setOnTouchListener(new MyTouchListener());
            findViewById(R.id.topleft).setOnDragListener(new MyDragListener());

        }
    }
    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action) {

                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    animateDragToStart(view, event.getX(), event.getY());
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;

        }
    }
    private void animateDragToStart(View initialView, float fromX, float fromY) {
        float topMargin = fromY - initialView.getTop();
        float leftMargin = fromX - initialView.getLeft();

        Animation translateAnimation = new TranslateAnimation(leftMargin - (initialView.getWidth() / 2), 0, topMargin - (initialView.getHeight() / 2), 0);
        translateAnimation.setDuration(500);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        initialView.startAnimation(translateAnimation);
        initialView.setVisibility(View.VISIBLE);
    }
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}