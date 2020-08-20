package sur.cas.edu.tablayout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Places> {
    ListView listView;

    private static final String LOG_TAG = PlacesAdapter.class.getSimpleName();
    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link PlacesAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param places is the list of {@link Places}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public PlacesAdapter(Activity context, ArrayList<Places> places, int colorResourceId) {
        super(context, 0, places);
        this.mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Get the {@link AndroidFlavor} object located at this position in the list
        Places places = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID place name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the song name from the current Music object and
        // set this text on the name TextView
        nameTextView.setText(places.getPlace());

        // Find the TextView in the list_item.xml layout with the ID description
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.description);
        // Get the musician name from the current Music object and
        // set this text on the number TextView
        numberTextView.setText(places.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(places.getmImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID phone_price
        TextView phone_price = (TextView) listItemView.findViewById(R.id.price_Phone);

        if (places.hasTextView())
        {
            // Get the price name from the current Place object and
            // set this text on the number TextView
            phone_price.setText(places.getPrice_phone());
            //make the textview visible if we do have a text on the place e.g HotelsFragment
            phone_price.setVisibility(View.VISIBLE);
        }
        else {
            //hides the textview while not taking the space of the text at th same time
            phone_price.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //set the background color of the textContainer
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}

