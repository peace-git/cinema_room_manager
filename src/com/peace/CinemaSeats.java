package com.peace;

import java.util.Arrays;
import java.util.Scanner;

public class CinemaSeats {
    private final int rows;
    private final int columns;
    private final boolean big;
    private char[][] seats;
    private int purchasedTicketsCount;
    private int currentIncome;

    public CinemaSeats(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        big = this.rows * this.columns > 60;
        initializeSeats();
    }

    private void initializeSeats() {
        seats = new char[rows][columns];
        for (var row : seats) Arrays.fill(row, 'S');
    }

    public int totalIncome() {
        if (!big) return rows * columns * 10;
        else
            return ((rows / 2 * columns) * 10 +
                    ((rows - rows / 2) * columns) * 8);
    }

    public int buyATicket() {
        final Scanner scanner = new Scanner(System.in);
        int row, seat;
        while (true) {
            System.out.print("Enter a row number: ");
            row = scanner.nextInt();
            System.out.print("Enter a seat number in that row: ");
            seat = scanner.nextInt();
            if (row < 1 || row > rows || seat < 1 || seat > columns)
                System.out.println("Wrong input!");
            else if (seats[row - 1][seat - 1] == 'B')
                System.out.println("That ticket has already been purchased!");
            else break;
        }
        int cost;
        if (!big) cost = 10;
        else if (row <= rows / 2) cost = 10;
        else cost = 8;
        reserveASeat(row, seat, cost);
        return cost;
    }

    private void reserveASeat(int row, int seat, int cost) {
        seats[row - 1][seat - 1] = 'B';
        purchasedTicketsCount++;
        currentIncome += cost;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public char[][] getSeats() {
        return seats;
    }

    public int getPurchasedTicketsCount() {
        return purchasedTicketsCount;
    }

    public double getPurchasedTicketsPercentage() {
        return ((double) purchasedTicketsCount * 100) / (rows * columns);
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

}
