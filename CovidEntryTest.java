import java.io.IOException;
/**
 * Write a description of class CovidEntryTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CovidEntryTest
{
    public static void main(String[] args)throws IOException{
        CovidDatabase database = new CovidDatabase();
        database.readCovidData("COVID_Sample_data_for_Project_3.txt");
        System.out.println(database.countRecords());
    
    }
}
