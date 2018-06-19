package cube;

import java.util.*;

public class Cube {

//  private int l=100,m=100,n=100;
  private double[] coordsX=null,coordsY=null,coordsZ=null;
  private boolean[][][] block;
  private double   EPS    = 0.000D;

  private Point5 start_line = null;
  private Point5   end_line = null;
  private Point5  mid_point = null;
  private Point5 tp1 = null,tp2 = null,tp3 = null;

// ラインの端点
  private double xp = 0.0D,yp=0.0D,zp=0.0D;
  private double xq = 0.0D,yq=0.0D,zq=0.0D;
  private double x,y,z;
  private double mid_x,mid_y,mid_z;
  private int posX = 0,posY = 0,posZ = 0;

//  TreeMap t = new TreeMap();//直線方程式のtを保存
  TreeMap t = null;//直線方程式のtを保存


  public Cube() {}
/*
  public Cube(int l,int m,int n) {
  this.l = l;
  this.m = m;
  this.n = n;
  }
*/
/*
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
*/
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



   public void setLine(double xp,double yp,double zp,double xq,double yq,double zq){

     this.xp = xp;
     this.yp = yp;
     this.zp = zp;
     this.xq = xq;
     this.yq = yq;
     this.zq = zq;

     start_line = new Point5(xp,yp,zp);
       end_line = new Point5(xq,yq,zq);
  }

  public void setLine(Point5 p,Point5 q){

    start_line = p;
      end_line = q;
 }


  public void calcT(){

  double tt = 0.0D;
  t = new TreeMap();//直線方程式のtを保存

/*
  for(int i=0;i<l+1;i++){
  tt = (coordsX[i]-xp)/(xq-xp);
  if(0.0D <= tt && tt <= 1.0D) t.put(new Double(tt),new Double(tt));
  }

  for(int j=0;j<m+1;j++){
  tt = (coordsY[j]-yp)/(yq-yp);
  if(0.0D <= tt && tt <= 1.0D) t.put(new Double(tt),new Double(tt));
  }

  for(int k=0;k<n+1;k++){
  tt = (coordsZ[k]-zp)/(zq-zp);
  if(0.0D <= tt && tt <= 1.0D) t.put(new Double(tt),new Double(tt));
  }
*/

/*
for(int i=0;i<l+1;i++){
tt = (coordsX[i]-start_line.getX())/(end_line.getX()-start_line.getX());
if(0.0D <= tt && tt <= 1.0D) t.put(new Double(tt),new Double(tt));
}

for(int i=0;i<m+1;i++){
tt = (coordsY[i]-start_line.getY())/(end_line.getY()-start_line.getY());
if(0.0D <= tt && tt <= 1.0D) t.put(new Double(tt),new Double(tt));
}

for(int i=0;i<n+1;i++){
tt = (coordsZ[i]-start_line.getZ())/(end_line.getZ()-start_line.getZ());
if(0.0D <= tt && tt <= 1.0D) t.put(new Double(tt),new Double(tt));
}
*/

//輪郭線が計算格子と完全に一致するときは立方体を出力しなくてもよい。このときはポリゴンで正確に判定出来る
//tt = (x-a)/l =(x-b)/m = (x-c)/n
for(int i=0;i<coordsX.length;i++){
tt = (coordsX[i]-start_line.getX())/(end_line.getX()-start_line.getX());
if(0.0D-EPS <= tt && tt <= 1.0D+EPS) t.put(new Double(tt),new Double(tt));
}

for(int i=0;i<coordsY.length;i++){
tt = (coordsY[i]-start_line.getY())/(end_line.getY()-start_line.getY());
if(0.0D-EPS <= tt && tt <= 1.0D+EPS) t.put(new Double(tt),new Double(tt));
}

for(int i=0;i<coordsZ.length;i++){
tt = (coordsZ[i]-start_line.getZ())/(end_line.getZ()-start_line.getZ());
if(0.0D-EPS <= tt && tt <= 1.0D+EPS) t.put(new Double(tt),new Double(tt));
}



}

  public void judgement(){
    Collection co  = t.values();
    Iterator   ite = co.iterator();

    double     t0 =0.0D,t1=0.0D;
    int             size  = t.size();
    double[]     t_array  = new double[size  ];
    Point5[]     points   = new Point5[size  ];
    Point5[]     mid_pnts = new Point5[size-1];

/*
    double[]     pointsX = new double[size];
    double[]     pointsY = new double[size];
    double[]     pointsZ = new double[size];
    double[] mid_pointsX = new double[size-1];
    double[] mid_pointsY = new double[size-1];
    double[] mid_pointsZ = new double[size-1];
*/
    int i = 0;
    while(ite.hasNext()){
    t_array[i] = ((Double)ite.next()).doubleValue();
     points[i] = calcPoint(start_line,end_line,t_array[i]);
//    System.out.println("t_array["+i+"] = "+t_array[i]);
    i++;
    }

    for(i=0;i<size-1;i++){
    this.makeBlock(this.getMidlePoint(points[i],points[i+1]));
    }
  }


  private Point5 calcPoint(Point5 p,Point5 q,double t){
    double xp = p.getX();
    double yp = p.getY();
    double zp = p.getZ();
    double xq = q.getX();
    double yq = q.getY();
    double zq = q.getZ();
//    System.out.println("PPP "+(xp + (xq-xp)*t));
    return new Point5(xp + (xq-xp)*t,yp + (yq-yp)*t,zp + (zq-zp)*t);
  }

