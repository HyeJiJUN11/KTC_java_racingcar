import java.util.Collections;
import java.util.List;

public class CarWinner {
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
