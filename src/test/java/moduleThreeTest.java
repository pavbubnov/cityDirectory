import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.tasks.Read;
import com.bubnov.cityDirectory.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class moduleThreeTest {

    @Test
    public void testFindMaxPopulation() throws FileNotFoundException {
        Read read = new Read();
        List<City> notSortedList = read.readFromFile(getClass().getResource("testModuleThree.txt").getFile());
        Task task = new Task(notSortedList);
        Assert.assertEquals(task.findMaxPopulation(),
                String.format("[%d] = %,d", 5, 165183));
    }

}
