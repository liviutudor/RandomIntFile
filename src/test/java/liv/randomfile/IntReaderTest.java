package liv.randomfile;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Unit test for {@link IntReader}.
 *
 * @author Liviu Tudor http://about.me/liviutudor
 */
public class IntReaderTest {
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private String getTestFile() throws IOException {
        File f = tempFolder.newFile();
        return f.getAbsolutePath();
    }

    private static void writeFile(String name, int arr[]) throws IOException {
        PrintWriter pw = new PrintWriter(name);
        for (int i = 0; i < arr.length; i++) {
            pw.println(arr[i]);
        }
        pw.flush();
        pw.close();
    }

    @Test
    public void testRead() throws Exception {
        int arr[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String testFile = getTestFile();
        writeFile(testFile, arr);
        IntReader r = new IntReader(testFile);
        r.read();
        int result[] = r.getArray();
        assertEquals(result.length, arr.length);
        assertArrayEquals(result, arr);
    }
}
