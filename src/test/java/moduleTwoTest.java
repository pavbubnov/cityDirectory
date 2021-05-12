import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.tasks.ReadFile;
import com.bubnov.cityDirectory.tasks.Sorting;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class moduleTwoTest {

    @Test
    public void testSortByName () throws FileNotFoundException {

        ReadFile readFile = new ReadFile();

        List<City> notSortedCities = readFile.readFromFile("testModuleTwo.txt");
        List<City> sortedCities = readFile.readFromFile("sortOne.txt");

        Sorting sorting = new Sorting();
        List<City> citiesAfterSorting = sorting.sortByName(notSortedCities);

        Assert.assertEquals(sortedCities,citiesAfterSorting);

    }

    @Test
    public void testSortByDistrictAndName() throws FileNotFoundException {

        ReadFile readFile = new ReadFile();

        List<City> notSortedCities = readFile.readFromFile("testModuleTwo.txt");
        List<City> sortedCities = readFile.readFromFile("sortTwo.txt");

        Sorting sorting = new Sorting();
        List<City> citiesAfterSorting = sorting.sortByDistrictAndName(notSortedCities);

        Assert.assertEquals(sortedCities,citiesAfterSorting);

    }

}
