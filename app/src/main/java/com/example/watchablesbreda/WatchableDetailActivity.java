package com.example.watchablesbreda;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class WatchableDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.d(TAG, "onCreate called");

        Bundle extras = getIntent().getExtras();

        Watchable mWatchable = (Watchable) extras.getSerializable("WATCHABLE");

        ImageView imgArtworkPicture = findViewById(R.id.img_listrow_artwork_image);
        TextView tvWatchableName = findViewById(R.id.tv_listrow_artwork_name);
        TextView tvwatchAbleId = findViewById(R.id.tv_listrow_artwork_id);
        TextView tvWatchableLocation = findViewById(R.id.tv_listrow_artwork_location);
        TextView tvWatchableArtist = findViewById(R.id.tv_listrow_artwork_artist);
        TextView tvWatchableMaterial = findViewById(R.id.tv_listrow_artwork_material);
        TextView tvWatchableDescription = findViewById(R.id.tv_listrow_artwork_description);
        TextView tvWatchablePostdate = findViewById(R.id.tv_listrow_artwork_postdate);


        tvWatchableName.setText(mWatchable.getWatchableName());
        tvwatchAbleId.setText(mWatchable.getWatchableId());
        tvWatchableLocation.setText(mWatchable.getWatchableLocation());
        tvWatchableArtist.setText(mWatchable.getWatchableArtist());
        tvWatchableMaterial.setText(mWatchable.getWatchableMaterial());
        tvWatchableDescription.setText(mWatchable.getWatchableDescription());
        tvWatchablePostdate.setText(mWatchable.getWatchablePostDate());

        Picasso.get()
                .load(mWatchable.getWatchableImageUrl())
                .into(imgArtworkPicture);



    }
}