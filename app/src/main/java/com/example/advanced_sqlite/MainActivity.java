package com.example.advanced_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");

//            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
//            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Pawan', 21)");
//            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Unknown', 21)");

//            sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Cap', 200)");
//            sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Iron Man', 3000)");
//            sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Thor', 1000)");

            sqLiteDatabase.execSQL("DELETE FROM newUsers WHERE id = 2");
//
//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name = 'Pawan'", null);
//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name = 'Pawan' AND age > 18 " , null);
//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'P%'", null);
//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%'", null);
//            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'P%' LIMIT 1", null);

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM newUsers ", null);

            int nameUser = c.getColumnIndex("name");
            int ageUser = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while(!c.isAfterLast()){
                Log.i("Results - Name : ", c.getString(nameUser));
                Log.i("Results - Age : ", c.getString(ageUser));
                Log.i("Results - id :", c.getString(idIndex));

                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}