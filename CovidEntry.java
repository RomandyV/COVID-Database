import java.text.DecimalFormat;
/*********************************************************************************************
 *A class to use to get data from Covid 
 *
 * @author Romandy Vu
 * @version Start date: November 23,2020
 ********************************************************************************************/
public class CovidEntry implements Comparable{
    /** Instance Variables */

    /** Holds a string value for one of the 50 states in the US */
    private String state;

    /** Holds an int value for one of the 12 months */
    private int month;

    /** Holds an int value of one of the days of a month */
    private int day;

    /** Holds an int value of the daily death of a day of a month of a state */
    private int dailyDeaths;

    /** Holds an int value of the daily infection of a day of a month of a state */
    private int dailyInfections;

    /** Holds an int value of the total death of a state */
    private int totalDeaths;

    /** Holds an int value of the total infection of a state*/
    private int totalInfections;
    
    /// private static DecimalFormat df = new DecimalFormat("#,###,###"); (from class)

    /**************************************************************************************
     * CovidEntry Constructor
     *
     * @param st A parameter that sets the state instance variable.
     * @param m A parameter that sets the month instance variable.
     * @param d A parameter that sets the day instance variable.
     * @param di A parameter that sets the dailyInfections instance variable.
     * @param dd A parameter that sets the dailyDeaths instance variable.
     * @param ti A parameter that sets the totalInfections instance variable.
     * @param td A parameter that sets the totalDeaths instance variable.
     ***************************************************************************************/
    public CovidEntry(String st, int m, int d, int di, int dd, int ti, int td){
        state = st;
        month = m;
        day = d;
        dailyInfections = di;
        dailyDeaths = dd;
        totalInfections = ti;
        totalDeaths = td;

    } 

    /**************************************************************************************
     * Method getMonth
     *
     * @return The return value of the month.
     *************************************************************************************/
    public int getMonth(){
        return month;

    }

    /***************************************************************************************
     * Method getDay
     *
     * @return The return value of the day.
     **************************************************************************************/
    public int getDay(){
        return day;

    }

    /***************************************************************************************
     * Method getState
     *
     * @return The return value of the state.
     **************************************************************************************/
    public String getState(){
        return state;

    }

    /***************************************************************************************
     * Method getDailyInfections
     *
     * @return The return value of the daily infections.
     **************************************************************************************/
    public int getDailyInfections(){
        return dailyInfections;

    }

    /****************************************************************************************
     * Method getDailyDeaths
     *
     * @return The return value of the daily deaths.
     ***************************************************************************************/
    public int getDailyDeaths(){
        return dailyDeaths;
    }
    
    /***************************************************************************************
     * Method getTotalInfections
     *
     * @return The return value of the total infections.
     *************************************************************************************/
    public int getTotalInfections(){
        return totalInfections;
    }
    
    /***************************************************************************************
     * Method getTotalDeaths
     *
     * @return The return value of the total deaths.
     *************************************************************************************/
    public int getTotalDeaths(){
        return totalDeaths;
    }
    
    /****************************************************************************************
     * Method toString
     *
     * @return The return value of the state, date (month/day), a formated total infections,
     * and a formated total deaths.
     ***************************************************************************************/
    public String toString(){
        DecimalFormat format = new DecimalFormat("###,###,###,####,###");
        String formatInfections = format.format(totalInfections);
        String formatDeaths = format.format(totalDeaths);
        
        return state + " " + month + "/" + day + " " + formatInfections + " infections, "
        + formatDeaths + " deaths";
        /// df.format(dailyInfections) (from class to replace formatInfections)
        ///df.format(dailyDeaths) (to replace formatDeaths)
    
    }
    
    public int compareTo(Object other){
        CovidEntry c = (CovidEntry) other;
        return c.dailyDeaths - dailyDeaths;
    
    }
}
