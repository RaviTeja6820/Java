import java.util.ArrayList;
import java.util.Arrays;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Reader;
import java.io.StringReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class FileResource {
    private String myPath;
    private String mySource;
    private File mySaveFile;

    public FileResource () {
        initRead();
    }
    
    public FileResource (String filename) {
        initRead(filename);
    }

    
    public String asString () {
        return mySource;
    }

    public CSVParser getCSVParser () {
        return getCSVParser(true);
    }

    public CSVParser getCSVParser (boolean withHeader) {
        return getCSVParser(withHeader, ",");
    }

    public CSVParser getCSVParser (boolean withHeader, String delimiter) {
        if (delimiter == null || delimiter.length() != 1) {
            throw new ResourceException("FileResource: CSV delimiter must be a single character: " + delimiter);
        }
        try {
            char delim = delimiter.charAt(0);
            Reader input = new StringReader(mySource);
            if (withHeader) {
                return new CSVParser(input, CSVFormat.EXCEL.withHeader().withDelimiter(delim));
            }
            else {
                return new CSVParser(input, CSVFormat.EXCEL.withDelimiter(delim));
            }
        }
        catch (Exception e) {
            throw new ResourceException("FileResource: cannot read " + myPath + " as a CSV file.");
        }
    }

    public Iterable<String> getCSVHeaders (CSVParser parser) {
        return parser.getHeaderMap().keySet();
    }


    // Prompt user for file to open
    private void initRead () {
        File f = FileSelector.selectFile();
        if (f == null) {
            throw new ResourceException("FileResource: no file choosen for reading");
        }
        else {
            initRead(f);
        }
    }

    // Create from a given File
    private void initRead (File f) {
        try {
            initRead(f.getCanonicalPath());
        }
        catch (Exception e) {
            throw new ResourceException("FileResource: cannot access " + f);
        }
    }

    // Create from the name of a File
    private void initRead (String fname) {
        try {
            myPath = fname;
            InputStream is = getClass().getClassLoader().getResourceAsStream(fname);
            if (is == null) {
                is = new FileInputStream(fname);
            }
            mySource = initFromStream(is);
        }
        catch (Exception e) {
            throw new ResourceException("FileResource: cannot access " + fname);
        }
    }

    // store data (keep in sync with URLResource)
    private String initFromStream (InputStream stream) {
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            StringBuilder contents = new StringBuilder();
            String line = null;
            while ((line = buff.readLine()) != null) {
                contents.append(line + "\n");
            }
            return contents.toString();
        }
        catch (Exception e) {
            throw new ResourceException("FileResource: error encountered reading " + myPath, e);
        }
        finally {
            try {
                if (buff != null) {
                    buff.close();
                }
            }
            catch (Exception e) {
                // should never happen
            }
        }
    }

}
