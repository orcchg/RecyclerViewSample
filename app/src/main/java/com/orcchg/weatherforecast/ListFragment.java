package com.orcchg.weatherforecast;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    private WeatherAdapter mAdapter;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new WeatherAdapter();
        mAdapter.add(new Weather[]{new Weather("Sunshine"), new Weather("Snow"), new Weather("Cloudy"), new Weather("Windy"), new Weather("Rain"),
                     new Weather("Volcanic"), new Weather("Clear sky"), new Weather("Twilights"), new Weather("Storm"), new Weather("Warm"),
                     new Weather("Cold"), new Weather("Hot"), new Weather("Moderate"), new Weather("Glacier"), new Weather("Sunny")});
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment_layout, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        RecyclerView list = (RecyclerView) rootView.findViewById(R.id.list_fragment_recyclerview);
        list.setLayoutManager(layoutManager);
        list.setAdapter(mAdapter);
        list.addOnItemTouchListener(new RecyclerItemClickListener(getActivity().getBaseContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                String message = mAdapter.getItem(position).getForecast();
                Toast.makeText(getActivity().getBaseContext(), message, Toast.LENGTH_SHORT).show();
            }
        }));
        return rootView;
    }
}
