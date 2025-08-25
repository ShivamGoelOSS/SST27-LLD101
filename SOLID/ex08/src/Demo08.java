public class Demo08 {
    public static void main(String[] args) {
        Bicycle v = new BasicBicycle();
        v.pedal(5);
        v.startEngine(); // crash
    }
}
