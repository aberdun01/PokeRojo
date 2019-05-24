import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

class OutputRom extends Rom {
    private String path;
    private byte[] romData;

    /**
     * @param path Path to modified Pokémon red
     */
    OutputRom(String path, byte[] romData) {
        super(path);
        this.path = path;
        this.romData = romData;
        modifyRom();
        writeRom();
    }

    private void modifyRom(){
        Data data = new Data();
        HashMap<String, Integer> offsetPointer = data.getOffsetHashMap();
        HashMap<String, Byte> pkmnData =  data.getPkmnHashMap();

        //Set Pokémon to Prof.OAK starters
        if(romData[offsetPointer.get("starter1")] == pkmnData.get("Charmander")){
            romData[offsetPointer.get("starter1")] = pkmnData.get("Charmander");
        }

        if(romData[offsetPointer.get("starter2")] == pkmnData.get("Squirtle")){
            romData[offsetPointer.get("starter2")] = pkmnData.get("Squirtle");
        }

        if(romData[offsetPointer.get("starter3")] == pkmnData.get("Bulbasaur")){
            romData[offsetPointer.get("starter3")] = pkmnData.get("Bulbasaur");
        }

        //Set Pokémon to rival first battle
        if(romData[offsetPointer.get("rivalBattle1starter1")] == pkmnData.get("Squirtle")){
            romData[offsetPointer.get("rivalBattle1starter1")] = romData[offsetPointer.get("starter2")];
        }

        if(romData[offsetPointer.get("rivalBattle1starter2")] == pkmnData.get("Bulbasaur")){
            romData[offsetPointer.get("rivalBattle1starter2")] = romData[offsetPointer.get("starter3")];
        }

        if(romData[offsetPointer.get("rivalBattle1starter3")] == pkmnData.get("Charmander")){
            romData[offsetPointer.get("rivalBattle1starter3")] = romData[offsetPointer.get("starter1")];
        }
    }

    private void writeRom() {
        try {
            File fileOut = new File(path);
            OutputStream os = new FileOutputStream(fileOut);
            os.write(romData);
            os.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
