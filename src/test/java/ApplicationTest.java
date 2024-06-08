import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTest {
    @Test
    void CarRaceTry(){
        Application app = new Application();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.get(1).setGo(3);
        assertTrue(carList.get(0).getGo() == 0 || carList.get(0).getGo() == 1);
        assertTrue(carList.get(1).getGo() == 3 || carList.get(1).getGo() == 4);
    }

//    @Test
//    void Car
}
