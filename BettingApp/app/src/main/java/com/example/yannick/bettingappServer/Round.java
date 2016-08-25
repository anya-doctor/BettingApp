package com.example.yannick.bettingappServer;

import com.example.yannick.bettingappClient.Game;
import com.example.yannick.bettingappClient.Player;
import com.example.yannick.bettingappClient.Role;
import com.example.yannick.bettingappClient.RoundState;

import java.util.HashMap;

/**
 * Created by Yannick on 22-8-2016.
 */
public class Round {
    private HashMap<Player,Role> players;
    private com.example.yannick.bettingappClient.Game game;
    private String question;
    private int answer;
    private RoundState currentState;
    private HashMap<Player,Integer> guesses;

    public Round(HashMap<Player,Role> players, Game game){
        this.players = players;
        this.game = game;
        this.guesses = new HashMap<Player,Integer>();
    }

    public void startRound(){
        currentState=RoundState.START;
        for(HashMap.Entry<Player,Role> e: players.entrySet()){
            //e.getKey().newRound(e.getValue(),this);
            if(e.getValue()==Role.ASKER){
                e.getKey().askForQuestion();
                currentState=RoundState.WAITFORQUESTION;
            }
        }
        updateState();
    }
    public void setQuestion(String question){
        this.question=question;
        for(HashMap.Entry<Player,Role> e: players.entrySet()){
            //e.getKey().setQuestion(question);
            if(e.getValue()==Role.ANSWERER){
                //e.getKey().askForAnswer();
                currentState=RoundState.WAITFORANSWER;
            }
        }
        updateState();
    }
    public void setAnswer(int answer){
        this.answer=answer;
        for(HashMap.Entry<Player,Role> e: players.entrySet()){
            if(e.getValue()==Role.QUESSER){
                //e.getKey().askForGuess();
                currentState=RoundState.WAITFORGUESSES;
            }
        }
        updateState();
    }
    public void addGuess(Player p, int guess){
        guesses.put(p,guess);
        if(guesses.size()==players.size()-2){
            currentState=RoundState.CHECKANSWERS;
        }
        updateState();
    }
    public void updateState(){
        for(Player p : players.keySet()){
            p.updateState(currentState);
        }
    }
}
