package com.example.checkers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataBasehandler extends SQLiteOpenHelper {

    private static final String TAG="DatabaseHelper";
    private static final String TABLE_Data = "Data.db"; ///// NAME OF DATABASE SHEET /////
    private static final String TABLE_NAME = "Data"; ///// NAME OF DATABASE TABLE /////
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_GAMENAME = "game_name";
    private static final String COLUMN_ARR1="arr1";
    private static final String COLUMN_ARR2="arr2";
    private static final String COLUMN_PLAYER1="player1";
    private static final String COLUMN_PLAYER2="player2";




    public DataBasehandler(Context context) {
        super(context, TABLE_Data, null,1);
    }

    //// ******* CONSTRUCTOR FOR CUSTOM_DIALOG ******///////

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = " CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                COLUMN_GAMENAME + " TEXT, " + COLUMN_ARR1 + " TEXT, " + COLUMN_ARR2 + " TEXT, " +
                COLUMN_PLAYER1 + " TEXT, " +COLUMN_PLAYER2 + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean ADD_GameName(String game_name, int[] pieces_data,int [] game_colors,String p1 , String p2)
    {
        String string_array1 = "";
        for (int i : pieces_data)
            string_array1 = string_array1 + Integer.toString(i) + ",";

        String string_array2 = "";
        for (int i : game_colors)
            string_array2 = string_array2 + Integer.toString(i) + ",";

        Log.d(TAG,"addData: Adding "+game_name+" to "+ TABLE_Data);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_GAMENAME, game_name);
        values.put(COLUMN_ARR1,string_array1);
        values.put(COLUMN_ARR2,string_array2);
        values.put(COLUMN_PLAYER1,p1);
        values.put(COLUMN_PLAYER2,p2);

        long result = sqLiteDatabase.insert(TABLE_NAME,null,values);
       if(result ==-1)
           return false;
       else
           return true;
    }

    public ArrayList<String> GET_GameName()
    {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query ="SELECT * FROM "+ TABLE_NAME;
        Cursor data = sqLiteDatabase.rawQuery(query,null);
        if (data.moveToFirst()){
            do {
                list.add(data.getString(1));
            } while(data.moveToNext());
        }
        data.close();
        sqLiteDatabase.close();
        return list;
    }
    public String GET_player1name(String name)
    {
        String s = "";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE " + COLUMN_GAMENAME + " =?";
        Cursor data = sqLiteDatabase.rawQuery(query, new String[] {name});
        if (data.moveToFirst()){
            do {
                s=data.getString(4);
            } while(data.moveToNext());
        }
        data.close();
        sqLiteDatabase.close();
        return s;
    }
    public String GET_player2name(String name)
    {
        String s = "";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE " + COLUMN_GAMENAME + " =?";
        Cursor data = sqLiteDatabase.rawQuery(query, new String[] {name});
        if (data.moveToFirst()){
            do {
                s=data.getString(5);
            } while(data.moveToNext());
        }
        data.close();
        sqLiteDatabase.close();
        return s;
    }

    public int[] GET_Pieces_Data(String name)
    {
        int[] pieces_array = new int[32];
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE " + COLUMN_GAMENAME + " =?";
        Cursor data = sqLiteDatabase.rawQuery(query, new String[] {name});
        String temp = "";
        if (data.moveToFirst()) {
            do{
                temp = data.getString(2);
            } while (data.moveToNext());
        }
        String[] arr = temp.split(",");
        for (int v = 0; v < 32; v++) {
                pieces_array[v] = Integer.parseInt(arr[v]);
        }
        data.close();
        sqLiteDatabase.close();
        return pieces_array;
    }
    public int[] GET_game_colors(String name)
    {
        int[] game_colors = new int[4];
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE " + COLUMN_GAMENAME + " =?";
        Cursor data = sqLiteDatabase.rawQuery(query, new String[] {name});
        String temp = "";
        if (data.moveToFirst()) {
            do{
                temp = data.getString(3);
            } while (data.moveToNext());
        }
        String[] arr = temp.split(",");
        for (int v = 0; v < 4; v++) {
            game_colors[v] = Integer.parseInt(arr[v]);
        }
        data.close();
        sqLiteDatabase.close();
        return game_colors;
    }

    public int GET_itemid(String name)
    {

        SQLiteDatabase sqLiteDatabase =getWritableDatabase();
        String query ="SELECT "+COLUMN_ID+" FROM "+TABLE_NAME+ " WHERE " +COLUMN_GAMENAME+ " =?" ;
        Cursor data = sqLiteDatabase.rawQuery(query, new String[] {name});
        int itemID = -1;
        while(data.moveToNext()){
            itemID = data.getInt(0);
        }
        data.close();
        sqLiteDatabase.close();
        return itemID;
    }
   public boolean search (String name)
   {

       return true;
   }
    public void updateName(String newname, int id, String oldname) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_GAMENAME +
                " = '" + newname + "' WHERE " + COLUMN_ID + " = '" + id + "'" +
                " AND " + COLUMN_GAMENAME + " = '" + oldname + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newname);
        sqLiteDatabase.execSQL(query);
    }

    public void deletename (int id, String gamename)
    {
        SQLiteDatabase sqLiteDatabase =getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COLUMN_ID + " = '" + id + "'" +
                " AND " + COLUMN_GAMENAME + " = '" + gamename + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + gamename + " from database.");
        sqLiteDatabase.execSQL(query);

    }


}























