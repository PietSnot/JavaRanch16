/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TreeMap;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Piet
 */
public class MarcRichardson {
    
   public static void main(String... args) {
        new MarcRichardson().go();
    }
    
    private void go() {
        var input = getInput();
        if (input == null) throw new RuntimeException("Can't read inputfile");
        var dateMap = input.stream().collect(
            groupingBy(
                LocalDateTime::toLocalDate, 
                TreeMap::new, 
                toList()
            )
        );
        dateMap.entrySet().forEach(System.out::println);
        System.out.println(dateMap.values().stream().mapToInt(List::size).sum());
    }
    
    private List<LocalDateTime> getInput() {
        var dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        var p = Paths.get("D:\\JavaProgs", "DatesInEenRaarFormaat.txt");
        try (var stream = Files.lines(p)) {
            return stream.map(s -> LocalDateTime.from(dtf.parse(s))).collect(toList());
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}