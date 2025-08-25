// public class Rectangle {
//     protected int w,h;
//     void setWidth(int w){ this.w = w; }
//     void setHeight(int h){ this.h = h; }
//     int area(){ return w*h; }
// }

public class Rectangle implements Shape{
    protected int w,h;
    void setWidth(int w){ this.w = w; }
    void setHeight(int h){ this.h = h; }
    public int area(){ return w*h; }
    public void resize(int width, int height){
        this.w = width; this.h = height;
    }
}