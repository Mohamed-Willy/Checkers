package com.example.checkers;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class LoadGame_Activity extends AppCompatActivity {

    public Themes themes=new Themes();

    ListView loadtext;
    DataBasehandler dbhandler;
    private static final String TAG = "ListDataActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_load_game);
        loadtext = (ListView) findViewById(R.id.listview);
        dbhandler = new DataBasehandler(this);
        printGamename();

    }

    public void printGamename() {
        //EditText edittext = findViewById(R.id.temp);;
        Log.d(TAG, "populateListView: Displaying data in the ListView.");
        ArrayList<String> listdata = dbhandler.GET_GameName();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listdata);
        loadtext.setAdapter(adapter);

        loadtext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = loadtext.getItemAtPosition(i).toString();

                Log.d(TAG, "onItemclicked: You Clicked on " + name);
                GameBoard.players = dbhandler.GET_Pieces_Data(name);
                GameBoard.arr = dbhandler.GET_game_colors(name);
                GameBoard.player1=dbhandler.GET_player1name(name);
                GameBoard.player2=dbhandler.GET_player2name(name);
                int itemID = dbhandler.GET_itemid(name);
                Intent ii = new Intent(LoadGame_Activity.this,GameBoard.class);
                ii.putExtra("Name",name);
                ii.putExtra("Id",itemID);
                startActivity(ii);

            }
        });
        Dialog dialog = new Dialog(this);
        loadtext.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=adapterView.getItemAtPosition(i).toString();
                int itemID = dbhandler.GET_itemid(name);

                dialog.setContentView(R.layout.activity_edit_delete);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                EditText txt = dialog.findViewById(R.id.editTextTextPersonName2);
                txt.setText(name);
                Button editbtn = dialog.findViewById(R.id.button8);
                Button deletebtn = dialog.findViewById(R.id.button9);
                dialog.show();

                editbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String item = txt.getText().toString();
                        if (!item.equals("")) {
                            dbhandler.updateName(item, itemID, name);
                            dialog.dismiss();
                            Intent intent = new Intent(LoadGame_Activity.this,Main_Menu.class);
                            startActivity(intent);
                        }
                        else
                            toastmessage("You must enter a name");
                    }
                });
                deletebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dbhandler.deletename(itemID,name);
                        txt.setText("");
                        dialog.dismiss();
                        Intent intent = new Intent(LoadGame_Activity.this,Main_Menu.class);
                        startActivity(intent);
                    }
                });

                return true;
            }
        });
    }

    public void toastmessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}

