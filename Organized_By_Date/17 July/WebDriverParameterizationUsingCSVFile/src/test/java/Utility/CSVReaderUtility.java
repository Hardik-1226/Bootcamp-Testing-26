package Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtility {
	
	
	public static List<String[]> getCSVData(String filePath) {

        List<String[]> data = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;

            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

}
