import java.util.List;
import shape.Circle;
import shape.Rectangle;
import shape.Shape;

public class Test {
    public static <T extends Shape> void drawShapes(List<T> shapes) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).drow();  
        }
    }
    public static void main(String[] args) {
         List<Rectangle> rectangleList = List.of(new Rectangle(), new Rectangle());
        List<Shape> shapeList = List.of(new Rectangle(), new Circle(), new Rectangle());

        System.out.println("Drow shapes from Rectangle List ..:");
        drawShapes(rectangleList); 

        System.out.println("\nDrow shapes from Shape List ..:");
        drawShapes(shapeList);
    }
    
}