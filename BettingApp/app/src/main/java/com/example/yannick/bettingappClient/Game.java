package com.example.yannick.bettingappClient;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class Game extends AppCompatActivity {
    ArrayList<Player> players;
    private String currentQuestion;
    private String currentAnswer;
    private String[] quesses;
    private int round = 0;
    private int starter;
    public Game(ArrayList<Player> playersArg){
        players = playersArg;
        starter = (int) Math.random()*players.size();
    }
    public void startGame(){
        for(Player p : players){
            //p.startGame(players);
        }
    }
    public void startRound(){
        round++;
        HashMap<Player,Role> map = new HashMap<Player,Role>();
        for(Player p : players){
            if(players.indexOf(p)==(starter+round)%players.size()){
                map.put(p, Role.ASKER);
            }
            else if(players.indexOf(p)==(starter+round+1)%players.size()){
                map.put(p,Role.ANSWERER);
            }
            else{
                map.put(p, Role.QUESSER);
            }
        }
        Round round = new Round(map,this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
