package com.company;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String args[])  {
        try {
            String URLS_FILE_NAME = "urls.txt";
            String WORDS_FILE_NAME = "words.txt";

            File urlsFile = new File(URLS_FILE_NAME);
            if (urlsFile.exists() == false) {
                System.out.println("Please Create File for urls");
                return;
            }
            RandomAccessFile urlsRandomAccessFile = new RandomAccessFile(urlsFile, "rw");
            if (urlsRandomAccessFile.length() == 0) {
                urlsRandomAccessFile.close();
                System.out.println("Please write urls in file");
                return;
            }
            File wordsFile = new File(WORDS_FILE_NAME);
            if (wordsFile.exists() == false) {
                System.out.println("Please Create File for words");
                return;
            }
            RandomAccessFile wordsRandomAccessFile = new RandomAccessFile(wordsFile, "rw");
            if (wordsRandomAccessFile.length() == 0) {
                wordsRandomAccessFile.close();
                System.out.println("Please write words in file");
                return;
            }
            Set<String> wordsSet = new HashSet<String>();
            while (wordsRandomAccessFile.getFilePointer() < wordsRandomAccessFile.length()) {
                wordsSet.add(wordsRandomAccessFile.readLine());
            }
            String urlString;

            Map<String, Integer> hashMap = new HashMap<String, Integer>();
            System.out.println("=================================");
            while (urlsRandomAccessFile.getFilePointer() < urlsRandomAccessFile.length()) {
                StringBuffer sb = new StringBuffer();
                urlString = urlsRandomAccessFile.readLine();
                URL url = new URL(urlString);
                Scanner sc = new Scanner(url.openStream());
                System.out.println(urlString);
                while (sc.hasNext()) {
                    sb.append(sc.next());
                    sb.append("  ");
                    //System.out.println(sc.next());
                }

                String result = sb.toString();

                result = result.replaceAll("<[^>]*>", "");
                // System.out.println(result);
                Map<String, Integer> individualHashMap = new HashMap<String, Integer>();
                Map<String, Integer> wordsHashMap = new HashMap<>(); // this map only contains that words which is present in text file

                String[] words = result.split(" ");

                for (String word : words) {

                    Integer integer = individualHashMap.get(word);

                    if (integer == null)

                        individualHashMap.put(word, 1);

                    else {

                        individualHashMap.put(word, integer + 1);
                    }
                }

                for (String word : wordsSet) {
                    Integer integer = individualHashMap.get(word);
                    if (integer != null) {


                        Integer i = hashMap.get(word);

                        if (i == null)

                            hashMap.put(word, integer);

                        else {

                            hashMap.put(word, integer + i);
                        }
                        wordsHashMap.put(word, integer);
                    }


                }
                wordsHashMap = sortByValue(wordsHashMap);
                int i = 0;
                for (Map.Entry<String, Integer> entry : wordsHashMap.entrySet()) {

                    System.out.println(entry.getKey() + " - " + entry.getValue());
                    i++;
                    if (i == 3) break;

                }

            }
            System.out.println("=================================");
            hashMap = sortByValue(hashMap);
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {

                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }catch (Exception e)
        {
            System.out.println("Some Error please check text Files");
        }
    }
    // this method is created for sorting map
    public static Map<String, Integer> sortByValue(final Map<String, Integer> wordCounts) {

        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}