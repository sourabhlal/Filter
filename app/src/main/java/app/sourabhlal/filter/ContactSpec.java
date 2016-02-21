package app.sourabhlal.filter;

import com.yahoo.squidb.annotations.ColumnSpec;
import com.yahoo.squidb.annotations.TableModelSpec;
import com.yahoo.squidb.data.TableModel;

/**
 * Created by jpbreuer on 2/21/16.
 */

// This is a table schema
@TableModelSpec(className = "Contact", tableName = "contact")

public class ContactSpec  {

    public String Name;
    public String Number;
    public String Email;
    public String Address;
    public String Website;
}
