package com.example.yannick.bettingappClient;

/**
 * Created by Yannick on 22-8-2016.
 */
public class Player {
    private String name;
    private Role currentRole;
    private Round currentRound;
    private boolean done;
    private Game game;
    public Player(String nameArg){
        name = nameArg;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void askForQuestion(){
        if(!done){
            //showQuestionScreen();
        }
    }
    public void sendQuestion(String question){
        done = true;
    }
    public void newRound(Role role, Round round){
        done = false;
        currentRole=role;
        currentRound = round;
    }
    public void updateState(RoundState state){
        //currentState = state;
    }
}
