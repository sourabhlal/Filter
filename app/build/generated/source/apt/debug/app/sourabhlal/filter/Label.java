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
// This class was generated from the model spec at app.sourabhlal.filter.LabelSpec
public class Label extends TableModel {

    // --- constants

    // --- allocate properties array
    public static final Property<?>[] PROPERTIES = new Property<?>[2];

    // --- table declaration
    public static final Table TABLE = new Table(Label.class, PROPERTIES, "Labels", null);

    // --- property declarations
    public static final LongProperty ID = new LongProperty(TABLE, TableModel.DEFAULT_ID_COLUMN, "PRIMARY KEY AUTOINCREMENT");
    static {
        TABLE.setIdProperty(ID);
    };

    public static final StringProperty LABELS = new StringProperty(TABLE, "Labels");

    @Override
    public LongProperty getIdProperty() {
        return ID;
    }

    static {
        PROPERTIES[0] = ID;
        PROPERTIES[1] = LABELS;
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
    public Label() {
        super();
    }

    public Label(SquidCursor<Label> cursor) {
        this();
        readPropertiesFromCursor(cursor);
    }

    public Label(ContentValues contentValues) {
        this(contentValues, PROPERTIES);
    }

    public Label(ContentValues contentValues, Property<?>... withProperties) {
        this();
        readPropertiesFromContentValues(contentValues, withProperties);
    }

    @Override
    public Label clone() {
        return (Label) super.clone();
    }

    // --- getters and setters
    public String getLabels() {
        return get(LABELS);
    }

    public Label setLabels(String Labels) {
        set(LABELS, Labels);
        return this;
    }

    @Override
    public Label setId(long id) {
        super.setId(id);
        return this;
    }

    // --- parcelable helpers
    public static final Creator<Label> CREATOR = new ModelCreator<Label>(Label.class);

    @Override
    protected Creator<? extends AbstractModel> getCreator() {
        return CREATOR;
    }

}
