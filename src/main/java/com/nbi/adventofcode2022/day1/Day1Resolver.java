package com.nbi.adventofcode2022.day1;

import com.nbi.adventofcode2022.utils.Utils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Day1Resolver {

    public Integer resolveDay1Step1(String inputStep1) {
        return getSummedQuantity(inputStep1, 1);
    }

    public Integer resolveDay1Step2(String inputStep1) {
        return getSummedQuantity(inputStep1, 3);
    }

    private Integer getSummedQuantity(String inputStep1, int maxSize) {
        List<QuantityByElf> quantityByElves = getQuantityByElves(inputStep1);
        return quantityByElves
                .stream()
                .limit(maxSize)
                .map(QuantityByElf::getQuantity)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private List<QuantityByElf> getQuantityByElves(String inputStep1) {
        List<String> lines = new ArrayList<>();
        lines.add("");
        lines.addAll(Utils.getLines(inputStep1));

        List<QuantityByElf> quantityByElves = new ArrayList<>();
        int elfIdentifier = 0;
        QuantityByElf current = null;

        for (String line : lines) {
            if (!StringUtils.hasLength(line)) {
                current = new QuantityByElf(elfIdentifier++, 0);
                quantityByElves.add(current);
                continue;
            }
            current.setQuantity(current.getQuantity() + Integer.valueOf(line));
        }

        quantityByElves.sort((o1, o2) -> o2.getQuantity().compareTo(o1.getQuantity()));
        return quantityByElves;
    }

    static class QuantityByElf {
        Integer elfIdentifier;
        Integer quantity;

        public QuantityByElf(Integer elfIdentifier, Integer quantity) {
            this.elfIdentifier = elfIdentifier;
            this.quantity = quantity;
        }

        public Integer getElfIdentifier() {
            return elfIdentifier;
        }

        public void setElfIdentifier(Integer elfIdentifier) {
            this.elfIdentifier = elfIdentifier;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }

}
