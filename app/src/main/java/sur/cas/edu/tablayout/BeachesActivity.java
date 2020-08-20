package sur.cas.edu.tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeachesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new BeachesFragment())
                .commit();
    }
}