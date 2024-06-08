import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTest {
    @Test
    void MakeCarListTry(){
        Application app = new Application();
        String[] carNameList = {"aaa", "bbb", "ccc"};
        List<Car> resultCarList = app.makeCarList(carNameList);

        List<Car> expectCarList = new ArrayList<>();
        expectCarList.add(new Car("aaa"));
        expectCarList.add(new Car("bbb"));
        expectCarList.add(new Car("ccc"));

        for(int i=0; i<3; i++){
            assertTrue(expectCarList.get(i).getName().equals(resultCarList.get(i).getName())
                    && expectCarList.get(i).getGo() == 0);
        }
    }

    @Test
    void carRaceTry(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.get(1).setGo(3);
        assertTrue(carList.get(0).getGo() == 0 || carList.get(0).getGo() == 1);
        assertTrue(carList.get(1).getGo() == 3 || carList.get(1).getGo() == 4);
    }

    @Test
    void carRaceResultTry(){
        Application app = new Application();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.get(0).setGo(3);
        carList.get(1).setGo(1);
        String expect = """
                aaa : ---
                bbb : -
                """;
        assertEquals(expect, app.carRaceResult(carList));
    }

    @Test
    void printGoTry(){
        Application app = new Application();
        Car car = new Car("qqq");
        car.setGo(5);
        assertEquals("-----", app.printGo(car));
    }

    @Test
    void winnerOneTry(){
        Application app = new Application();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.add(new Car("ccc"));
        carList.get(0).setGo(2);
        carList.get(1).setGo(4);
        carList.get(2).setGo(3);
        String expect = "최종우승자 : bbb";
        assertEquals(expect, app.winner(carList));
    }

    @Test
    void winnerTwoTry(){
        Application app = new Application();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.add(new Car("ccc"));
        carList.get(0).setGo(2);
        carList.get(1).setGo(3);
        carList.get(2).setGo(3);
        String expect = "최종우승자 : bbb, ccc";
        assertEquals(expect, app.winner(carList));
    }

    @Test
    void winnerAllTry(){
        Application app = new Application();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.add(new Car("ccc"));
        carList.get(0).setGo(3);
        carList.get(1).setGo(3);
        carList.get(2).setGo(3);
        String expect = "최종우승자 : aaa, bbb, ccc";
        assertEquals(expect, app.winner(carList));
    }

    @Test
    void jointWinnerTry(){
        Application app = new Application();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.add(new Car("ccc"));
        carList.add(new Car("ddd"));
        carList.get(0).setGo(5);
        carList.get(1).setGo(5);
        carList.get(2).setGo(1);
        carList.get(3).setGo(5);
        String expect = ", bbb, ddd";
        assertEquals(expect, app.jointWinner(carList, 5));
    }
}
