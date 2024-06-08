import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = input.nextLine().split(","); //,구분한 이름 리스트
        List<Car> carList = CarPlay.makeCarList(carNameList); //car 객체 리스트

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = input.nextInt();
        System.out.println();

        System.out.println("실행결과");
        for(int i=0; i<tryNum; i++){ //시도횟수 만큼 반복
            CarPlay.carRaceTry(carList);
            System.out.println(CarResult.carRaceResult(carList));
        }

        System.out.println(CarWinner.winner(carList));
    }
}
