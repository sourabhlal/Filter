package app.sourabhlal.filter;
import com.yahoo.squidb.annotations.TableModelSpec;

/**
 * Created by sourabhlal on 2/21/2016.
 */

import com.yahoo.squidb.annotations.ColumnSpec;
import com.yahoo.squidb.annotations.TableModelSpec;
import com.yahoo.squidb.data.TableModel;

// This is a table schema
@TableModelSpec(className = "Link", tableName = "link")

public class LinkSpec  {

    public int contact;
    public int label;
}
