package com.example.checkers;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.content.Intent;

public class Edit_Delete_Activity extends AppCompatActivity {
    private static final String TAG = "EditDataActivity";

    private Button editbutton,continuebutton,deletebutton;
    private EditText gamenametext;

    DataBasehandler dbhandler;

    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);
        editbutton=(Button) findViewById(R.id.button8);
        continuebutton=(Button) findViewById(R.id.button2);
        deletebutton=(Button) findViewById(R.id.button9);
        gamenametext=(EditText)findViewById(R.id.editTextTextPersonName2);
        dbhandler = new DataBasehandler(this);

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id",-1);
        selectedName = receivedIntent.getStringExtra("name");
        gamenametext.setText(selectedName);

        editbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String item = gamenametext.getText().toString();
                if (!item.equals("")) {
                    dbhandler.updateName(item, selectedID, selectedName);
                    Intent intent = new Intent(Edit_Delete_Activity.this,Main_Menu.class);
                    startActivity(intent);
                }
                else
                toastmessage("You must enter a name");

            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhandler.deletename(selectedID,selectedName);
                gamenametext.setText("");
                toastmessage("removed from database");
                Intent intent = new Intent(Edit_Delete_Activity.this,Main_Menu.class);
                startActivity(intent);

            }
        });
        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii = new Intent(Edit_Delete_Activity.this,GameBoard.class);
                startActivity(ii);
            }
        });


        }


        public void toastmessage (String message)
        {
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }
}