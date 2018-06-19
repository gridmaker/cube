package cube;

import java.io.*;
import java.util.*;

public class Test {

  private double minX = Double.POSITIVE_INFINITY;
  private double minY = Double.POSITIVE_INFINITY;
  private double minZ = Double.POSITIVE_INFINITY;
  private double maxX = Double.NEGATIVE_INFINITY;
  private double maxY = Double.NEGATIVE_INFINITY;
  private double maxZ = Double.NEGATIVE_INFINITY;

  public Test() {
  }

  public void getMinMax(Point5 p){
    double x = p.getX();
    double y = p.getY();
    double z = p.getZ();
/*
    if(x==Double.NEGATIVE_INFINITY) return;
    if(x==Double.POSITIVE_INFINITY) return;
    if(y==Double.NEGATIVE_INFINITY) return;
    if(y==Double.POSITIVE_INFINITY) return;
    if(z==Double.NEGATIVE_INFINITY) return;
    if(z==Double.POSITIVE_INFINITY) return;
*/
    if(maxX < x) maxX = x;
    if(x < minX) minX = x;
    if(maxY < y) maxY = y;
    if(y < minY) minY = y;
    if(maxZ < z) maxZ = z;
    if(z < minZ) minZ = z;
  }

  public double getMinX(){return minX;}
  public double getMaxX(){return maxX;}
  public double getMinY(){return minY;}
  public double getMaxY(){return maxY;}
  public double getMinZ(){return minZ;}
  public double getMaxZ(){return maxZ;}

  public double[] makeCoords(double res,double min,double max){
  Vector cord = new Vector();

  double c     = (Math.floor(min/res)-1)*res;
  int    count = 0;
  double tmp = 0.0D;

//  System.out.println("CCC = "+c);

  while(true){
  tmp = c+res*count;
  count++;

  cord.add(new Double(tmp));

  if(max < tmp) break;
  }

//  System.out.println("count = "+count);

  int      size = cord.size();
  double[] ccc  = new double[size];
  int counter = 0;
  Enumeration enum2 = cord.elements();
  while(enum2.hasMoreElements()){
  double vvv = ((Double)enum2.nextElement()).doubleValue();
//  System.out.println("VVV "+counter+" "+vvv);
  ccc[counter++] = vvv;
//  System.out.println();
  }

  return ccc;
  }


  public double[] makeCoords(double res,double min,double max,int div,int part){
  div = 2;//::::::::::::::::::::::::とりあえず
    Vector cord = new Vector();

  double c     = (Math.floor(min/res)-1)*res;
  int    count = 0;
  double tmp = 0.0D;

//  System.out.println("CCC = "+c);

  while(true){
  tmp = c+res*count;
  count++;

  cord.add(new Double(tmp));

  if(max < tmp) break;
  }

//  System.out.println("count = "+count);

  int      size      = cord.size();
  int      size_down = (int)Math.ceil((double)(cord.size())/(double)div);
  int      size_up   = size-size_down+1;
  double[] ccc       = null;

  System.out.println("size = "     +size     );
  System.out.println("size_down = "+size_down);
  System.out.println("size_up = "  +size_up  );

  if(part==0){
  ccc  = new double[size_down];
  int counter = 0;
/*
  Enumeration enum = cord.elements();
  while(enum.hasMoreElements()){
  if(size_down<=counter) break;
  double vvv = ((Double)enum.nextElement()).doubleValue();
  ccc[counter++] = vvv;
  }
*/
  for(int i=0;i<size_down;i++){
    double vvv =  ((Double)cord.elementAt(i)).doubleValue();
  ccc[counter++] = vvv;
  }
  }

  else if(part==1){
  ccc  = new double[size_up];
  int counter = 0;
/*
  Enumeration enum = cord.elements();
  while(enum.hasMoreElements()){
  double vvv = ((Double)enum.nextElement()).doubleValue();
  if(size_down > counter){counter++; continue;}
  ccc[counter++] = vvv;

  }*/
  for(int i=size_down-1;i<size;i++){
    double vvv =  ((Double)cord.elementAt(i)).doubleValue();
  ccc[counter++] = vvv;


  }


  }

  return ccc;
  }


