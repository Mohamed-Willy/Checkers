package com.example.checkers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class phase2 extends AppCompatActivity {

    private ImageView image_icon2;
    private TextView Player2;
    private EditText name2;
    private Button pick_color2;
    private Button pick_icon2, Play;
    int choosen_color2;
    public Themes themes=new Themes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.phase2);
        pop.phase = 2;
        image_icon2=(ImageView) findViewById(R.id.image2);
        pick_color2=(Button)findViewById(R.id.button2) ;
        name2=(EditText) findViewById(R.id.player2name);
        Player2=(TextView) findViewById(R.id.player2) ;
        choosen_color2= ContextCompat.getColor(phase2.this, R.color.white);
        pick_icon2=(Button) findViewById(R.id.pick_icon);
        Play = (Button) findViewById(R.id.button);

        pick_color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop2.phase = 2;
                Intent intent_pop2 = new Intent(phase2.this, pop2.class);
                startActivityForResult(intent_pop2,1);
            }
        });
        pick_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_pop = new Intent(phase2.this, pop.class);
                startActivityForResult(intent_pop,1);
            }
        });

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameBoard.player2 = name2.getText().toString();
                if(GameBoard.player2.length() >= 1 && GameBoard.arr[3]!= -1 && GameBoard.arr[1] != -1 ){
                    Intent i =new Intent(phase2.this,GameBoard.class);
                    i.putExtra("Name","Phase2");
                    i.putExtra("Id",-1);
                    startActivity(i);
                }
                else if(GameBoard.arr[3] == -1){
                    Toast.makeText(phase2.this,"CHOOSE YOUR ICON !!",Toast.LENGTH_LONG).show();
                }
                else if(GameBoard.player2.length() <= 1){
                    Toast.makeText(phase2.this,"ENTER YOUR NAME !!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(phase2.this,"CHOOSE FIRST BOX COLOR !!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                image_icon2.setImageResource(result);
            }

        }
    }
}