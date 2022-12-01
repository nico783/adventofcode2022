package com.nbi.adventofcode2022.day1;

import com.nbi.adventofcode2022.utils.Utils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1Resolver {


    public Integer resolveDay1Step1(String inputStep1) {
        List<QuantityByElf> quantityByElves = getQuantityByElves(inputStep1);

        return quantityByElves.get(0).quantity;
    }

    public Integer resolveDay1Step2(String inputStep1) {
        List<QuantityByElf> quantityByElves = getQuantityByElves(inputStep1);

        return quantityByElves.get(0).quantity + quantityByElves.get(1).quantity + quantityByElves.get(2).quantity;
    }

    private List<QuantityByElf> getQuantityByElves(String inputStep1) {
        List<String> lines = Utils.getLines(inputStep1);
        List<QuantityByElf> quantityByElves = new ArrayList<>();
        int elfIdentifier = 0;
        boolean first = true;
        QuantityByElf current = null;
        for (String line : lines) {
            if (first) {
                current = new QuantityByElf(elfIdentifier++, 0);
                quantityByElves.add(current);
            }
            if (!StringUtils.hasLength(line)) {
                current = new QuantityByElf(elfIdentifier++, 0);
                quantityByElves.add(current);
                continue;
            }
            current.setQuantity(current.getQuantity() + Integer.valueOf(line));
            first = false;
        }

        quantityByElves.sort((o1, o2) -> o2.getQuantity().compareTo(o1.getQuantity()));
        return quantityByElves;
    }

    class QuantityByElf {
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
