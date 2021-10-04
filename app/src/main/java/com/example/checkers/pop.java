package com.example.checkers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class pop extends Activity {
    public Themes themes=new Themes();
    private ImageButton Kiwi,Orange,Nwa3m,Whitechecker,Whitemoon,Brownwood,Blackchecker,Blackwood,Blackmoon,Watermelon;
    public static int phase;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.popup);

        Kiwi=(ImageButton) findViewById(R.id.c4);
        Orange=(ImageButton) findViewById(R.id.c5);
        Nwa3m=(ImageButton) findViewById(R.id.c9);
        Whitechecker=(ImageButton) findViewById(R.id.c3);
        Whitemoon=(ImageButton) findViewById(R.id.c1);
        Brownwood=(ImageButton) findViewById(R.id.c2);
        Blackchecker=(ImageButton)findViewById(R.id.c6);
        Blackwood=(ImageButton)findViewById(R.id.c8);
        Blackmoon=(ImageButton) findViewById(R.id.c10);
        Watermelon=(ImageButton)findViewById(R.id.c7);

        Intent intent = getIntent();
        Kiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.kiwi);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=1;finish();
                }
                else if (test(1)){
                    GameBoard.arr[3]=1;finish();
                }
            }
        });
        Orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.orange);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=9;finish();
                }
                else if (test(9)){
                    GameBoard.arr[3]=9;finish();
                }
            }
        });
        Nwa3m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.nwa3m);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=10;finish();
                }
                else if (test(10)){
                    GameBoard.arr[3]=10;finish();
                }
            }
        });
        Whitechecker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.whitechecker);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=8;finish();
                }
                else if (test(8)){
                    GameBoard.arr[3]=8;finish();
                }
            }
        });
        Whitemoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.whitemoon);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=6;finish();
                }
                else if (test(6)){
                    GameBoard.arr[3]=6;finish();
                }
            }
        });
        Brownwood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.brownwood);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=2;finish();
                }
                else if (test(2)){
                    GameBoard.arr[3]=2;finish();
                }
            }
        });
        Blackchecker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.blackchecker);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=3;finish();
                }
                else if (test(3)){

                    GameBoard.arr[3]=3;finish();
                }
            }
        });
        Blackwood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.blackwood);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=5;finish();
                }
                else if (test(5)){
                    GameBoard.arr[3]=5;finish();
                }
            }
        });
        Watermelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.watermel);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=7;finish();
                }
                else if (test(7)){
                    GameBoard.arr[3]=7;finish();
                }
            }
        });
        Blackmoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", R.drawable.blackmoon);
                setResult(RESULT_OK, resultIntent);
                if(phase==1){
                    GameBoard.arr[2]=4;finish();
                }
                else if (test(4)){
                    GameBoard.arr[3]=4;finish();
                }
            }
        });
    }
    private boolean test(int x){
        if(GameBoard.arr[2] == x){
            Toast.makeText(this, "PICK A DIFFRENT ICON !!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else return true;
    }
}
