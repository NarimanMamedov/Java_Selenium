package gui.utils;

import com.fasterxml.jackson.databind.ObjectMapper;;
import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;

public class JsonFileReader {
    private static final Logger log = Logger.getLogger(String.valueOf(JsonFileReader.class));

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T readJsonFile(String path, Class <T> destinationObject){
        try {
            log.info("Read JSON file with test data. File path: " + path);
            File file = new File(path);
            if (!file.exists() || file.isDirectory()){
                log.error("Can't find data file. File path: "+ path);
                throw new IOException("File doesn`t exist");
            }
            return mapper.readValue(file, destinationObject);
        }catch (IOException e){
            log.error("Can't find data file. Error: " + e.getMessage());
        }
        return null;
    }
}
