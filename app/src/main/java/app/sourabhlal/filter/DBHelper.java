package app.sourabhlal.filter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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
            // + col_Picture + " BLOB, "
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
            + "FOREIGN KEY("+col_labelID+") REFERENCES "+Table_Labels+"("+col_labID+"),"
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


    //CRUD Operations: Create, Read, Update, Delete

    // CREATE
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues v = new ContentValues();
        v.put(col_Name, contact.getName());
        v.put(col_PhoneNumber, contact.getNumber());
        v.put(col_Email, contact.getEmail());
        v.put(col_Address, contact.getAddress());
        v.put(col_Website, contact.getWebsite());

        db.insert(Table_Contacts, null, v);
        db.close();
    }


    public void addLabel(Label label) {
        // TODO: 2/20/2016 Louis/Sofia
    }

    // READ(ALL)
    public Contact getContact(int id) {
        // TODO: 2/20/2016 Louis/Sofia
    }

    public Label getLabel(int id) {
        // TODO: 2/20/2016 Louis/Sofia
    }

    public List<Contact> getAllContacts() {
        // TODO: 2/20/2016 Louis/Sofia
    }

    public List<Label> getAllLabels() {
        // TODO: 2/20/2016 Louis/Sofia
    }

    public List<Contact> getContactsByLabel(Label label) {
        // TODO: 2/20/2016 Sourabh
        List<Contact> matchingContacts = new ArrayList<Contact>();
        return matchingContacts;
    }

    public List<Label> getLabelsByContact(Contact contact) {
        // TODO: 2/20/2016 Sourabh
        List<Label> matchingLabels = new ArrayList<Label>();
        return matchingLabels;
    }

    // COUNT
    public int getContactsCount() {
        String Query = "SELECT  * FROM " + Table_Contacts;
        Cursor c = this.getReadableDatabase().rawQuery(Query, null);
        c.close();
        int count = c.getCount();
        return count;
    }

    public int getLabelsCount() {
        // TODO: 2/20/2016 Louis/Sofia
    }

    //UPDATE
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues v = new ContentValues();
        v.put(col_Name, contact.getName());
        v.put(col_PhoneNumber, contact.getNumber());
        v.put(col_Email, contact.getEmail());
        v.put(col_Address, contact.getAddress());
        v.put(col_Website, contact.getWebsite());
        //values.put(col_Picture, contact.getName());
        return db.update(Table_Contacts, v, col_ID + " = ?", new String[] { String.valueOf(contact.getId()) });
    }

    //DELETE
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_Contacts, col_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }

    public void removeLabelFromContact(Contact contact, Label label) {
        // TODO: 2/20/2016 Sourabh
    }
}