public class InputError {
    /**
     * 자동차 이름이 제대로 입력됐는지 확인
     * @param carNames
     */
    public static void inputNameErrorTest(String carNames){
        if(!carNames.contains(",")){
            throw new IllegalStateException("자동차는 2대 이상 ,로 구분되어야 합니다.");
        }
    }

    /**
     * 횟수가 제대로 입력됐는지 확인
     * @param tryNumString
     * @return 맞다면 int로 반환
     */
    public static int inputTryNumErrorTest(String tryNumString){
        boolean isNumeric = tryNumString.matches("[+-]?\\d*(\\.\\d+)?");
        if(isNumeric){
            return Integer.parseInt(tryNumString);
        }
        throw new IllegalStateException("횟수는 숫자여야 합니다.");
    }
}
