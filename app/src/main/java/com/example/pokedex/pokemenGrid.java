package com.example.pokedex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class pokemenGrid extends Fragment{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the layout of this fragment
        return inflater.inflate(R.layout.fragment_pokemen_grid, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
