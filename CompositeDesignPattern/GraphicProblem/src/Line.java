public class Line implements Graphic{
    Line(){
        System.out.println("create Line.");
    }

    @Override
    public void draw() {
        System.out.println("draw Line.");
    }
}
