package Week1_PaintingShapes;

public abstract class Shape {
    public String shapeName;
    // constructor
    public Shape(String shapeNameNew) {
        shapeName = shapeNameNew;
    }
    // abstract method calculate area of shapes
    public abstract double area();

    public String toString() {
        return "Name of shape" + shapeName;
    }
}
