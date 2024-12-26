import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise2 {
//Find the most populated city of each continent
    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();

  //      write your answer here
  List<City> highPopulated = countryDao.findAllCountries()  //findAllCountries() method presumably returns a list of countries
               .stream()  //converts that list into a stream
               .map(country-> country.getCities()
               .stream()
               .max(Comparator.comparing(City::getPopulation))) //.map() operation transforms each country object in the stream then take this list in stream and use max to return the highest cities with population
               .filter(Optional::isPresent)   //Optional --> which means that it may or may not contain a city
               .map(Optional::get)  //its extract the cities with the highest population 
               .collect(Collectors.toList());  //terminal operation that collects the results (the cities with the highest population) into a list.

              

              InMemoryWorldDao worldDao = InMemoryWorldDao.getInstance();
              
              worldDao.getAllContinents().stream()
              .map
              (continent -> 
              highPopulated.stream()
              .filter(city -> countryDao.findCountryByCode(city.getCountryCode()).getContinent().equals(continent))
              .max(Comparator.comparing(City::getPopulation)))
              .filter(Optional::isPresent)
              .map(optional -> optional.get())
              .forEach(city -> System.out.println(city));
              
              
              
    
              }
  
  
  



}


