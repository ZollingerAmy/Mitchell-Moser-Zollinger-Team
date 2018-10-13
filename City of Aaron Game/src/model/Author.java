
package model;

/**
 *
 * @author Amber
 */

public enum Author {
    Amber("Amber Mitchell"),
    Teresa("Teresa Moser"),
    Amy("Amy Zollinger");
    
    private final String value;
    
    Author(final String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    // toString method
    @Override
    public String toString() {
        String allValues = "";
        boolean firstRun = true;
        for (Author info : Author.values()){
            if (firstRun) {
                firstRun = false;
                allValues += info.getValue();
            } else {
                allValues += ", " + info.getValue();
            }
        }

        return "Authors: " 
                + allValues
                ;
    }
    
}
