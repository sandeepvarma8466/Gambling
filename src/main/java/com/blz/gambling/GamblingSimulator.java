package com.blz.gambling;

import java.util.Random;

public class GamblingSimulator {

    static final int stakePerDay = 100;
    static final int betPerGame = 1;
    static final int isWin = 1;
    static int stake = 0;

    public static void winCheck() {
        Random random = new Random();
        int betReturns = random.nextInt(2);
        if (betReturns == isWin){
            stake++;
            System.out.println("Congratulations you win!!");
        }
        else {
            stake--;
            System.out.println("You loss the game!!");
        }
        System.out.println("Stake: "+(stake+stakePerDay));
    }
    public static void resignDayCheck() {
        int totalStake = 0;
        while (stake != 50 && stake != -50) {
            winCheck();
        }
        totalStake = stake + stakePerDay;
        System.out.println("Total Stack for resign of a day is: "+totalStake);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulator");
        resignDayCheck();
    }
}
