package solution;

import java.io.*;

public class TableReader {
    private int[][] pricesMatrix;
    private File tableFile;

    public TableReader(String tableFilePath){
        this.tableFile = new File(Main.class.getClassLoader().getResource(tableFilePath).getFile());
        this.pricesMatrix = new int[4][4];
        this.readFile();
    }

    private void readFile() {
        try {
            FileReader fr = new FileReader(this.tableFile);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String[] line;
            for( int i = 0 ; i < 3 ; i++) {
                line = reader.readLine().split(" ");
                for( int j = 0 ; j < 4 ; j++)
                    this.pricesMatrix[i][j] = Integer.parseInt(line[j]);
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
    }

    public int[][] getMatrix(){
        return this.pricesMatrix;
    }

    public void printMatrix(){
        for( int i = 0 ; i < this.pricesMatrix.length ; i++ ) {
            for (int j = 0; j < this.pricesMatrix[i].length; j++)
                System.out.print(this.pricesMatrix[i][j] + " ");
            System.out.println();
        }
    }
}
