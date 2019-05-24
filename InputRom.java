import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class InputRom extends Rom {
    private String path;

    /**
     * @param path Path to Pokémon_Red.GB
     */
    InputRom(String path) {
        super(path);
        this.path=path;
        readGame();
    }

    byte[] readGame() {
        File file = new File(path);
        FileInputStream fis;
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return bArray;
    }
}
