package solution;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        char[][] areaMatrix = new char[4][4];
        char race = '0';
        File areaFile = new File(Main.class.getClassLoader().getResource("areas/1.txt").getFile());
        try(FileReader reader = new FileReader(areaFile))
        {
            for( int i = 0 ; i < 4 ; i++)
                for( int j = 0 ; j < 4 ; j++ )
                    areaMatrix[i][j] = (char)reader.read();
            reader.read();
            race = (char)reader.read();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        for(int i = 0 ; i < 4 ; i++ ) {
            for (int j = 0; j < 4; j++ )
                System.out.print(areaMatrix[i][j] + " ");
            System.out.println();
        }
        System.out.println("race: " + race);




        System.out.println();

        int[][] pricesMatrix = new int[3][4];
        File tableFile = new File(Main.class.getClassLoader().getResource("tables/1.txt").getFile());
        try {
            FileReader fr = new FileReader(tableFile);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String[] line;
            for( int i = 0 ; i < 3 ; i++) {
                line = reader.readLine().split(" ");
                for( int j = 0 ; j < 4 ; j++)
                    pricesMatrix[i][j] = Integer.parseInt(line[j]);
            }
            reader.close();
            fr.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for( int i = 0 ; i < pricesMatrix.length ; i++ ) {
            for (int j = 0; j < pricesMatrix[i].length; j++)
                System.out.print(pricesMatrix[i][j] + " ");
            System.out.println();
        }

        // Все прочитано из файлов

        int[][] pricesMatrixForCurrentRace = new int[4][4];
        int raceId;
        switch (race) {
            case ('H'):
                raceId = 0;
                break;
            case ('S'):
                raceId = 1;
                break;
            case ('W'):
                raceId = 2;
                break;
            default:
                try {
                    throw new Exception();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('S', 0);
        map.put('W', 1);
        map.put('T', 2);
        map.put('P', 3);

        System.out.println();
        for(int i = 0 ; i < 4 ; i++ ) {
            for (int j = 0; j < 4; j++) {
                pricesMatrixForCurrentRace[i][j] = pricesMatrix[raceId][map.get(areaMatrix[i][j])];
                System.out.print(pricesMatrixForCurrentRace[i][j] + " ");
            }
            System.out.println();
        }


        int rightPrice;
        int downPrice;
        int[][] way = new int[4][4];
        for(int i = 0 ; i < 4 ; i++)
            for(int j = 0 ; j < 4 ; j++)
                way[i][j] = Integer.MAX_VALUE;
        way[0][0] = 0;
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                rightPrice = Integer.MAX_VALUE;
                downPrice = Integer.MAX_VALUE;
                if(j < 3) {
                    rightPrice = pricesMatrixForCurrentRace[i][j + 1];
                    way[i][j+1] = Integer.min(way[i][j] + rightPrice , way[i][j+1]);
                }

                if(i < 3) {
                    downPrice = pricesMatrixForCurrentRace[i + 1][j];
                    way[i+1][j] = Integer.min(way[i][j] + downPrice , way[i+1][j]);
                }
            }
        }

        System.out.println("\n\n");
        System.out.println(way[3][3]);

//        int result;
//        result = Solution.getResult();
//        System.out.println("Минимальные затраты на перемещение: " + result);
    }
}
