package liv.randomfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class which does the reading line by line and ignores the actual
 * opening of the resource.
 *
 * @author Liviu Tudor http://about.me/liviutudor
 */
public class RandomIntReader {
    /** Stream to read data from. */
    private InputStream is;
    /**
     * Array of integer read following the call to {@link #read()}. null until
     * first call.
     */
    private int[]       arr;

    public RandomIntReader(InputStream is) {
        this.is = is;
    }

    /**
     * Does the actual reading. Overwrites {@link #arr}.
     *
     * @throws IOException
     *             if any I/O errors occur or if a line in the file is not an
     *             integer
     */
    public void read() throws IOException {
        this.arr = null; // set to null so we free up memory
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        List<Integer> readLines = new ArrayList<Integer>();
        while ((line = br.readLine()) != null) {
            try {
                readLines.add(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                br.close();
                throw new IOException("Wrong format for integer", e);
            }
        }
        br.close();
        arr = new int[readLines.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = readLines.get(i);
        }
    }

    /**
     * Accessor for {@link #arr}.
     *
     * @return the contents of the array read from the file at previous call to
     *         {@link #read()} or null if the file has never been read
     */
    public int[] getArray() {
        return arr;
    }
}
