package cube;
import java.io.*;
import java.util.*;

public class CubeDxfPrinter5 {

  private PrintWriter  fw;

  public CubeDxfPrinter5() {
  }


  public void printCube(String filename,double[] x,double[] y,double[] z,boolean[][][] block){
  try{

    fw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));


    fw.write("  0\n");
    fw.write("SECTION\n");
    fw.write("  2\n");
    fw.write("ENTITIES\n");

    for(int i=0;i<x.length-1;i++){
      for(int j=0;j<y.length-1;j++){
        for(int k=0;k<z.length-1;k++){

  if(block[i][j][k]){
  System.out.println("四角を出力");

  fw.write("  0\n"+"3DFACE\n"+"  8\n"+"MODELDATA_RECT");
  fw.write("\n 62\n   "+8);
  fw.write("\n  10\n"+x[i  ]);
  fw.write("\n  20\n"+y[j  ]);
  fw.write("\n  30\n"+z[k  ]);
  fw.write("\n  11\n"+x[i+1]);
  fw.write("\n  21\n"+y[j  ]);
  fw.write("\n  31\n"+z[k  ]);
  fw.write("\n  12\n"+x[i+1]);
  fw.write("\n  22\n"+y[j+1]);
  fw.write("\n  32\n"+z[k  ]);
  fw.write("\n  13\n"+x[i  ]);
  fw.write("\n  23\n"+y[j+1]);
  fw.write("\n  33\n"+z[k  ]);
  fw.write("\n");

  fw.write("  0\n"+"3DFACE\n"+"  8\n"+"MODELDATA_RECT");
  fw.write("\n 62\n   "+8);
  fw.write("\n  10\n"+x[i  ]);
  fw.write("\n  20\n"+y[j  ]);
  fw.write("\n  30\n"+z[k+1]);
  fw.write("\n  11\n"+x[i+1]);
  fw.write("\n  21\n"+y[j  ]);
  fw.write("\n  31\n"+z[k+1]);
  fw.write("\n  12\n"+x[i+1]);
  fw.write("\n  22\n"+y[j+1]);
  fw.write("\n  32\n"+z[k+1]);
  fw.write("\n  13\n"+x[i  ]);
  fw.write("\n  23\n"+y[j+1]);
  fw.write("\n  33\n"+z[k+1]);
  fw.write("\n");

  fw.write("  0\n"+"3DFACE\n"+"  8\n"+"MODELDATA_RECT");
  fw.write("\n 62\n   "+8);
  fw.write("\n  10\n"+x[i  ]);
  fw.write("\n  20\n"+y[j  ]);
  fw.write("\n  30\n"+z[k  ]);
  fw.write("\n  11\n"+x[i+1]);
  fw.write("\n  21\n"+y[j  ]);
  fw.write("\n  31\n"+z[k  ]);
  fw.write("\n  12\n"+x[i+1]);
  fw.write("\n  22\n"+y[j  ]);
  fw.write("\n  32\n"+z[k+1]);
  fw.write("\n  13\n"+x[i  ]);
  fw.write("\n  23\n"+y[j  ]);
  fw.write("\n  33\n"+z[k+1]);
  fw.write("\n");

  fw.write("  0\n"+"3DFACE\n"+"  8\n"+"MODELDATA_RECT");
  fw.write("\n 62\n   "+8);
  fw.write("\n  10\n"+x[i  ]);
  fw.write("\n  20\n"+y[j+1]);
  fw.write("\n  30\n"+z[k  ]);
  fw.write("\n  11\n"+x[i+1]);
  fw.write("\n  21\n"+y[j+1]);
  fw.write("\n  31\n"+z[k  ]);
  fw.write("\n  12\n"+x[i+1]);
  fw.write("\n  22\n"+y[j+1]);
  fw.write("\n  32\n"+z[k+1]);
  fw.write("\n  13\n"+x[i  ]);
  fw.write("\n  23\n"+y[j+1]);
  fw.write("\n  33\n"+z[k+1]);
  fw.write("\n");

  fw.write("  0\n"+"3DFACE\n"+"  8\n"+"MODELDATA_RECT");
  fw.write("\n 62\n   "+8);
  fw.write("\n  10\n"+x[i  ]);
  fw.write("\n  20\n"+y[j  ]);
  fw.write("\n  30\n"+z[k  ]);
  fw.write("\n  11\n"+x[i  ]);
  fw.write("\n  21\n"+y[j+1]);
  fw.write("\n  31\n"+z[k  ]);
  fw.write("\n  12\n"+x[i  ]);
  fw.write("\n  22\n"+y[j+1]);
  fw.write("\n  32\n"+z[k+1]);
  fw.write("\n  13\n"+x[i  ]);
  fw.write("\n  23\n"+y[j  ]);
  fw.write("\n  33\n"+z[k+1]);
  fw.write("\n");

  fw.write("  0\n"+"3DFACE\n"+"  8\n"+"MODELDATA_RECT");
  fw.write("\n 62\n   "+8);
  fw.write("\n  10\n"+x[i+1]);
  fw.write("\n  20\n"+y[j  ]);
  fw.write("\n  30\n"+z[k  ]);
  fw.write("\n  11\n"+x[i+1]);
  fw.write("\n  21\n"+y[j+1]);
  fw.write("\n  31\n"+z[k  ]);
  fw.write("\n  12\n"+x[i+1]);
  fw.write("\n  22\n"+y[j+1]);
  fw.write("\n  32\n"+z[k+1]);
  fw.write("\n  13\n"+x[i+1]);
  fw.write("\n  23\n"+y[j  ]);
  fw.write("\n  33\n"+z[k+1]);
  fw.write("\n");


  }
      }
    }
    }
    fw.write("  0\n");
    fw.write("ENDSEC\n");
    fw.write("  0\n");
    fw.write("EOF\n");
    fw.flush();
    fw.close();

  }catch (Exception e){System.out.println("\nDxfPrinter.print3DFACE_RECT8888\n "+e);}

}

