
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
    
}
