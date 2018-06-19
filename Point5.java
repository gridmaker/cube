package cube;

public class Point5 {

  private double x = 0.0D;
  private double y = 0.0D;
  private double z = 0.0D;

  public Point5() {
  }

  public Point5(double x,double y,double z){
    this.x=x;
    this.y=y;
    this.z=z;
  }


  public void setXYZ(double x,double y,double z){
    this.x=x;
    this.y=y;
    this.z=z;
    }

    public double getX(){return x;}
    public double getY(){return y;}
    public double getZ(){return z;}

    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}
    public void setZ(double z){this.z = z;}

  public static void main(String[] args) {
    Point5 point51 = new Point5();
  }

}