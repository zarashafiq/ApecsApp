package com.example.apecsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;

public class Pictures extends AppCompatActivity {
    GridView gridview1;
    TextView textview;
    String[] resId;
    String scenario;
    int value;
    String finalEd;
    SharedPreferences sharedPreferences;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            scenario = bundle.getString("title");
            switch(scenario)
            {
                case"Activities":
                    resId=Activities;
                    break;
                case "Animals":
                    resId=Animals;
                    break;
                case "Basic":
                    resId=Basic;
                    break;
                case "Clothes":
                    resId=Clothing;
                    break;
                case "Communicatiom":
                    resId=Communicating;
                    break;
                case "Foods":
                    resId=Foods;
                    break;
                case "Household":
                    resId=Household;
                    break;
                case "People":
                    resId=People;
                    break;
                case "Places":
                    resId=Places;
                    break;
                case "Selfhelp":
                    resId=SelfHelp;
                    break;
                case "Tools":
                    resId=Tools;
                    break;
                case "Transportation":
                    resId=Transportation;
                    break;
                default:
                    Toast.makeText(Pictures.this,"---INVALID---",Toast.LENGTH_SHORT).show();
                    break;



            }}

        gridview1 = (GridView) findViewById(R.id.mainGridView2);
        sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        value = sharedPreferences.getInt("level",1);
        gridview1.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
                Uri uri= Uri.parse(resId[p3]);
                String s=uri.getLastPathSegment().substring(0, uri.getLastPathSegment().length() - 4);
                if(s.contains("_"))
                {String ed1=null;
                    ed1=s.replace("_"," ");
                    finalEd = ed1;}
                else {finalEd=s;}
                Toast.makeText(getApplicationContext(), finalEd, Toast.LENGTH_LONG).show();
                String Suri=uri.toString();
                sharedPreferences= getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
////                editor.putString("value", uri);
////                editor.apply();
                if(value==1){
                Intent intent = new Intent(Pictures.this, CommunicationInterface.class);
                editor.putString("liburi",Suri);
                editor.putString("title",finalEd);
                editor.putInt("counter",counter);
                editor.apply();
                startActivity(intent);
                }
                if(value==2)
                {editor.putString("value",Suri);
                editor.putString("title",finalEd);
                editor.apply();
                Intent intent=new Intent(Pictures.this,selectedPictures.class);
                startActivity(intent);}
////                intent.putExtra("liburi",uri);
////                intent.putExtra("title",s);
//
////            }
//
//
            }
        });

        final PictureAdapter movieAdapter = new PictureAdapter(this, resId);
        gridview1.setAdapter(movieAdapter);
    }    public final String[] Activities={("http://192.168.1.6/apecs/PECS_pictures/Activities/Acoustic_Guitar.jpg"),
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
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Keyboard.jpg"),
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
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Play_Video_Game.jpg"),
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
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Vacuuming.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Volleyball_Player.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Walk.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Watching_TV.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/Activities/Yawn.jpg")

    };
    public final String[] Animals={
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Cow.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Dinosaur_Bones.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Dog.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Duck.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Fish.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Giraffe.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Goldfish.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Horse.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Parrot.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Penguin.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Pig.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Pigeon.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Seal.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Shark.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Snake.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Swan.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Turtle.jpg"),
            ("http://192.168.1.6/apecs/PECS_pictures/animals/Tyrannosaurus_Rex.jpg")

    };

