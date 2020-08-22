package sur.cas.edu.tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GetListInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_list_info);

        //get the ID value associated with the image
        ImageView image = findViewById(R.id.image_toBeDisplayed);

        //get the ID of the placeName textView
        TextView placeName = findViewById(R.id.placeName_toBeDisplayed);

        //get the ID of the description textView
        TextView description = findViewById(R.id.description_toBeDisplayed);

        // create the object of getTntent receive the value in String type variable
        // by getStringExtra method using
        Intent intent = getIntent();

       /*
        //the  received value set in the ImageView object of
         activity xml file*/
        int pic = intent.getIntExtra("image", -1);
        image.setImageResource(pic);

        /*
        //the  received value set in the name of the place TextView object of
         activity xml file*/
        String placeNameTxt = intent.getStringExtra("name");
        placeName.setText(placeNameTxt);

             /*
        //the  received value set in the description of the place TextView object of
         activity xml file*/
        String descriptionTxt = intent.getStringExtra("description");
        description.setText(descriptionTxt);

    }
}