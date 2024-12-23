import java.util.List;
import shape.Circle;
import shape.Rectangle;
import shape.Shape;

public class Test {
    public static void drawShapes(List<? extends Shape> shapes){
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).drow();  
        }
    }
    public static void main(String[] args) {
        List<Rectangle> rectangleList = List.of(new Rectangle(), new Rectangle());
        List<Shape> shapeList = List.of(new Circle(), new Circle(), new Rectangle());

        System.out.println("Drow shapes from Rectangle List ..:");
        drawShapes(rectangleList); 
        System.out.println("------------------------------------------------------");
        System.out.println("Drow shapes from Shape List ..:");
        drawShapes(shapeList);
    }
    
}