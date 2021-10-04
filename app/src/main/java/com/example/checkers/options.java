package com.example.checkers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.health.ServiceHealthStats;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class options extends AppCompatActivity {
    Themes themes=new Themes();
   public static boolean ison = true;
    SwitchCompat sound_switch;
    ImageButton white_wood,black_wood,cyan,orange,green,colors;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.options_activity);

        sound_switch = (SwitchCompat) findViewById(R.id.sound_switch);
        white_wood = (ImageButton) findViewById(R.id.white_wood);
        black_wood  = (ImageButton) findViewById(R.id.black_wood);
        cyan = (ImageButton) findViewById(R.id.cyan);
        orange = (ImageButton) findViewById(R.id.orange);
        green = (ImageButton) findViewById(R.id.green);
        SharedPreferences sharedPreferences=getSharedPreferences("save",MODE_PRIVATE);
        sound_switch.setChecked(sharedPreferences.getBoolean("value",true));
        colors = (ImageButton) findViewById(R.id.colors);
        btn_clk();
        sound_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sound_switch.isChecked())
                {
                   ison=true;
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    sound_switch.setChecked(true);

                }
                else
                {
                   ison=false;
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    sound_switch.setChecked(false);

                }
            }
        });
    }
    private void btn_clk(){
        white_wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themes.changeToTheme(options.this,0);

            }
        });

        black_wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themes.changeToTheme(options.this,1);

            }
        });

        cyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themes.changeToTheme(options.this,2);

            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themes.changeToTheme(options.this,3);

            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themes.changeToTheme(options.this,4);

            }
        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themes.changeToTheme(options.this,5);

            }
        });

    }
}
