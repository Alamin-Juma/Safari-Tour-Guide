package sur.cas.edu.tablayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NatonalParksFragment();
        } else if (position == 1) {
            return new BeachesFragment();
        }
        else if (position == 2) {
            return new HotelFragment();
        }
        else {
            return new CulturalFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.national_parks);
        } else if (position == 1) {
            return mContext.getString(R.string.beaches);
        } else if (position == 2) {
            return mContext.getString(R.string.hotels);
        } else {
            return mContext.getString(R.string.culture);
        }
    }
}
