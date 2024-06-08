import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //자동차 갯수, 이름 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        //,구분한 이름 리스트
        String[] carNameList = input.nextLine().split(",");
        //car 객체 리스트
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            //이름이 5이상이면 오류 발생
            if (name.length() > 5) {
                throw new IllegalStateException("잘못된 입력입니다.");
            }
            //아니면 car 객체 생성후 넣음
            carList.add(new Car(name));
        }

        //시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = input.nextInt();

        System.out.println();
        System.out.println("실행결과");

        //시도횟수 만큼 반복
        for(int i=0; i<tryNum; i++){
            //랜덤돌림
            CarRaceTry(carList);
            //결과 프린트
            CarRacePrint(carList);
            System.out.println();
        }
    }

    private static void CarRacePrint(List<Car> carList) {
    }

    /**
     * 각 car마다 랜덤 숫자가 4이상이면 1칸 전진
     * @param carList
     */
    private static void CarRaceTry(List<Car> carList) {
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
