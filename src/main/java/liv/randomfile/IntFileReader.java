package liv.randomfile;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Utility class used to read files generated by {@link IntGenerator}.
 *
 * @author Liviu Tudor http://about.me/liviutudor
 */
public class IntFileReader extends RandomIntReader {
    /** Name of the file to read from. */
    private String file;

    /**
     * Constructor. Simply initializes the file name and sets array to null.
     * Doesn't perform any reading however it opens the file.
     *
     * @param file
     *            Name of the file will read from
     */
    public IntFileReader(String file) throws IOException {
        super(new FileInputStream(file));
    }

    public String getFile() {
        return file;
    }
}