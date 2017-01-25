package tnmk.el.service.historyevent.model;

/**
 * @author khoi.tran on 9/20/16.
 */
public enum ModernAreaLevel {
    CONTINENT(4), REGION(3), COUNTRY(2), PROVINCE(1);
    private final int numValue;

    ModernAreaLevel(int numValue) {this.numValue = numValue;}
}
