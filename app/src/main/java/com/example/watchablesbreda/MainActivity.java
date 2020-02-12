package com.example.watchablesbreda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView tvRandomPersonName;
    private Button btnGetRandomPerson;
    private ImageView imgRandomPersonImage;

    private final static String mRandomUserUrl = "https://services7.arcgis.com/21GdwfcLrnTpiju8/arcgis/rest/services/Sierende_elementen/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json ";
    private ArrayList<Watchable> mWatchablesList;
    private RecyclerView.Adapter mAdapter;

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

        WatchablesCollector randomUserTask = new WatchablesCollector(this);
        WatchablesCollector.execute(mRandomUserUrl);
    }
}
