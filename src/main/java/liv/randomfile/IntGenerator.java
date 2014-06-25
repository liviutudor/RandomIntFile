package liv.randomfile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Class used to generate a text file with randomly generated integers.
 *
 * @author Liviu Tudor http://about.me/liviutudor
 */
public class IntGenerator {
    /**
     * Default number of integers generated if nothing specified in command
     * line.
     */
    public static final int DEFAULT_N = 1000000;

    /** Default min value to be used if nothing specified in the command line. */
    public static final int MIN_INT   = 0;

    /** Default max value to be used if nothing specified in the command line. */
    public static final int MAX_INT   = Integer.MAX_VALUE;

    private String          outputFile;
    private int             n;
    private int             min;
    private int             max;

    public IntGenerator(String outputFile, int n, int min, int max) {
        this.outputFile = outputFile;
        this.n = n;
        this.min = min;
        this.max = max;
    }

    private static void printHelpExit() {
        System.out.println("java IntGenerator output-file [number-of-integers [min] [max]]");
        System.exit(1);
    }

    private static int readIntOrShowHelpAndExit(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            printHelpExit();
            return 0; // never to be reached!
        }
    }

    /**
     * Program entry point. Supports up to 4 parameters:
     * <code>java IntGenerator OutputFile.txt [number of integers [min] [max]]</code>
     * . If <code>number of integers</code> is not specified, it is assumed to
     * be 1,000,000. If <code>min</code> and <code>max</code> are missing they
     * are assumed to be 0 and <code>Integer.MAX_INTEGER</code> respectively.
     *
     * @param args
     *            Command line arguments. See above.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            printHelpExit();
        }
        String outputFile = args[0];
        int n = DEFAULT_N;
        int min = MIN_INT;
        int max = MAX_INT;
        if (args.length == 2) {
            // n specified
            n = readIntOrShowHelpAndExit(args[1]);
        } else if (args.length == 4) {
            // min and max specified
            min = readIntOrShowHelpAndExit(args[2]);
            max = readIntOrShowHelpAndExit(args[3]);
        } else if (args.length != 1) {
            printHelpExit();
        }

        // now construct the object and go
        IntGenerator ig = new IntGenerator(outputFile, n, min, max);
        try {
            ig.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

    /**
     * Generates the actual file with the random integers.
     *
     * @throws IOException
     *             if any I/O errors occur
     */
    public void writeFile() throws IOException {
        PrintWriter pw = new PrintWriter(new File(outputFile));
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            int generated = min + (r.nextInt(max - min));
            pw.println(generated);
        }
        pw.flush();
        pw.close();
    }
}
