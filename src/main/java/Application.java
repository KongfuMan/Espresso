import espresso.syntax.EspressoCompiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        String script = readTextFile(args[0]);
        EspressoCompiler compiler = new EspressoCompiler();
        compiler.compile(script);
    }

    private static String readTextFile(String pathName) throws IOException {
        StringBuffer buffer = new StringBuffer();
        try (FileReader reader = new FileReader(pathName);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line).append('\n');
            }
        }
        return buffer.toString();
    }
}
