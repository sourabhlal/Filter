package app.sourabhlal.filter;

import android.content.ContentValues;
import com.yahoo.squidb.data.AbstractModel;
import com.yahoo.squidb.data.SquidCursor;
import com.yahoo.squidb.data.TableModel;
import com.yahoo.squidb.sql.Property;
import com.yahoo.squidb.sql.Property.LongProperty;
import com.yahoo.squidb.sql.Property.StringProperty;
import com.yahoo.squidb.sql.Table;

// Generated code -- do not modify!
// This class was generated from the model spec at app.sourabhlal.filter.ContactSpec
public class Contact extends TableModel {

    // --- constants

    // --- allocate properties array
    public static final Property<?>[] PROPERTIES = new Property<?>[6];

    // --- table declaration
    public static final Table TABLE = new Table(Contact.class, PROPERTIES, "contact", null);

    // --- property declarations
    public static final LongProperty ID = new LongProperty(TABLE, TableModel.DEFAULT_ID_COLUMN, "PRIMARY KEY AUTOINCREMENT");
    static {
        TABLE.setIdProperty(ID);
    };

    public static final StringProperty NAME = new StringProperty(TABLE, "Name");

    public static final StringProperty NUMBER = new StringProperty(TABLE, "Number");

    public static final StringProperty EMAIL = new StringProperty(TABLE, "Email");

    public static final StringProperty ADDRESS = new StringProperty(TABLE, "Address");

    public static final StringProperty WEBSITE = new StringProperty(TABLE, "Website");

    @Override
    public LongProperty getIdProperty() {
        return ID;
    }

    static {
        PROPERTIES[0] = ID;
        PROPERTIES[1] = NAME;
        PROPERTIES[2] = NUMBER;
        PROPERTIES[3] = EMAIL;
        PROPERTIES[4] = ADDRESS;
        PROPERTIES[5] = WEBSITE;
    }

    // --- default values
    protected static final ContentValues defaultValues = new ContentValues();
    static {
        // --- put property defaults
    }

    @Override
    public ContentValues getDefaultValues() {
        return defaultValues;
    }

    // --- default constructors
    public Contact() {
        super();
    }

    public Contact(SquidCursor<Contact> cursor) {
        this();
        readPropertiesFromCursor(cursor);
    }

    public Contact(ContentValues contentValues) {
        this(contentValues, PROPERTIES);
    }

    public Contact(ContentValues contentValues, Property<?>... withProperties) {
        this();
        readPropertiesFromContentValues(contentValues, withProperties);
    }

    @Override
    public Contact clone() {
        return (Contact) super.clone();
    }

    // --- getters and setters
    public String getName() {
        return get(NAME);
    }

    public Contact setName(String Name) {
        set(NAME, Name);
        return this;
    }

    public String getNumber() {
        return get(NUMBER);
    }

    public Contact setNumber(String Number) {
        set(NUMBER, Number);
        return this;
    }

    public String getEmail() {
        return get(EMAIL);
    }

    public Contact setEmail(String Email) {
        set(EMAIL, Email);
        return this;
    }

    public String getAddress() {
        return get(ADDRESS);
    }

    public Contact setAddress(String Address) {
        set(ADDRESS, Address);
        return this;
    }

    public String getWebsite() {
        return get(WEBSITE);
    }

    public Contact setWebsite(String Website) {
        set(WEBSITE, Website);
        return this;
    }

    @Override
    public Contact setId(long id) {
        super.setId(id);
        return this;
    }

    // --- parcelable helpers
    public static final Creator<Contact> CREATOR = new ModelCreator<Contact>(Contact.class);

    @Override
    protected Creator<? extends AbstractModel> getCreator() {
        return CREATOR;
    }

}
