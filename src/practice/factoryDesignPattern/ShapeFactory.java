package practice.factoryDesignPattern;

public class ShapeFactory {

    public Shape getShape(String shape) {
        shape = shape.toLowerCase();
        return switch (shape) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            case "square" -> new Square();
            default -> new Circle();
        };

    }
}
