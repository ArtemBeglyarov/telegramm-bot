package tasks.task3;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\abeglyarov\\Documents\\ProjectForMickroTask\\src\\main\\resourses\\task3text");
        String delimiters = "[<> =,.!?/'\";:()\n\r\t\\[\\]-]+";

        Files.lines(Paths.get(file.getAbsolutePath())).flatMap(x -> Stream.of(x.split(delimiters)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);


        
//        try (InputStream inputStream = new FileInputStream(file)) {
//            splitString(IOUtils.toString(inputStream, "utf-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private static void splitString(String string) {
//
//        String delimiters = "[<> =,.!?/'\";:()\n\r\t\\[\\]-]+";
//        Stream.of(string.split(delimiters))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new))
//                .forEach((x, y) -> System.out.println(x + "  " + y));
    }
}
