/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vbiperformancecalculator;

/**
 *
 * @author dmorris
 */
public class rootInfo {
    private String rootName;
    private int rootnumCycles;
    
    public rootInfo(String rootTitle) {
        rootName = rootTitle;
        rootnumCycles = 1;
    }
    
    @Override
    public String toString() {
        String myString = new String();
        myString = getRootName() + ", Cycles: " + getrootNumCycles();
        return myString;
    }

    public int calcrootTotalTime(int numrootCyles) {
        int rootcycleTotalTime = 1;
        
        
        return rootcycleTotalTime;
    }
    
    /**
     * @return the rootName
     */
    public String getRootName() {
        return rootName;
    }

    /**
     * @param rootName the rootName to set
     */
    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    /**
     * @return the rootnumCycles
     */
    public int getrootNumCycles() {
        return rootnumCycles;
    }

    /**
     * @param rootnumCycles the rootnumCycles to set
     */
    public void setrootNumCycles(int rootnumCycles) {
        this.rootnumCycles = rootnumCycles;
    }
}
