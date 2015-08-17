package projects.egsal.myjobsearchhelper.database;

import android.database.Cursor;

import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by egsal on 8/17/15.
 */

@Table(name = "Opportunities")
public class Opportunity extends Model {
    // Unique Opportunity ID.
    @Column(name = "remote_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public long oppId;

    // Name
    @Column (name = "Name")
    public String name;

    @Column (name = "Status")
    public String status;

    @Column (name = "Notes")
    public String notes;

    @Column (name = "Location")
    public String location;

    public Opportunity (int oppId, String name, String status, String notes, String location)
    {
        super();
        this.oppId = oppId;
        this.name = name;
        this.status = status;
        this.notes = notes;
        this.location = location;
    }
    public Opportunity()
    {
        super();
    }

    public static Cursor fetchOpportunities() {
        String tableName = Cache.getTableInfo(Opportunity.class).getTableName();
        // Query all items without any conditions
        String resultRecords = new Select(tableName + ".*, " + tableName + ".Id as _id").
                from(Opportunity.class).toSql();
        // Execute query on the underlying ActiveAndroid SQLite database
        Cursor resultCursor = Cache.openDatabase().rawQuery(resultRecords, null);
        return resultCursor;
    }

}
