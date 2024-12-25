import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class Exercise1 {
//Find the highest populated city of each country
   public static void main(String[] args) {
      CountryDao countryDao= InMemoryWorldDao.getInstance();
      //write your answer here
     List<City> highPopulated = countryDao.findAllCountries()  //findAllCountries() method presumably returns a list of countries
               .stream()  //converts that list into a stream
               .map(country-> country.getCities()
               .stream()
               .max(Comparator.comparing(City::getPopulation))) //.map() operation transforms each country object in the stream then take this list in stream and use max to return the highest cities with population
               .filter(Optional::isPresent)   //Optional --> which means that it may or may not contain a city
               .map(Optional::get)  //its extract the cities with the highest population 
               .collect(Collectors.toList());  //terminal operation that collects the results (the cities with the highest population) into a list.
               highPopulated.forEach(System.out::println);  //print each city in the list
   }
}
/*
   * .stream(): Converts a collection into a stream for processing.
   * .map(): Transforms each element of the stream by applying a function.
   * .filter(): Filters elements based on a condition. 
   * .distinct(): Results in a stream containing only the unique elements.
   * .sorted():Results in a stream in which the elements are in sorted order. The new stream has the same number of elements as the original stream.
   * .forEach(): Performs processing on every element in a stream (display each element).
   * .collect(): A terminal operation that gathers the stream results into a collection (like a list). This is the final operation that produces the result.
 */