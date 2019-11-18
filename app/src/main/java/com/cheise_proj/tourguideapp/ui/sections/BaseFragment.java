package com.cheise_proj.tourguideapp.ui.sections;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cheise_proj.tourguideapp.adapter.PlaceAdapter;
import com.cheise_proj.tourguideapp.common.Constants;
import com.cheise_proj.tourguideapp.model.Place;
import com.cheise_proj.tourguideapp.ui.DetailActivity;

import java.util.Objects;

abstract class BaseFragment extends Fragment {
    PlaceAdapter adapter;
    RecyclerView recyclerView;

    //initialize recycler view properties
    void initRecyclerView() {
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    // navigate to details of place
    void navigateToDetails(Place data) {
        Objects.requireNonNull(getContext()).startActivity(
                DetailActivity.newInstance(getContext()).putExtra(Constants.PLACE_EXTRAS, data));
    }

}
