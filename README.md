# java-carRace
KTC step1 과제1 자동차경주 구현

## 프로젝트 소개
- 자동차 이름 및 갯수 시행 횟수 입력 받음.
- 0-9의 무작위 수중 4이상일 경우 한 칸 전진.
- 최종우승자 출력(여러명 가능)

## Car 객체
- **name** : 자동차 이름
- **go** : 전진 횟수
- **compareTo** : go 비교
  
## 기능 소개
### CarPlay
- **MakeCarList** : 이름 리스트로 Car객체 리스트 만듦.
- **CarRaceTry** : 각 차마다 랜덤숫자가 4이상이면 go를 1 진전 시킴.
### CarResult
- **CarRaceResult** : 시행 횟수마다 결과 리턴.
- **printGo** : go만큼 '-' 이어 리턴.
### CarWinner
- **Winner** : 최종 우승자 string 리턴.
- **jointWinner** : 공동 우승이 있을시 이름 추가.
### InputError
- **inputNameErrorTest** : 차동차 이름 입력이 맞는지 확인.
- **inputTryNumErrorTest** : 횟수 입력이 맞는지 확인
