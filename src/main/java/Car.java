public class Car implements Comparable<Car>{
    private String name;
    private int go;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGo() {
        return go;
    }

    public void setGo(int go) {
        this.go = go;
    }

    public Car(String name) {
        this.name = name;
        this.go = 0;
    }

    @Override
    public int compareTo(Car o) {
        return o.getGo() - getGo();
    }
}
