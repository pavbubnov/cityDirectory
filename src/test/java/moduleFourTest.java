import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.tasks.Read;
import com.bubnov.cityDirectory.tasks.Task;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class moduleFourTest {

    @Test
    public void testCountCityByRegions() throws FileNotFoundException {
        Read read = new Read();
        List<City> cities = read.readFromFile(getClass().getResource("testModuleFour.txt").getFile());
        Task task = new Task(cities);
        List<String> stringList = new ArrayList<>();
        stringList.add("Мурманская область - 2");
        stringList.add("Санкт-Петербург - 1");
        Assert.assertEquals(stringList, task.countCityByRegions());
    }

}
