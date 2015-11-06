package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import model.data.Data;


public class ParserTester {

    static String readFile (String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main (String[] args) throws IOException {
        Data allData = new Data();
        Parser parser = new Parser();
        new Traverser();
        String input =
                readFile("examples/procedures_with_parameters/dash.logo", StandardCharsets.UTF_8);
        // input = "dotimes [ :d 10 ] [ repeat 20 [ fd :d ] rt 2 ]";
        input = "to bleh [ ] [ bleh ] bleh sum 3 4";
        parser.parse(input, allData);
    }
}
