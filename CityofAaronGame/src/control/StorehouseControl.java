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

    //print report for Animals --Teresa Mo
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
            report.println(String.format("Name\t, Quantity\t, Condition\t, Age"));
            for (Animal animal : animals) {
                report.println(String.format(String.format(animal.getName(), animal.getQuantity(), animal.getCondition(), animal.getAge())));
            }
            report.println();
            report.println("End");
            report.flush();
        }

    }

}
