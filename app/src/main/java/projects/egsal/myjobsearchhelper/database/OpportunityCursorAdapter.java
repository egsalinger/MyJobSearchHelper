package projects.egsal.myjobsearchhelper.database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import projects.egsal.myjobsearchhelper.R;

/**
 * Created by egsal on 8/17/15.
 */
public class OpportunityCursorAdapter extends CursorAdapter {

    public OpportunityCursorAdapter(Context context, Cursor cursor, int flags)
    {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_info_item, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView nameView = (TextView) view.findViewById(R.id.itemTitle);
        TextView statusView = (TextView) view.findViewById(R.id.itemStatus);
        // Extract properties from cursor
        String name ="";
        String status = "";
        try
        {
            name = cursor.getString(cursor.getColumnIndexOrThrow("Name"));
        }
        catch (IllegalArgumentException e)
        {
            name = context.getString( R.string.error_opportunity_name);
        }
        try
        {
            status = cursor.getString(cursor.getColumnIndexOrThrow("Status"));
        }
        catch (IllegalArgumentException e)
        {
            status = context.getString(R.string.error_opportunity_status);
        }
        // Populate fields with extracted properties
        statusView.setText(status);
        nameView.setText(name);
    }
}
