import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.tasks.Read;
import com.bubnov.cityDirectory.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class moduleTwoTest {

    @Test
    public void testSortByName () throws FileNotFoundException {
        Read read = new Read();
        List<City> notSortedCities = read.readFromFile(getClass().getResource("testModuleTwo.txt").getFile());
        List<City> sortedCities = read.readFromFile(getClass().getResource("sortOne.txt").getFile());
        Task task = new Task(notSortedCities);
        List<City> citiesAfterSorting = task.sortByName();
        Assert.assertEquals(sortedCities,citiesAfterSorting);
    }

    @Test
    public void testSortByDistrictAndName() throws FileNotFoundException {
        Read read = new Read();
        List<City> notSortedCities = read.readFromFile(getClass().getResource("testModuleTwo.txt").getFile());
        List<City> sortedCities = read.readFromFile(getClass().getResource("sortTwo.txt").getFile());
        Task task = new Task(notSortedCities);
        List<City> citiesAfterSorting = task.sortByDistrictAndName();
        Assert.assertEquals(sortedCities,citiesAfterSorting);
    }

}
