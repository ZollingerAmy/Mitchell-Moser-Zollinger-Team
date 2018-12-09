/*
 * This class helps us print reports from the Storehouse
 */
package control;

import app.CityOfAaron;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Animal;
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
     * @param animalFile
     * @param provisionFile
     * @param toolFile
     * @throws java.io.IOException
     */
    public StorehouseControl(String animalFile, String provisionFile, String toolFile) throws IOException {
        args[0] = animalFile;
        args[1] = provisionFile;
        args[2] = toolFile;
        printProvisions(args[1]);
        printAnimals(args[0]);
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

    //print report for Animals --Teresa Mo
    public static void printAnimals(String arg) throws IOException {
        String filename = "animals.txt";
        if (arg != null) {
            filename = arg;
        }
        // set up data
        ArrayList<Animal> animals = CityOfAaron.getCurrentGame().getTheStorehouse().getAnimals();
        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("LIST OF ANIMALS");
            
            String[] columnNames = {"Name", "Type", "Quantity", "Condition", "Age"};
            ArrayList<Animal> data = CityOfAaron.getCurrentGame().getTheStorehouse().getAnimals();
            JTable table = new JTable(data, columnNames);
            JScrollPane tableScrollPane = new JScrollPane(table);
            table.setShowGrid(true);
            
            for (Animal animal : animals) {
                report.println(String.format( animal.getName(), animal.getType(), animal.getQuantity(), animal.getCondition(), animal.getAge()));
            }
            report.println();
            report.println("End");
            report.flush();
        }
    }

    private static class Columns {

        public Columns() {
        }

    }

    private static class JTable {

        public JTable() {
        }

        private JTable(ArrayList<Animal> data, String[] columnNames) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setShowGrid(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class JScrollPane {

        public JScrollPane() {
        }

        private JScrollPane(JTable table) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }


}
