package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgbtnStart;
    TextView txtTypes;
    //18 different types
    Button btnNormal;
    Button btnFire;
    Button btnWater;
    Button btnElectric;
    Button btnGrass;
    Button btnIce;
    Button btnFighting;
    Button btnPoison;
    Button btnGround;
    Button btnFlying;
    Button btnPsychic;
    Button btnBug;
    Button btnRock;
    Button btnGhost;
    Button btnDragon;
    Button btnDark;
    Button btnSteel;
    Button btnFairy;

    boolean normal = false;
    boolean fire = false;
    boolean water = false;





    ArrayList<String> types = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtnStart = findViewById(R.id.imgbtnStart);
        txtTypes = findViewById(R.id.txtTypes);
        btnNormal = findViewById(R.id.btnNormal);
        btnFire = findViewById(R.id.btnFire);
        btnWater = findViewById(R.id.btnWater);

        txtTypes.setText("");
        imgbtnStart.setOnClickListener(this);
        btnNormal.setOnClickListener(this);
        btnFire.setOnClickListener(this);
        btnWater.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgbtnStart:
                Intent startIntent = new Intent(this, PokedexActivity.class);
                startIntent.putExtra("types",types);
                this.startActivity(startIntent);
                break;
            case R.id.btnNormal:
                if(normal) {
                    System.out.println("removing: normal");
                    removeStr("normal");
                    normal = false;
                }
                else if(types.size()<2) {
                    normal = true;
                    types.add("normal");
                }
                break;
            case R.id.btnFire:
                if(fire){
                    System.out.println("removing: fire");
                    removeStr("fire");
                    fire = false;
                }
                else if(types.size()<2) {
                    fire = true;
                    types.add("fire");
                }
                break;
            case R.id.btnWater:
                if(water){
                    System.out.println("removing: water");
                    removeStr("water");
                    water = false;
                }
                else if(types.size()<2) {
                    water = true;
                    types.add("water");
                }
                break;



            default:
                break;
        }
        update();


    }

    public void update(){
        txtTypes.setText(types.toString());
    }


    //FIXME: buggy...concurrent modification exception?
    public void removeStr(String str){
        System.out.println("Types to remove ["+str+"] from: "+types.toString());
        for(String obj : types){
            if(obj == str){
                System.out.println("removed: "+obj);
                types.remove(obj);
            }
        }

    }

}