  public static void helpPrinter(){
    System.out.println("******************************************************");
    System.out.println("= 使用法 =");
    System.out.println("java [-cp classpath] angou.Startup cube.Test [格子間隔] [入力ファイル名] [出力ファイル名] [-fs]");
    System.out.println("格子間隔はゼロより大きい実数。");
    System.out.println("-f : 閉領域処理を行う（立方体で構成された閉領域を立方体で充填します）。");
    System.out.println("-s : 閉領域の表面のみ出力。");
    System.out.println("入力出力ファイルはDXFの3DFACEエンティティーのみに対応。");
    System.out.println("******************************************************\n\n");
  }



  public static void main(String[] args) throws Exception{

    int num_face    = 0;    //3DFACEのトータル
    int num_face4   = 0;    //四角形の3DFACE
    int num_hyoumen = 0;    //表面のみ出力時（-sオプション）の面の数
    boolean fill    = false;//閉領域を充填する
    boolean surface = false;//表面のみを出力

    int mirror_1 = 0;
    int mirror_2 = 0;
    int mirror_3 = 0;
    int mirror_4 = 0;
    int mirror_5 = 0;
    int mirror_6 = 0;


//    System.out.println("\n===== GridMaker Cubenizer Ver0.9 =====");
//    System.out.println(  "          (c)2006 Masatoshi Aoki\n");

    System.out.println("\n===== GridMaker Nanocube Ver 0.91 =====");
    System.out.println(  "           (c)2006 Masatoshi Aoki");
    System.out.println(  "                    AOK R&D.,LLP.");
    System.out.println(  "=======================================\n");


    if(args == null){
    Test.helpPrinter();
    System.exit(0);
    }
/*
    if(args.length<3 || 4<args.length){
    Test.helpPrinter();
    System.exit(0);
    }
    if(args.length==4){
    if(!"-f".equals(args[3].trim())){
    Test.helpPrinter();
    System.exit(0);
    }
    else{fill=true;}//閉領域をブロックで埋める
    }
*/
System.out.println("ZZZZZWWW");
if(args.length<3 || 16<args.length){
Test.helpPrinter();
System.exit(0);
}
//if(args.length==4){
System.out.println("ZZZZZWWW2 "+args[0]);
  if( "-f".equals(args[3].trim())){fill    = true;}//閉領域をブロックで埋める
     else if( "-s".equals(args[4].trim())){surface = true;}//表面のみ出力
     else if("-sf".equals(args[4].trim())){fill    = true;surface = true;}
     else if("-fs".equals(args[4].trim())){fill    = true;surface = true;}
     else                                 {Test.helpPrinter();System.exit(0);}
//}
System.out.println("ZZZZZWWW3");
    Test test = new Test();

//  double res = 1.0;//解像度
    double res = 2.0;//解像度

    int l=0,m=0,n=0;
    double[] coordsX = null;
    double[] coordsY = null;
    double[] coordsZ = null;
    int divX =1;
    int divY =1;
    int divZ =1;
    int posX =1;
    int posY =1;
    int posZ =1;

    try {
      res = new Double(args[1]).doubleValue();
    }
    catch (NumberFormatException ex) {
      System.out.println("エラー：格子間隔には半角の実数を入力してください。");
      Test.helpPrinter();
      System.exit(0);
    }

    if(res<=0.0)   {
      System.out.println("エラー：格子間隔には正の実数を入力してください。");
      Test.helpPrinter();
      System.exit(0);
    }

/*
    try {
      if(args[4] != null)divX = new Integer(args[4]).intValue();
      if(args[5] != null)posX = new Integer(args[5]).intValue();
      if(args[6] != null)divY = new Integer(args[6]).intValue();
      if(args[7] != null)posY = new Integer(args[7]).intValue();
      if(args[8] != null)divZ = new Integer(args[8]).intValue();
      if(args[9] != null)posZ = new Integer(args[9]).intValue();

      if(args[10] != null) mirror_1 = new Integer(args[10]).intValue();
      if(args[11] != null) mirror_2 = new Integer(args[11]).intValue();
      if(args[12] != null) mirror_3 = new Integer(args[12]).intValue();
      if(args[13] != null) mirror_4 = new Integer(args[13]).intValue();
      if(args[14] != null) mirror_5 = new Integer(args[14]).intValue();
      if(args[15] != null) mirror_6 = new Integer(args[15]).intValue();
    }

    catch (NumberFormatException ex) {
      System.out.println("エラー：計算領域分割数には半角の実数を入力してください。");
      Test.helpPrinter();
      System.exit(0);
    }

    if(divX<1)   {
      System.out.println("エラー：計算領域分割数には正の実数を入力してください。");
      Test.helpPrinter();
      System.exit(0);
    }

*/

/*
    int l=100,m=100,n=100;
    double[] coordsX = new double[l+1];
    double[] coordsY = new double[m+1];
    double[] coordsZ = new double[n+1];
    for(int i= 0;i<l+1;i++) coordsX[i] = (double)i;
    for(int j= 0;j<m+1;j++) coordsY[j] = (double)j;
    for(int k= 0;k<n+1;k++) coordsZ[k] = (double)k;
*/

    Double[] x = new Double[3];
    Double[] y = new Double[3];
    Double[] z = new Double[3];

    DxfReader dr  = new DxfReader();
    DxfEntity ent = null;
    Point5 p1= null,p2=null,p3=null;

    try {
      dr.switchOn(args[2]);
    }
    catch (IOException ex2) {
    System.out.println("エラー：入力ファイルの読込みに失敗しました。");
    Test.helpPrinter();
    ex2.printStackTrace();
    System.exit(0);
    }
    while(true){
    try {ent = dr.readEntity();}
    catch(EOFException exa) {break;}
    catch( IOException exb) {exb.printStackTrace();System.exit(0);}
//System.out.println("ZZZZZWWW");
    ent.initEntity();

    if(!ent.is3DFace() ) continue;
    if(!ent.isRegular()) continue;

    try {
//System.out.println("ZZZZZCCCCC");
      x = ent.getFirstTriangleX();
      y = ent.getFirstTriangleY();
      z = ent.getFirstTriangleZ();
      p1 = new Point5(x[0].doubleValue(), y[0].doubleValue(), z[0].doubleValue());
      p2 = new Point5(x[1].doubleValue(), y[1].doubleValue(), z[1].doubleValue());
      p3 = new Point5(x[2].doubleValue(), y[2].doubleValue(), z[2].doubleValue());
      test.getMinMax(p1);
      test.getMinMax(p2);
      test.getMinMax(p3);
//System.out.println("ZZZZZCCCCC2");
      if(!ent.isTriangle()){//四角の3DFACEのとき
      x = ent.getLastTriangleX();
      y = ent.getLastTriangleY();
      z = ent.getLastTriangleZ();
      p1 = new Point5(x[0].doubleValue(), y[0].doubleValue(), z[0].doubleValue());
      p2 = new Point5(x[1].doubleValue(), y[1].doubleValue(), z[1].doubleValue());
      p3 = new Point5(x[2].doubleValue(), y[2].doubleValue(), z[2].doubleValue());
      test.getMinMax(p1);
      test.getMinMax(p2);
      test.getMinMax(p3);
      num_face4++;
      }
//System.out.println("ZZZZZCCCCC77777");
    }
    catch (Exception ex1) {ex1.printStackTrace();System.exit(0);}
//    finally{dr.switchOff();}
    num_face++;
    }
//System.out.println("ZZZZZAAAA");
    dr.switchOff();
//    System.out.println("\n-----------------\n");
    System.out.println("3DFACE "+num_face );
    System.out.println("RECT "  +num_face4);
    System.out.println("格子間隔 "+res);
    System.out.println("形状の最小及び最大座標値");
    System.out.println("X "+test.getMinX()+" <-> "+test.getMaxX());
    System.out.println("Y "+test.getMinY()+" <-> "+test.getMaxY());
    System.out.println("Z "+test.getMinZ()+" <-> "+test.getMaxZ());

    coordsX = test.makeCoords(res,test.getMinX(),test.getMaxX());
    coordsY = test.makeCoords(res,test.getMinY(),test.getMaxY());
    coordsZ = test.makeCoords(res,test.getMinZ(),test.getMaxZ());

/*
    coordsX = test.makeCoords(res,test.getMinX(),test.getMaxX(),2,0);
    coordsY = test.makeCoords(res,test.getMinY(),test.getMaxY(),2,0);
    coordsZ = test.makeCoords(res,test.getMinZ(),test.getMaxZ(),2,0);
*/
/*
    coordsX = test.makeCoords(res,test.getMinX(),test.getMaxX(),divX,posX);
    coordsY = test.makeCoords(res,test.getMinY(),test.getMaxY(),divY,posY);
    coordsZ = test.makeCoords(res,test.getMinZ(),test.getMaxZ(),divZ,posZ);
*/
    l = coordsX.length-1;
    m = coordsY.length-1;
    n = coordsZ.length-1;
//    System.out.println("SSSSS l m n "+" "+l+" "+m+" "+n);

    try {
      dr.switchOn(args[2]);
    }
    catch (IOException ex2) {
      System.out.println("エラー：入力ファイルの読込みに失敗しました。");
      Test.helpPrinter();
      ex2.printStackTrace();
      System.exit(0);
    }

/*
    int l=100,m=100,n=100;
    double[] coordsX = new double[l+1];
    double[] coordsY = new double[m+1];
    double[] coordsZ = new double[n+1];
    for(int i= 0;i<l+1;i++) coordsX[i] = (double)i;
    for(int j= 0;j<m+1;j++) coordsY[j] = (double)j;
    for(int k= 0;k<n+1;k++) coordsZ[k] = (double)k;

    Double[] x = new Double[3];
    Double[] y = new Double[3];
    Double[] z = new Double[3];
*/

    boolean[][][] block = new boolean[l][m][n];
    for(int i= 0;i<l;i++)
    for(int j= 0;j<m;j++)
    for(int k= 0;k<n;k++) block[i][j][k] = false;

    cube.Cubenizer cube = new Cubenizer();
    cube.setCoords(coordsX,coordsY,coordsZ,block);

//    Test test = new Test();

//  DxfReader dr = new DxfReader();
//  dr.switchOn("c:\\test.dxf");
//  dr.switchOn(args[0]);

//    DxfEntity ent = null;

//    Point5 p1= null,p2=null,p3=null;

   System.out.println("GGGGGG");

    int t_num_face  = 0;
    int t_num_face4 = 0;

    while(true){
    try {ent = dr.readEntity();}
    catch (EOFException exaa) {break;}
    catch ( IOException exbb) {
    System.out.println("エラー：ファイルの出力に失敗しました。");
    Test.helpPrinter();
    exbb.printStackTrace();System.exit(0);
    }

    ent.initEntity();

    if(!ent.is3DFace() ) continue;
    if(!ent.isRegular()) continue;

    try {

      x = ent.getFirstTriangleX();
      y = ent.getFirstTriangleY();
      z = ent.getFirstTriangleZ();
      p1 = new Point5(x[0].doubleValue(), y[0].doubleValue(), z[0].doubleValue());
      p2 = new Point5(x[1].doubleValue(), y[1].doubleValue(), z[1].doubleValue());
      p3 = new Point5(x[2].doubleValue(), y[2].doubleValue(), z[2].doubleValue());
//      System.out.println("QQQQQ "+x[0]+" "+y[0]+" "+z[0]);
      cube.updateBlock(p1, p2, p3);
      t_num_face++;

      if(!ent.isTriangle()){//四角の3DFACEのとき
      x = ent.getLastTriangleX();
      y = ent.getLastTriangleY();
      z = ent.getLastTriangleZ();
      p1 = new Point5(x[0].doubleValue(), y[0].doubleValue(), z[0].doubleValue());
      p2 = new Point5(x[1].doubleValue(), y[1].doubleValue(), z[1].doubleValue());
      p3 = new Point5(x[2].doubleValue(), y[2].doubleValue(), z[2].doubleValue());
//      System.out.println("QQQQQ "+x[0]+" "+y[0]+" "+z[0]);
      cube.updateBlock(p1, p2, p3);
      t_num_face4++;
      }


//      dr.switchOff();

    }
    catch (Exception ex1) {ex1.printStackTrace();System.exit(0);}
//    finally{dr.switchOff();}

    System.out.println(t_num_face+"/"+num_face);
    }

      dr.switchOff();

/*
    CubeDxfPrinter cdp = new CubeDxfPrinter();
    cdp.printCube("c:\\cubecube.dxf",coordsX,coordsY,coordsZ,block);
*/

//閉じられたスペースをtrueで埋める
      System.out.println("FILL "+fill);

if(fill) block = new GridFiller(l,m,n,block,mirror_1,mirror_2,mirror_3,mirror_4,mirror_5,mirror_6).makeBlock();


//:::::::::::  半分出力  テスト　::::::::::::::::::::
/*
l = (int)(l/2);
for(int i= 0;i<l;i++)
for(int j= 0;j<m;j++)
for(int k= 0;k<n;k++) block[i][j][k] = false;
*/
//:::::::::::  半分出力  テスト　::::::::::::::::::::

/*
CubeDxfFrinter2 cdp = new CubeDxfFrinter2();
int num = cdp.printCube2(args[2],coordsX,coordsY,coordsZ,block);
*/
int num = 0;
if(surface){//表面を出力
CubeDxfPrinter3 cdp = new CubeDxfPrinter3();
num = cdp.printCube2(args[3],coordsX,coordsY,coordsZ,block);
}
else{//直方体を出力
CubeDxfPrinter5 cdp = new CubeDxfPrinter5();
num = cdp.printCube2(args[3],coordsX,coordsY,coordsZ,block);
}


int b_num = 0;
for(int i= 0;i<l;i++)
for(int j= 0;j<m;j++)
for(int k= 0;k<n;k++) if(block[i][j][k]) b_num++;



//System.out.println("\n-----------------\n");
//System.out.println("格子間隔 "+res);
System.out.println("読み込まれた3DFACE "+num_face+"(四角形 "+num_face4+")");
System.out.println("生成された立方体（圧縮前）  "+b_num);

if(surface){System.out.println("生成された正方形（表面）  "+  num);}
else       {System.out.println("生成された直方体（圧縮後）  "+  num+" ( "+num*6+" 面)");}
/*
System.out.println("形状の最小及び最大座標値");
System.out.println("X "+test.getMinX()+" <-> "+test.getMaxX());
System.out.println("Y "+test.getMinY()+" <-> "+test.getMaxY());
System.out.println("Z "+test.getMinZ()+" <-> "+test.getMaxZ());
*/

/*
System.out.println("MAX "+test.getMaxX()+" "+test.getMaxY()+" "+test.getMaxZ());
System.out.println("MIN "+test.getMinX()+" "+test.getMinY()+" "+test.getMinZ());
*/


/*
for(int iii =0;iii<coordsX.length;iii++) System.out.println("X"+iii+" "+coordsX[iii]);
for(int jjj =0;jjj<coordsY.length;jjj++) System.out.println("Y"+jjj+" "+coordsY[jjj]);
for(int kkk =0;kkk<coordsZ.length;kkk++) System.out.println("Z"+kkk+" "+coordsZ[kkk]);
*/

  }

}