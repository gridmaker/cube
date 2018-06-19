package cube;

public class Cubenizer {

  private boolean[][][] block = null;;
  private double[] coordsX = null,coordsY = null,coordsZ = null;

  public Cubenizer() {}
  public void setCoords(double[] cx,double[] cy,double[] cz,boolean[][][] blk){
    this.coordsX = cx;
    this.coordsY = cy;
    this.coordsZ = cz;
    this.block   = blk;
  }

  public void updateBlock(Point5 p1,Point5 p2,Point5 p3){

    //CUBEが三角形の辺で串刺しにされる

    Cube cube = new Cube();
    cube.setCoords(coordsX,coordsY,coordsZ,block);
    cube.setTriangle(p1,p2,p3);
    try {
      cube.makeTriangleEdgeBlock();
      block = cube.getBlock();
    }catch (Exception ex) {}


    //三角形に点が包含される


    PolyToCube ptc = new PolyToCube();
    ptc.setCoords(coordsX,coordsY,coordsZ,block);
    try {
    ptc.makeArray(p1, p2, p3);
    block = ptc.getBlock();
    }
    catch (Exception ex1) {}


  }


/*
  public void makePolyToCube(double[] cx,double[] cy,double[] cz,boolean[][][] block,Point5 tp1,Point5 tp2,Point5 tp3){


  Cube cube = new Cube();
  cube.setCoords(cx,cy,cz,block);
  try {
    cube.makeTriangleEdgeBlock();
    block = cube.getBlock();
  }catch (Exception ex) {}


  PolyToCube ptc = new PolyToCube();
  ptc.setCoords(cx,cy,cz,block);
  try {
  ptc.makeArray(tp1, tp2, tp3);
  block = ptc.getBlock();
  }
  catch (Exception ex1) {}
}
*/
  public static void main(String[] args) {

    Point5 a1 = null,a2 = null,a3 = null;


    int l=200,m=200,n=200;

    double[] coordsX = new double[l+1];
    double[] coordsY = new double[m+1];
    double[] coordsZ = new double[n+1];

    for(int i= 0;i<l+1;i++) coordsX[i] = (double)i-100;
    for(int j= 0;j<m+1;j++) coordsY[j] = (double)j-100;
    for(int k= 0;k<n+1;k++) coordsZ[k] = (double)k-100;

    boolean[][][] block = new boolean[l][m][n];
    for(int i= 0;i<l;i++)
    for(int j= 0;j<m;j++)
    for(int k= 0;k<n;k++) block[i][j][k] = false;

    Cubenizer cnz = new Cubenizer();
    cnz.setCoords(coordsX,coordsY,coordsZ,block);

//    cnz.updateBlock(new Point5(-10,10,40),new Point5(60,-30,40),new Point5(60,60,40));
//    cnz.updateBlock(new Point5(10,10,10),new Point5(60,10,10),new Point5(60,60,10));

    cnz.updateBlock(new Point5(-10,10,40),new Point5(60,-30,40),new Point5(60,60,40));
    cnz.updateBlock(new Point5(10,10,10),new Point5(60,10,10),new Point5(60,60,10));



/*
    CubeDxfPrinter cdp = new CubeDxfPrinter();
    cdp.printCube("c:\\testcube.dxf",coordsX,coordsY,coordsZ,block);
*/
    CubeDxfFrinter2 cdp = new CubeDxfFrinter2();

    try {
      cdp.printCube2("c:\\testcube.dxf", coordsX, coordsY, coordsZ, block);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

  }

}