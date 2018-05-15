package Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static Init.ArraysAndMaps.TIDs;

public class DeviceIdentification {
    public static void main(String[] args){
        File TIDfile = new File("C:\\Eftpos 3.0\\terminal.id");
        try {
            FileReader fr = new FileReader(TIDfile);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.printf(line);
                TIDs.add(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
