import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.tasks.Read;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class moduleOneTest {

    @Test(expected = FileNotFoundException.class)
    public void expectFileNotFoundException () throws FileNotFoundException {
        Read read = new Read();
        read.readFromFile("iDontHaveThisFile.txt");
    }

    @Test
    public void readTestFile() throws FileNotFoundException {
        City city = new City("Санкт-Петербург", "Санкт-Петербург", "Северо-Западный",
                5500000, "1703");
        Read read = new Read();
        List<City> cities = read.readFromFile(getClass().getResource("testModuleOne.txt").getFile());
        cities.get(0);
        Assert.assertEquals(cities.size(), 1);
        Assert.assertEquals(city,cities.get(0));

    }

}
