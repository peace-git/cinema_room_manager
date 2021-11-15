package com.peace;

import java.util.Scanner;

public class DataPrinter {
    private static final Scanner scanner = new Scanner(System.in);
    private final CinemaSeats cinemaSeats;

    public DataPrinter() {
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row: ");
        int columns = scanner.nextInt();
        this.cinemaSeats = new CinemaSeats(rows, columns);
    }

    public void printSeats() {
        System.out.println("Cinema:");
        for (int i = 0; i <= cinemaSeats.getRows(); i++) {
            for (int j = 0; j <= cinemaSeats.getColumns(); j++) {
                if (i == 0 && j == 0) System.out.print("  ");
                else if (i == 0) System.out.printf(" %d", j);
                else if (j == 0) System.out.printf(" %d", i);
                else System.out.printf(" %c", cinemaSeats.getSeats()[i - 1][j - 1]);
            }
            System.out.println();
        }
    }

    public void buyATicket() {
        System.out.printf("Ticket price: $%d%n", cinemaSeats.buyATicket());
    }

    public void printMenu() {
        System.out.println(
                """

                        1. Show the seats
                        2. Buy a ticket
                        3. Statistics
                        0. Exit
                        """
        );
    }

    public void printStatistics() {
        printPurchasedTicketsCount();
        printPurchasedTicketsPercentage();
        printCurrentIncome();
        printTotalIncome();
    }

    public void printPurchasedTicketsCount() {
        System.out.printf("Number of purchased tickets: %d%n", cinemaSeats.getPurchasedTicketsCount());
    }

    public void printPurchasedTicketsPercentage() {
        System.out.printf("Percentage: %.2f%%%n", cinemaSeats.getPurchasedTicketsPercentage());
    }

    public void printCurrentIncome() {
        System.out.printf("Current income: $%d%n", cinemaSeats.getCurrentIncome());
    }

    public void printTotalIncome() {
        System.out.printf("Total income: $%d%n", cinemaSeats.totalIncome());
    }
}
