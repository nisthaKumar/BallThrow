package com.example.niskumar.ballthrow;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Direction direction = Direction.DOWN_RIGHT;

    float height;
    float width;
    final float dis = 250f;
    int duration = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("This is loaded");
        Toast.makeText(getApplicationContext(),  "Welcome", Toast.LENGTH_SHORT).show();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y-200;
    }


    public void animate(View view){
        ImageView ball = (ImageView)findViewById(R.id.ball);
        float x = ball.getTranslationX();
        float y = ball.getTranslationY();

        if(direction.equals(Direction.DOWN_RIGHT))
        {
            if((x+dis<=width) && (y+dis<=height))   goDownRight(ball);

            else if((x+dis>width) && (y+dis<=height))   goDownLeft(ball);

            else if((x+dis<=width) && (y+dis>height))   goUpRight(ball);

            else goUpLeft(ball);
        }
        if(direction.equals(Direction.DOWN_LEFT))
        {
            if((x-dis>=0) && (y+dis<=height))   goDownLeft(ball);

            else if((x-dis>=0) && (y+dis>height))   goUpLeft(ball);

            else if((x-dis<0) && (y+dis<=height))   goDownRight(ball);

            else goUpRight(ball);
        }
        if(direction.equals(Direction.UP_RIGHT))
        {
            if((x+dis<=width) && (y-dis>=0))   goUpRight(ball);

            else if((x+dis>width) && (y-dis>=0))   goUpLeft(ball);

            else if((x+dis<=width) && (y-dis<0))   goDownRight(ball);

            else goDownLeft(ball);
        }
        if(direction.equals(Direction.UP_LEFT))
        {
            if((x-dis>=0) && (y-dis>=0))   goUpLeft(ball);

            else if((x-dis>=0) && (y-dis<0))   goDownLeft(ball);

            else if((x-dis<0) && (y-dis>=0))  goUpRight(ball);

            else goDownRight(ball);
        }




    }
    public void goDownRight(ImageView ball){
        ball.animate().rotationBy(340f).setDuration(duration).translationYBy(dis).translationXBy(dis);
        direction = Direction.DOWN_RIGHT;
    }
    public void goDownLeft(ImageView ball){
        ball.animate().rotationBy(-340f).setDuration(duration).translationYBy(dis).translationXBy(-1*dis);
        direction = Direction.DOWN_LEFT;
    }
    public void goUpRight(ImageView ball){
        ball.animate().rotationBy(340f).setDuration(duration).translationYBy(-1*dis).translationXBy(dis);
        direction = Direction.UP_RIGHT;
    }
    public void goUpLeft(ImageView ball){
        ball.animate().rotationBy(-340f).setDuration(duration).translationYBy(-1*dis).translationXBy(-1*dis);
        direction = Direction.UP_LEFT;
    }

    public enum Direction {
        DOWN_RIGHT, DOWN_LEFT, UP_RIGHT, UP_LEFT;
    }
}
