
public class Demo05 {
    static int areaAfterResize(Shape r){
        r.resize(4, 5); return r.area();
    }
    public static void main(String[] args) {
        System.out.println(areaAfterResize(new Rectangle())); // 20
        System.out.println(areaAfterResize(new Square()));    // 16 (!) violates expectation
    }
}
