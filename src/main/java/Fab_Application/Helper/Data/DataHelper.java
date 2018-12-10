package Fab_Application.Helper.Data;

import org.testng.Reporter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    public DataHelper() {
    }


    public static String readFile(String file) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            String ls = System.getProperty("line.separator");

            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            reader.close();
        } catch (IOException var5) {
            Reporter.log("Could not find file " + file);
        }

        return stringBuilder.toString();
    }

    public static List<String> executeShelCommand(String command) {
        ArrayList outputData = new ArrayList();

        try {
            String dataString = null;
            Process execCommand = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command});
            BufferedReader commandRespReader = new BufferedReader(new InputStreamReader(execCommand.getInputStream()));

            while((dataString = commandRespReader.readLine()) != null) {
                outputData.add(dataString);
            }
        } catch (Exception var5) {
            Reporter.log("Couldn't execute command");
        }

        return outputData;
    }
}
