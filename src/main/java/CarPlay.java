import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarPlay {

    /**
     * 이름 리스트로 CarList 만듦
     * @param carNameList 이름 리스트
     * @return car객체 리스트
     */
    public static List<Car> makeCarList(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            //이름이 5이상이면 오류 발생
            if (name.length() > 5) {
                throw new IllegalStateException("잘못된 입력입니다.");
            }
            //아니면 car 객체 생성후 넣음
            carList.add(new Car(name));
        }
        return carList;
    }

    /**
     * 각 car마다 랜덤 숫자가 4이상이면 1칸 전진
     * @param carList
     */
    public static void carRaceTry(List<Car> carList) {
        for(Car car : carList){
            Random random = new Random();
            if(random.nextInt(9) >= 4){
                //4이상이면 전진
                int goTemp = car.getGo();
                goTemp++;
                car.setGo(goTemp);
            }
        }
    }
}
