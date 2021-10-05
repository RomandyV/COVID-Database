import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;

/**********************************************************************************************
 * A database for COVID
 *
 * @author Romandy Vu
 * @version Started on: November 23,2020
 ********************************************************************************************/
public class CovidDatabase
{
    /** Instance Variables */

    /** An ArrayList to hold CovidEntry objects */
    private ArrayList<CovidEntry> arrayOfEntries;
    
    /**An ArrayList that contains the unique states (Used for GUI method) */
    private ArrayList<String> listOfStates;

    /**A variable to keep a state lockdown for in days */
    private static final int SAFE = 5;

    /************************************************************************************
     * CovidDatabase Constructor
     *
     ************************************************************************************/
    public CovidDatabase(){
        arrayOfEntries = new ArrayList<CovidEntry>();

    }

    /*********************************************************************************
     * Method readCovidData
     *
     * @param filename A parameter that is the file that will be open to 
     * fill in information to make the CovidEntry
     * objects for the CovidEntry ArrayList.
     *********************************************************************************/
    public void readCovidData(String filename) throws IOException{
        FileInputStream fileName = new FileInputStream(filename);
        Scanner reader = new Scanner(fileName);
        reader.useDelimiter("[,\r\n]+");
        reader.nextLine();

        while(reader.hasNext()){
            String state = reader.next();
            int month = reader.nextInt();
            int day = reader.nextInt();
            int dailyInfect = reader.nextInt();
            int dailyDeaths = reader.nextInt();
            int totalInfect = reader.nextInt();
            int totalDeaths = reader.nextInt();
            CovidEntry object = new CovidEntry(state,month,day,dailyInfect,dailyDeaths,totalInfect,
                    totalDeaths);
            arrayOfEntries.add(object);
            

        }
    }

    /**********************************************************************************
     * Method countRecords
     *
     * @return The return value of the size of the ArrayList.
     *********************************************************************************/
    public int countRecords(){
        return arrayOfEntries.size();

    }

    /*********************************************************************************
     * Method getTotalDeaths
     *
     * @return The return value of the total daily deaths of the ArrayList.
     ********************************************************************************/
    public int getTotalDeaths(){
        int sum = 0;
        for(CovidEntry objectData: arrayOfEntries){
            sum += objectData.getDailyDeaths();

        }
        return sum;
    }

    /**********************************************************************************
     * Method getTotalInfections
     *
     * @return The return value of the total daily infections of the ArrayList.
     *********************************************************************************/
    public int getTotalInfections(){
        int sum = 0;
        for(CovidEntry objectData:arrayOfEntries){
            sum += objectData.getDailyInfections();

        }
        return sum;

    }

    /**********************************************************************************
     * Method countTotalDeaths
     *
     * @param m A parameter that specifies the month to be checked.
     * @param d A parameter that specifies the day to be checked.
     * @return The return value of the total daily deaths in the ArrayList at that month
     * and day.
     **********************************************************************************/
    public int countTotalDeaths(int m, int d){
        int sum = 0;

        for(CovidEntry objectData: arrayOfEntries){
            if((objectData.getMonth() == m) && (objectData.getDay() == d)){
                sum += objectData.getDailyDeaths();

            }

        }
        return sum;

    }

    /***********************************************************************************
     * Method countTotalInfections
     *
     * @param m A parameter that specifies the month to be checked.
     * @param d A parameter that specifies the day to be checked.
     * @return The return value of the total daily infections in the ArrayList at that
     * month and day.
     **********************************************************************************/
    public int countTotalInfections(int m, int d){
        int sum = 0;

        for(CovidEntry objectData: arrayOfEntries){
            if((objectData.getMonth() == m) && (objectData.getDay() == d)){
                sum += objectData.getDailyInfections();

            }

        }
        return sum;

    }

    /**********************************************************************************
     * Method peakDailyDeaths
     *
     * @param st A parameter that specifies the state to be that is going to be checked.
     * argument entered must be a state abbreviation.
     * @return The return value of a CovidEntry object that has the highest death of
     * that state given from the parameter.
     **********************************************************************************/
    public CovidEntry peakDailyDeaths(String st){
        CovidEntry peak = null;
        int peakDeaths = -1;

        for(CovidEntry objectData: arrayOfEntries){
            if(objectData.getState().equalsIgnoreCase(st)){
                if(objectData.getDailyDeaths() > peakDeaths){
                    peak = objectData;
                    peakDeaths = objectData.getDailyDeaths();

                }

            }

        }

        return peak;

    }

    /**********************************************************************************
     * Method getDailyDeaths
     *
     * @param m A parameter that specifies the month to be checked.
     * @param d A parameter that specifies the day to be checked.
     * @return The return value of an ArrayList of contains CovidEntry objects
     * of that day and month.
     *********************************************************************************/
    public ArrayList <CovidEntry> getDailyDeaths(int m,int d){
        ArrayList <CovidEntry> result = new ArrayList<CovidEntry>();

        for(CovidEntry object: arrayOfEntries){
            if ((object.getMonth() == m) && (object.getDay() == d)){
                result.add(object);

            }

        }
        return result;

    }

