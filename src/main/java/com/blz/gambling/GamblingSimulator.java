package com.blz.gambling;

import java.util.Random;

public class GamblingSimulator {

    static final int stakePerDay = 100;
    static final int betPerGame = 1;
    static final int isWin = 1;
    static int stake = 0;
    static int daysWonCount = 0;
    static int daysLostCount = 0;

    /*
     * winCheck function will check if gambler wins or loss
     */
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
    /*
     * As a Calculative Gambler if won or lost 50% of the stake, would resign for
     * the day
     */
    public static void resignDayCheck() {
        int totalStake = 0;
        while (stake != 50 && stake != -50) {
            winCheck();
        }
        totalStake = stake + stakePerDay;
        System.out.println("Total Stack for resign of a day is: "+totalStake);
    }
    /*
     * After 20 days of playing every day would like to know the total amount won or
     * lost.
     */
    public static void monthlyWinOrLossCheck() {
        int totalStake = 0;
        for (int i = 0; i <= 20; i++) {
            System.out.println("Day: " +i);
            resignDayCheck();
            if (stake == 50) {
                daysWonCount++;
                totalStake = totalStake + stake;
                System.out.println("It was my luckiest Day!!");
            }
            else if (stake == -50) {
                daysLostCount++;
                totalStake = totalStake + stake;
                System.out.println("It was my Unluckiest Day!!");
            }
        }
        if (totalStake < 0) {
            System.out.println("After playing for 20 days Gambler lost total amount: $"+totalStake);
        }
        else {
            System.out.println("After playing for 20 days Gambler won total amount: $"+totalStake);
        }
        System.out.println(daysWonCount+ " Days won for a month \n" +daysLostCount+ " Days lost for a month");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulator");
        monthlyWinOrLossCheck();
    }
}
