package com.example.checkers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Menu extends AppCompatActivity {
    Themes themes=new Themes();
    public Button load_button;
    public Button play_button;
    public Button credits_button;
    public Button howtoplay_button;
    public Button options_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("");
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main3);
        play_button=(Button) findViewById(R.id.button3);
        play_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V)
            {
                GameBoard.arr[2] = -1;
                GameBoard.arr[3] = -1;
                GameBoard.arr[0]=-1;
                GameBoard.arr[1]=-1;
                int x = 1;
                for (int i = 0;i<32;i++){
                    if(i>11&&i<=19)x=0;
                    else if(i>19)x=2;
                    GameBoard.players[i] = x;
                }
                Intent play_intent = new Intent(Main_Menu.this,phase1.class);
                startActivity(play_intent);
            }
        });

        load_button=(Button) findViewById(R.id.button4);
        load_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V)
            {
                Intent load_intent = new Intent(Main_Menu.this,LoadGame_Activity.class);
                startActivity(load_intent);
            }
        });

        howtoplay_button=(Button) findViewById(R.id.button5);
        howtoplay_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V)
            {
                Intent intent = new Intent(Main_Menu.this,how_to_play.class);
                startActivity(intent);

            }
        });
        options_button=(Button) findViewById(R.id.button6);
        options_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V)
            {
                Intent intent = new Intent(Main_Menu.this,options.class);
                startActivity(intent);
            }
        });

        credits_button=(Button) findViewById(R.id.button7);
        credits_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V)
            {
                Intent intent = new Intent(Main_Menu.this,credits.class);
                startActivity(intent);
            }
        });



    }
}