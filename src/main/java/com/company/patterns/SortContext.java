package com.company.patterns;

public class SortContext {
    private Strategy strategy;

    public SortContext(Strategy strategy){
        this.strategy = strategy;
    }

    public Strategy getStrategy(){
        return strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
}
