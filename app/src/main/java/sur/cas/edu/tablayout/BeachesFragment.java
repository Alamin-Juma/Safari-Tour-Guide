package sur.cas.edu.tablayout;

import android.media.AudioManager;
import android.media.MediaPlayer;
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
 * Use the {@link BeachesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeachesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BeachesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BeachesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BeachesFragment newInstance(String param1, String param2) {
        BeachesFragment fragment = new BeachesFragment();
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of place
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getString(R.string.dianiBeach), getString(R.string.dianiBeachDescription), R.drawable.diani_beach));
        places.add(new Places(getString(R.string.kilifiBeach), getString(R.string.kilifiBeachDescription),
                R.drawable.kilifi_beach));
        places.add(new Places(getString(R.string.lamuBeach), getString(R.string.lamuBeachDescription),
                R.drawable.lamu_beaches));
        places.add(new Places(getString(R.string.malindiBeach), getString(R.string.malindiBeachDescription),
                R.drawable.malindi_beach));
        places.add(new Places(getString(R.string.nyaliBeach), getString(R.string.nyaliBeachDescription),
                R.drawable.nyali_beach));
        places.add(new Places(getString(R.string.shanzuBeach), getString(R.string.shanzuBeachDescription),
                R.drawable.shanzu_beach));
        places.add(new Places(getString(R.string.shellyBeach), getString(R.string.shellyBeachDescription),
                R.drawable.shelly_beach));
        places.add(new Places(getString(R.string.tiwiBeach), getString(R.string.tiwiBeachDescription), R.drawable.tiwi_beach));
        places.add(new Places(getString(R.string.watamuBeach), getString(R.string.watamuBeachDescription),
                R.drawable.watamu_beach));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), places, R.color.Beaches_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}