  private Point5 getMidlePoint(Point5 p,Point5 q){

    double xp = p.getX();
    double yp = p.getY();
    double zp = p.getZ();
    double xq = q.getX();
    double yq = q.getY();
    double zq = q.getZ();
//System.out.println("MID "+((xp+xq)*0.5D));

    return new Point5((xp+xq)*0.5D,(yp+yq)*0.5D,(zp+zq)*0.5D);
  }


   private void calcPoint(double xp,double yp,double zp,double xq,double yq,double zq,double t){
//直線の方程式

     x = xp + (xq-xp)*t;
     y = yp + (yq-yp)*t;
     z = zp + (zq-zp)*t;


   }

   private void getMidlePoint(double xp,double yp,double zp,double xq,double yq,double zq){
     mid_x = (xp+xq)*0.5D;
     mid_y = (yp+yq)*0.5D;
     mid_z = (zp+zq)*0.5D;
   }


   private void makeBlock(Point5 middle){

   double mx = middle.getX();
   double my = middle.getY();
   double mz = middle.getZ();
   boolean findX = false;
   boolean findY = false;
   boolean findZ = false;
   int i=0,j=0,k=0;


//   ラインが軸の座標値と一致したときはプラス側にブロックを生成
   for(i=0;i<coordsX.length-1;i++){//マイナス側ブロックは無視する
//   if(coordsX[i] <= mx && mx <  coordsX[i+1]){findX=true;break;}
     if(coordsX[i]-EPS <= mx && mx <= coordsX[i+1]+EPS){findX=true;break;}
   }
   for(j=0;j<coordsY.length-1;j++){//マイナス側ブロックは無視する
//   if(coordsY[j] <= my && my <  coordsY[j+1]){findY=true;break;}
     if(coordsY[j]-EPS <= my && my <= coordsY[j+1]+EPS){findY=true;break;}
   }
   for(k=0;k<coordsZ.length-1;k++){//マイナス側ブロックは無視する
//   if(coordsZ[k] <= mz && mz <  coordsZ[k+1]){findZ=true;break;}
     if(coordsZ[k]-EPS <= mz && mz <= coordsZ[k+1]+EPS){findZ=true;break;}
   }




   if(findX && findY && findZ){

     this.block[i][j][k] = true;}//ラインと交差するブロック
  // System.out.println("BLOCK X Y Z "+i+" "+j+" "+k);


 }


/*
   private void getPosition(double mx,double my,double mz){
   int i=-1,j=-1,k=-1;

   for(i=0;i<coordsX.length-1;i++){if(coordsX[i]<= mx && mx < coordsX[i+1]) break;}//イコールのときの処理を検討すること
   for(j=0;j<coordsY.length-1;j++){if(coordsY[j]<= my && my < coordsY[j+1]) break;}
   for(k=0;k<coordsZ.length-1;k++){if(coordsZ[k]<= mz && mz < coordsZ[k+1]) break;}

   this.block[i][j][k] = true;//ラインと交差するブロック
 }
*/
  public boolean[][][] getBlock(){return block;}
  public void setTriangle(Point5 tp1,Point5 tp2,Point5 tp3){
/*
    if(this.isSamePoint(tp1,tp2)) throw new Exception("tp1とtp2は同じ点です");
    if(this.isSamePoint(tp2,tp3)) throw new Exception("tp2とtp3は同じ点です");
    if(this.isSamePoint(tp1,tp3)) throw new Exception("tp1とtp3は同じ点です");
*/
    this.tp1 = tp1;
    this.tp2 = tp2;
    this.tp3 = tp3;
  }

  public boolean isSamePoint(Point5 p,Point5 q){

  if(p.getX() == q.getX() && p.getY() == q.getY() && p.getZ() == q.getZ()) return true;
  return false;
  }


  public void makeTriangleEdgeBlock() throws Exception{

    if(this.isSamePoint(tp1,tp2)) throw new Exception("tp1とtp2は同じ点です");
    if(this.isSamePoint(tp2,tp3)) throw new Exception("tp2とtp3は同じ点です");
    if(this.isSamePoint(tp1,tp3)) throw new Exception("tp1とtp3は同じ点です");


    makeBlock(tp1);//頂点は必ず押さえる
    makeBlock(tp2);
    makeBlock(tp3);

    setLine(tp1,tp2);
    calcT();
    judgement();
    setLine(tp2,tp3);
    calcT();
    judgement();
    setLine(tp1,tp3);
    calcT();
    judgement();
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



//    Cube cube1 = new Cube(100,100,100);
//    cube1.initArray();
//    cube1.setLine(5,5,5,20,20,20);

    Cube cube = new Cube();
    cube.setCoords(coordsX,coordsY,coordsZ,block);
    cube.setTriangle(new Point5(10,10,10),new Point5(60,10,10),new Point5(60,60,10));

    try {
      cube.makeTriangleEdgeBlock();
    }
    catch (Exception ex) {
    ex.printStackTrace();
    System.exit(0);
    }

    CubeDxfPrinter cdp = new CubeDxfPrinter();
    cdp.printCube("c:\\cubecube.dxf",coordsX,coordsY,coordsZ,cube.getBlock());

/*
    cube1.calcT();
    cube1.judgement();
*/

  }

}