package file;

import unit.Point;

import java.io.*;
import java.util.List;

public class LoadFile {

    public  static void load(File file, List<Point> points){

        BufferedReader fis = null;
        try {
            fis = new BufferedReader(new FileReader(file));

            String num;
            String[] number;
            while((num = fis.readLine()) != null){
                number = num.split(",");
                points.add(new Point(Double.parseDouble(number[0]),Double.parseDouble(number[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
