package model;

import control.GameControl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Storehouse implements Serializable {

    private Author[] authors = new Author[3];
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<InventoryItem> tools = new ArrayList<>();
    private ArrayList<Provision> provisions = new ArrayList<>();

    public Storehouse() {
        // Empty constructor for bean
    }
    
    public Storehouse(Author[] aAuthors, ArrayList<Animal> aAnimals, ArrayList<InventoryItem> aTools, ArrayList<Provision> aProvisions) {
        setAuthors(aAuthors);
        setAnimals(aAnimals);
        setTools(aTools);
        setProvisions(aProvisions);
    }

    public Author[] getAuthors() {
        return authors;
    }
    
    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<InventoryItem> getTools() {
        return tools;
    }

    public void setTools(ArrayList<InventoryItem> tools) {
        this.tools = tools;
    }

    public ArrayList<Provision> getProvisions() {
        return provisions;
    }

    public void setProvisions(ArrayList<Provision> provisions) {
        this.provisions = provisions;
    }

    // toString method
    @Override
    public String toString() {
        return "Storehouse{\n"
                + Author.Amber.toString()
                + "\nAnimals: " + animals
                + "\nProvisions: " + provisions
                + "\nTools: " + tools
                + "\n}";
    }
}
