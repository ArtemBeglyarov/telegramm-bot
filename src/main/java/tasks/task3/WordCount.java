package tasks.task3;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
    public static void main(String[] args) {
        splitString("fegwrgwrgfg hdfjkghlkdgkladfkghjklafjg kjafkgj lakdfjgkljadlkfjglkadjglkad");
    }


    public static void splitString(String string) {

        Map<String, Integer> uniqueWords = new HashMap<>();
        String delimiters = "[<> ,.!?/'\";:()\n\r\t\\[\\]-]+";
        String[] s = string.split(delimiters);

        for (String we : s) {
            if (uniqueWords.containsKey(we)) {
                int f = uniqueWords.get(we) + 1;
                uniqueWords.put(we, f);
            } else {
                uniqueWords.put(we, 1);
            }
        }

    }
}
