import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = input.nextLine().split(","); //,구분한 이름 리스트
        List<Car> carList = makeCarList(carNameList); //car 객체 리스트

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = input.nextInt();
        System.out.println();

        System.out.println("실행결과");
        for(int i=0; i<tryNum; i++){ //시도횟수 만큼 반복
            carRaceTry(carList);
            System.out.println(carRaceResult(carList));
        }

        System.out.println(winner(carList));
    }

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


    /**
     * 우승자 String 생성
     * @param carList 정렬된 carList
     * @return 우승자 String
     */
    public static String winner(List<Car> carList) {
        Collections.sort(carList); //go순으로 정렬
        String WinnerString = "최종우승자 : " + carList.get(0).getName();
        int maxGo = carList.get(0).getGo();
        //공동 우승자 있을 시
        WinnerString += jointWinner(carList, maxGo);
        return WinnerString;
    }

    /**
     * 우승한 Car 와 go가 같은 공동 우승자 출력
     * @param carList
     * @param maxGo 우승 자동차의 전진 횟수
     * @return 공동 우승자 String
     */
    public static String jointWinner(List<Car> carList, int maxGo) {
        StringBuilder jointWinnerString = new StringBuilder();
        for(int i=1; i<carList.size(); i++){
            if(carList.get(i).getGo() == maxGo){
                jointWinnerString.append(", ").append(carList.get(i).getName());
            }
        }
        return jointWinnerString.toString();
    }
}