public final String[] Basic= {"http://192.168.1.6/apecs/PECS_pictures/Basic/1_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/2_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/3_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/4_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/5_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/6_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/7_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/8_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/9_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/10_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/11_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/12_o'clock.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/A%20(2).jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/Afternoon.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Basic/April.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/April.jpg",
   "http://192.168.1.6/apecs/PECS_pictures/Basic/August.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/B(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Bat.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Black.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Blue.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Brown.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/C.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Christmas.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Christmas_Tree.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Circle.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/D(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Day.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/December.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Dime.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/E(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Easter.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Evening.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/F(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Fall.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/February.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/G(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Gift.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Gray.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Green.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/H(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Halloween.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Heart.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/I(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/J(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/January.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/July.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/June.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/K.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/L.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/M.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/March.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/May.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Month.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Moon.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Morning.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/N.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Nickel.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Night.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Noon.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/November.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/O.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/October.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Orange.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Oval.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/P(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Penny.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Pink.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Pumpkin.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Purple.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Put_Star_on_Tree.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Q.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Quarter.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/R.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Rectangle.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Red.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/S.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/September.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Spring.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Square.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Star.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Stocking.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Summer.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/T.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Thanksgiving.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Time_Permitted.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Twenty-dollar_bill.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/U.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/V(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/W.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Week.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/White.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Winter.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Wreath.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/X.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Y(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Yellow.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/Z.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/a.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/b.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/c(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/d.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/e.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/f.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/g.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/h.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/i.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/j.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/k(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/l(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/m(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/n(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/o(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/p.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/q(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/r(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/s(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/t(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/u(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/v.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/w(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/x(1).jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/y.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Basic/z%20(2).jpg"
};
public final String[] Clothing={
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Baseball_Cap.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Belt.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Boots.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Bra.jpg",
         "http://192.168.1.6/apecs/PECS_pictures/Clothing/Cleats.jpg",
         "http://192.168.1.6/apecs/PECS_pictures/Clothing/Panties.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Pants.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Shirt.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Shorts.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Sneakers.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Socks.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Spool_of_thread.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Underwear.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Clothing/Winter_Coat.jpg"

};
public final String[] Communicating={
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/All_Gone.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Angry.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Angry.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Back_Pain.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Bad_Smell.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Biting.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Calm_Down.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Climbing.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Cold.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Congratulations.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Crying.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Do_Not_Run_Away.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Do_Not_Run_at_School.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Don't_Touch.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Excited.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Feeling_Sick.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Good-bye.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Good_Job.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Hair_Pulling.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Hands_on_Mouth.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Happy.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Headache.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Hello.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Hitting.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Hot_Stove.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/I_Need_Help.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/I_Want.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/I_don't_know.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Idea.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Jumpiing.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Kicking.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Listen.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Listening.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Look.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Mad.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Nail_Biting.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Climbing.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Eating_Objects.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Eating_Objects.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Hair_Pulling.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Hitting.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Jumping.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Kicking.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Nail_Biting.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Open_Mouth.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Playing_in_Trash.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Pointing.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Pulling_Hair.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Punching.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Running.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Scratching.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Sleeping.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Stick_Out_Tongue.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Throwing.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_Thumb_Sucking.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/No_picking_nose.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Ok.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Owie.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Peace.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Picking_nose.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Playing_in_Trash.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Please.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Pointing.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Proud.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Pulling_Hair.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Punching.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Quiet_Mouth.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Sad.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Scared.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Scratching.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Smell.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Stick_Out_Tongue.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Stomachache.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Stop!.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Stop.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Strong.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Stubborn.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Sure.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Surprised.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Thinking.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/This_one.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Throwing.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Thumb_sucking.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Time-out.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Time_Out.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Timeout.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Wait.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Wave.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Wink.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Yeah.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Yikes.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Yucky.jpg",
    "http://192.168.1.6/apecs/PECS_pictures/Communicating/Yummy.jpg",

    };
