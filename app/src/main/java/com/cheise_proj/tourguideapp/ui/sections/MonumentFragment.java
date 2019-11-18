package com.cheise_proj.tourguideapp.ui.sections;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;

import com.cheise_proj.tourguideapp.R;
import com.cheise_proj.tourguideapp.adapter.PlaceAdapter;
import com.cheise_proj.tourguideapp.adapter.PlaceClickListener;
import com.cheise_proj.tourguideapp.model.Data;
import com.cheise_proj.tourguideapp.model.Place;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonumentFragment extends BaseFragment {
    public MonumentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MonumentFragment.
     */
    public static MonumentFragment newInstance() {
        return new MonumentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monument, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new PlaceAdapter(new DiffUtil.ItemCallback<Place>() {
            @Override
            public boolean areItemsTheSame(@NonNull Place oldItem, @NonNull Place newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Place oldItem, @NonNull Place newItem) {
                return oldItem.getName().equals(newItem.getName()) &&
                        oldItem.getImageResourceId() == newItem.getImageResourceId();
            }
        });
        adapter.setPlaceClickListener(new PlaceClickListener<Place>() {
            @Override
            public void onClick(Place data) {
                navigateToDetails(data);
            }
        });
        adapter.submitList(Data.getMonument(Objects.requireNonNull(getContext())));
        initRecyclerView();

    }

}
