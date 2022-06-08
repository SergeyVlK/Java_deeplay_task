package solution;

import java.util.HashMap;
import java.util.Map;

public class AreaPricesCalculator {
    private int[][] pricesMatrixForCurrentRace;
    private Map<Character, Integer> raceId;
    private Map<Character, Integer> areaId;

    public AreaPricesCalculator(char race, int[][] pricesMatrix, char[][] areaMatrix) {
        this.pricesMatrixForCurrentRace = new int[4][4];

        this.raceId = new HashMap<Character, Integer>();
        this.raceId.put('H', 0);
        this.raceId.put('S', 1);
        this.raceId.put('W', 2);

        this.areaId = new HashMap<Character, Integer>();
        this.areaId.put('S', 0);
        this.areaId.put('W', 1);
        this.areaId.put('T', 2);
        this.areaId.put('P', 3);

        this.calculate(race, pricesMatrix, areaMatrix);
    }

    private void calculate(char race, int[][] pricesMatrix, char[][] areaMatrix){
        for(int i = 0 ; i < 4 ; i++ ) {
            for (int j = 0; j < 4; j++)
                this.pricesMatrixForCurrentRace[i][j] = pricesMatrix[this.raceId.get(race)][this.areaId.get(areaMatrix[i][j])];
        }
    }

    public int[][] getMatrix(){
        return this.pricesMatrixForCurrentRace;
    }

    public void printMatrix(){
        for(int i = 0 ; i < 4 ; i++ ) {
            for (int j = 0; j < 4; j++) {
                System.out.print(this.pricesMatrixForCurrentRace[i][j] + " ");
            }
            System.out.println();
        }
    }
}
