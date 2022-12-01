package com.nbi.adventofcode2022.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void shouldGetLines(){
        List<String> lines = Utils.getLines(getInput());
        Assertions.assertEquals(5, lines.size());
    }

    private String getInput(){
        return """
                1000
                2000
                3000
                                
                4000          
                """;
    }


}