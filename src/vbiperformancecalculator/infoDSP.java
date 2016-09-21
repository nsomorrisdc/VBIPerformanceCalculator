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
//Class which holds all data contained within a DSP, filter selection and selected options
    public class infoDSP {
        private int ROI;
        private double exposureTime;
        private int exposureRate;
        private int Binning;
        private int numberFrames;
        private int numberFields;
        private int fieldSample;
        private double moveTime;
        private String filterSelect;
        private String synchronizationSelect;
        private boolean speckleSelect;
        private int numCycles;
        
        public infoDSP(String filterName) {
            //Default configuration upon load of application
             ROI = 1;
             exposureTime = 0.002;
             exposureRate = 2;
             numberFrames = 80;
             numberFields = 9;
             moveTime = 0.3;
             Binning = 2;
             fieldSample = 0;
             filterSelect = filterName;
             synchronizationSelect = "Fixed";
             speckleSelect = true;
             numCycles = 1;
             alltoString();
        }
        
        public double getDuration() {
            
            double duration = (double) (((1./exposureRate) * getNumberFrames() + getMoveTime()) * getNumberFields());
            //System.out.println(exposureRate);
            //System.out.println(numberFrames);
            //System.out.println(moveTime);
            //System.out.println(numberFields);
            //System.out.println(duration);
            return duration;
        }
        
        @Override
        public String toString() {
            
            String myString = new String();
            myString = getFilterSelect();
            char firstSelect = myString.charAt(0);
            if (myString != null) {
                if (firstSelect == 'R') {
                   myString = myString.replace("Red - ","");
                   return myString;
                }
                else if (firstSelect == 'B'){
                   myString = myString.replace("Blue - ", "");
                   return myString;
                }
                else {
                    return null;
                }
                
            }
            else {
                return null;
            }
            
        }
        
        
        public String alltoString() {
            
            String myString = new String();
            //Can we abstract this up into the UI setup class above?
            myString = "ROI: "+ getROI()+ "\nExposure Time: " + getExposureTime() + "\nExposure Rate: "+ getExposureRate() + "\nBinning: " + getBinning()
                    + "\nCamera Field: " + getNumberFields() + "\nFilter Selection: " + getFilterSelect() + "\nNumber of Frames: " + getNumberFrames() + "\nSynchronization Mode: " + getSynchronizationSelect()
                    + "\nSpeckle Selection: " + isSpeckleSelect(); //+ "\nTotal Time: "+ Math.max(calcscaleTimelineRecursive(redchanneltreeView.getRoot().getChildren()),calcscaleTimelineRecursive(bluechanneltreeView.getRoot().getChildren()));
//            
            //infoDSPTextBox.setText(myString);
            //infoDSPTextBox.setWrapText(true);
            return myString;
            
        }
        
        //Set filter combobox selection to specific image file
        //public HashMap setfilterImage(String filterSelect) {
        //    HashMap<String, String> filterimageMap = new HashMap();
            //filterimageMap.put("Red - H Alpha 656.3 nm","/img/alanfriedman_sun_halpha.jpg");
            //filterimageMap.put(,);
             
        //    return filterimageMap;
        //}

        /**
         * @return the ROI
         */
        public int getROI() {
            return ROI;
        }

        /**
         * @param ROI the ROI to set
         */
        public void setROI(int ROI) {
            this.ROI = ROI;
        }

        /**
         * @return the exposureTime
         */
        public double getExposureTime() {
            return exposureTime;
        }

        /**
         * @return the exposureRate
         */
        public int getExposureRate() {
            return exposureRate;
        }

        /**
         * @param exposureRate the exposureRate to set
         */
        public void setExposureRate(int exposureRate) {
            this.exposureRate = exposureRate;
        }

        /**
         * @return the Binning
         */
        public int getBinning() {
            return Binning;
        }

        /**
         * @param Binning the Binning to set
         */
        public void setBinning(int Binning) {
            this.Binning = Binning;
        }

        /**
         * @return the fieldSample
         */
        public int getFieldSample() {
            return fieldSample;
        }

        /**
         * @param fieldSample the fieldSample to set
         */
        public void setFieldSample(int fieldSample) {
            this.fieldSample = fieldSample;
        }

        /**
         * @return the filterSelect
         */
        public String getFilterSelect() {
            return filterSelect;
        }
        
        public void setFilterSelect(String selectedFilter) {
            this.filterSelect = selectedFilter;
        }

        /**
         * @return the synchronizationSelect
         */
        public String getSynchronizationSelect() {
            return synchronizationSelect;
        }

        /**
         * @param synchronizationSelect the synchronizationSelect to set
         */
        public void setSynchronizationSelect(String synchronizationSelect) {
            this.synchronizationSelect = synchronizationSelect;
        }

        /**
         * @return the speckleSelect
         */
        public boolean isSpeckleSelect() {
            return speckleSelect;
        }

        /**
         * @param speckleSelect the speckleSelect to set
         */
        public void setSpeckleSelect(boolean speckleSelect) {
            this.speckleSelect = speckleSelect;
        }

        /**
         * @return the numberFrames
         */
        public int getNumberFrames() {
            return numberFrames;
        }

        /**
         * @param numberFrames the numberFrames to set
         */
        public void setNumberFrames(int numberFrames) {
            this.numberFrames = numberFrames;
        }

        /**
         * @return the numberFields
         */
        public int getNumberFields() {
            return numberFields;
        }

        /**
         * @param numberFields the numberFields to set
         */
        public void setNumberFields(int numberFields) {
            this.numberFields = numberFields;
        }

        /**
         * @return the moveTime
         */
        public double getMoveTime() {
            return moveTime;
        }

        /**
         * @param moveTime the moveTime to set
         */
        public void setMoveTime(int moveTime) {
            this.moveTime = moveTime;
        }

        /**
         * @param exposureTime the exposureTime to set
         */
        public void setExposureTime(double exposureTime) {
            this.exposureTime = exposureTime;
        }

        /**
         * @param moveTime the moveTime to set
         */
        public void setMoveTime(double moveTime) {
            this.moveTime = moveTime;
        }

        /**
         * @return the numCycles
         */
        public int getNumCycles() {
            return numCycles;
        }

        /**
         * @param numCycles the numCycles to set
         */
        public void setNumCycles(int numCycles) {
            this.numCycles = numCycles;
        }  
        
    }
