package cube;

public class PolyToCube {

  private int l=100,m=100,n=100;
  private double[] coordsX=null,coordsY=null,coordsZ=null;
  private boolean[][][] block;
  private double EPS = 0.0000;

  private Point5 start_line = null;
  private Point5   end_line = null;
  private Point5  mid_point = null;
  private Point5 triangle_G = null;

  double A = 0.0D,B = 0.0D,C = 0.0D,D = 0.0D;// Ax+By+Cz+D = 0 平面の方程式



  public PolyToCube() {}

  public void setCoords(double[] cx,double[] cy,double[] cz,boolean[][][] blk){
    this.coordsX = cx;
    this.coordsY = cy;
    this.coordsZ = cz;
    this.block   = blk;

/*
    block = new boolean[cx.length-1][cy.length-1][cz.length-1];
    for(int i= 0;i<cx.length-1;i++)
    for(int j= 0;j<cy.length-1;j++)
    for(int k= 0;k<cz.length-1;k++) block[i][j][k] = false;
*/
  }

  public boolean[][][] getBlock(){
  return block;
  }


  public void initArray(){
    coordsX = new double[l+1];
    coordsY = new double[m+1];
    coordsZ = new double[n+1];
    for(int i= 0;i<l+1;i++) coordsX[i] = (double)i;
    for(int j= 0;j<m+1;j++) coordsY[j] = (double)j;
    for(int k= 0;k<n+1;k++) coordsZ[k] = (double)k;

    block = new boolean[l][m][n];
    for(int i= 0;i<l;i++)
    for(int j= 0;j<m;j++)
    for(int k= 0;k<n;k++) block[i][j][k] = false;
  }

    public void calcPlain(Point5 p1,Point5 p2,Point5 p3){

      double x1 = p1.getX();
      double y1 = p1.getY();
      double z1 = p1.getZ();
      double x2 = p2.getX();
      double y2 = p2.getY();
      double z2 = p2.getZ();
      double x3 = p3.getX();
      double y3 = p3.getY();
      double z3 = p3.getZ();

      double aa = x2-x1;
      double bb = y2-y1;
      double cc = z2-z1;
      double dd = x3-x1;
      double ee = y3-y1;
      double ff = z3-z1;

      A = bb*ff-cc*ee;
      B = cc*dd-aa*ff;
      C = aa*ee-bb*dd;
      D = -x1*bb*ff-y1*cc*dd-z1*aa*ee+x1*cc*ee+y1*aa*ff+z1*bb*dd;
/*
      System.out.println("A= "+A);
      System.out.println("B= "+B);
      System.out.println("C= "+C);
      System.out.println("D= "+D);
*/
    }

    // 座標軸に平行な直線との交点を求める
    // 交点がないときもあるので注意！！
    public Point5 getIntersectZ(double x,double y) throws Exception{
    if(C==0.0D) throw new Exception("Cはゼロです。");
    double z = -1.0D*(A*x+B*y+D)/C;
    return new Point5(x,y,z);
    }

    public Point5 getIntersectY(double x,double z) throws Exception{
      if(B==0.0D) throw new Exception("Bはゼロです。");

    double y = -1.0D*(A*x+C*z+D)/B;
    return new Point5(x,y,z);
    }

    public Point5 getIntersectX(double y,double z) throws Exception{
      if(A==0.0D) throw new Exception("Aはゼロです。");

    double x = -1.0D*(B*y+C*z+D)/A;
    return new Point5(x,y,z);
    }

