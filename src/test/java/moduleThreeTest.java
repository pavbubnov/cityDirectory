import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.tasks.MaxPopulation;
import com.bubnov.cityDirectory.tasks.ReadFile;
import com.bubnov.cityDirectory.tasks.Sorting;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class moduleThreeTest {


    @Test
    public void testFindMaxPopulation() throws FileNotFoundException {

        ReadFile readFile = new ReadFile();
        List<City> notSortedList = readFile.readFromFile("testModuleThree.txt");

        Sorting sorting = new Sorting();
        City[] notSortedArray = sorting.createArray(notSortedList);

        MaxPopulation maxPopulation = new MaxPopulation();


        maxPopulation.findMaxPopulation(notSortedArray);
        Assert.assertEquals(maxPopulation.findMaxPopulation(notSortedArray),
                String.format("[%d] = %,d", 5, 165183));

    }

}
