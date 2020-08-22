package sur.cas.edu.tablayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NatonalParksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NatonalParksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NatonalParksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NatonalParksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NatonalParksFragment newInstance(String param1, String param2) {
        NatonalParksFragment fragment = new NatonalParksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of place
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getString(R.string.AberdeNationalPark), getString(R.string.AberdaeParkDescription), R.drawable.aberdare_national_park));
        places.add(new Places(getString(R.string.AmboseliNationalPark), getString(R.string.AmboseliNationalParkDescription),
                R.drawable.amboseli));
        places.add(new Places(getString(R.string.HelsGatePark), getString(R.string.HelsGateParkDescription), R.drawable.hells_gate_national_park));
        places.add(new Places(getString(R.string.lakeNakuruPark), getString(R.string.lakeNakuruParkDescription) , R.drawable.lake_nakuru_national_park));
        places.add(new Places(getString(R.string.malindiMarinePark), getString(R.string.malindiMarineParkDescription) ,
                R.drawable.malindi_marine_national_park));
        places.add(new Places(getString(R.string.mtKenyaPark), getString(R.string.mtKenyaParkDdescription) ,
                R.drawable.mount_kenya_national_park));
        places.add(new Places(getString(R.string.NairobiNationalPark), getString(R.string.NairobiNationalParkDescription) ,
                R.drawable.nairobi_national_park));
        places.add(new Places(getString(R.string.SibiloiNationalPark), getString(R.string.SibiloiNationalParkDdescription)
                , R.drawable.sibiloi_national_park));
        places.add(new Places(getString(R.string.TsavoEastPark), getString(R.string.TsavoEastParkDescription),
                R.drawable.tsavo_east_national_park));
        places.add(new Places(getString(R.string.MtLongonot), getString(R.string.MtLongonotDescription) ,
                R.drawable.mount_longonot_national_park));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), places, R.color.NationalParks_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open a view with data of the listView when the list item is
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), "I am working", Toast.LENGTH_SHORT).show();

                // Get the item of the given position the user clicked on
                Places placeClicked = (Places) parent.getItemAtPosition(position);

                //get the item from the list that is  clicked, name of place, description and image
                String placeName = placeClicked.getPlace();
                String description = placeClicked.getDescription();
                int image = placeClicked.getmImageResourceId();

                //create an intent object
                Intent intent = new Intent(getActivity(), GetListInfo.class);
                //use intent extra to get the image and its key to be used in GetListInfo activity
                intent.putExtra("image", placeClicked.getmImageResourceId());

                //use intent extra to get the text name and its key to be used in
                // GetListInfo activity
                intent.putExtra("name", placeName);

                //use intent extra to get the text description and its key to be used in
                // GetListInfo activity
                intent.putExtra("description", description);

                //start activity
                startActivity(intent);
            }
        });

        return rootView;
    }
}