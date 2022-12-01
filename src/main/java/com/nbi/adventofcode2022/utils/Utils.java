package com.nbi.adventofcode2022.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> getLines(String s) {
        return s.lines().collect(Collectors.toList());
    }

}
