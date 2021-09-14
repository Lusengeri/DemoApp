package com.alsoftware.navbottombarcombidemo.ui.main.people;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alsoftware.navbottombarcombidemo.MediaRecyclerViewAdapter;
import com.alsoftware.navbottombarcombidemo.PersonRecyclerViewAdapter;
import com.alsoftware.navbottombarcombidemo.R;

public class ArtistsFragment extends Fragment {

    public ArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artists, container, false);
        RecyclerView artistList = view.findViewById(R.id.artistList);
        PersonRecyclerViewAdapter adapter = new PersonRecyclerViewAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        artistList.setLayoutManager(gridLayoutManager);
        artistList.setAdapter(adapter);
        artistList.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}