public int printCube2(String filename,double[] x,double[] y,double[] z,boolean[][][] block) throws Exception{

 int num = 0;

try{

  fw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));


  fw.write("  0\n");
  fw.write("SECTION\n");
  fw.write("  2\n");
  fw.write("ENTITIES\n");
}catch (Exception e){
  e.printStackTrace();
  throw e;
}

try{
 num = this.makeBlockToDxf(fw,x,y,z,block);
}catch (Exception e){
  e.printStackTrace();
  throw e;
//  System.out.println("\nDxfPrinter.print3DFACE_RECTbbb\n "+e);
}


try{
  fw.write("  0\n");
  fw.write("ENDSEC\n");
  fw.write("  0\n");
  fw.write("EOF\n");
  fw.flush();
  fw.close();

}catch (Exception e){
//  System.out.println("\nDxfPrinter.print3DFACE_RECTccc\n "+e);
  e.printStackTrace();
  throw e;
}

  System.out.println("正常に終了しました。");
  return num;

}



private int makeBlockToDxf(PrintWriter pw,double[] x,double[] y,double[] z,boolean[][][] block) throws Exception{

int outputNum = 0;//出力されたキューブの数

try{
//System.out.println("11111111");
//pw.println("AAAAA");
//System.out.println("1212123333");


  //データ圧縮版
      boolean[][] workArray       = null;
      int[][]     counterX        = null;
      int[][]     counterY        = null;
      boolean[]   scanline_master = null;
      boolean[]   scanline_temp   = null;

  int xSize = x.length-1;//要素数は配列より１少ない
  int ySize = y.length-1;
  int zSize = z.length-1;
  int pos   = 0;
  int pos2  = 0;
  int k1    = 0;
  int k2    = 0;

  boolean[][] zLayer   = null;
  boolean[][] tmpLayer = null;;

//System.out.println("111111112");
//z方向に同じパターンを見つける
for(int k=0;k<zSize;k++){

zLayer = get2DArray(xSize,ySize,k,block);

k1 = k;//k1にはじめの位置を保存

for(int kk=k;kk<zSize;kk++){
//System.out.println("ZZZZZZZZZZ");
tmpLayer = get2DArray(xSize,ySize,kk,block);
if(compare(tmpLayer,zLayer,xSize,ySize)){
if(kk == zSize-1){k=kk;k2=kk;}//一番上まできたときkkのループを抜ける
continue;//それ以外はループを継続
}
else{k2=kk-1;k=k2;break;}//パターンが変わった。合同レイヤの位置を保存。
}//k1 から k2　は同じ形状

//System.out.println("11111113");

// *      *            -1  -1
// *      *            -1  -1
// ***   **  *      *   4   5    *    *
// ***   **  ***   **   2   3    **  **
// ***** **  ***** **   1   1    *** **
//  圧縮前    y圧縮後　　counter   x圧縮後


workArray = new boolean[xSize][ySize];
counterX  = new     int[    2][xSize];
counterY  = new     int[    2][ySize];

for(int i=0;i<xSize;i++) {counterX[0][i]=-1;counterX[1][i]=-1;}//配列を-1で初期化(x方向圧縮用)
for(int j=0;j<ySize;j++) {counterY[0][j]=-1;counterY[1][j]=-1;}//配列を-1で初期化(y方向圧縮用)

for(int j=0;j<ySize;j++)
for(int i=0;i<xSize;i++)
workArray[i][j] = block[i][j][k];

//------------Y軸方向圧縮-----------------
scanline_temp   = new boolean[xSize];
scanline_master = new boolean[xSize];

pos =0;
counterY[0][0] = 0;
counterY[1][0] = 0;
for(int j=1;j<ySize;j++){

  for(int i=0;i<xSize;i++){scanline_master[i] = workArray[i][pos];}
  for(int i=0;i<xSize;i++){scanline_temp[i]   = workArray[i][j  ];}

if(compareArray(scanline_master,scanline_temp)){
  counterY[1][pos] = j;
  for(int i=0;i<xSize;i++){
  workArray[i][j] = false;
  }
}
else{
  counterY[0][pos+1] = j;
  counterY[1][pos+1] = j;

  if(j-pos>1){
  for(int i=0;i<xSize;i++){
    workArray[i][pos+1] = scanline_temp[i];
    workArray[i][j    ] = false;
  }}
  pos++;
}

}//END  OF  J

//------------X軸方向圧縮-----------------
scanline_temp   = new boolean[ySize];
scanline_master = new boolean[ySize];
pos =0;
counterX[0][0] = 0;
counterX[1][0] = 0;
for(int i=1;i<xSize;i++){
//System.out.println("I POS xSize ySize "+i+" "+pos+" "+xSize+" "+ySize);
  for(int j=0;j<ySize;j++){scanline_master[j] = workArray[pos][j];}
  for(int j=0;j<ySize;j++){scanline_temp[j]   = workArray[i  ][j];}

if(compareArray(scanline_master,scanline_temp)){
  counterX[1][pos] = i;
  for(int j=0;j<ySize;j++){
  workArray[i][j] = false;
  }
}
else{
  counterX[0][pos+1] = i;
  counterX[1][pos+1] = i;
  if(i-pos>1){
  for(int j=0;j<ySize;j++){
    workArray[pos+1][j] = scanline_temp[j];
    workArray[i    ][j] = false;
  }}
  pos++;
}

}//END  OF  I

//----------------------------------------------
outputNum += getLineCommand2(pw,x,y,z,workArray,counterX,counterY,k1,k2);

//  System.out.println("UUUUUEEEEEE22");

}
//    }//END  OF  K  C
//dos.writeBytes( "/******  END  OF  MATE MADE OF PANEL 2  ******\n");
}catch(Exception eexx){
    eexx.printStackTrace();
    throw eexx;
    }
/*
try{
 fw.write("  0\n");
 fw.write("ENDSEC\n");
 fw.write("  0\n");
 fw.write("EOF\n");
 fw.flush();
 fw.close();
}catch (Exception e){
 e.printStackTrace();
 throw e;
}
System.out.println("正常に終了しました。");
*/
return outputNum;
}

  private boolean containsNum(boolean[] array){
  int size = array.length;
  for(int i=1;i<size-1;i++) {
  if(array[i]){return true;}
  }
  return false;
  }

