package fr.unice.polytech.polynews.association;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.polynews.BuildConfig;

public class AssoDBHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/" + BuildConfig.APPLICATION_ID + "/";
    private static String DB_NAME = "data_assoc";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public AssoDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (!dbExist) {
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            //database doesn't exist yet.
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException {
        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List<Assos> getAssoList() {
        List<Assos> assoList = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM assoc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Assos asso = new Assos();

            asso.setId(cursor.getInt(cursor.getColumnIndex("id")));
            asso.setName(cursor.getString(cursor.getColumnIndex("name")));
            asso.setDescription(cursor.getString(cursor.getColumnIndex("description")));
            asso.setImage(cursor.getString(cursor.getColumnIndex("image")));
            assoList.add(asso);
            cursor.moveToNext();
        }
        cursor.close();
        myDataBase.close();
        return assoList;
    }
}