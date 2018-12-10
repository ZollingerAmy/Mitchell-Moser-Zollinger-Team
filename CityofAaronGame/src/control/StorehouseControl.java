/*
 * This class helps us print reports from the Storehouse
 */
package control;

import app.CityOfAaron;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import model.Animal;
import model.Condition;
import model.Provision;

/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class StorehouseControl {

    private final String[] args = new String[3];

    /**
     * Constructor
     *
     * @param animalsFile
     * @param provisionFile
     * @param toolFile
     * @throws java.io.IOException
     */
    public StorehouseControl(String animalsFile, String provisionFile, String toolFile) throws IOException {
        args[0] = animalsFile;
        args[1] = provisionFile;
        args[2] = toolFile;
        printAnimals(args[0]);
        printProvisions(args[1]);

    }

    public static void printProvisions(String arg) throws IOException {
        String filename = "provisions.txt";
        if (arg != null) {
            filename = arg;
        }
        // set up data
        ArrayList<Provision> provisions = CityOfAaron.getCurrentGame().getTheStorehouse().getProvisions();
        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("Provisions");
            report.println();
            String formatString = "%-40s %-15s %-15s %-15s %10s";
            report.println(String.format(formatString, "NAME", "TYPE", "QUANTITY", "CONDITION", "PERISHABLE"));
            report.println("------------------------------------------------------------------------------------------------------");
            for (Provision provision : provisions) {
                report.println(String.format(formatString, provision.getName(), provision.getType(), provision.getQuantity(), provision.getCondition(), provision.isPerishable()));
            }
            report.println();
            report.println("End");
            report.flush();
        }
    }

 //Print report for Animals--Teresa Mo
    public class CommandLineTable {
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public CommandLineTable() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }

     public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
        
    }

        private void addRow(String name, int quantity, Condition condition, ArrayList<Integer> age) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
         public void main(String[] args) {
            //test code
            CommandLineTable st = new CommandLineTable();
            //st.setRightAlign(true);//if true then cell text is right aligned
            st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
            st.setHeaders( "Name", "Quantity", "Condition", "Age");//optional - if not used then there will be no header and horizontal lines
             // set up data
             ArrayList<Animal> animals = CityOfAaron.getCurrentGame().getTheStorehouse().getAnimals();  
            for (Animal animal : animals) {
                st.addRow(animal.getName(), animal.getQuantity(), animal.getCondition(), animal.getAge());
               }
         }
    
    public static void printAnimals(String args) throws IOException {
        String filename = "animals.txt";
        if (args != null) {
            filename = args;
        }

        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("List of Animals");
            report.println();
            report.println("End");
            report.flush();
        }
    }
}
