import java.util.Comparator;
import java.util.List;

public class Exercise5 {
//Find the highest populated capital city
    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
       //write your answer here 
 
                List <Country> country =countryDao.findAllCountries(); 
                System.out.println(
                    country.stream() 
                .map(coun -> cityDao.findCityById(coun.getCapital()))
                .filter(o->o != null)
                .max(Comparator.comparingInt(City::getPopulation))
                );
                 

                
               
                
               
      
    }

}