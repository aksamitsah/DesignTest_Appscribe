package me.aksamitsah.trivia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import me.aksamitsah.trivia.model.Score;

public class DBHandler extends SQLiteOpenHelper {


    private static final String DB_NAME = "scoreHistory";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "score";

    private static final String ID_COL = "id";
    private static final String PLAYER_NAME = "playerName";
    private static final String ANS_ONE = "ansOne";
    private static final String ANS_TWO = "ansTwo";
    private static final String DATE_TIME = "dateTime";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PLAYER_NAME + " TEXT,"
                + ANS_ONE + " TEXT,"
                + ANS_TWO + " TEXT,"
                + DATE_TIME + " TEXT )";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addScoreData(String playerName, String ansOne, String ansTwo, String dateTime) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PLAYER_NAME, playerName);
        values.put(ANS_ONE, ansOne);
        values.put(ANS_TWO, ansTwo);
        values.put(DATE_TIME, dateTime);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public ArrayList<Score> readCourses() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorScore = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Score> courseModalArrayList = new ArrayList<>();

        if (cursorScore.moveToFirst()) {
            do {

                courseModalArrayList.add(new Score(cursorScore.getString(0), cursorScore.getString(1),
                        cursorScore.getString(2),
                        cursorScore.getString(3),
                        cursorScore.getString(4)


                ));

            } while (cursorScore.moveToNext());
        }
        cursorScore.close();
        return courseModalArrayList;
    }


}

