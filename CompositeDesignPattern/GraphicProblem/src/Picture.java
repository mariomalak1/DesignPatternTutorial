import java.util.ArrayList;
import java.util.List;

public class Picture implements Graphic{
    private final List<Graphic> Graphics;


    Picture(){
        Graphics = new ArrayList<>();
        System.out.println("create pic.");
    }


    @Override
    public void draw() {
        System.out.println("start draw Pic.");
        for (Graphic g: Graphics) {
            g.draw();
        }
        System.out.println("end draw Pic.");
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