/*
  private boolean containsNum2(byte c,byte[][] tmpLayer,int sx,int sy){
  for(int j=1;j<sy;j++)
  for(int i=1;i<sx;i++)
  if(tmpLayer[i][j]==c) return true;
  return false;
  }
*/
  private boolean compareArray(boolean[] a,boolean[] b){
  if(a.length != b.length) System.out.println("ARRAY LENGTH ERROR !!");
  for(int i=0;i<a.length;i++){
  if(a[i] != b[i]) return false;
  }
  return true;
  }

  private void getLineCommand(int sx,int sy,int z1,int z2,byte[][] wa,int[][] cnt,int c) throws Exception{
  System.out.println("WORK ARRAY");
  for(int j=1;j<sy;j++){
  for(int i=1;i<sx;i++){
  System.out.print(""+wa[i][j]);
  }
  System.out.print("\n");
  }
  }


  private int getLineCommand2(PrintWriter pw,double[] cx,double[] cy,double[] cz,boolean[][] wa,int[][] cntX,int[][] cntY,int k1,int k2) throws Exception{

  int outputDxfNum = 0;

  try{

    int sx  = cx.length-1;
    int sy  = cy.length-1;
    int sz  = cz.length-1;
 //   int pos = 0;
    boolean[] scanLine = new boolean[cx.length];//毎回、最後尾にfalseをセットする


    for(int j=0;j<sy;j++){
 // System.out.println("SY:"+j);
  //System.out.println("j:"+j+" cntY:"+cntY[0][j]+" "+cntY[1][j]);
      if(cntY[0][j]==-1 && cntY[1][j]==-1) break;

      for(int i=0;i<sx;i++){scanLine[i] = wa[i][j];}

  scanLine[sx] = false;//末尾にfalseを追加

  boolean bs1  = false,be1=false;
  boolean str  = false;//処理中のフラッグ
  int     strX = 0;

  for(int i=0;i<sx;i++){
//  System.out.println("i:"+i+" cntX:"+cntX[0][i]+" "+cntX[1][i]);
  if(cntX[0][i]==-1 && cntX[1][i]==-1) break;
//  System.out.println("SX2:"+i);

    bs1 = scanLine[i  ];
    be1 = scanLine[i+1];
    if(i==0){
      if(bs1 && !be1){
        str = false;outputDxf2(pw,cx,cy,cz,cntX[0][0],cntX[1][0]+1,cntY[0][j],cntY[1][j]+1,k1,k2+1);
//        str = false;outputDxf(pw,cx,cy,cz,cntX[0][0],cntX[1][0]+1,cntY[0][j],cntY[1][j]+1,k1,k2+1);

        outputDxfNum++;
                                             }        //*-  *:true -:false
      if(!bs1 &&  be1){str = true;strX = i+1;}        //-*  strX→1
      if( bs1 &&  be1){str = true;strX = i;  }        //**  strX→0
    }

    else{
      if(bs1 && !be1 &&  str){
 //       System.out.println("cntX "+cntX[0][strX]+" "+cntX[1][i]+1);
        str = false;outputDxf2(pw,cx,cy,cz,cntX[0][strX],cntX[1][i]+1,cntY[0][j],cntY[1][j]+1,k1,k2+1);
 //       str = false;outputDxf(pw,cx,cy,cz,cntX[0][strX],cntX[1][i]+1,cntY[0][j],cntY[1][j]+1,k1,k2+1);
        outputDxfNum++;                              }//*-  *:true -:false
      if( !bs1 &&  be1 && !str){str = true; strX=i+1;}//-*
    }
  }
/*
  pos++;
  if(sy==pos) break;
*/
  }//while(cnt[0][pos]>0 && cnt[1][pos]>0)
  }catch (Exception exex){
  exex.printStackTrace();
  throw exex;
  }
  return outputDxfNum;
  }


  public void outputDxf(PrintWriter pw,double[] x,double[] y,double[] z,int x1,int x2,int y1,int y2,int z1,int z2) throws Exception{


  try{
    fw.write("  0\n"+"3DFACE\n"+"  8\n"+"Face1");
    fw.write("\n 62\n   "+7);
    fw.write("\n  10\n"+x[x1]);
    fw.write("\n  20\n"+y[y1]);
    fw.write("\n  30\n"+z[z1]);
    fw.write("\n  11\n"+x[x2]);
    fw.write("\n  21\n"+y[y1]);
    fw.write("\n  31\n"+z[z1]);
    fw.write("\n  12\n"+x[x2]);
    fw.write("\n  22\n"+y[y2]);
    fw.write("\n  32\n"+z[z1]);
    fw.write("\n  13\n"+x[x1]);
    fw.write("\n  23\n"+y[y2]);
    fw.write("\n  33\n"+z[z1]);
    fw.write("\n");
// System.out.println("AAAAAAAAAA3");
    fw.write("  0\n"+"3DFACE\n"+"  8\n"+"Face2");
    fw.write("\n 62\n   "+7);
    fw.write("\n  10\n"+x[x1]);
    fw.write("\n  20\n"+y[y1]);
    fw.write("\n  30\n"+z[z2]);
    fw.write("\n  11\n"+x[x2]);
    fw.write("\n  21\n"+y[y1]);
    fw.write("\n  31\n"+z[z2]);
    fw.write("\n  12\n"+x[x2]);
    fw.write("\n  22\n"+y[y2]);
    fw.write("\n  32\n"+z[z2]);
    fw.write("\n  13\n"+x[x1]);
    fw.write("\n  23\n"+y[y2]);
    fw.write("\n  33\n"+z[z2]);
    fw.write("\n");
// System.out.println("AAAAAAAAAA4");
    fw.write("  0\n"+"3DFACE\n"+"  8\n"+"Face3");
    fw.write("\n 62\n   "+7);
    fw.write("\n  10\n"+x[x1]);
    fw.write("\n  20\n"+y[y1]);
    fw.write("\n  30\n"+z[z1]);
    fw.write("\n  11\n"+x[x2]);
    fw.write("\n  21\n"+y[y1]);
    fw.write("\n  31\n"+z[z1]);
    fw.write("\n  12\n"+x[x2]);
    fw.write("\n  22\n"+y[y1]);
    fw.write("\n  32\n"+z[z2]);
    fw.write("\n  13\n"+x[x1]);
    fw.write("\n  23\n"+y[y1]);
    fw.write("\n  33\n"+z[z2]);
    fw.write("\n");
// System.out.println("AAAAAAAAAA5");
    fw.write("  0\n"+"3DFACE\n"+"  8\n"+"Face4");
    fw.write("\n 62\n   "+7);
    fw.write("\n  10\n"+x[x1]);
    fw.write("\n  20\n"+y[y2]);
    fw.write("\n  30\n"+z[z1]);
    fw.write("\n  11\n"+x[x2]);
    fw.write("\n  21\n"+y[y2]);
    fw.write("\n  31\n"+z[z1]);
    fw.write("\n  12\n"+x[x2]);
    fw.write("\n  22\n"+y[y2]);
    fw.write("\n  32\n"+z[z2]);
    fw.write("\n  13\n"+x[x1]);
    fw.write("\n  23\n"+y[y2]);
    fw.write("\n  33\n"+z[z2]);
    fw.write("\n");
// System.out.println("AAAAAAAAAA6");
    fw.write("  0\n"+"3DFACE\n"+"  8\n"+"Face5");
    fw.write("\n 62\n   "+7);
    fw.write("\n  10\n"+x[x1]);
    fw.write("\n  20\n"+y[y1]);
    fw.write("\n  30\n"+z[z1]);
    fw.write("\n  11\n"+x[x1]);
    fw.write("\n  21\n"+y[y2]);
    fw.write("\n  31\n"+z[z1]);
    fw.write("\n  12\n"+x[x1]);
    fw.write("\n  22\n"+y[y2]);
    fw.write("\n  32\n"+z[z2]);
    fw.write("\n  13\n"+x[x1]);
    fw.write("\n  23\n"+y[y1]);
    fw.write("\n  33\n"+z[z2]);
    fw.write("\n");
// System.out.println("AAAAAAAAAA7");
    fw.write("  0\n"+"3DFACE\n"+"  8\n"+"Face6");
    fw.write("\n 62\n   "+7);
    fw.write("\n  10\n"+x[x2]);
    fw.write("\n  20\n"+y[y1]);
    fw.write("\n  30\n"+z[z1]);
    fw.write("\n  11\n"+x[x2]);
    fw.write("\n  21\n"+y[y2]);
    fw.write("\n  31\n"+z[z1]);
    fw.write("\n  12\n"+x[x2]);
    fw.write("\n  22\n"+y[y2]);
    fw.write("\n  32\n"+z[z2]);
    fw.write("\n  13\n"+x[x2]);
    fw.write("\n  23\n"+y[y1]);
    fw.write("\n  33\n"+z[z2]);
    fw.write("\n");
  }catch(Exception exxx){
    exxx.printStackTrace();
    throw exxx;
  }

  }

  public void outputDxf2(PrintWriter pw,double[] x,double[] y,double[] z,int x1,int x2,int y1,int y2,int z1,int z2) throws Exception{

  double t = z[z2]-z[z1];
  try{

    fw.write("  0\n"+"SOLID\n"+"  8\n"+"OBJ");
    fw.write("\n 62\n   "+7);
    fw.write("\n  10\n"+x[x1]);
    fw.write("\n  20\n"+y[y1]);
    fw.write("\n  30\n"+z[z1]);
    fw.write("\n  11\n"+x[x2]);
    fw.write("\n  21\n"+y[y1]);
    fw.write("\n  31\n"+z[z1]);
    fw.write("\n  12\n"+x[x1]);
    fw.write("\n  22\n"+y[y2]);
    fw.write("\n  32\n"+z[z1]);
    fw.write("\n  13\n"+x[x2]);
    fw.write("\n  23\n"+y[y2]);
    fw.write("\n  33\n"+z[z1]);
    fw.write("\n  39\n"+t);
    fw.write("\n");
/*
    fw.write("  0\n"+"SOLID\n"+"  8\n"+"OBJ");
    fw.write("\n 62\n   "+7);
    fw.write("\n  10\n"+x[x1]);
    fw.write("\n  20\n"+y[y1]);
    fw.write("\n  30\n"+z[z1]);
    fw.write("\n  11\n"+x[x2]);
    fw.write("\n  21\n"+y[y1]);
    fw.write("\n  31\n"+z[z1]);
    fw.write("\n  12\n"+x[x2]);
    fw.write("\n  22\n"+y[y2]);
    fw.write("\n  32\n"+z[z1]);
    fw.write("\n  13\n"+x[x1]);
    fw.write("\n  23\n"+y[y2]);
    fw.write("\n  33\n"+z[z1]);
    fw.write("\n  39\n"+t);
    fw.write("\n");
*/

  }catch(Exception exxx){
    exxx.printStackTrace();
    throw exxx;
  }

  }
  private boolean[][] get2DArray(int sx,int sy,int z,boolean[][][] block){

  boolean[][] tmp = new boolean[sx+1][sy+1];
  for(int j=1;j<sy;j++)
  for(int i=1;i<sx;i++){
  tmp[i][j] = block[i][j][z];
  }
  return tmp;
  }

  private boolean compare(boolean[][] tmpLayer,boolean[][] zLayer,int sx,int sy){

  for(int j=1;j<sy;j++)
  for(int i=1;i<sx;i++)
  if(tmpLayer[i][j]!=zLayer[i][j]) return false;

  return true;

  }

  public static void main(String[] args) {
    CubeDxfPrinter5 cubeDxfPrinter1 = new CubeDxfPrinter5();
  }

}
