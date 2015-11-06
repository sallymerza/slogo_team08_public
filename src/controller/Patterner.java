package controller;

import java.io.File;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class Patterner extends ControlFunctions {
    private final String RESOURCES_PATH = "src/resources/languages/";
    private final String DEFAULT_RESOURCES = "resources/languages/";

    private List<Entry<String, Pattern>> patterns;

    public Patterner () {
        initPattern();
    }

    private void initPattern () {
        patterns = new ArrayList<>();
        File[] folder = new File(RESOURCES_PATH).listFiles();
        for (File f : folder) {
            patterns.addAll(makePatterns(DEFAULT_RESOURCES + f.getName().split("\\.")[0]));
        }
    }

    public List<Entry<String, Pattern>> getPatterns () {
        return patterns;
    }

    private List<Entry<String, Pattern>> makePatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        List<Entry<String, Pattern>> patterns = new ArrayList<>();
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            patterns.add(new SimpleEntry<String, Pattern>(key,
                                                          // THIS IS THE KEY LINE
                                                          Pattern.compile(regex,
                                                                          Pattern.CASE_INSENSITIVE)));
        }
        return patterns;
    }

    private boolean match (String input, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(input).matches();
        // basic strings can match also, but not using a Pattern (thus not
        // ignore case)
        // return input.matches(regex);
    }

    public List<String[]> matchSplitCommand (String[] tests,
                                             List<Entry<String, Pattern>> patterns) {
        List<String[]> tempList = new ArrayList<>();
        for (String s : tests) {
            boolean matched = false;
            if (s.trim().length() > 0) {
                for (Entry<String, Pattern> p : patterns) {
                    if (match(s, p.getValue())) {
                        // System.out.println(String.format("%s matches %s", s,
                        // p.getKey()));
                        String[] tempArray = { s, p.getKey() };
                        tempList.add(tempArray);
                        matched = true;
                        break;
                    }
                }
                if (!matched) {
                    // TODO error
                    // System.out.println(String.format("%s not matched", s));
                }
            }
        }
        return tempList;
    }

}