    /***********************************************************************************
     * Method peakDailyDeaths
     *
     * @param m A parameter that specifies the month to be checked.
     * @param d A parameter tat specifies the day to be chcked.
     * @return The return value of a CovidEntry object that contains the highest
     * daily death of the given month and day (from the parameters specified).
     **********************************************************************************/
    public CovidEntry peakDailyDeaths(int m, int d){
        CovidEntry peak = null;
        int peakDeaths = -1;
        for(CovidEntry objectData: arrayOfEntries){
            if ((objectData.getMonth() == m) && (objectData.getDay() == d)){
                if(objectData.getDailyDeaths() > peakDeaths){
                    peak = objectData;
                    peakDeaths = objectData.getDailyDeaths();

                }

            }

        }
        return peak;

    }

    /***********************************************************************************
     * Method mostTotalDeaths
     *
     * @return The return value of a CovidEntry object that has the highest total deaths.
     **********************************************************************************/
    public CovidEntry mostTotalDeaths(){
        CovidEntry peak = null;
        int totalDeaths = -1;
        for(CovidEntry objectData: arrayOfEntries){

            if(objectData.getTotalDeaths() > totalDeaths){
                peak = objectData;
                totalDeaths = objectData.getTotalDeaths();

            }

        }
        return peak;

    }

    /**********************************************************************************
     * Method listMinimumDailyInfections
     *
     * @param m A parameter that specifies the month to be checked.
     * @param d A parameter that specifies the day to be checked.
     * @param min A parameter that specifes the minimum deaths to be checked.
     * @return The return value of a ArrayList of CovidEntry objects that contains the 
     * specified day, month, and contains at least the minimum deaths specified. 
     *********************************************************************************/
    public ArrayList <CovidEntry> listMinimumDailyInfections(int m, int d, int min){
        ArrayList <CovidEntry> result = new ArrayList<CovidEntry>();
        String s = min + "";

        for(CovidEntry objectData: arrayOfEntries){
            if((objectData.getMonth() == m) && (objectData.getDay() == d) &&
            (objectData.getDailyInfections() >= min) && (s.equals("")==false)){
                result.add(objectData);

            }

        }
        return result;
    }

    /*************************************************************************************
     * Method safeToOpen
     *
     * @param st A parameter that specifies the state that checked (must be abbreviated).
     * @return The return value of an ArrayList that contains the dates of a downwards daily
     * infection of a SAFE amount of days. If there is not a time period of SAFE amount
     * of days it will return null.
     ************************************************************************************/
    public ArrayList <CovidEntry> safeToOpen(String st){
        ArrayList <CovidEntry> result = new ArrayList<CovidEntry>();
        int newMin = arrayOfEntries.get(0).getDailyInfections();

        for(CovidEntry objectData: arrayOfEntries){

            if(objectData.getState().equalsIgnoreCase(st)){
                if(objectData.getDailyInfections() < newMin){
                    result.add(objectData);
                    newMin = objectData.getDailyInfections();

                }
                else{
                    result.clear();
                    result.add(objectData);
                    newMin = objectData.getDailyInfections();

                }
            }
            if(result.size() == SAFE){
                break;
            }
        }

        if(result.size() == SAFE){
            return result;
        }

        else{
            return null;
        }

    }
    /****************************************************************************************
     * Method topTenDeaths
     *
     * @param m A parameter that specifies the month to be checked.
     * @param d A parameter that specifies the day to be checked.
     * @return The return value that contains an ArrayList of the top ten states in
     * descending order of the specified date. If the date is invalid
     * in the data, then there will be no elements in the ArrayList.
     ***************************************************************************************/
    public ArrayList <CovidEntry> topTenDeaths(int m, int d){
        ArrayList<CovidEntry> contender = new ArrayList<CovidEntry>();
        ArrayList<CovidEntry> result = new ArrayList<CovidEntry>();
        boolean isDateValid = false;

        for(CovidEntry ObjectData: arrayOfEntries){
            if((ObjectData.getMonth() == m) && (ObjectData.getDay() == d)){
                contender.add(ObjectData);
                isDateValid = true;

            }
        }

        if(isDateValid){
            Collections.sort(contender);
            for (int i = 0; i < 10; i++){
                result.add(contender.get(i));

            }
        }

        return result;
    }
    
    /******************************************************************************************
     * Method listOfStates
     *
     * @return The return value that contains an ArrayList of type String
     * of all data entries. (Used for Validation for GUI to check
     * if input is a state abbreviation)
     ******************************************************************************************/
    public ArrayList <String> listOfStates(){
        ArrayList<String> result = new ArrayList<String>();
        boolean isDuplicate;
        
        for(CovidEntry states: arrayOfEntries){
            result.add(states.getState());
            
        
        }
        
        return result;
    }
    
}
