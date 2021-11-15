package com.peace;

import java.util.Scanner;

public class Menu {
    public static final Scanner scanner = new Scanner(System.in);
    private final DataPrinter dataPrinter = new DataPrinter();

    public void start() {
        var pointer = -1;
        while (pointer != 0) {
            dataPrinter.printMenu();
            pointer = scanner.nextInt();
            switch (pointer) {
                case 0: break;
                case 1: {
                    dataPrinter.printSeats();
                    break;
                }
                case 2: {
                    dataPrinter.buyATicket();
                    break;
                }
                case 3: {
                    dataPrinter.printStatistics();
                    break;
                }
            }
        }
    }
}
