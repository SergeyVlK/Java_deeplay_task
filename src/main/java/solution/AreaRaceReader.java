package solution;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AreaRaceReader {
    private char[][] areaMatrix;
    private char race;
    private File areaFile;

    public AreaRaceReader(String areaFilePath) {
        this.areaFile = new File(Main.class.getClassLoader().getResource(areaFilePath).getFile());
        this.areaMatrix = new char[4][4];
        this.race = '0';
        this.readFile();
    }

    private void readFile() {
        try(FileReader reader = new FileReader(this.areaFile))
        {
            for( int i = 0 ; i < 4 ; i++)
                for( int j = 0 ; j < 4 ; j++ )
                    this.areaMatrix[i][j] = (char)reader.read();
            reader.read();
            this.race = (char)reader.read();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void printMatrix(){
        for(int i = 0 ; i < 4 ; i++ ) {
            for (int j = 0; j < 4; j++ )
                System.out.print(this.areaMatrix[i][j] + " ");
            System.out.println();
        }
    }

    private void printRace(){
        System.out.println("race: " + this.race);
    }
    public char[][] getMatrix() {
        return this.areaMatrix;
    }
    public char getRace() {
        return this.race;
    }
}
