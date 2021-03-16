package Week1_PaintingShapes;

public class Cylinder extends Shape{
    private double radius; //radius in feet
    private double height; // height in feet
    //----------------------------------
// Constructor: Sets up the cylinder.
//----------------------------------
    public Cylinder(double r, double newHeight)
    {
        super("Cylinder");
        radius = r;
        height = newHeight;
    }
    //-----------------------------------------
// Returns the surface area of the cylinder.
//-----------------------------------------
    public double area()
    {
        return Math.PI*Math.pow(radius,2)*height;
    }
    //-----------------------------------
// Returns the cylinder as a String.
//-----------------------------------
    public String toString()
    {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}
