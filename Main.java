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
        HashMap<String, Byte> pokemon = populateHM();

        //Offsets
        int starter1=119054;
        int starter2=119071;
        int starter3=119088;
        int rivalBattle1starter1=238066;
        int rivalBattle1starter2=238069;
        int rivalBattle1starter3=238072;

        //Set Pokémon to Prof.OAK starters
        gameArray[starter1] = pokemon.get("Charmander");
        gameArray[starter2] = pokemon.get("Squirtle");
        gameArray[starter3] = pokemon.get("Bulbasaur");

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

    private static HashMap<String, Byte> populateHM() {
        //Contains decimal value for each Pokemon
        HashMap<String, Byte> pokemon = new HashMap<>();
        pokemon.put("'M",(byte) 0);
        pokemon.put("Rhydon", (byte) 1);
        pokemon.put("Kangaskhan", (byte) 2);
        pokemon.put("NidoranM", (byte) 3);
        pokemon.put("Clefairy", (byte) 4);
        pokemon.put("Spearow", (byte) 5);
        pokemon.put("Voltorb", (byte) 6);
        pokemon.put("Nidoking", (byte) 7);
        pokemon.put("Slowbro", (byte) 8);
        pokemon.put("Ivysaur", (byte) 9);
        pokemon.put("Exeggutor", (byte) 10);
        pokemon.put("Lickitung", (byte) 11);
        pokemon.put("Exeggcute", (byte) 12);
        pokemon.put("Grimer", (byte) 13);
        pokemon.put("Gengar", (byte) 14);
        pokemon.put("NidoranF", (byte) 15);
        pokemon.put("Nidoqueen", (byte) 16);
        pokemon.put("Cubone", (byte) 17);
        pokemon.put("Rhyhorn", (byte) 18);
        pokemon.put("Lapras", (byte) 19);
        pokemon.put("Arcanine", (byte) 20);
        pokemon.put("Mew", (byte) 21);
        pokemon.put("Gyarados", (byte) 22);
        pokemon.put("Shellder", (byte) 23);
        pokemon.put("Tentacool", (byte) 24);
        pokemon.put("Gastly", (byte) 25);
        pokemon.put("Scyther", (byte) 26);
        pokemon.put("Staryu", (byte) 27);
        pokemon.put("Blastoise", (byte) 28);
        pokemon.put("Pinsir", (byte) 29);
        pokemon.put("Tangela", (byte) 30);
        pokemon.put("MissingNo.", (byte) 31);
        pokemon.put("Growlithe", (byte) 33);
        pokemon.put("Onix", (byte) 34);
        pokemon.put("Fearow", (byte) 35);
        pokemon.put("Pidgey", (byte) 36);
        pokemon.put("Slowpoke", (byte) 37);
        pokemon.put("Kadabra", (byte) 38);
        pokemon.put("Graveler", (byte) 39);
        pokemon.put("Chansey", (byte) 40);
        pokemon.put("Machoke", (byte) 41);
        pokemon.put("Mr.Mime", (byte) 42);
        pokemon.put("Hitmonlee", (byte) 43);
        pokemon.put("Hitmonchan", (byte) 44);
        pokemon.put("Arbok", (byte) 45);
        pokemon.put("Parasect", (byte) 46);
        pokemon.put("Psyduck", (byte) 47);
        pokemon.put("Drowzee", (byte) 48);
        pokemon.put("Golem", (byte) 49);
        pokemon.put("Magmar", (byte) 51);
        pokemon.put("Electabuzz", (byte) 53);
        pokemon.put("Magneton", (byte) 54);
        pokemon.put("Koffing", (byte) 55);
        pokemon.put("Mankey", (byte) 57);
        pokemon.put("Seel", (byte) 58);
        pokemon.put("Diglett", (byte) 59);
        pokemon.put("Tauros", (byte) 60);
        pokemon.put("Farfetch'd", (byte) 64);
        pokemon.put("Venonat", (byte) 65);
        pokemon.put("Dragonite", (byte) 66);
        pokemon.put("Doduo", (byte) 70);
        pokemon.put("Poliwag", (byte) 71);
        pokemon.put("Jynx", (byte) 72);
        pokemon.put("Moltres", (byte) 73);
        pokemon.put("Articuno", (byte) 74);
        pokemon.put("Zapdos", (byte) 75);
        pokemon.put("Ditto", (byte) 76);
        pokemon.put("Meowth", (byte) 77);
        pokemon.put("Vulpix", (byte) 82);
        pokemon.put("Ninetales", (byte) 83);
        pokemon.put("Pikachu", (byte) 84);
        pokemon.put("Raichu", (byte) 85);
        pokemon.put("Dratini", (byte) 88);
        pokemon.put("Dragonair", (byte) 89);
        pokemon.put("Kabuto", (byte) 90);
        pokemon.put("Kabutops", (byte) 91);
        pokemon.put("Horsea", (byte) 92);
        pokemon.put("Seadra", (byte) 93);
        pokemon.put("Sandshrew", (byte) 96);
        pokemon.put("Sandslash", (byte) 97);
        pokemon.put("Omanyte", (byte) 98);
        pokemon.put("Omastar", (byte) 99);
        pokemon.put("Jigglypuff", (byte) 100);
        pokemon.put("Wigglytuff", (byte) 101);
        pokemon.put("Eevee", (byte) 102);
        pokemon.put("Flareon", (byte) 103);
        pokemon.put("Jolteon", (byte) 104);
        pokemon.put("Vaporeon", (byte) 105);
        pokemon.put("Machop", (byte) 106);
        pokemon.put("Zubat", (byte) 107);
        pokemon.put("Ekans", (byte) 108);
        pokemon.put("Paras", (byte) 109);
        pokemon.put("Poliwhirl", (byte) 110);
        pokemon.put("Poliwrath", (byte) 111);
        pokemon.put("Weedle", (byte) 112);
        pokemon.put("Kakuna", (byte) 113);
        pokemon.put("Beedrill", (byte) 114);
        pokemon.put("Dodrio", (byte) 116);
        pokemon.put("Primeape", (byte) 117);
        pokemon.put("Dugtrio", (byte) 118);
        pokemon.put("Venomoth", (byte) 119);
        pokemon.put("Dewgong", (byte) 120);
        pokemon.put("Caterpie", (byte) 123);
        pokemon.put("Metapod", (byte) 124);
        pokemon.put("Butterfree", (byte) 125);
        pokemon.put("Machamp", (byte) 126);
        pokemon.put("Golduck", (byte) 128);
        pokemon.put("Hypno", (byte) 129);
        pokemon.put("Golbat", (byte) 130);
        pokemon.put("Mewtwo", (byte) 131);
        pokemon.put("Snorlax", (byte) 132);
        pokemon.put("Magikarp", (byte) 133);
        pokemon.put("Muk", (byte) 136);
        pokemon.put("Kingler", (byte) 138);
        pokemon.put("Cloyster", (byte) 139);
        pokemon.put("Electrode", (byte) 141);
        pokemon.put("Clefable", (byte) 142);
        pokemon.put("Weezing", (byte) 143);
        pokemon.put("Persian", (byte) 144);
        pokemon.put("Marowak", (byte) 145);
        pokemon.put("Haunter", (byte) 147);
        pokemon.put("Abra", (byte) 148);
        pokemon.put("Alakazam", (byte) 149);
        pokemon.put("Pidgeotto", (byte) 150);
        pokemon.put("Pidgeot", (byte) 151);
        pokemon.put("Starmie", (byte) 152);
        pokemon.put("Bulbasaur", (byte) 153);
        pokemon.put("Venusaur", (byte) 154);
        pokemon.put("Tentacruel", (byte) 155);
        pokemon.put("Goldeen", (byte) 157);
        pokemon.put("Seaking", (byte) 158);
        pokemon.put("Ponyta", (byte) 163);
        pokemon.put("Rapidash", (byte) 164);
        pokemon.put("Rattata", (byte) 165);
        pokemon.put("Raticate", (byte) 166);
        pokemon.put("Nidorino", (byte) 167);
        pokemon.put("Nidorina", (byte) 168);
        pokemon.put("Geodude", (byte) 169);
        pokemon.put("Porygon", (byte) 170);
        pokemon.put("Aerodactyl", (byte) 171);
        pokemon.put("Magnemite", (byte) 173);
        pokemon.put("Charmander", (byte) 176);
        pokemon.put("Squirtle", (byte) 177);
        pokemon.put("Charmeleon", (byte) 178);
        pokemon.put("Wartortle", (byte) 179);
        pokemon.put("Charizard", (byte) 180);
        pokemon.put("Ghost", (byte) 184);
        pokemon.put("Oddish", (byte) 185);
        pokemon.put("Gloom", (byte) 186);
        pokemon.put("Vileplume", (byte) 187);
        pokemon.put("Bellsprout", (byte) 188);
        pokemon.put("Weepinbell", (byte) 189);
        pokemon.put("Victreebel", (byte) 190);
        return pokemon;
    }
}
