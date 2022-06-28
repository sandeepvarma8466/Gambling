package com.blz.gambling;

import java.util.Random;

public class GamblingSimulator {

    static final int stakePerDay = 100;
    static final int betPerGame = 1;
    static final int isWin = 1;
    static int stake = 0;
    static int daysWonCount = 0;
    static int daysLostCount = 0;

    public static void winCheck() {
        Random random = new Random();
        int betReturns = random.nextInt(2);
        if (betReturns == isWin){
            stake = stake + betPerGame;
            System.out.println("Congratulations you win!!");
        }
        else {
            stake = stake - betPerGame ;
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
    public static void monthlyWinOrLossCheck() {
        int totalStake = 0;
        for (int i = 0; i <= 20; i++) {
            System.out.println("Day: " +i);
            resignDayCheck();
            if (stake == 50) {
                daysWonCount++;
                totalStake = totalStake + stake;
            }
            else if (stake == -50) {
                daysLostCount++;
                totalStake = totalStake + stake;
            }
        }
        if (totalStake < 0) {
            System.out.println("After playing for 20 days Gambler lost total amount: $"+totalStake);
        }
        else {
            System.out.println("After playing for 20 days Gambler won total amount: $"+totalStake);
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulator");
        monthlyWinOrLossCheck();
    }
}
