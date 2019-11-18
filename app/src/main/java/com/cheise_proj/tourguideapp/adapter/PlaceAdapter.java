package com.cheise_proj.tourguideapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.cheise_proj.tourguideapp.R;
import com.cheise_proj.tourguideapp.model.Place;

/**
 * PlaceAdapter custom adapter for recycler view
 */
public class PlaceAdapter extends ListAdapter<Place, PlaceAdapter.Place_ViewHolder> {
    private PlaceClickListener<Place> placeClickListener;

    public PlaceAdapter(@NonNull DiffUtil.ItemCallback<Place> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public Place_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Place_ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_place, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Place_ViewHolder holder, int position) {
        holder.bind(getItem(position), placeClickListener);
    }

    public void setPlaceClickListener(PlaceClickListener<Place> placeClickListener) {
        this.placeClickListener = placeClickListener;
    }

    class Place_ViewHolder extends RecyclerView.ViewHolder {
        private ImageView placeImage;
        private TextView placeName;

        private Place_ViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.img_place);
            placeName = itemView.findViewById(R.id.tv_place_name);
        }

        private void bind(final Place item, final PlaceClickListener<Place> placeClickListener) {
            placeName.setText(item.getName());
            placeImage.setImageResource(item.getImageResourceId());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    placeClickListener.onClick(item);
                }
            });
        }
    }
}
