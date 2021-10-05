import java.io.IOException;
/**
 * Write a description of class SampleOutput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SampleOutput
{
    public static void main(String[] args)throws IOException{
        CovidDatabase db = new CovidDatabase();
        db.readCovidData("covid_data.csv");
        System.out.println("Total records in file was: " + db.countRecords());
        System.out.println("Total deaths in the file is: " + db.getTotalDeaths());
        System.out.println("Total infection in the file is: " + db.getTotalInfections());
        System.out.println("Most total death is: " + db.mostTotalDeaths().getState() + " at " + db.mostTotalDeaths().getTotalDeaths());
        System.out.println("Peak daily deaths for " + db.peakDailyDeaths("MI").getState() + " was: " 
            + db.peakDailyDeaths("MI").getDailyDeaths() + " at " + db.peakDailyDeaths("MI").getMonth() + "/" +db.peakDailyDeaths("MI").getDay());
            
        System.out.println("Peak deaths at " + db.peakDailyDeaths(5,5).getMonth() + "/" + db.peakDailyDeaths(5,5).getDay() + " was "
        + db.peakDailyDeaths(5,5).getState() + " at " + db.peakDailyDeaths(5,5).getDailyDeaths() + " deaths" );
        
        System.out.println("Top 10 deaths on 5/5 was: ");
        for(int i = 0; i < db.topTenDeaths(5,5).size(); i++){
            System.out.println(db.topTenDeaths(5,5).get(i).getState() + " at " + db.topTenDeaths(5,5).get(i).getDailyDeaths()
            + " deaths ");
        
        }
        System.out.println("Is MI safe to open?: " + (db.safeToOpen("MI").size() == 5));
        System.out.println("List of states that had at least 1000 infections on 6/12 was: ");
        for(int i = 0; i < db.listMinimumDailyInfections(6,12,1000).size(); i++){
            System.out.println(db.listMinimumDailyInfections(6,12,1000).get(i).getState() + " at " 
            + db.listMinimumDailyInfections(6,12,1000).get(i).getDailyInfections() + " infections");
        
        }
        System.out.println("Total Infections since 3/1 was: " + db.countTotalInfections(3,1));
        System.out.println("Total deaths since 3/1 was: " + db.countTotalDeaths(3,1));
        System.out.println();
        if (2147483647*60000 <= 60000){
            System.out.println(2147483647*60000);
        }

    }
    
}
