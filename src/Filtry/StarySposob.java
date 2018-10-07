package Filtry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class StarySposob {

    public static void main(String[] args) {
        List<String> lines = Arrays.asList("adam", "coraz", "mlodszy");
        List<String> result = getFilterOutput(lines, "mlodszy");
        for (String temp : result) {
            System.out.println(temp);    //output : spring, node
        }
    }
    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"mlodszy".equals(line)) { // nie chce mlodszego  ("mlodszy.equals(line) chce mlodszego
                result.add(line);
            }
        }
        return result;
    }
}