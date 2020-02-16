package com.example.pokedex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class pokemenList extends Fragment{

    private RecyclerView listPokemen;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listPokemen = (RecyclerView) view.findViewById(R.id.listPokemen);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        listPokemen.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        listPokemen.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        //mAdapter = new MyAdapter(myDataset);
        //listPokemen.setAdapter(mAdapter);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the layout of this fragment
        return inflater.inflate(R.layout.fragment_pokemen_list, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();

    }
}
