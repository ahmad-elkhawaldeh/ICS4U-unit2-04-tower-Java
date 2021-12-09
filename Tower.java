/*
* This program solves the Tower of Hanoi riddle.
*
* @author  Ahmad El-khawaldeh
* @version 1.0
* @since   2021-12-04
*/

import java.util.Scanner;

/**
* This class contains the solution to the Towers of Hanoi.
*
*/
final class Tower {

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private Tower() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Uses recursion to complete the hanoi algorithm and move all the rings to
    * the final rod.
    *
    * @param nOfDisks the amount of disks
    * @param startPeg is the initial peg
    * @param endPeg is the final peg
    * @throws IOException if there is anything wrong with the user input.
    * @throws NumberFormatException if the user input cannot be turned into
    *     an integer.
    */
    static void hanoi(final int nOfDisks, final int startPeg,
                     final int endPeg) {
        final int pegNumber = 6;
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + " to peg "
                               + endPeg);
        } else {
            hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
            System.out.println("Move disk " + nOfDisks + " from peg "
                               + startPeg + "  peg "
                               + endPeg);
            hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }

    /**
    * Solves the towers of hanoi.
    *
    * @param args No args will be used.
    * @throws IOException if there is anything wrong with the user input.
    * @throws RuntimeException  if the user input cannot be turned into
    *     an integer.
    */
    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            final int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                hanoi(nOfDisks, startPeg, endPeg);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (ManagerException ex) {
            throw new RuntimeException("Error during startup of service", e);
        }

        System.out.println("\nDone.");
    }
}