    public boolean isPointContainedPolygonXY(Point5 p1,Point5 p2,Point5 p3,Point5 px){
//三角形p1p2p3 にpxは包含されるか？
//XY平面に投影したとき
      double x  = px.getX();
      double y  = px.getY();
      double z  = px.getZ();//いらない？
      double x1 = p1.getX();
      double y1 = p1.getY();
      double z1 = p1.getZ();//いらない？
      double x2 = p2.getX();
      double y2 = p2.getY();
      double z2 = p2.getZ();//いらない？
      double x3 = p3.getX();
      double y3 = p3.getY();
      double z3 = p3.getZ();//いらない？

  double delta = (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
  double    xi = (y3-y1)*(x -x1)-(x3-x1)*(y -y1);
  double   eta =-(y2-y1)*(x -x1)+(x2-x1)*(y -y1);

      if(0.0D<xi && 0.0D<eta && (xi+eta)<delta) return true;
 else if(0.0D>xi && 0.0D>eta && (xi+eta)>delta) return true;
 else return false;
 }

 public boolean isPointContainedPolygon(double x,double y,double x1,double y1,double x2,double y2,double x3,double y3){
//三角形p1p2p3 にpxは包含されるか？
//XY平面に投影したとき

double delta = (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
double    xi = (y3-y1)*(x -x1)-(x3-x1)*(y -y1);
double   eta =-(y2-y1)*(x -x1)+(x2-x1)*(y -y1);

     if(0.0D<xi && 0.0D<eta && (xi+eta)<delta) return true;
else if(0.0D>xi && 0.0D>eta && (xi+eta)>delta) return true;
else return false;
}

  public void makeArray(Point5 p1,Point5 p2,Point5 p3) throws Exception{

    if(isSamePoint(p1,p2)) throw new Exception("p1とp2は同じです。");
    if(isSamePoint(p2,p3)) throw new Exception("p2とp3は同じです。");
    if(isSamePoint(p1,p3)) throw new Exception("p1とp3は同じです。");

    //三角形の重心を計算
    //単位CUBEより小さい微小ポリゴンもブロック化する？
    //計算簡略化のテクニック
    double mx = (p1.getX()+p2.getX()+p3.getX())/3.0D;
    double my = (p1.getY()+p2.getY()+p3.getY())/3.0D;
    double mz = (p1.getZ()+p2.getZ()+p3.getZ())/3.0D;

    boolean findX = false;
    boolean findY = false;
    boolean findZ = false;

    int i=0,j=0,k=0;

    for(i=0;i<coordsX.length-1;i++){//マイナス側ブロックは無視する
      if(coordsX[i]-EPS <= mx && mx <= coordsX[i+1]+EPS){findX=true;break;}
    }
    for(j=0;j<coordsY.length-1;j++){//マイナス側ブロックは無視する
      if(coordsY[j]-EPS <= my && my <= coordsY[j+1]+EPS){findY=true;break;}
    }
    for(k=0;k<coordsZ.length-1;k++){//マイナス側ブロックは無視する
      if(coordsZ[k]-EPS <= mz && mz <= coordsZ[k+1]+EPS){findZ=true;break;}
//    System.out.println("mzaa ="+mz);
    }

    if(findX && findY && findZ){this.block[i][j][k] = true;}//ラインと交差するブロック
//    System.out.println("BLOCK X Y Z "+i+" "+j+" "+k);

    Point5 p = null;
    double x = 0.0D;
    double y = 0.0D;
    double z = 0.0D;
    boolean contained = false;

//  this.initArray();
  this.calcPlain(p1,p2,p3);

  for(i=0;i<coordsX.length-1;i++)//xy平面投影
  for(j=0;j<coordsY.length-1;j++){
    contained = false;
    x = (coordsX[i]+coordsX[i+1])*0.5D;
    y = (coordsY[j]+coordsY[j+1])*0.5D;
    contained = this.isPointContainedPolygon(x,y,p1.getX(),p1.getY(),p2.getX(),p2.getY(),p3.getX(),p3.getY());
    //軸の座標値と平行平面が一致したときの処理を考えること
    try {
      if (contained) {
        p = this.getIntersectZ(x, y);
        for (k = 0; k < coordsZ.length - 1; k++) {
        //if (coordsZ[k] <= p.getZ() && p.getZ() < coordsZ[k + 1]) { // イコールのときの処理をどうする？
          if (coordsZ[k]-EPS <= p.getZ() && p.getZ() <= coordsZ[k + 1]+EPS) { // イコールのときの処理をどうする？
            block[i][j][k] = true;
            //System.out.println("BLOCK " + i + " " + j + " " + k);
            break;
          }
        }
      }
    }
    catch (Exception ex) {
    ex.printStackTrace();
    }

    }

    for(i=0;i<coordsX.length-1;i++)//xz平面投影
    for(k=0;k<coordsZ.length-1;k++){
      contained = false;
      x = (coordsX[i]+coordsX[i+1])*0.5D;
      y = (coordsZ[k]+coordsZ[k+1])*0.5D;//注意
      contained = this.isPointContainedPolygon(x,y,p1.getX(),p1.getZ(),p2.getX(),p2.getZ(),p3.getX(),p3.getZ());
      //軸の座標値と平行平面が一致したときの処理を考えること
      try {
        if (contained) {
          p = this.getIntersectY(x, y); //yに注意
          for (j = 0; j < coordsY.length - 1; j++) {
          //if (coordsY[j] <= p.getY() && p.getY() < coordsY[j + 1]) { // イコールのときの処理をどうする？
            if (coordsY[j]-EPS <= p.getY() && p.getY() <= coordsY[j + 1]+EPS) { // イコールのときの処理をどうする？
              block[i][j][k] = true;
              //System.out.println("BLOCK2 " + i + " " + j + " " + k);
             break;
            }
          }
        }
      }
      catch (Exception ex1) {
      ex1.printStackTrace();
      }
      }

    for(j=0;j<coordsY.length-1;j++)//yz平面投影
    for(k=0;k<coordsZ.length-1;k++){
      contained = false;
      x = (coordsY[j]+coordsY[j+1])*0.5D;//注意
      y = (coordsZ[k]+coordsZ[k+1])*0.5D;//注意
      contained = this.isPointContainedPolygon(x,y,p1.getY(),p1.getZ(),p2.getY(),p2.getZ(),p3.getY(),p3.getZ());
      //軸の座標値と平行平面が一致したときの処理を考えること
      try {
        if (contained) {
          p = this.getIntersectX(x, y); //x,yに注意
          for (i = 0; i < coordsX.length - 1; i++) {
          //if (coordsX[i] <= p.getX() && p.getX() < coordsX[i + 1]) { // イコールのときの処理をどうする？
            if (coordsX[i]-EPS <= p.getX() && p.getX() <= coordsX[i + 1]+EPS) { // イコールのときの処理をどうする？

              block[i][j][k] = true;
              //System.out.println("BLOCK3 " + i + " " + j + " " + k);
             break;
            }
          }
        }
      }
      catch (Exception ex2) {
      ex2.printStackTrace();
      }
      }



  }

  public boolean isSamePoint(Point5 p,Point5 q){

  if(p.getX() == q.getX() && p.getY() == q.getY() && p.getZ() == q.getZ()) return true;
  return false;
  }




  public static void main(String[] args) {

    int l=100,m=100,n=100;


    double[] coordsX = new double[l+1];
    double[] coordsY = new double[m+1];
    double[] coordsZ = new double[n+1];
    for(int i= 0;i<l+1;i++) coordsX[i] = (double)i;
    for(int j= 0;j<m+1;j++) coordsY[j] = (double)j;
    for(int k= 0;k<n+1;k++) coordsZ[k] = (double)k;

    boolean[][][] block = new boolean[l][m][n];
    for(int i= 0;i<l;i++)
    for(int j= 0;j<m;j++)
      for(int k= 0;k<n;k++) block[i][j][k] = false;


    PolyToCube ptc = new PolyToCube();
    ptc.setCoords(coordsX,coordsY,coordsZ,block);

    try {
      ptc.makeArray(new Point5(10, 10, 10), new Point5(60.0, 60.0,10),
                    new Point5(60, 10, 10));
//      ptc.makeArray(new Point5(10.1, 10.1, 10.1), new Point5(10.2,10.2,10.2),
//                    new Point5(10.3, 10.3, 10.3));


    }
    catch (Exception ex) {
    ex.printStackTrace();
    System.exit(0);
    }

    CubeDxfPrinter cdp = new CubeDxfPrinter();
    cdp.printCube("c:\\cubecube.dxf",coordsX,coordsY,coordsZ,ptc.getBlock());

  }

}