public final String[] Foods={
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Apple.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Apple_Juice.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Avacado.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Bacon.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Bagel.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Banana.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Bananas.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Beef_Corn_Dog.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Beef_Stick.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Bell_Pepper.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Blackberry.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Bottled_Water.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Broccoli.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Brownie.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cake.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Carrot.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cauliflower.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cheese_Puffs.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cheese_Slice.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cheese_Wedge.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cheeseburger.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cherry.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Chicken_Nuggets.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Chili_pepper.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cinnamon_Bun.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cinnamon_Roll.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Corn.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Corn_Dog.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cracker.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cucumber.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Cupcake.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Doughnut.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Eggplant.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/French_fries.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Fried_Chicken.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Fried_Egg.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Goldfish_Crackers.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Grapes.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Grilled_Cheese.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Ham.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Hard-Boiled_Egg.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Hot_Drink.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Hot_dog.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Ice_cream.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Ketchup.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Lemon.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Lettuce.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Loaf_of_Bread.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Lollipop.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Macaroni_and_Cheese.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Mango.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Milk.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Muffin.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Mustard.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Onion.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Orange.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Orange_Juice.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pancakes.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pasta_Sauce.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Peach.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Peanut_Butter(1).jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Peanut_Butter.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pear.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pickle.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pie.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pineapple.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pizza.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pizza_Pie.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Plum.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Popcorn.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Potato_Chips.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pretzel.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Pumpkin.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Radish.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Raisins.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Rasberry.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Sack_Lunch.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Sandwhich.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Sliced_Plum.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Soda.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Soda_Pop.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Strawberry.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Sugar.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Sundae.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Toast.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Waffles.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Water.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/Foods/Watermelon.jpg"
};
public final String[] Household={


            "http://192.168.1.6/apecs/PECS_pictures/Household/Bowl.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Butter_Knife.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Chair.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Chopping_Knife.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Clothes_hanger.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Cotton_Swab.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Couch.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Deodorant.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Drinking_Glass.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Floss.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Fork.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Hair_dryer.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Hot_Stove.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Household_Cleaner.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Light_bulb.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Nail_Clippers.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Pan.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Paper_Towel.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Pitcher.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Pot.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Refrigerator.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Remote_Control.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Scissors.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Spoon.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Stairs.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Steak_knife.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Stove.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Tablet.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Television.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Toaster.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Toilet.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Toilet_Open.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Toilet_Paper.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Toothbursh.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Toothpaste_Closed.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Toothpaste_Open.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Trash_Can.jpg",
            "http://192.168.1.6/apecs/PECS_pictures/Household/Tweezers.jpg",


    };
public final String[] People=
    {
        "http://192.168.1.6/apecs/PECS_pictures/People/Back.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Chest.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Children.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Dancer.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Elbow.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Eye.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Eyes.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Feet.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Fireman.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Foot.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Friends.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Hand.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Hands.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Knee.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Man.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Men.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/People.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Policeman.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Shoulder.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Teeth.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Woman.jpg",
        "http://192.168.1.6/apecs/PECS_pictures/People/Women.jpg"
    };
public final String[] Places=
        {
                "http://192.168.1.6/apecs/PECS_pictures/Places/Backpack.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Ball.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Bible.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Books.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Church.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Classroom.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Dentist.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Dentist_Office.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Doctor.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Geography.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Glue.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Grocery_Store.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/History.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Mailbox.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Math.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Notebook.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Nurse.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Paper.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Park.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Pen.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Pencil.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Playground.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Pool.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Put_backpack_on.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Put_in_backpack.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Ready_to_Work.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/School.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Science.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Social_Studies.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Stethoscope.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Students.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Teacher.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Teddy_Bear.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Telescope.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Toy_store.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Wagon.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Places/Water_Fountain.jpg"
        };
public final String[] SelfHelp=
        {
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Bath.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Blow_Nose.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Brush_Hair.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Brush_Teeth.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Clean_ears.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Clean_up.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Clip_Nails.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Comb.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Dry_Face.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Getting_Dressed.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Help_with_Cooking.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Pants_on.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Put_Socks_On.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Put_on_Deodorant.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Put_on_Helmet.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Shirt_on.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Shoes_on.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Soap.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Throw_away.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Tie_shoes.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Use_Toothpaste.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Wash_Face.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Wash_Hands.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Wear_Helmet.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Wipe_Nose.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Zip-up.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Self%20Help/Zipper.jpg",

        };
public final String[] Tools=
        {
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Axe.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Drill.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Fire_Extinguisher.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Hammer.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Lock.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Pick.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Pickaxe.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Pliers.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Saw.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Screwdriver.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Shovel.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Wood_Clamp.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Tools/Wrench.jpg"

        };
public final String[] Transportation=
        {
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Ambulance.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Bicycle.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Fire_Truck.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Limousine.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Minivan.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Motorcycle.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Pickup_Truck.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Police_Car.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Propeller_Aircraft.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/RV.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/SUV.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/School_Bus.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Semi-Trailer_Truck.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Snowplow.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Sports_Car.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Steam_Train.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Tank.jpg",
                "http://192.168.1.6/apecs/PECS_pictures/Transportation/Van.jpg"
        };
}















