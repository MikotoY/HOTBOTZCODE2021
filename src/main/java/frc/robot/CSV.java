package frc.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSV {
    PrintWriter pw;
    StringBuilder sb;
    double xPosition, yPosition;

    public CSV(double xPosition, double yPosition) throws FileNotFoundException{
        pw = new PrintWriter(new File("test.csv"));
        sb = new StringBuilder();
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        sb.append("x");
        sb.append(',');
        sb.append("y");
        sb.append('\n');

        sb.append(xPosition);
        sb.append(',');
        sb.append(yPosition);
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }        
}