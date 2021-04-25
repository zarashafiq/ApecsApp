package com.example.apecsapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class Pictures extends AppCompatActivity {
    private GridView gridview1;
    public final String[] Activities={("http://192.168.1.6/apecs/PECS_pictures/Activities/Acoustic_Guitar.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Birthday.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Blocks.jpg"),
            ( "http://192.168.1.6/apecs/PECS_pictures/Activities/Blowing.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Booing.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Bounce_Basketball.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Bowling.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Bubbles.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Cheerleader.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Chew.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Clap.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Climb_Tree.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Cooking.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Cymbal.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Dancing.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Do_Laundry.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Drawing.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Drinking.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Drive.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Drum.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Drum_and_Cymbal.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Drum_Sticks.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Eat.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Eat_Lunch.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Fist_Bump.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Football.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Go_Down_Stairs.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Go_Up_Stairs.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Haircut.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Hide.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/High_Five.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Hug.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Keyboad.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Lay_down.jpg"),
            ( "http://192.168.1.6/apecs/PECS_pictures/Activities/Leg_Press.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Lego_Play.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Legos.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Lunch.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Microphone.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Monkey_Bars.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Pet_Dog.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Piggyback_Ride.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Play_at_Beach.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Play_Cymbal.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Play_Drum.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Play_Guitar.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Play_Keyboard.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Play_Recorder.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Play_Video_Games.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Playing.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Pray.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/PT_Room.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Puzzle.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Recorder.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Ride_in_Car.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Ride_On.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Sandbox.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Shake_Hands.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Singing.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Sit.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Sit_Crisscross.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Sit_Down.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Sleep.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Slide.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Snap_Fingers.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Sneeze.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Swim_in_Ocean.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Swim_in_Pool.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Swimming.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Swing.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Therapist.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Timed_Workout.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Trampoline.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Trampoline2.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Trumpet.jpg"),
            ( "http://192.168.1.6/apecs/PECS_pictures/Activities/Turn_off.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Turn_on.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Up_to_Bat.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Use_Remote_Control.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Vaccuuming.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Volleyball_Player.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Walk.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Watching_TV.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Yawn.jpg")

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        gridview1 = (GridView) findViewById(R.id.mainGridView2);
        final PictureAdapter movieAdapter = new PictureAdapter(this, Activities);
        gridview1.setAdapter(movieAdapter);
    }}












