public class Main {
    public static void main(String[] args) {

        Picture picture = new Picture();
        Circle circle = new Circle();

        picture.addGraphic(new Text());
        picture.addGraphic(new Line());

        circle.addGraphic(new Line());
        circle.addGraphic(new Line());

        picture.addGraphic(circle);

        picture.getGraphic(2).draw();

        picture.draw();
    }
}