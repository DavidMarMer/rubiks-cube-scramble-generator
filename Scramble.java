import java.util.Random;

/**
 * @author David Martínez Merencio
 * 
 */

public class Scramble {
    /* Generates scramble */
    public static String[] generateScramble(byte totalMovs) {
        String[] possibleMovs = {"U", "D", "L", "R", "F", "B"};
        String[] scramble = new String[totalMovs];
        byte numPossibleMovs = (byte) possibleMovs.length;
        Random random = new Random();
        String actualMov, lastMov = "";
        byte i, factor;
        
        for (i = 0; i < totalMovs; i++) {
            /* Generates a new letter until it doesn't match the last one generated */
            do {
                actualMov = possibleMovs[(byte)(random.nextDouble() * numPossibleMovs)];
            } while (actualMov.equals(lastMov));
            lastMov = actualMov;

            /* Chooses if the movement is clockwise, anticlockwise or double */
            factor = (byte)(random.nextDouble() * 3 + 1);
            if (factor == 1) {
                actualMov += "'";
            } else if (factor == 2) {
                actualMov += "2";
            } else {
                actualMov += " ";
            }
            
            /* Adds the movement to the final scramble */
            scramble[i] = actualMov;
        }

        return scramble;
    }

    public static void main (String args[]) {
        /* Number of movements that the final scramble will have */
        final byte NUM_MOVEMENTS = 15;

        String[] scramble = generateScramble(NUM_MOVEMENTS);

        /* Shows the scramble in console */
        byte i;
        for (i = 0; i < NUM_MOVEMENTS; i++) {
            System.out.print(scramble[i]);
            if (i < NUM_MOVEMENTS) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
