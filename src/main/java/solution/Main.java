package solution;

import java.io.*;
import java.util.Arrays;

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




//        int result;
//        result = Solution.getResult();
//        System.out.println("Минимальные затраты на перемещение: " + result);
    }
}
