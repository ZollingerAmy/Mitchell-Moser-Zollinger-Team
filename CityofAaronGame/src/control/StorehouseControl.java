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
