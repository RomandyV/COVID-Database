import java.io.IOException;
/**
 * To test the CovidDatabase Class methods
 *
 * @author Romandy
 * @version Start date: 12/1/2020
 */
public class CovidDatabaseTest
{
  public static void main(String[] args) throws IOException{
      System.out.println("Test starting");
      CovidDatabase db = new CovidDatabase();
      db.readCovidData("covid_data.csv");
      
      assert db.countRecords() == 10346 : "Should be 10346"; //Testing countRecords()
      
      assert db.getTotalDeaths() == 196696: "Should be 196696"; //Testing getTotalDeaths()
      
      assert db.getTotalInfections() == 7032090: "Should be 7032090"; //Testing getTotalInfections()
      
      assert db.mostTotalDeaths().getState().equalsIgnoreCase("NY"): "Should be NY";
      assert db.mostTotalDeaths().getTotalDeaths() == 25456: "Should be 25456";
      //Testing mostTotalDeaths
      
      assert db.peakDailyDeaths("MI").getMonth() == 4: "Should be 4";
      assert db.peakDailyDeaths("MI").getDay() == 16: "Should be 16";
      assert db.peakDailyDeaths("MI").getDailyInfections() == 922: "Should be 922";
      assert db.peakDailyDeaths("MI").getDailyDeaths() == 169: "Should be 169";
      //Testing peakDailyDeaths(string parameter)
      
      assert db.peakDailyDeaths(5,5).getState().equalsIgnoreCase("PA"): "Should be PA";
      assert db.peakDailyDeaths(5,5).getDay() == 5: " Day should be 5";
      assert db.peakDailyDeaths(5,5).getMonth() == 5: "Month should be 5";
      assert db.peakDailyDeaths(5,5).getDailyDeaths() == 554: "Should be 554";
      //Testing peakDailyDeaths(int month parameter, int day parameter)
      
      System.out.println(db.topTenDeaths(5,5));
      assert db.topTenDeaths(5,5).get(0).getState().equalsIgnoreCase("PA"): "Should be PA";
      assert db.topTenDeaths(5,5).get(1).getState().equalsIgnoreCase("NJ"): "Should be NJ";
      assert db.topTenDeaths(5,5).get(2).getState().equalsIgnoreCase("NY"): "Should be NY";
      assert db.topTenDeaths(5,5).get(3).getState().equalsIgnoreCase("IL"): "Should be IL";
      assert db.topTenDeaths(5,5).get(4).getState().equalsIgnoreCase("CT"): "Should be CT";
      assert db.topTenDeaths(5,5).get(5).getState().equalsIgnoreCase("MA"): "Should be MA";
      assert db.topTenDeaths(5,5).get(6).getState().equalsIgnoreCase("FL"): "Should be FL";
      assert db.topTenDeaths(5,5).get(7).getState().equalsIgnoreCase("OH"): "Should be OH";
      assert db.topTenDeaths(5,5).get(8).getState().equalsIgnoreCase("GA"): "Should be GA";
      assert db.topTenDeaths(5,5).get(9).getState().equalsIgnoreCase("CA"): "Should be CA";
      //Testing topTenDeaths
      
      System.out.println(db.safeToOpen("MI"));
      assert db.safeToOpen("MI").get(0).getMonth() == 5: "Month should be 5";
      assert db.safeToOpen("MI").get(0).getDay() == 26: "First day should be 26";
      assert db.safeToOpen("MI").get(1).getDay() == 27: "First day should be 27";
      assert db.safeToOpen("MI").get(2).getDay() == 28: "First day should be 28";
      assert db.safeToOpen("MI").get(3).getDay() == 29: "First day should be 29";
      assert db.safeToOpen("MI").get(4).getDay() == 30: "First day should be 30";
      //Testing safeToOpen
      
      System.out.println(db.listMinimumDailyInfections(6,12,1000));
      
      for(int i = 0; i < db.listMinimumDailyInfections(6,12,1000).size(); i++){
          assert db.listMinimumDailyInfections(6,12,1000).get(i).getDailyInfections() >= 1000
          : "There is atleast 1 that does not equal 1000";
        
        }
       
      ///Testing listMinimumDailyInfections
      assert db.countTotalInfections(3,1) == 16: "Should be 16"; ///Testing countTotalInfections
      assert db.countTotalDeaths(3,1) == 3: "Should be 3"; ///Testing countTotalDeaths
      assert db.getDailyDeaths(3,1).size() == 6: "Size should be 6";
      for(int i = 0; i < db.getDailyDeaths(3,1).size(); i++){
          assert db.getDailyDeaths(3,1).get(i).getMonth() == 3: " There is atleast one data entry in the ArrayList where month is not 3";
          assert db.getDailyDeaths(3,1).get(i).getDay() == 1: "There is atleast one data entry in the ArrayList where day is not 1";
        
        }
      assert db.getDailyDeaths(1,1).size() == 0: "Size should be 0"; ///Testing getDailyDeaths
      System.out.println("Test completed");
      
      
      
      
      
    
    }
}
