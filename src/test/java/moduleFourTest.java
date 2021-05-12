import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.tasks.ReadFile;
import com.bubnov.cityDirectory.tasks.RegionCount;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class moduleFourTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @Test
    public void testCountCityByRegions() throws FileNotFoundException {

        ReadFile readFile = new ReadFile();
        List<City> cities = readFile.readFromFile("testModuleFour.txt");

        System.setOut(new PrintStream(outputStreamCaptor));

        String checkOut = "Города в разрезе регионов:\n"
                + "Мурманская область - 2\n"
                + "Санкт-Петербург - 1";

        RegionCount regionCount = new RegionCount();
        regionCount.countCityByRegions(cities);

        Assert.assertEquals(checkOut, outputStreamCaptor.toString()
                .trim());

    }

}
