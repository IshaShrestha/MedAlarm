package remainder.com.remainder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import remainder.com.remainder.database.database;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="vaccine.db";
    public static final String TABLE_NAME = "vaccination";
    public static final String COL1 = "vaccination name",COL2 = "month";
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "ITEM1 TEXT)";
        sqLiteDatabase.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXITS" + TABLE_NAME);

    }
    public boolean addData(String name,String month){
        SQLiteDatabase db  =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("vaccination name",name);
        contentValues.put("month",month);
        mDatabase.insert("vaccination",null,contentValues);

        long result = db.insert(TABLE_NAME,null, contentValues);

        if (result == -1){
            return false;

        }
        else {
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db  =  this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "  + TABLE_NAME,null);
        return data;
    }
}
