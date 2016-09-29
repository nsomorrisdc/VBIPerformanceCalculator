/*
 * Copyright 2016
 * National Solar Observatory, operated by the Association of Universities
 * for Research in Astronomy, Inc., under cooperative agreement with the
 * National Science Foundation.
 *
 * This copy of ATST software is licensed to you under the terms
 * described in the LICENSE file included in this distribution.
 *
 */
package vbiperformancecalculator;

/**
 *
 * @author dmorris
 */
public class groupInfo {
    private String groupName;
    private int groupnumCycles;
    
    public groupInfo(String groupTitle) {
        groupName = groupTitle;
        groupnumCycles = 1;
    }
    
    @Override
    public String toString() {
        String myString = new String();
<<<<<<< HEAD
        myString = getGroupName() + ", Cycles x" + getgroupNumCycles();
=======
        myString = getGroupName() + ", Cycles: " + getgroupNumCycles();
>>>>>>> f2a9ad672126473ff60011cfee4d05fa26975cae
        return myString;
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return the numCycles
     */
    public int getgroupNumCycles() {
        return groupnumCycles;
    }

    /**
     * @param numCycles the numCycles to set
     */
    public void setgroupNumCycles(int numCycles) {
        this.groupnumCycles = numCycles;
    }
}
