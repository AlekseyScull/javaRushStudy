package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fr1 = new FileReader(reader.readLine());
            BufferedReader br = new BufferedReader(fr1);
            while ((line = br.readLine()) != null) {
                allLines.add(line);
            }
            FileReader fr2 = new FileReader(reader.readLine());
            br = new BufferedReader(fr2);
            while ((line = br.readLine()) != null) {
                forRemoveLines.add(line);
            }
            reader.close();
            fr1.close();
            fr2.close();
            br.close();
            new Solution().joinData();
        } catch (Exception e) {
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
