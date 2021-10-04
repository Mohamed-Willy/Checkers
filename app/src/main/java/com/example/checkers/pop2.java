package com.example.checkers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class pop2 extends Activity {
    public Themes themes=new Themes();
    private ImageButton c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    public static int phase;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.popup2);

        c4=(ImageButton)  findViewById(R.id.c4);
        c5=(ImageButton)  findViewById(R.id.c5);
        c9=(ImageButton)  findViewById(R.id.c9);
        c3=(ImageButton)  findViewById(R.id.c3);
        c1=(ImageButton)  findViewById(R.id.c1);
        c2=(ImageButton)  findViewById(R.id.c2);
        c6=(ImageButton)  findViewById(R.id.c6);
        c8=(ImageButton)  findViewById(R.id.c8);
        c10=(ImageButton) findViewById(R.id.c10);
        c7=(ImageButton)  findViewById(R.id.c7);

       c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=1;
                    finish();}
                else if (test(1)){
                    GameBoard.arr[1]=1;
                    finish();}
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=2;
                    finish();}
                else if (test(2)){
                    GameBoard.arr[1]=2;
                    finish();}
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=3;
                    finish();}
                else if (test(3)){
                    GameBoard.arr[1]=3;
                    finish();    }
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=4;
                    finish();}
                else if (test(4)){
                    GameBoard.arr[1]=4;
                    finish();}
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=5;
                    finish();}
                else if (test(5)){
                    GameBoard.arr[1]=5;
                    finish();}
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=6;
                    finish();}
                else if (test(6)){
                    GameBoard.arr[1]=6;
                    finish();}
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=7;
                    finish();}
                else if (test(7)){
                    GameBoard.arr[1]=7;
                    finish();}
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=8;
                    finish();}
                else if (test(8)){
                    GameBoard.arr[1]=8;
                    finish();}
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=9;
                    finish();}
                else if (test(9)){
                    GameBoard.arr[1]=9;
                    finish();}
            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phase==1){
                    GameBoard.arr[0]=10;
                    finish();}
                else if (test(10)){
                    GameBoard.arr[1]=10;
                    finish();}
            }
        });
    }
    private boolean test(int x){
        if(GameBoard.arr[0] == x){
            Toast.makeText(this, "PICK A DIFFRENT COLOR !!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else return true;
    }
}
