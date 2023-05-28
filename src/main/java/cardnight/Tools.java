package cardnight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Tools {
    public static String readFile(String resourcePath) {
        try (InputStream in = Tools.class.getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
             return reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
