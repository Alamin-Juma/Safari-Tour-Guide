package sur.cas.edu.tablayout;

public class Places {
    //name of the place
    private String place;

    //description of the place
    private String description;

    //Drawable resource ID
    private int mImageResourceId;

    //price and and contact of the place
    private String price_phone = NO_TEXTVIEW_PROVIDED;
    private static final String NO_TEXTVIEW_PROVIDED = " ";

    //a constructor to create an object of place
    public Places(String place, String description, int mImageResourceId) {
        this.place = place;
        this.description = description;
        this.mImageResourceId = mImageResourceId;
    }
    //a constructor to create an object of place
    public Places(String place, String description, int mImageResourceId, String price_phone) {
        this.place = place;
        this.description = description;
        this.mImageResourceId = mImageResourceId;
        this.price_phone = price_phone;
    }

    //get the name of the place
    public String getPlace() {
        return place;
    }

    //get the description of the place
    public String getDescription() {
        return description;
    }

    //get the resource ID of the place
    public int getmImageResourceId() {
        return mImageResourceId;
    }

    //get the price and phone of the place
    public String getPrice_phone() {
        return price_phone;
    }
    /*
            Whether or not there is an textView or not for this word
    */
    public boolean hasTextView() {
        return price_phone != NO_TEXTVIEW_PROVIDED;
    }
}
