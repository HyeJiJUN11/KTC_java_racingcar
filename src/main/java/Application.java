import java.util.ArrayList;
import java.util.List;
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

            //시도할 횟수 입력
            System.out.println("시도할 회수는 몇회인가요?");
            int tryNum = input.nextInt();

            System.out.println();
            System.out.println("실행결과");
        }
    }
}
