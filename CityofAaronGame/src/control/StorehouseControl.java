
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import app.CityOfAaron;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Condition;
import model.InventoryItem;
import view.ErrorView;

/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class StorehouseControl {

    /**
     * Constructor
     *
     */
    public StorehouseControl() {

    }

    /**
     *
     * @param tools
     * @throws IOException
     */
    public void printToolsReport(ArrayList<model.InventoryItem> tools) throws IOException {
        //  

        try (PrintWriter out = new PrintWriter("toolReport.txt")) {

            out.println("\n\n      Tools Report                 ");
            out.printf("%n%-20s%10s%10s%", "Tool", "Quantity", "Condition");
            out.printf("%n%-20s%10d%10%", "----", "--------", "---------");

            for (model.InventoryItem allTools : tools) {

                out.printf("%n%-20s%10s%10s%", allTools.getName(), allTools.getQuantity(), allTools.getCondition());

            }
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "I/O Error: " + ex.getMessage());
        }

    }

    /**
     *
     * @throws IOException
     */
    
    /**
     *
     * @param poorCondition
     * @param location
     * @throws IOException
     */
    public static void printPoorCondition(ArrayList<model.InventoryItem> poorCondition, String location) throws IOException {

        try (PrintWriter out = new PrintWriter(location)) {

            System.out.println("\n\n      Tools in Poor Condition Report                 ");
            System.out.printf("%n%-20s%10s%10s%", "Tool", "Quantity", "Condition");
            System.out.printf("%n%-20s%10d%10%", "----", "--------", "---------");

            for (model.InventoryItem myTool : poorCondition) {
                out.printf("%n%-20s%10s%10s%", myTool.getName(), myTool.getQuantity(), myTool.getCondition());
            }
            
//             String file = new String();
//            file = getUserInput("Please enter a file name to save report.");
//            File location = new File("C:\\Users\\Amy\\Documents\\" + file + ".txt");
//            FileWriter write = new FileWriter(location);
//            write.write(poorCondition());
//            write.close();
//        } catch (IOException e) {
//            ErrorView.display(this.getClass().getName(), "Must enter file name.");
        }
    }
    
}

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
    public static void printAnimals(String arg) throws IOException {
        String filename = "animals.txt";
        if (arg != null) {
            filename = arg;
        }
        // set up data
        ArrayList<Animal> animals = CityOfAaron.getCurrentGame().getTheStorehouse().getAnimals();
        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("List of Animals");
            report.println();
            String formatString = "%-20s %-15s %-15s %10s";
            report.println(String.format(formatString, "NAME", "QUANTITY", "CONDITION", "AGE"));
            report.println("-----------------------------------------------------------------------------");
            for (Animal animal : animals) {
                report.println(String.format(formatString, animal.getName(), animal.getQuantity(), animal.getCondition(), animal.getAge()));
            }
            report.println();
            report.println("End");
            report.flush();
        }
    }
}

