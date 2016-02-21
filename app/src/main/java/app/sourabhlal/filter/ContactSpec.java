package app.sourabhlal.filter;

import com.yahoo.squidb.annotations.ColumnSpec;
import com.yahoo.squidb.annotations.TableModelSpec;

/**
 * Created by jpbreuer on 2/21/16.
 */

// This is a table schema
@TableModelSpec(className = "Contact", tableName = "Contacts")

public class ContactSpec {

    public String Name;
    public String Number;
    public String Email;

    @ColumnSpec(name = "Address")
    public long Address;
    public String Website;
}

