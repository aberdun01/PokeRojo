import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        File inputGamePath = new File("");
        File outputGamePath = new File("");

        byte[] gameArray = readGame(inputGamePath);
        modifyGame(gameArray);
        writeGame(outputGamePath, gameArray);
    }

    private static void modifyGame(byte[] gameArray) {
        HashMap<String, Byte> pkmnDecimalValue = populateHM();

        //Offsets
        int starter1=119054;
        int starter2=119071;
        int starter3=119088;
        int rivalBattle1starter1=238066;
        int rivalBattle1starter2=238069;
        int rivalBattle1starter3=238072;

        //Set Pokémon to Prof.OAK starters
        gameArray[starter1] = pkmnDecimalValue.get("Charmander");
        gameArray[starter2] = pkmnDecimalValue.get("Squirtle");
        gameArray[starter3] = pkmnDecimalValue.get("Bulbasaur");

        //Set Pokémon to rival first battle
        gameArray[rivalBattle1starter1] = gameArray[starter2];
        gameArray[rivalBattle1starter2] = gameArray[starter3];
        gameArray[rivalBattle1starter3] = gameArray[starter1];
    }

    private static void writeGame(File fileOut, byte[] romArray) {
        try {
            OutputStream os = new FileOutputStream(fileOut);
            os.write(romArray);
            os.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param file Path to Pokémon_Red.GB
     */
    private static byte[] readGame(File file) {
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

    /**
     * @return HashMap with Pokémon name & decimal value
     */
    private static HashMap<String, Byte> populateHM() {
        HashMap<String, Byte> pkmnDecimalValue = new HashMap<>();
        pkmnDecimalValue.put("'M",(byte) 0);
        pkmnDecimalValue.put("Rhydon", (byte) 1);
        pkmnDecimalValue.put("Kangaskhan", (byte) 2);
        pkmnDecimalValue.put("NidoranM", (byte) 3);
        pkmnDecimalValue.put("Clefairy", (byte) 4);
        pkmnDecimalValue.put("Spearow", (byte) 5);
        pkmnDecimalValue.put("Voltorb", (byte) 6);
        pkmnDecimalValue.put("Nidoking", (byte) 7);
        pkmnDecimalValue.put("Slowbro", (byte) 8);
        pkmnDecimalValue.put("Ivysaur", (byte) 9);
        pkmnDecimalValue.put("Exeggutor", (byte) 10);
        pkmnDecimalValue.put("Lickitung", (byte) 11);
        pkmnDecimalValue.put("Exeggcute", (byte) 12);
        pkmnDecimalValue.put("Grimer", (byte) 13);
        pkmnDecimalValue.put("Gengar", (byte) 14);
        pkmnDecimalValue.put("NidoranF", (byte) 15);
        pkmnDecimalValue.put("Nidoqueen", (byte) 16);
        pkmnDecimalValue.put("Cubone", (byte) 17);
        pkmnDecimalValue.put("Rhyhorn", (byte) 18);
        pkmnDecimalValue.put("Lapras", (byte) 19);
        pkmnDecimalValue.put("Arcanine", (byte) 20);
        pkmnDecimalValue.put("Mew", (byte) 21);
        pkmnDecimalValue.put("Gyarados", (byte) 22);
        pkmnDecimalValue.put("Shellder", (byte) 23);
        pkmnDecimalValue.put("Tentacool", (byte) 24);
        pkmnDecimalValue.put("Gastly", (byte) 25);
        pkmnDecimalValue.put("Scyther", (byte) 26);
        pkmnDecimalValue.put("Staryu", (byte) 27);
        pkmnDecimalValue.put("Blastoise", (byte) 28);
        pkmnDecimalValue.put("Pinsir", (byte) 29);
        pkmnDecimalValue.put("Tangela", (byte) 30);
        pkmnDecimalValue.put("MissingNo.", (byte) 31);
        pkmnDecimalValue.put("Growlithe", (byte) 33);
        pkmnDecimalValue.put("Onix", (byte) 34);
        pkmnDecimalValue.put("Fearow", (byte) 35);
        pkmnDecimalValue.put("Pidgey", (byte) 36);
        pkmnDecimalValue.put("Slowpoke", (byte) 37);
        pkmnDecimalValue.put("Kadabra", (byte) 38);
        pkmnDecimalValue.put("Graveler", (byte) 39);
        pkmnDecimalValue.put("Chansey", (byte) 40);
        pkmnDecimalValue.put("Machoke", (byte) 41);
        pkmnDecimalValue.put("Mr.Mime", (byte) 42);
        pkmnDecimalValue.put("Hitmonlee", (byte) 43);
        pkmnDecimalValue.put("Hitmonchan", (byte) 44);
        pkmnDecimalValue.put("Arbok", (byte) 45);
        pkmnDecimalValue.put("Parasect", (byte) 46);
        pkmnDecimalValue.put("Psyduck", (byte) 47);
        pkmnDecimalValue.put("Drowzee", (byte) 48);
        pkmnDecimalValue.put("Golem", (byte) 49);
        pkmnDecimalValue.put("Magmar", (byte) 51);
        pkmnDecimalValue.put("Electabuzz", (byte) 53);
        pkmnDecimalValue.put("Magneton", (byte) 54);
        pkmnDecimalValue.put("Koffing", (byte) 55);
        pkmnDecimalValue.put("Mankey", (byte) 57);
        pkmnDecimalValue.put("Seel", (byte) 58);
        pkmnDecimalValue.put("Diglett", (byte) 59);
        pkmnDecimalValue.put("Tauros", (byte) 60);
        pkmnDecimalValue.put("Farfetch'd", (byte) 64);
        pkmnDecimalValue.put("Venonat", (byte) 65);
        pkmnDecimalValue.put("Dragonite", (byte) 66);
        pkmnDecimalValue.put("Doduo", (byte) 70);
        pkmnDecimalValue.put("Poliwag", (byte) 71);
        pkmnDecimalValue.put("Jynx", (byte) 72);
        pkmnDecimalValue.put("Moltres", (byte) 73);
        pkmnDecimalValue.put("Articuno", (byte) 74);
        pkmnDecimalValue.put("Zapdos", (byte) 75);
        pkmnDecimalValue.put("Ditto", (byte) 76);
        pkmnDecimalValue.put("Meowth", (byte) 77);
        pkmnDecimalValue.put("Vulpix", (byte) 82);
        pkmnDecimalValue.put("Ninetales", (byte) 83);
        pkmnDecimalValue.put("Pikachu", (byte) 84);
        pkmnDecimalValue.put("Raichu", (byte) 85);
        pkmnDecimalValue.put("Dratini", (byte) 88);
        pkmnDecimalValue.put("Dragonair", (byte) 89);
        pkmnDecimalValue.put("Kabuto", (byte) 90);
        pkmnDecimalValue.put("Kabutops", (byte) 91);
        pkmnDecimalValue.put("Horsea", (byte) 92);
        pkmnDecimalValue.put("Seadra", (byte) 93);
        pkmnDecimalValue.put("Sandshrew", (byte) 96);
        pkmnDecimalValue.put("Sandslash", (byte) 97);
        pkmnDecimalValue.put("Omanyte", (byte) 98);
        pkmnDecimalValue.put("Omastar", (byte) 99);
        pkmnDecimalValue.put("Jigglypuff", (byte) 100);
        pkmnDecimalValue.put("Wigglytuff", (byte) 101);
        pkmnDecimalValue.put("Eevee", (byte) 102);
        pkmnDecimalValue.put("Flareon", (byte) 103);
        pkmnDecimalValue.put("Jolteon", (byte) 104);
        pkmnDecimalValue.put("Vaporeon", (byte) 105);
        pkmnDecimalValue.put("Machop", (byte) 106);
        pkmnDecimalValue.put("Zubat", (byte) 107);
        pkmnDecimalValue.put("Ekans", (byte) 108);
        pkmnDecimalValue.put("Paras", (byte) 109);
        pkmnDecimalValue.put("Poliwhirl", (byte) 110);
        pkmnDecimalValue.put("Poliwrath", (byte) 111);
        pkmnDecimalValue.put("Weedle", (byte) 112);
        pkmnDecimalValue.put("Kakuna", (byte) 113);
        pkmnDecimalValue.put("Beedrill", (byte) 114);
        pkmnDecimalValue.put("Dodrio", (byte) 116);
        pkmnDecimalValue.put("Primeape", (byte) 117);
        pkmnDecimalValue.put("Dugtrio", (byte) 118);
        pkmnDecimalValue.put("Venomoth", (byte) 119);
        pkmnDecimalValue.put("Dewgong", (byte) 120);
        pkmnDecimalValue.put("Caterpie", (byte) 123);
        pkmnDecimalValue.put("Metapod", (byte) 124);
        pkmnDecimalValue.put("Butterfree", (byte) 125);
        pkmnDecimalValue.put("Machamp", (byte) 126);
        pkmnDecimalValue.put("Golduck", (byte) 128);
        pkmnDecimalValue.put("Hypno", (byte) 129);
        pkmnDecimalValue.put("Golbat", (byte) 130);
        pkmnDecimalValue.put("Mewtwo", (byte) 131);
        pkmnDecimalValue.put("Snorlax", (byte) 132);
        pkmnDecimalValue.put("Magikarp", (byte) 133);
        pkmnDecimalValue.put("Muk", (byte) 136);
        pkmnDecimalValue.put("Kingler", (byte) 138);
        pkmnDecimalValue.put("Cloyster", (byte) 139);
        pkmnDecimalValue.put("Electrode", (byte) 141);
        pkmnDecimalValue.put("Clefable", (byte) 142);
        pkmnDecimalValue.put("Weezing", (byte) 143);
        pkmnDecimalValue.put("Persian", (byte) 144);
        pkmnDecimalValue.put("Marowak", (byte) 145);
        pkmnDecimalValue.put("Haunter", (byte) 147);
        pkmnDecimalValue.put("Abra", (byte) 148);
        pkmnDecimalValue.put("Alakazam", (byte) 149);
        pkmnDecimalValue.put("Pidgeotto", (byte) 150);
        pkmnDecimalValue.put("Pidgeot", (byte) 151);
        pkmnDecimalValue.put("Starmie", (byte) 152);
        pkmnDecimalValue.put("Bulbasaur", (byte) 153);
        pkmnDecimalValue.put("Venusaur", (byte) 154);
        pkmnDecimalValue.put("Tentacruel", (byte) 155);
        pkmnDecimalValue.put("Goldeen", (byte) 157);
        pkmnDecimalValue.put("Seaking", (byte) 158);
        pkmnDecimalValue.put("Ponyta", (byte) 163);
        pkmnDecimalValue.put("Rapidash", (byte) 164);
        pkmnDecimalValue.put("Rattata", (byte) 165);
        pkmnDecimalValue.put("Raticate", (byte) 166);
        pkmnDecimalValue.put("Nidorino", (byte) 167);
        pkmnDecimalValue.put("Nidorina", (byte) 168);
        pkmnDecimalValue.put("Geodude", (byte) 169);
        pkmnDecimalValue.put("Porygon", (byte) 170);
        pkmnDecimalValue.put("Aerodactyl", (byte) 171);
        pkmnDecimalValue.put("Magnemite", (byte) 173);
        pkmnDecimalValue.put("Charmander", (byte) 176);
        pkmnDecimalValue.put("Squirtle", (byte) 177);
        pkmnDecimalValue.put("Charmeleon", (byte) 178);
        pkmnDecimalValue.put("Wartortle", (byte) 179);
        pkmnDecimalValue.put("Charizard", (byte) 180);
        pkmnDecimalValue.put("Ghost", (byte) 184);
        pkmnDecimalValue.put("Oddish", (byte) 185);
        pkmnDecimalValue.put("Gloom", (byte) 186);
        pkmnDecimalValue.put("Vileplume", (byte) 187);
        pkmnDecimalValue.put("Bellsprout", (byte) 188);
        pkmnDecimalValue.put("Weepinbell", (byte) 189);
        pkmnDecimalValue.put("Victreebel", (byte) 190);
        return pkmnDecimalValue;
    }
}
