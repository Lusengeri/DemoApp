package com.alsoftware.navbottombarcombidemo.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.alsoftware.navbottombarcombidemo.MediaRecyclerViewAdapter;
import com.alsoftware.navbottombarcombidemo.R;

public class HomeFragment extends Fragment {

    private ImageButton playButton;
    private ImageButton addToPlaylistButton;
    private ImageButton infoButton;
    private ImageButton videoPlay1, videoPlay2, videoPlay3;
    private ImageButton audioPlay1, audioPlay2, audioPlay3;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView discoverCarousel = view.findViewById(R.id.carousel_1);
        MediaRecyclerViewAdapter adapter1 = new MediaRecyclerViewAdapter();
        LinearLayoutManager horizontalLayout1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        discoverCarousel.setLayoutManager(horizontalLayout1);
        discoverCarousel.setAdapter(adapter1);
        discoverCarousel.setItemAnimator(new DefaultItemAnimator());

        RecyclerView popularCarousel = view.findViewById(R.id.carousel_2);
        MediaRecyclerViewAdapter adapter2 = new MediaRecyclerViewAdapter();
        LinearLayoutManager horizontalLayout2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        popularCarousel.setLayoutManager(horizontalLayout2);
        popularCarousel.setAdapter(adapter2);
        popularCarousel.setItemAnimator(new DefaultItemAnimator());

        RecyclerView suggestedCarousel = view.findViewById(R.id.carousel_3);
        MediaRecyclerViewAdapter adapter3 = new MediaRecyclerViewAdapter();
        LinearLayoutManager horizontalLayout3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        suggestedCarousel.setLayoutManager(horizontalLayout3);
        suggestedCarousel.setAdapter(adapter3);
        suggestedCarousel.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpButtons(view);
    }

    private void setUpButtons(View view) {
        addToPlaylistButton = view.findViewById(R.id.add_to_playlist_button);
        addToPlaylistButton.setOnClickListener(view1 -> notImplementedMessage());

        playButton = view.findViewById(R.id.play_button);
        playButton.setOnClickListener(view12 -> notImplementedMessage());

        infoButton = view.findViewById(R.id.info_button);
        infoButton.setOnClickListener(view13 -> notImplementedMessage());

        videoPlay1 = view.findViewById(R.id.youtube_icon1);
        videoPlay1.setOnClickListener(view14 -> notImplementedMessage());
        videoPlay2 = view.findViewById(R.id.youtube_icon2);
        videoPlay2.setOnClickListener(view15 -> notImplementedMessage());
        videoPlay3 = view.findViewById(R.id.youtube_icon3);
        videoPlay3.setOnClickListener(view16 -> notImplementedMessage());

        audioPlay1 = view.findViewById(R.id.headphones_icon1);
        audioPlay1.setOnClickListener(view19 -> notImplementedMessage());
        audioPlay2 = view.findViewById(R.id.headphones_icon2);
        audioPlay2.setOnClickListener(view18 -> notImplementedMessage());
        audioPlay3 = view.findViewById(R.id.headphones_icon3);
        audioPlay3.setOnClickListener(view17 -> notImplementedMessage());
    }

    public void notImplementedMessage() {
        Toast.makeText(getContext(), "Not Implemented", Toast.LENGTH_SHORT).show();
    }
}