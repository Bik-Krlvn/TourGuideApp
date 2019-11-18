package com.cheise_proj.tourguideapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cheise_proj.tourguideapp.R;
import com.cheise_proj.tourguideapp.common.Constants;
import com.cheise_proj.tourguideapp.model.Place;

import java.util.Objects;

/**
 * DetailActivity shows details information of place
 */
public class DetailActivity extends AppCompatActivity {
    private ImageView placeImage;
    private TextView textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        placeImage = findViewById(R.id.img_place);
        textDescription = findViewById(R.id.tv_place_description);

        // Get data extras from intent
        if (getIntent().hasExtra(Constants.PLACE_EXTRAS)) {
            Place place = getIntent().getParcelableExtra(Constants.PLACE_EXTRAS);
            assert place != null;
            initDetails(place);
        }
    }

    /**
     * Set View content
     *
     * @param place place object data
     */
    private void initDetails(Place place) {
        placeImage.setImageResource(place.getImageResourceId());
        textDescription.setText(place.getDescription());
    }

    /**
     * Return an Intent of DetailActivity
     *
     * @param context provide current context
     * @return intent
     */
    public static Intent newInstance(Context context) {
        return new Intent(context, DetailActivity.class);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
