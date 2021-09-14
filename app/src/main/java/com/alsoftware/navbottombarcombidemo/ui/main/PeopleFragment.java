package com.alsoftware.navbottombarcombidemo.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.alsoftware.navbottombarcombidemo.MainActivity;
import com.alsoftware.navbottombarcombidemo.R;
import com.alsoftware.navbottombarcombidemo.ui.main.people.MainPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PeopleFragment extends Fragment {
    MainActivity parentActivity;

    public PeopleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parentActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SearchView searchView = view.findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);

        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager(), getLifecycle());
        viewPager.setAdapter(mainPagerAdapter);

        TabLayoutMediator.TabConfigurationStrategy strategy = new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("ARTISTS");
                } else {
                    tab.setText("USERS");
                }
            }
        };
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager, strategy);
        mediator.attach();
    }
}