package Week1_PaintingShapes;

public class Rectangle extends Shape{
    // Width and height in feet
    private double width;
    private double height;
    //----------------------------------
// Constructor: Sets up the Rectangle.
//----------------------------------
    public Rectangle(double newWidth, double newHeight)
    {
        super("Rectangle");
        width = newWidth;
        height = newHeight;
    }
    //-----------------------------------------
// Returns the surface area of the Rectangle.
//-----------------------------------------
    public double area()
    {
        return width * height;
    }
    //-----------------------------------
// Returns the Rectangle as a String.
//-----------------------------------
    public String toString()
    {
        return super.toString() + " of width " + width + " and height " + height;
    }
}
