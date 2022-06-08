package solution;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        AreaRaceReader areaRaceReader = new AreaRaceReader("areas/1.txt");
        char[][] areaMatrix = areaRaceReader.getMatrix();
        char race = areaRaceReader.getRace();

        TableReader tableReader = new TableReader("tables/1.txt");

        int[][] pricesMatrix = tableReader.getMatrix();

        // Все прочитано из файлов

        AreaPricesCalculator areaPricesCalculator = new AreaPricesCalculator(race, pricesMatrix, areaMatrix);

        int[][] pricesMatrixForCurrentRace = areaPricesCalculator.getMatrix();

        System.out.println(Solution.getResult(pricesMatrixForCurrentRace));

    }
}
