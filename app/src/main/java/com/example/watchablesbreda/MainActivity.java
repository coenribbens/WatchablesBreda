package com.example.watchablesbreda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity
        extends AppCompatActivity
        implements WatchablesCollector.OnRandomWatchableListener, WatchablesAdapter.ListItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ImageView ivArtworkImage;
    private TextView tvArtworkName;
    private TextView tvArtworkLocation;
    private TextView tvArtworkId;

    private final static String mRandomWatchableUrl = "https://services7.arcgis.com/21GdwfcLrnTpiju8/arcgis/rest/services/Sierende_elementen/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json ";
    private ArrayList<Watchable> mWatchablesList;
    private RecyclerView.Adapter mAdapter;
    private WatchablesAdapter adapter;
    private RecyclerView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.rv_watchables_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mWatchablesList = new ArrayList<>();
        mAdapter = new WatchablesAdapter(mWatchablesList, this);
        mRecyclerView.setAdapter(mAdapter);

        WatchablesCollector watchablesCollector = new WatchablesCollector(this);
        new WatchablesCollector(this).execute(mRandomWatchableUrl);

    }

    @Override
    public void onRandomWatchableAvailable(ArrayList<Watchable> watchablesList) {
        Log.d(TAG, "onRandomUserAvailable was called - got " + watchablesList.size() + " persons.");

        mWatchablesList.clear();
        mWatchablesList.addAll(watchablesList);
        mAdapter.notifyDataSetChanged();
    }

    public void onListItemClick(int clickedItemIndex) {
        Log.d(TAG, "onListItemClick was called - got index " + clickedItemIndex);

        Intent intent = new Intent(getApplicationContext(), WatchableDetailActivity.class);

        intent.putExtra("WATCHABLE", mWatchablesList.get(clickedItemIndex));
        startActivity(intent);

    }


}
