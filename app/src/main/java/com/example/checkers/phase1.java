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


public class phase1 extends AppCompatActivity {

    private ImageView image_icon;
    private TextView Player1;
    private EditText name1;
    private Button pick_color1,pick_icon1,Ok;
    int choosen_color1;
    public Themes themes=new Themes();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.phase1);
        image_icon= (ImageView) findViewById(R.id.image1);
        Player1=(TextView) findViewById(R.id.player1);
        name1=(EditText) findViewById(R.id.player1name);
        pick_color1=(Button) findViewById(R.id.button2);
        pick_icon1=(Button) findViewById(R.id.pick_icon);
        Ok=(Button) findViewById(R.id.button);
        choosen_color1= ContextCompat.getColor(phase1.this, R.color.white);
        pop.phase = 1;


        pick_color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop2.phase = 1;
                Intent intent_pop2 = new Intent(phase1.this, pop2.class);
                startActivityForResult(intent_pop2,1);
            }
        });

        pick_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_pop = new Intent(phase1.this, pop.class);
                startActivityForResult(intent_pop,1);
            }
        });


        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameBoard.player1 = name1.getText().toString();
                if (GameBoard.player1.length() >= 1 && GameBoard.arr[2]!= -1 && GameBoard.arr[0] !=-1) {
                    startActivity(new Intent(phase1.this, phase2.class));
                }
                else if(GameBoard.arr[2] == -1){
                    Toast.makeText(phase1.this,"CHOOSE YOUR ICON !!",Toast.LENGTH_LONG).show();
                }
                else if(GameBoard.player1.length() <= 1){
                    Toast.makeText(phase1.this,"ENTER YOUR NAME !!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(phase1.this,"CHOOSE FIRST BOX COLOR !!",Toast.LENGTH_LONG).show();
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
                image_icon.setImageResource(result);
            }

        }
    }
}
