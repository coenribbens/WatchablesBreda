package com.example.watchablesbreda;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class WatchableDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.d(TAG, "onCreate called");

        Bundle extras = getIntent().getExtras();

        Watchable mWatchable = (Watchable) extras.getSerializable("WATCHABLE");

        TextView tvArtworkName = findViewById(R.id.tv_listrow_artwork_name);
        ImageView imgArtworkPicture = findViewById(R.id.img_listrow_artwork_image);

        tvArtworkName.setText(mWatchable.getWatchableName());

        Picasso.get()
                .load(mWatchable.getWatchableURL())
                .into(imgArtworkPicture);



    }
}