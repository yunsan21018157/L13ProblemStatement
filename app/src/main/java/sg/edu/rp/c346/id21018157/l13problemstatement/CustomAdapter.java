package sg.edu.rp.c346.id21018157.l13problemstatement;

import android.content.Context;
import android.widget.ArrayAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Enrolment> enrolmentList;

    public CustomAdapter(Context context, int resource, ArrayList<Enrolment> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        enrolmentList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitleEnrolment = rowView.findViewById(R.id.tvTitleEnrolment);
        TextView tvEnrolmentInput = rowView.findViewById(R.id.tvEnrolmentInput);
        TextView tvTitleYear = rowView.findViewById(R.id.tvTitleYear);
        TextView tvYearInput = rowView.findViewById(R.id.tvYearInput);

        // Obtain the song information based on the position
        Enrolment currentEnrolment = enrolmentList.get(position);

        // Set values to the TextView to display the corresponding information
        tvEnrolmentInput.setText(currentEnrolment.getEnrolment() + "");
        tvYearInput.setText(currentEnrolment.getYear() + "");


        return rowView;
    }

}
