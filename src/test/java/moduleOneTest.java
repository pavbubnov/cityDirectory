import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.tasks.ReadFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class moduleOneTest {


    @Test(expected = FileNotFoundException.class)
    public void expectFileNotFoundException () throws FileNotFoundException {

        ReadFile readFile = new ReadFile();
        readFile.readFromFile("iDontHaveThisFile.txt");
    }


    @Test
    public void readTestFile() throws FileNotFoundException {

        City city = new City("Санкт-Петербург", "Санкт-Петербург", "Северо-Западный",
                5500000, "1703");

        ReadFile readFile = new ReadFile();
        List<City> cities = readFile.readFromFile("testModuleOne.txt");
        cities.get(0);

        Assert.assertEquals(city,cities.get(0));

    }



}
