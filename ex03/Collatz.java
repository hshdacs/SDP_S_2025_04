package ex03;

public class Collatz {
    public static void main(String[] args) {

        final int MAX_COLLATZ_NUMBER = 100_000_000;
        int[] memory = new int[ MAX_COLLATZ_NUMBER ];
        
        int longestSequence = 0;
        int longestSequenceN = 0;

        long timeStart = System.currentTimeMillis();
        for (int i = 2; i < MAX_COLLATZ_NUMBER; i++) {
            long n = i;
            int sequenceLength = 0;

            while (n != 1) {
                if (n < i) {
                    sequenceLength += memory[ (int)n ];
                    break; // yeah, we're done
                }

                sequenceLength++;
                if (n % 2 == 0) {
                    n /= 2;
                }
                else {
                    n = 3*n + 1;
                }
            }
            memory[ (int)i ] = sequenceLength;

            if (sequenceLength > longestSequence) {
                longestSequence = sequenceLength;
                longestSequenceN = i;
            }
        }
        long timeStop = System.currentTimeMillis();
        long diffTime = timeStop - timeStart;

        System.out.println("Longest sequence found:");
        System.out.println(longestSequenceN + " with " +
            longestSequence + " steps");
        System.out.println(diffTime + "ms");
    }
}
