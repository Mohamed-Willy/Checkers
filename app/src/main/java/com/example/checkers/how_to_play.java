package com.example.checkers;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class how_to_play extends AppCompatActivity {
    public Themes themes=new Themes();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.how_to_play);
    }
}
