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
            FileReader reader = null;
            try {
            reader = new FileReader(this.tableFile);
            } catch (FileNotFoundException e) {
                System.out.println("File \"" + this.tableFile.getName() + "\"  not found or does not exist!");
                throw new RuntimeException(e);
            }

            BufferedReader bufferedReader = new BufferedReader(reader);
            String[] line;
            for( int i = 0 ; i < 3 ; i++) {
                line = bufferedReader.readLine().split(" ");
                if(line.length != 4){
                    System.out.println("String " + i + " does not contain 4 numbers");
                    throw new RuntimeException("String " + i + " does not contain 4 numbers");
                }
                for( int j = 0 ; j < 4 ; j++)
                    this.pricesMatrix[i][j] = Integer.parseInt(line[j]);
            }
            bufferedReader.close();
            reader.close();
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
