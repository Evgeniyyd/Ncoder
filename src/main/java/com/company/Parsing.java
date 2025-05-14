package com.company;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {
    @SneakyThrows
    public void pars() {
        ConsoleHelper.writeMessage("Введите адрес к файлу для его разшифровке");
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите адрес файла для набора статистики");
        String statistic = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, "_parsing");
        Map<Character, Integer> mapEncrypted = fiilMap(src);
        Map<Character, Integer> mapStatistic = fiilMap(statistic);
        List<Map.Entry<Character, Integer>> listEncrypted = mapToList(mapEncrypted);
        List<Map.Entry<Character, Integer>> listStatistic = mapToList(mapStatistic);
        Map<Character, Character> mapDecrypted = new HashMap<>();

        if (listEncrypted.size() <= listStatistic.size()) {
            for (int i = 0; i < listEncrypted.size(); i++) {
                mapDecrypted.put(listEncrypted.get(i).getKey(), listStatistic.get(i).getKey());
            }
            try (FileReader fileReader = new FileReader(src);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
                while (bufferedReader.ready()) {
                    String string = bufferedReader.readLine();
                    char[] array = string.toCharArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < array.length; i++) {
                        Character character = mapDecrypted.get(array[i]);
                        stringBuilder.append(character);
                    }
                    bufferedWriter.write(stringBuilder.toString());
                    bufferedWriter.newLine();
                }

            }


        } else {
            ConsoleHelper.writeMessage("Размера файла статистики не достаточно для разшифровки");
        }

    }

    private List<Map.Entry<Character, Integer>> mapToList(Map<Character, Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {

                return o2.getValue() - o1.getValue();
            }
        };
        list.sort(comparator);
        return list;
    }

    @SneakyThrows
    private Map<Character, Integer> fiilMap(String path) {
        Map<Character, Integer> map = new HashMap<>();
        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                char[] array = string.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    if (!map.containsKey(array[i])) {
                        map.put(array[i], 1);
                    } else {
                        Integer value = map.get(array[i]);
                        map.put(array[i], value + 1);
                    }

                }
            }

        }
        return map;
    }
}
// выписать все методы колекции map, listArray утилитарные классы
// выписать методы класса стринг, Character,