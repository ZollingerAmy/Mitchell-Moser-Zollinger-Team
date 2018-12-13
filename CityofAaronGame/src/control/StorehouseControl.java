
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
import model.Animal;
import model.Condition;
import model.InventoryItem;
import model.Provision;
import view.ErrorView;

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
        printTools(args[2]);
        printPoorCondition(args[3]);

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

    /**
     *
     * @param tools
     * @throws IOException
     */
    public static void printTools(String arg) throws IOException {
        //  

        String filename = "animals.txt";
        if (arg != null) {
            filename = arg;
        }
        // set up data
        ArrayList<model.InventoryItem> tools = CityOfAaron.getCurrentGame().getTheStorehouse().getTools();
        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("List of Tools");
            report.println();
            String formatString = "%-20s %-15s %-15s";
            report.println(String.format(formatString, "NAME", "QUANTITY", "CONDITION"));
            report.println("-----------------------------------------------------------------------------");
            for (model.InventoryItem allTools : tools) {
                report.println(String.format(formatString, allTools.getName(), allTools.getQuantity(), allTools.getCondition()));
            }

            report.println();
            report.println("End");
            report.flush();
        }
    }

    
    public static void printPoorCondition(String arg) throws IOException {
        String filename = "poorTools.txt";
        if (arg != null) {
            filename = arg;
        }
        ArrayList<model.InventoryItem> tools = CityOfAaron.getCurrentGame().getTheStorehouse().getTools();
        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("List of Poor Tools");
            report.println();
            String formatString = "%-20s %-15s %-15s";
            report.println(String.format(formatString, "NAME", "QUANTITY", "CONDITION"));
            report.println("-----------------------------------------------------------------------------");
            for (model.InventoryItem allTools : tools) {
                report.println(String.format(formatString, allTools.getName(), allTools.getQuantity(), allTools.getCondition()));
            }
            report.println();
            report.println("End");
            report.flush();
        }

    }
}
