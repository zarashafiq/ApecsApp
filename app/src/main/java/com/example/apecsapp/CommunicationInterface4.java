package com.example.apecsapp;

import android.content.ClipData;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.Locale;
import java.util.TimerTask;

public class CommunicationInterface4 extends AppCompatActivity {
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
        setContentView(R.layout.activity_communication_interface4);
        imageView = findViewById(R.id.myimage5th);
        imageView2 = findViewById(R.id.myimage5th2);
        b1 = findViewById(R.id.speakbutton5th);
        b2 = findViewById(R.id.reloadimage5th);
        sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        l = sharedPreferences.getInt("level", 4);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Picasso.get().load("http://192.168.1.6/apecs/PECS_pictures/Communicating/I_Want.jpg").into(imageView);
        if (sharedPreferences.contains("image1value")) {
            resId = sharedPreferences.getString("image1value", "");
            imageUri1 = Uri.parse(resId);
            Picasso.get().load(resId).into(imageView2);
        }
        image1title="I want";
        if(sharedPreferences.contains("imagetitle1")) {
            image2title = sharedPreferences.getString("imagetitle1", "");
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
                t1.speak(image1title, TextToSpeech.QUEUE_FLUSH, null);
                t1.speak(image2title,TextToSpeech.QUEUE_ADD,null);



            }
        });
        imageView.setOnTouchListener(new CommunicationInterface4.MyTouchListener());
        imageView2.setOnTouchListener(new CommunicationInterface4.MyTouchListener());

        findViewById(R.id.topleft5).setOnDragListener(new CommunicationInterface4.MyDragListener());

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
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activitiespopup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
       // boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}