package com.example.checkers;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class GameBoard extends AppCompatActivity {

    ImageView ii[] = new ImageView[64];
    ImageView p[] = new ImageView[32];
    public static String player1 = new String();
    public static String player2 = new String();
    TextView playersname;
    int turn = 1;
    public static boolean returntomenu = false;
    public static int arr[] = new int[4];
    public static int players[] = new int[32];
    int currentplayer = -1, currentpos = -1;
    Button svbtn;
    Themes themes=new Themes();
    DataBasehandler dbhandler;
    private String selectedName;
    private int selectedId;
    MediaPlayer mp = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_game_board);
        svbtn = (Button) findViewById(R.id.save_game);
        setimages();
        dbhandler = new DataBasehandler(this);
        Intent receivedIntent = getIntent();
        selectedName = receivedIntent.getStringExtra("Name");
        selectedId = receivedIntent.getIntExtra("Id",-1);
        playersname = findViewById(R.id.textView5);
        playersname.setText(player1);
        mp = MediaPlayer.create(this,R.raw.videoplayback);
        //box 1 color
        if (arr[0] == 1) color1black();
        if (arr[0] == 2) color1blue();
        if (arr[0] == 3) color1cyan();
        if (arr[0] == 4) color1gray();
        if (arr[0] == 5) color1purple();
        if (arr[0] == 6) color1red();
        if (arr[0] == 7) color1yellow();
        if (arr[0] == 8) color1teal();
        if (arr[0] == 9) color1green();
        if (arr[0] == 10) color1white();
        //box 2 color
        if (arr[1] == 1) color2black();
        if (arr[1] == 2) color2blue();
        if (arr[1] == 3) color2cyan();
        if (arr[1] == 4) color2gray();
        if (arr[1] == 5) color2purple();
        if (arr[1] == 6) color2red();
        if (arr[1] == 7) color2yellow();
        if (arr[1] == 8) color2teal();
        if (arr[1] == 9) color2green();
        if (arr[1] == 10) color2white();
        setplaces();
        svbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(GameBoard.this);
                dialog.setContentView(R.layout.gamename_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                EditText txt = dialog.findViewById(R.id.gamename);
                Button svbtn = dialog.findViewById(R.id.svbtn);
                Button cancelbtn = dialog.findViewById(R.id.cancelbtn);
                DataBasehandler db = new DataBasehandler(GameBoard.this);
                dialog.show();


                svbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (txt.getText().toString().isEmpty()) {
                            Toast.makeText(GameBoard.this,"Please Enter a Name !!",Toast.LENGTH_LONG).show();
                        }
                        else {
                            String game_name = txt.getText().toString();
                            db.ADD_GameName(game_name, players, arr, player1, player2);
                            dialog.dismiss();
                            Intent intent = new Intent(GameBoard.this, Main_Menu.class);
                            startActivity(intent);
                        }
                    }
                });
                cancelbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { dialog.dismiss();
                    }
                });

            }
        });

    }

    public void sound() {
        if(options.ison==true)
            mp.start();
        else
            mp.stop();

    }
    //set places
    private void setplaces() {
        for (int i = 0; i < 32; i++) {
            if (players[i] == 0) {
                if (arr[0] == 1) p[i].setImageResource(R.drawable.blackbox);
                if (arr[0] == 2) p[i].setImageResource(R.drawable.bluebox);
                if (arr[0] == 3) p[i].setImageResource(R.drawable.cyanbox);
                if (arr[0] == 4) p[i].setImageResource(R.drawable.graybox);
                if (arr[0] == 5) p[i].setImageResource(R.drawable.purplebox);
                if (arr[0] == 6) p[i].setImageResource(R.drawable.redbox);
                if (arr[0] == 7) p[i].setImageResource(R.drawable.yellowbox);
                if (arr[0] == 8) p[i].setImageResource(R.drawable.tealbox);
                if (arr[0] == 9) p[i].setImageResource(R.drawable.greenbox);
                if (arr[0] == 10) p[i].setImageResource(R.drawable.whitebox);
            } else if (players[i] == 1) {
                //player 1 shape
                if (arr[2] == 1) p1kiwi(i);
                if (arr[2] == 2) p1brownwood(i);
                if (arr[2] == 3) p1blackchecker(i);
                if (arr[2] == 4) p1blackmoon(i);
                if (arr[2] == 5) p1blackwood(i);
                if (arr[2] == 6) p1whitemoon(i);
                if (arr[2] == 7) p1watermel(i);
                if (arr[2] == 8) p1whitechecker(i);
                if (arr[2] == 9) p1orange(i);
                if (arr[2] == 10) p1nwa3m(i);
            } else if (players[i] == 2) {
                //player 2 shape
                if (arr[3] == 1) p1kiwi(i);
                if (arr[3] == 2) p1brownwood(i);
                if (arr[3] == 3) p1blackchecker(i);
                if (arr[3] == 4) p1blackmoon(i);
                if (arr[3] == 5) p1blackwood(i);
                if (arr[3] == 6) p1whitemoon(i);
                if (arr[3] == 7) p1watermel(i);
                if (arr[3] == 8) p1whitechecker(i);
                if (arr[3] == 9) p1orange(i);
                if (arr[3] == 10) p1nwa3m(i);
            } else if (players[i] == 3) {
                //player 1 shape
                if (arr[2] == 1) p[i].setImageResource(R.drawable.ckiwi);
                if (arr[2] == 2) p[i].setImageResource(R.drawable.cbrownwood);
                if (arr[2] == 3) p[i].setImageResource(R.drawable.cblackchecker);
                if (arr[2] == 4) p[i].setImageResource(R.drawable.cblackmoon);
                if (arr[2] == 5) p[i].setImageResource(R.drawable.cblackwood);
                if (arr[2] == 6) p[i].setImageResource(R.drawable.cwhitemoon);
                if (arr[2] == 7) p[i].setImageResource(R.drawable.cwatermel);
                if (arr[2] == 8) p[i].setImageResource(R.drawable.cwhitechecker);
                if (arr[2] == 9) p[i].setImageResource(R.drawable.corange);
                if (arr[2] == 10) p[i].setImageResource(R.drawable.cnwa3m);
            } else if (players[i] == 4) {
                //player 2 shape
                if (arr[3] == 1) p[i].setImageResource(R.drawable.ckiwi);
                if (arr[3] == 2) p[i].setImageResource(R.drawable.cbrownwood);
                if (arr[3] == 3) p[i].setImageResource(R.drawable.cblackchecker);
                if (arr[3] == 4) p[i].setImageResource(R.drawable.cblackmoon);
                if (arr[3] == 5) p[i].setImageResource(R.drawable.cblackwood);
                if (arr[3] == 6) p[i].setImageResource(R.drawable.cwhitemoon);
                if (arr[3] == 7) p[i].setImageResource(R.drawable.cwatermel);
                if (arr[3] == 8) p[i].setImageResource(R.drawable.cwhitechecker);
                if (arr[3] == 9) p[i].setImageResource(R.drawable.corange);
                if (arr[3] == 10) p[i].setImageResource(R.drawable.cnwa3m);
            } else if (players[i] == 5) {
                p[i].setImageResource(R.drawable.browndot);
            }
        }
    }

    //intializing image views
    private void setimages() {
        ii[0] = findViewById(R.id.i0);
        ii[1] = findViewById(R.id.i1);
        ii[2] = findViewById(R.id.i2);
        ii[3] = findViewById(R.id.i3);
        ii[4] = findViewById(R.id.i4);
        ii[5] = findViewById(R.id.i5);
        ii[6] = findViewById(R.id.i6);
        ii[7] = findViewById(R.id.i7);
        ii[8] = findViewById(R.id.i8);
        ii[9] = findViewById(R.id.i9);
        ii[10] = findViewById(R.id.i10);
        ii[11] = findViewById(R.id.i11);
        ii[12] = findViewById(R.id.i12);
        ii[13] = findViewById(R.id.i13);
        ii[14] = findViewById(R.id.i14);
        ii[15] = findViewById(R.id.i15);
        ii[16] = findViewById(R.id.i16);
        ii[17] = findViewById(R.id.i17);
        ii[18] = findViewById(R.id.i18);
        ii[19] = findViewById(R.id.i19);
        ii[20] = findViewById(R.id.i20);
        ii[21] = findViewById(R.id.i21);
        ii[22] = findViewById(R.id.i22);
        ii[23] = findViewById(R.id.i23);
        ii[24] = findViewById(R.id.i24);
        ii[25] = findViewById(R.id.i25);
        ii[26] = findViewById(R.id.i26);
        ii[27] = findViewById(R.id.i27);
        ii[28] = findViewById(R.id.i28);
        ii[29] = findViewById(R.id.i29);
        ii[30] = findViewById(R.id.i30);
        ii[31] = findViewById(R.id.i31);
        ii[32] = findViewById(R.id.i32);
        ii[33] = findViewById(R.id.i33);
        ii[34] = findViewById(R.id.i34);
        ii[35] = findViewById(R.id.i35);
        ii[36] = findViewById(R.id.i36);
        ii[37] = findViewById(R.id.i37);
        ii[38] = findViewById(R.id.i38);
        ii[39] = findViewById(R.id.i39);
        ii[40] = findViewById(R.id.i40);
        ii[41] = findViewById(R.id.i41);
        ii[42] = findViewById(R.id.i42);
        ii[43] = findViewById(R.id.i43);
        ii[44] = findViewById(R.id.i44);
        ii[45] = findViewById(R.id.i45);
        ii[46] = findViewById(R.id.i46);
        ii[47] = findViewById(R.id.i47);
        ii[48] = findViewById(R.id.i48);
        ii[49] = findViewById(R.id.i49);
        ii[50] = findViewById(R.id.i50);
        ii[51] = findViewById(R.id.i51);
        ii[52] = findViewById(R.id.i52);
        ii[53] = findViewById(R.id.i53);
        ii[54] = findViewById(R.id.i54);
        ii[55] = findViewById(R.id.i55);
        ii[56] = findViewById(R.id.i56);
        ii[57] = findViewById(R.id.i57);
        ii[58] = findViewById(R.id.i58);
        ii[59] = findViewById(R.id.i59);
        ii[60] = findViewById(R.id.i60);
        ii[61] = findViewById(R.id.i61);
        ii[62] = findViewById(R.id.i62);
        ii[63] = findViewById(R.id.i63);
        p[0] = findViewById(R.id.p0);
        p[1] = findViewById(R.id.p1);
        p[2] = findViewById(R.id.p2);
        p[3] = findViewById(R.id.p3);
        p[4] = findViewById(R.id.p4);
        p[5] = findViewById(R.id.p5);
        p[6] = findViewById(R.id.p6);
        p[7] = findViewById(R.id.p7);
        p[8] = findViewById(R.id.p8);
        p[9] = findViewById(R.id.p9);
        p[10] = findViewById(R.id.p10);
        p[11] = findViewById(R.id.p11);
        p[12] = findViewById(R.id.p12);
        p[13] = findViewById(R.id.p13);
        p[14] = findViewById(R.id.p14);
        p[15] = findViewById(R.id.p15);
        p[16] = findViewById(R.id.p16);
        p[17] = findViewById(R.id.p17);
        p[18] = findViewById(R.id.p18);
        p[19] = findViewById(R.id.p19);
        p[20] = findViewById(R.id.p20);
        p[21] = findViewById(R.id.p21);
        p[22] = findViewById(R.id.p22);
        p[23] = findViewById(R.id.p23);
        p[24] = findViewById(R.id.p24);
        p[25] = findViewById(R.id.p25);
        p[26] = findViewById(R.id.p26);
        p[27] = findViewById(R.id.p27);
        p[28] = findViewById(R.id.p28);
        p[29] = findViewById(R.id.p29);
        p[30] = findViewById(R.id.p30);
        p[31] = findViewById(R.id.p31);
    }

    //first color select
    private void color1black() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.blackbox);
        }
    }

    private void color1blue() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.bluebox);

        }
    }

    private void color1cyan() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.cyanbox);
        }
    }

    private void color1gray() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.graybox);
        }
    }

    private void color1purple() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.purplebox);
        }
    }

    private void color1red() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.redbox);
        }
    }

    private void color1yellow() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.yellowbox);
        }
    }

    private void color1teal() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.tealbox);
        }
    }

    private void color1green() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.greenbox);
        }
    }

    private void color1white() {
        int m = 0;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.whitebox);
        }
    }

    //second color select
    private void color2black() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.blackbox);
        }
    }

    private void color2blue() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.bluebox);

        }
    }

    private void color2cyan() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.cyanbox);
        }
    }

    private void color2gray() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.graybox);
        }
    }

    private void color2purple() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.purplebox);
        }
    }

    private void color2red() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.redbox);
        }
    }

    private void color2yellow() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.yellowbox);
        }
    }

    private void color2teal() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.tealbox);
        }
    }

    private void color2green() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.greenbox);
        }
    }

    private void color2white() {
        int m = 1;
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i > 0) {
                m = 1 - m;
            }
            if (i % 2 == m)
                ii[i].setImageResource(R.drawable.whitebox);
        }
    }

    //first player checker peaces color
    private void p1kiwi(int i) {
        p[i].setImageResource(R.drawable.kiwi);
    }

    private void p1brownwood(int i) {
        p[i].setImageResource(R.drawable.brownwood);
    }

    private void p1blackchecker(int i) {
        p[i].setImageResource(R.drawable.blackchecker);
    }

    private void p1blackmoon(int i) {
        p[i].setImageResource(R.drawable.blackmoon);
    }

    private void p1blackwood(int i) {
        p[i].setImageResource(R.drawable.blackwood);
    }

    private void p1whitemoon(int i) {
        p[i].setImageResource(R.drawable.whitemoon);
    }

    private void p1watermel(int i) {
        p[i].setImageResource(R.drawable.watermel);
    }

    private void p1whitechecker(int i) {
        p[i].setImageResource(R.drawable.whitechecker);
    }

    private void p1orange(int i) {
        p[i].setImageResource(R.drawable.orange);
    }

    private void p1nwa3m(int i) {
        p[i].setImageResource(R.drawable.nwa3m);
    }

    //on click functions
    public void onp0(View V) {
        movement(0);
    }

    public void onp1(View V) {
        movement(1);
    }

    public void onp2(View V) {
        movement(2);
    }

    public void onp3(View V) {
        movement(3);
    }

    public void onp4(View V) {
        movement(4);
    }

    public void onp5(View V) {
        movement(5);
    }

    public void onp6(View V) {
        movement(6);
    }

    public void onp7(View V) {
        movement(7);
    }

    public void onp8(View V) {
        movement(8);
    }

    public void onp9(View V) {
        movement(9);
    }

    public void onp10(View V) {
        movement(10);
    }

    public void onp11(View V) {
        movement(11);
    }

    public void onp12(View V) {
        movement(12);
    }

    public void onp13(View V) {
        movement(13);
    }

    public void onp14(View V) {
        movement(14);
    }

    public void onp15(View V) {
        movement(15);
    }

    public void onp16(View V) {
        movement(16);
    }

    public void onp17(View V) {
        movement(17);
    }

    public void onp18(View V) {
        movement(18);
    }

    public void onp19(View V) {
        movement(19);
    }

    public void onp20(View V) {
        movement(20);
    }

    public void onp21(View V) {
        movement(21);
    }

    public void onp22(View V) {
        movement(22);
    }

    public void onp23(View V) {
        movement(23);
    }

    public void onp24(View V) {
        movement(24);
    }

    public void onp25(View V) {
        movement(25);
    }

    public void onp26(View V) {
        movement(26);
    }

    public void onp27(View V) {
        movement(27);
    }

    public void onp28(View V) {
        movement(28);
    }

    public void onp29(View V) {
        movement(29);
    }

    public void onp30(View V){
        movement(30);
    }

    public void onp31(View V) {
        movement(31);
    }

    //winning massage
    private void winner() {
        int x = 0;
        for (int i = 0; i < 32; i++) {
            if (players[i] != 0 && players[i] != 5) {
                if (x == 0) x = players[i];
                else if (x % 2 != players[i] % 2) {
                    x = -1;
                    break;
                }
            }
        }
        ////player one wins
        if (x == 1 || x == 3) {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.winning_activity);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            TextView txt = dialog.findViewById(R.id.winner_name);
            txt.setText(player1 + " Won");
            Button btnok = dialog.findViewById(R.id.btnok);
            Button playagain = dialog.findViewById(R.id.play_again);
            dialog.show();
            btnok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selectedName=="Phase2" && selectedId==-1)
                    {
                        Intent intent = new Intent(GameBoard.this, Main_Menu.class);
                        startActivity(intent);
                    }
                    else
                    {
                        dbhandler.deletename(selectedId,selectedName);
                        Intent intent = new Intent(GameBoard.this, Main_Menu.class);
                        startActivity(intent);
                    }
                }
            });
            playagain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selectedName!="Phase2" && selectedId !=-1)
                    {
                        dbhandler.deletename(selectedId,selectedName);
                    }
                    int x = 1;
                    for (int i = 0; i < 32; i++) {
                        if (i > 11 && i < 20) x = 0;
                        else if (i > 12) x = 2;
                        players[i] = x;
                    }
                    setplaces();
                    dialog.dismiss();
                }
            });
        }
        /////player 2 wins
        if (x == 2 || x == 4) {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.winning_activity);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            TextView txt = dialog.findViewById(R.id.winner_name);
            txt.setText(player2 + " Won");
            Button btnok = dialog.findViewById(R.id.btnok);
            Button playagain = dialog.findViewById(R.id.play_again);
            dialog.show();
            btnok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selectedName=="Phase2" && selectedId==-1)
                    {
                        Intent intent = new Intent(GameBoard.this, Main_Menu.class);
                        startActivity(intent);
                    }
                    else
                    {
                        dbhandler.deletename(selectedId,selectedName);
                        Intent intent = new Intent(GameBoard.this, Main_Menu.class);
                        startActivity(intent);
                    }
                }
            });
            playagain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selectedName!="Phase2" && selectedId !=-1)
                    {
                        dbhandler.deletename(selectedId,selectedName);
                    }
                    int x = 1;
                    for (int i = 0; i < 32; i++) {
                        if (i > 11 && i < 20) x = 0;
                        else if (i > 12) x = 2;
                        players[i] = x;
                    }
                    setplaces();
                    dialog.dismiss();
                }
            });
        }
    }

    //moving peaces
    private void movement(int ind) {
        winner();
        int checkrow = currentpos / 4;
        int left = 0, right = 0;
        if (currentplayer == -1) {
            if (players[ind] > 0) {
                if (players[ind] == turn || players[ind] - 2 == turn) {
                    currentplayer = players[ind];
                    currentpos = ind;
                    checkplaces();
                    setplaces();
                }
            }
        }
        else {
            if (players[ind] != 5) {
                currentplayer = -1;
                currentpos = -1;
            }
            else if (players[ind] == 0 || players[ind] == 5) {
                //one block above and below
                if (currentplayer == 1) {
                    if (checkrow % 2 == 0) {
                        left = 3;
                        right = 4;
                    } else {
                        left = 4;
                        right = 5;
                    }
                    if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                        left = 0;
                    }
                    else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                        right = 0;
                    }
                    //player 1 move
                    if (ind - currentpos == left || ind - currentpos == right) {
                        players[currentpos] = 0;
                        players[ind] = currentplayer;
                        setplaces();sound();
                        turn = 3 - turn;
                    }
                    else if ((ind - currentpos == 7)) {
                        if (players[currentpos + left] == 2 || players[currentpos + left] == 4) {
                            if (currentpos + left == 24 || currentpos + left == 16 || currentpos + left == 8 || currentpos + left == 0) {
                            }
                            else {
                                players[currentpos] = players[currentpos + left] = 0;
                                players[currentpos + 7] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    }
                    else if ((ind - currentpos == 9)) {
                        if (players[currentpos + right] == 2 || players[currentpos + right] == 4) {
                            if (currentpos + right == 31 || currentpos + right == 23 || currentpos + right == 15 || currentpos + right == 7) {
                            } else {
                                players[currentpos] = players[currentpos + right] = 0;
                                players[currentpos + 9] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    }
                    currentplayer = currentpos = -1;
                }
                if (currentplayer == 2) {
                    //player 2 move
                    if (checkrow % 2 == 1) {
                        left = 4;
                        right = 3;
                    } else {
                        left = 5;
                        right = 4;
                    }
                    if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                        left = 0;
                    } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                        right = 0;
                    }
                    if (currentpos - ind == left || currentpos - ind == right) {
                        players[currentpos] = 0;
                        players[ind] = currentplayer;
                        setplaces();sound();
                        turn = 3 - turn;
                    } else if (currentpos - ind == 7) {
                        if (players[currentpos - right] == 1 || players[currentpos - right] == 3) {
                            if (currentpos - right == 31 || currentpos - right == 23 || currentpos - right == 15 || currentpos - right == 7) {
                            } else {

                                players[currentpos] = players[currentpos - right] = 0;
                                players[currentpos - 7] = currentplayer;
                                setplaces();
                                sound();
                                turn = 3 - turn;
                            }
                        }
                    } else if (currentpos - ind == 9) {
                        if (players[currentpos - left] == 1 || players[currentpos - left] == 3) {
                            if (currentpos - left == 24 || currentpos - left == 16 || currentpos - left == 8 || currentpos - left == 0) {
                            } else {
                                players[currentpos] = players[currentpos - left] = 0;
                                players[currentpos - 9] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    }
                    currentplayer = currentpos = -1;
                }
                if (currentplayer == 3) {
                    if (checkrow % 2 == 0) {
                        left = 3;
                        right = 4;
                    } else {
                        left = 4;
                        right = 5;
                    }
                    if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                        left = 0;
                    } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                        right = 0;
                    }
                    //player 1 move
                    if (ind - currentpos == left || ind - currentpos == right) {
                        players[currentpos] = 0;
                        players[ind] = currentplayer;
                        sound();
                        setplaces();
                        turn = 3 - turn;
                    } else if ((ind - currentpos == 7)) {
                        if (players[currentpos + left] == 2 || players[currentpos + left] == 4) {
                            if (currentpos + left == 24 || currentpos + left == 16 || currentpos + left == 8 || currentpos + left == 0) {
                            } else {
                                players[currentpos] = players[currentpos + left] = 0;
                                players[currentpos + 7] = currentplayer;
                                setplaces();
                                sound();turn = 3 - turn;
                            }
                        }
                    } else if ((ind - currentpos == 9)) {
                        if (players[currentpos + right] == 2 || players[currentpos + right] == 4) {
                            if (currentpos + right == 31 || currentpos + right == 23 || currentpos + right == 15 || currentpos + right == 7) {
                            } else {
                                players[currentpos] = players[currentpos + right] = 0;
                                players[currentpos + 9] = currentplayer;
                                setplaces();
                                sound();
                                turn = 3 - turn;
                            }
                        }
                    }
                    //player 2 move
                    if (checkrow % 2 == 1) {
                        left = 4;
                        right = 3;
                    } else {
                        left = 5;
                        right = 4;
                    }
                    if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                        left = 0;
                    } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                        right = 0;
                    }
                    if (currentpos - ind == left || currentpos - ind == right) {
                        players[currentpos] = 0;
                        players[ind] = currentplayer;
                        sound();setplaces();
                        turn = 3 - turn;
                    } else if (currentpos - ind == 7) {
                        if (players[currentpos - right] == 2 || players[currentpos - right] == 4) {
                            if (currentpos - right == 31 || currentpos - right == 23 || currentpos - right == 15 || currentpos - right == 7) {
                            } else {
                                players[currentpos] = players[currentpos - right] = 0;
                                players[currentpos - 7] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    } else if (currentpos - ind == 9) {
                        if (players[currentpos - left] == 2 || players[currentpos - left] == 4) {
                            if (currentpos - left == 24 || currentpos - left == 16 || currentpos - left == 8 || currentpos - left == 0) {
                            } else {
                                players[currentpos] = players[currentpos - left] = 0;
                                players[currentpos - 9] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    }
                    currentplayer = currentpos = -1;
                }
                if (currentplayer == 4) {
                    if (checkrow % 2 == 0) {
                        left = 3;
                        right = 4;
                    } else {
                        left = 4;
                        right = 5;
                    }
                    if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                        left = 0;
                    } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                        right = 0;
                    }
                    //player 1 move
                    if (ind - currentpos == left || ind - currentpos == right) {
                        players[currentpos] = 0;
                        players[ind] = currentplayer;
                        setplaces();sound();
                        turn = 3 - turn;
                    } else if ((ind - currentpos == 7)) {
                        if (players[currentpos + left] == 1 || players[currentpos + left] == 3) {
                            if (currentpos + left == 24 || currentpos + left == 16 || currentpos + left == 8 || currentpos + left == 0) {
                            } else {
                                players[currentpos] = players[currentpos + left] = 0;
                                players[currentpos + 7] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    } else if ((ind - currentpos == 9)) {
                        if (players[currentpos + right] == 1 || players[currentpos + right] == 3) {
                            if (currentpos + right == 31 || currentpos + right == 23 || currentpos + right == 15 || currentpos + right == 7) {
                            } else {
                                players[currentpos] = players[currentpos + right] = 0;
                                players[currentpos + 9] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    }
                    //player 2 move
                    if (checkrow % 2 == 1) {
                        left = 4;
                        right = 3;
                    } else {
                        left = 5;
                        right = 4;
                    }
                    if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                        left = 0;
                    } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                        right = 0;
                    }
                    if (currentpos - ind == left || currentpos - ind == right) {
                        players[currentpos] = 0;
                        players[ind] = currentplayer;
                        setplaces();sound();
                        turn = 3 - turn;
                    } else if (currentpos - ind == 7) {
                        if (players[currentpos - right] == 1 || players[currentpos - right] == 3) {
                            if (currentpos - right == 31 || currentpos - right == 23 || currentpos - right == 15 || currentpos - right == 7) {
                            } else {
                                players[currentpos] = players[currentpos - right] = 0;
                                players[currentpos - 7] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    } else if (currentpos - ind == 9) {
                        if (players[currentpos - left] == 1 || players[currentpos - left] == 3) {
                            if (currentpos - left == 24 || currentpos - left == 16 || currentpos - left == 8 || currentpos - left == 0) {
                            } else {
                                players[currentpos] = players[currentpos - left] = 0;
                                players[currentpos - 9] = currentplayer;
                                setplaces();sound();
                                turn = 3 - turn;
                            }
                        }
                    }
                    currentplayer = currentpos = -1;
                }
            }
            removedots();
            setplaces();
        }
        makeking();
        setplaces();
        if (turn == 1) playersname.setText(player1);
        else playersname.setText(player2);
        winner();
    }

    //remove dots
    private void removedots() {
        for (int i = 0; i < 32; i++) {
            if (players[i] == 5) players[i] = 0;
        }
    }

    //check places
    private void checkplaces() {
        int checkrow = currentpos / 4;
        int left = 0, right = 0;
        for (int ind = 0; ind < 32; ind++) {
            if (currentplayer == 1) {
                if (checkrow % 2 == 0) {
                    left = 3;
                    right = 4;
                } else {
                    left = 4;
                    right = 5;
                }
                if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                    left = 0;
                } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                    right = 0;
                }
                //player 1 check
                if (players[ind] == 0) {
                    if (ind - currentpos == left || ind - currentpos == right) {
                        players[ind] = 5;
                    } else if ((ind - currentpos == 7) && ((players[currentpos + left] == 2) || (players[currentpos + left] == 4))) {
                        if (currentpos + left == 24 || currentpos + left == 16 || currentpos + left == 8 || currentpos + left == 0) {
                        } else {
                            players[currentpos + 7] = 5;
                        }
                    } else if ((ind - currentpos == 9) && ((players[currentpos + right] == 2) || (players[currentpos + right] == 4))) {
                        if (currentpos + right == 31 || currentpos + right == 23 || currentpos + right == 15 || currentpos + right == 7) {
                        } else {
                            players[currentpos + 9] = 5;
                        }
                    }
                }
            }
            if (currentplayer == 2) {
                //player 2 check
                if (checkrow % 2 == 1) {
                    left = 4;
                    right = 3;
                } else {
                    left = 5;
                    right = 4;
                }
                if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                    left = 0;
                } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                    right = 0;
                }
                if (players[ind] == 0) {
                    if (currentpos - ind == left || currentpos - ind == right) {
                        players[ind] = 5;
                    } else if (currentpos - ind == 7) {
                        if (players[currentpos - right] == 1 || players[currentpos - right] == 3) {
                            if (currentpos - right == 31 || currentpos - right == 23 || currentpos - right == 15 || currentpos - right == 7) {
                            } else {
                                players[currentpos - 7] = 5;
                            }
                        }
                    } else if (currentpos - ind == 9) {
                        if (players[currentpos - left] == 1 || players[currentpos - left] == 3) {
                            if (currentpos - left == 24 || currentpos - left == 16 || currentpos - left == 8 || currentpos - left == 0) {
                            } else {
                                players[currentpos - 9] = 5;
                            }
                        }
                    }
                }
            }
            if (currentplayer == 3) {
                //player 1 move
                if (checkrow % 2 == 0) {
                    left = 3;
                    right = 4;
                } else {
                    left = 4;
                    right = 5;
                }
                if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                    left = 0;
                } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                    right = 0;
                }
                if (players[ind] == 0) {
                    if (ind - currentpos == left || ind - currentpos == right) {
                        players[ind] = 5;
                    } else if ((ind - currentpos == 7)) {
                        if (players[currentpos + left] == 2 || players[currentpos + left] == 4) {
                            if (currentpos + left == 24 || currentpos + left == 16 || currentpos + left == 8 || currentpos + left == 0) {
                            } else {
                                players[currentpos + 7] = 5;
                            }
                        }
                    } else if ((ind - currentpos == 9)) {
                        if (players[currentpos + right] == 2 || players[currentpos + right] == 4) {
                            if (currentpos + right == 31 || currentpos + right == 23 || currentpos + right == 15 || currentpos + right == 7) {
                            } else {
                                players[currentpos + 9] = 5;
                            }
                        }
                    }
                }
                //player 2 move
                if (checkrow % 2 == 1) {
                    left = 4;
                    right = 3;
                } else {
                    left = 5;
                    right = 4;
                }
                if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                    left = 0;
                } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                    right = 0;
                }
                if (players[ind] == 0) {
                    if (currentpos - ind == left || currentpos - ind == right) {
                        players[ind] = 5;
                    } else if (currentpos - ind == 7) {
                        if (players[currentpos - right] == 2 || players[currentpos - right] == 4) {
                            if (currentpos - right == 31 || currentpos - right == 23 || currentpos - right == 15 || currentpos - right == 7) {
                            } else {
                                players[currentpos - 7] = 5;
                            }
                        }
                    } else if (currentpos - ind == 9) {
                        if (players[currentpos - left] == 2 || players[currentpos - left] == 4) {
                            if (currentpos - left == 24 || currentpos - left == 16 || currentpos - left == 8 || currentpos - left == 0) {
                            } else {
                                players[currentpos - 9] = 5;
                            }
                        }
                    }
                }
            }
            if (currentplayer == 4) {
                //player 1 move
                if (checkrow % 2 == 0) {
                    left = 3;
                    right = 4;
                } else {
                    left = 4;
                    right = 5;
                }
                if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                    left = 0;
                } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                    right = 0;
                }
                if (players[ind] == 0) {
                    if (ind - currentpos == left || ind - currentpos == right) {
                        players[ind] = 5;
                    } else if ((ind - currentpos == 7)) {
                        if (players[currentpos + left] == 1 || players[currentpos + left] == 3) {
                            if (currentpos + left == 24 || currentpos + left == 16 || currentpos + left == 8 || currentpos + left == 0) {
                            } else {
                                players[currentpos + 7] = 5;
                            }
                        }
                    } else if ((ind - currentpos == 9)) {
                        if (players[currentpos + right] == 1 || players[currentpos + right] == 3) {
                            if (currentpos + right == 31 || currentpos + right == 23 || currentpos + right == 15 || currentpos + right == 7) {
                            } else {
                                players[currentpos + 9] = 5;
                            }
                        }
                    }
                }
                //player 2 move
                if (checkrow % 2 == 1) {
                    left = 4;
                    right = 3;
                } else {
                    left = 5;
                    right = 4;
                }
                if (currentpos == 24 || currentpos == 16 || currentpos == 8 || currentpos == 0) {
                    left = 0;
                } else if (currentpos == 7 || currentpos == 15 || currentpos == 23 || currentpos == 31) {
                    right = 0;
                }
                if (players[ind] == 0) {
                    if (currentpos - ind == left || currentpos - ind == right) {
                        players[ind] = 5;
                    } else if (currentpos - ind == 7) {
                        if (players[currentpos - right] == 1 || players[currentpos - right] == 3) {
                            if (currentpos - right == 31 || currentpos - right == 23 || currentpos - right == 15 || currentpos - right == 7) {
                            } else {
                                players[currentpos - 7] = 5;
                            }
                        }
                    } else if (currentpos - ind == 9) {
                        if (players[currentpos - left] == 1 || players[currentpos - left] == 3) {
                            if (currentpos - left == 24 || currentpos - left == 16 || currentpos - left == 8 || currentpos - left == 0) {
                            } else {
                                players[currentpos - 9] = 5;
                            }
                        }
                    }
                }
            }
        }
    }

    //make king
    private void makeking() {
        for (int i = 0; i < 4; i++) {
            if (players[i] == 2) players[i] = 4;
        }
        for (int i = 28; i < 32; i++) {
            if (players[i] == 1) players[i] = 3;
        }
    }

}