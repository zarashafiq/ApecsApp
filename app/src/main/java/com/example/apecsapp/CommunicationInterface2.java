package com.example.apecsapp;

import android.content.ClipData;
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

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.Locale;
import java.util.TimerTask;

public class CommunicationInterface2 extends AppCompatActivity {
    TextToSpeech t1;
    ImageButton b1;
    ImageView imageView;
    ImageView imageView2;
    Uri imageUri1;
    Uri imageUri2;
    String image1title;
    String image2title;
    SharedPreferences sharedPreferences;
    public String finalEd;
    TimerTask t2;
    ImageButton b2;
    String resId;
    String resId2;
    int l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_interface2);
        imageView=findViewById(R.id.myimage3rd);
        imageView2=findViewById(R.id.myimage3rd2);
        b1=findViewById(R.id.speakbutton3rd);
        b2=findViewById(R.id.reloadimage3rd);
        sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        l=sharedPreferences.getInt("level",2);
        if(sharedPreferences.contains("image1value")) {
            resId = sharedPreferences.getString("image1value", "");
            imageUri1 = Uri.parse(resId);
            Picasso.get().load(resId).into(imageView);
        }
        if(sharedPreferences.contains("image2value")) {
            resId2 = sharedPreferences.getString("image2value", "");
            imageUri2 = Uri.parse(resId2);
            Picasso.get().load(resId2).into(imageView2);
        }
        if(sharedPreferences.contains("imagetitle1")) {
            image1title = sharedPreferences.getString("imagetitle1", "");

        }
        if(sharedPreferences.contains("imagetitle2")) {
            image2title = sharedPreferences.getString("imagetitle2", "");

        }
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), image1title, Toast.LENGTH_SHORT).show();
                t1.speak(image1title, TextToSpeech.QUEUE_FLUSH, null);
                t1.speak(image2title,TextToSpeech.QUEUE_ADD,null);



            }
        });

        imageView.setOnTouchListener(new CommunicationInterface2.MyTouchListener());
        imageView2.setOnTouchListener(new CommunicationInterface2.MyTouchListener());

        findViewById(R.id.topleft3).setOnDragListener(new CommunicationInterface2.MyDragListener());
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