import java.util.Collections;
import java.util.List;

public class CarResult {
    /**
     * 한 시도 횟수의 결과
     * @param carList
     * @return 결과 String
     */
    public static String carRaceResult(List<Car> carList) {
        StringBuilder raceResult = new StringBuilder();
        for(Car car : carList){
            raceResult.append(car.getName()).append(" : ").append(printGo(car)).append("\n");
        }
        return raceResult.toString();
    }

    /**
     * 이동한 거리 "-"로 출력
     * @param car
     * @return - string
     */
    public static String printGo(Car car) {
        StringBuilder goString = new StringBuilder();
        if(car.getGo() == 0)
            return goString.toString();
        for(int i=0; i<car.getGo(); i++){
            goString.append("-");
        }
        return goString.toString();
    }
}
