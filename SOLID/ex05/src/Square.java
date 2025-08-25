
// public class Square extends Rectangle {
//     @Override void setWidth(int w){ this.w = this.h = w; }
//     @Override void setHeight(int h){ this.w = this.h = h; }
// }
public class Square implements Shape {
    private int side;

    public int area() {
        return side * side;
    }

    public void resize(int width, int height) {
        if (width != height) {
            throw new IllegalArgumentException("Square must have equal sides");
        }
        this.side = width;
    }
}