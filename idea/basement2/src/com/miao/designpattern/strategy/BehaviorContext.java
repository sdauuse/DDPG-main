package com.miao.designpattern.strategy;

public class BehaviorContext {
    private Penguin _penguin;

    public BehaviorContext(Penguin newPenguin){
        this._penguin = newPenguin;
    }

    public void setPenguin(Penguin newPenguin){
        this._penguin = newPenguin;
    }

    public void everyday(){
        this._penguin.eating();
        this._penguin.sleeping();
        this._penguin.beating();
    }
}
