package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;


public class PokedexActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


    Button btnSwitch;
    Button btnSearch;

    String toGrid = "Grid";
    String toList = "List";
    String type_one;
    String type_two;
    String[] types;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        //getting data from search
        types = getIntent().getStringArrayExtra("types");


        btnSearch = findViewById(R.id.btnSearch);
        btnSwitch = findViewById(R.id.btnSwitch);
        btnSwitch.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnSwitch.setText(toGrid);


        pokemenList p_list = new pokemenList();
        pokemenGrid p_grid = new pokemenGrid();

        fragmentTransaction.replace(R.id.fragContainer, p_list).commit();

    }


    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.btnSearch:
                Intent startIntent = new Intent(this, MainActivity.class);
                this.startActivity(startIntent);
                break;
            case R.id.btnSwitch:
                if(btnSwitch.getText() == toGrid) {
                    System.out.println("calling self-made replace on GRID");
                    replaceFragment(new pokemenGrid());
                    btnSwitch.setText(toList);
                }else{
                    System.out.println("calling self-made replace on LIST");
                    replaceFragment(new pokemenList());
                    btnSwitch.setText(toGrid);
                }
                break;
            default:
                break;


        }

    }
    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = PokedexActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if(fragments != null){
            for(Fragment fragment : fragments){
                if(fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }
    public void replaceFragment(Fragment novel) {
        System.out.println("new transaction");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack

        System.out.println("replace and add to backstack");

        transaction.replace(R.id.fragContainer, novel);
        transaction.addToBackStack(null);

        System.out.println("committing change");

        // Commit the transaction
        transaction.commit();
    }



}
