import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = input.nextLine();
        InputError.inputNameErrorTest(carNames);
        List<Car> carList = CarPlay.makeCarList(carNames); //car 객체 리스트

        System.out.println("시도할 횟수는 몇회인가요?");
        String tryNumString = input.nextLine();
        int tryNum = InputError.inputTryNumErrorTest(tryNumString);

        System.out.println("\n" + "실행결과");
        for(int i=0; i<tryNum; i++){ //시도횟수 만큼 반복
            CarPlay.carRaceTry(carList);
            System.out.println(CarResult.carRaceResult(carList));
        }

        System.out.println(CarWinner.winner(carList));
    }
}
