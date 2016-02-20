import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sourabhlal on 2/20/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String Table_Contacts="Accounts";
    public static final String col_ID="_id";
    public static final String col_Name="Name";
    public static final String col_PhoneNumber="Number";
    public static final String col_Email="Email";
    public static final String col_Picture="Picture";
    public static final String col_Address="Address";
    public static final String col_Website="Website";

    public static final String Table_Labels="Accounts";
    public static final String col_labID="_id";
    public static final String col_labName="Name";

    public static final String Table_M2M="manyToMany";
    public static final String col_m2mID="_id";
    public static final String col_contactID="contactId";
    public static final String col_labelID="labelId";

    private static final String DATABASE_NAME = "filtercon.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String TABLE_CREATE1 = "create table "
            + Table_Contacts + "("
            + col_ID + " integer primary key autoincrement, "
            + col_Name + " text not null, "
            + col_PhoneNumber + " text, "
            + col_Email + " text, "
            + col_Picture + " text, "
            + col_Address + " text, "
            + col_Website + " text);";

    private static final String TABLE_CREATE2 = "create table "
            + Table_Labels + "("
            + col_labID + " integer primary key autoincrement, "
            + col_labName + " text not null);";

    private static final String TABLE_CREATE3 = "create table "
            + Table_M2M + "("
            + col_m2mID + " integer primary key autoincrement, "
            + col_labelID + " integer not null, "
            + col_contactID + " integer not null), "
            + "FOREIGN KEY("+col_labelID+") REFERENCES "+Table_Labels+"("+col_labID+");"
            + "FOREIGN KEY("+col_contactID+") REFERENCES "+Table_Contacts+"("+col_ID+"));";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(TABLE_CREATE1);
        database.execSQL(TABLE_CREATE2);
        database.execSQL(TABLE_CREATE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + Table_Contacts);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Labels);
        db.execSQL("DROP TABLE IF EXISTS " + Table_M2M);
        onCreate(db);
    }
}