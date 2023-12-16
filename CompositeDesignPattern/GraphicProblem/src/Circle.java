import java.util.ArrayList;
import java.util.List;

public class Circle implements Graphic{
    private final List<Graphic> Graphics;


    Circle(){
        Graphics = new ArrayList<>();
        System.out.println("create Circle.");
    }

    @Override
    public void draw() {
        System.out.println("start create Circle.");
        for (Graphic g: Graphics) {
            g.draw();
        }
        System.out.println("end draw Circle.");
    }


    public void addGraphic(Graphic graphic){
        Graphics.add(graphic);
    }

    public void removeGraphic(Graphic graphic){
        Graphics.remove(graphic);
    }

    public Graphic getGraphic(int i){
        return Graphics.get(i);
    }
}
