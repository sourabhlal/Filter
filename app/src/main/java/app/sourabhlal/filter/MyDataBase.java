package app.sourabhlal.filter;

import android.content.Context;

import com.yahoo.squidb.data.SquidDatabase;
import com.yahoo.squidb.data.adapter.SQLiteDatabaseWrapper;
import com.yahoo.squidb.sql.Table;

/**
 * Created by elkhamlichisofia on 21/02/16.
 */
// This is how you'd set up a database instance
public class MyDataBase extends SquidDatabase {

    private static final int VERSION = 1;

    public MyDataBase(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "my-database.db";
    }

    @Override
    protected Table[] getTables() {
        return new Table[]{
                // List all tables here
                Contact.TABLE,
                Label.TABLE
        };
    }

    @Override
    protected boolean onUpgrade(SQLiteDatabaseWrapper db, int oldVersion, int newVersion) {
        return false;
    }

    @Override
    protected int getVersion() {
        return VERSION;
    }

    // Other overridable methods exist for migrations and initialization;
    // omitted for brevity
}
