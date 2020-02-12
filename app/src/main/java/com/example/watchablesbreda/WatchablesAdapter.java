package com.example.watchablesbreda;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.Watchable;
import java.util.ArrayList;

public class WatchablesAdapter extends RecyclerView.Adapter<WatchablesAdapter.WatchablesViewHolder> {

    private static final String TAG = WatchablesAdapter.class.getSimpleName();

    private ArrayList<Watchable> mWatchablesList;
    private ListItemClickListener listener;

    public WatchablesAdapter(ArrayList<Watchable> mWatchablesList, ListItemClickListener listener) {
        this.mWatchablesList = mWatchablesList;
        this.listener = listener;
    }

    @Override
    public WatchablesAdapter.WatchablesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Log.d(TAG, "onCreateViewHolder");

        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        boolean attachToRoot = false;

        View listRow = inflater.inflate(R.layout.watchable_list_row, viewGroup, attachToRoot);
        WatchablesViewHolder watchableViewHolder = new WatchablesViewHolder(listRow);

        return watchableViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WatchablesAdapter.WatchablesViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder - position = " + position);


    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount");


        return mWatchablesList.size();
    }

    class WatchablesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final String TAG = WatchablesAdapter.class.getSimpleName();

        public TextView tvArtworkName;
        public TextView tvArtworkArtist;
        public TextView tvArtworkId;
        public ImageView imgArtworkPicture;

        public WatchablesViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "constructor");

            // Connect naar de view items in de list row.
            tvArtworkName = (TextView) itemView.findViewById(R.id.tv_listrow_artwork_name);
            tvArtworkArtist = (TextView) itemView.findViewById(R.id.tv_listrow_artwork_artist);
            tvArtworkId = (TextView) itemView.findViewById(R.id.tv_listrow_artwork_id);
            imgArtworkPicture = (ImageView) itemView.findViewById(R.id.img_listrow_artwork_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            Log.d(TAG, "onClick on position " + position);
            listener.onListItemClick(position);
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}

