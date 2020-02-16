package com.example.pokedex;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class pokemon {
    int attack;
    int defense;
    int hp;
    int uID;

    String type1;
    String type2;
    String[] types;

    String name;


    public pokemon(JSONObject poke) {




    }

    public pokemon(JSONArray pokemen) {




    }


    public JSONArray JSON_to_pokemen(String file) {
        JSONParser jsonParser = new JSONParser();
        JSONArray PokemonJson;

        try (FileReader reader = new FileReader(file)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            PokemonJson = (org.json.JSONArray) obj;
            for(int n = 0; n < PokemonJson.length(); n++)
            {
                try () {
                    JSONObject object = PokemonJson.getJSONObject(n);
                    for (int i = 0; i < object.length(); i++) {
                        JSONObject poke = PokemonJson.getJSONObject(n);
                        attack = poke.get("Attack");
                        defense = poke.get("Defense");
                        hp = poke.get("HP");
                        types = poke.get("Type");
                        uID = poke.get("#");


                    }

                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            //Iterate over employee array


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

}