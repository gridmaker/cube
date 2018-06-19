package cube;

import java.io.*;
import java.util.*;

public class CubeDxfPrinter3 {

//   private PrintWriter  fw;

  public CubeDxfPrinter3() {
  }

  public int printCube2(String filename,double[] x,double[] y,double[] z,boolean[][][] block) throws Exception{

   int num = 0;
   PrintWriter    fw = null;
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
 // System.out.println("\nDxfPrinter.print3DFACE_RECTbbb\n "+e);
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

  boolean[] face= {false,false,false,false,false,false};

  int outputNum = 0;//出力されたキューブの数
  int xSize = x.length-1;//要素数は配列より１少ない
  int ySize = y.length-1;
  int zSize = z.length-1;

  for(int i=0;i<xSize;i++)
  for(int j=0;j<ySize;j++)
  for(int k=0;k<zSize;k++){

  if(block[i][j][k]){
 //   System.out.println("BLOCK "+i+" "+j+" "+k+block[i][j][k]);

    face[0]= false;
    face[1]= false;
    face[2]= false;
    face[3]= false;
    face[4]= false;
    face[5]= false;

         if(i==0             ){face[0]= true;outputNum++;}
    else if(!block[i-1][j][k]){face[0]= true;outputNum++;}
         if(i==xSize-1       ){face[1]= true;outputNum++;}
    else if(!block[i+1][j][k]){face[1]= true;outputNum++;}

         if(j==0             ){face[2]= true;outputNum++;}
    else if(!block[i][j-1][k]){face[2]= true;outputNum++;}
         if(j==ySize-1       ){face[3]= true;outputNum++;}
    else if(!block[i][j+1][k]){face[3]= true;outputNum++;}

         if(k==0             ){face[4]= true;outputNum++;}
    else if(!block[i][j][k-1]){face[4]= true;outputNum++;}
         if(k==zSize-1       ){face[5]= true;outputNum++;}
    else if(!block[i][j][k+1]){face[5]= true;outputNum++;}
    printDXF(pw,x[i],x[i+1],y[j],y[j+1],z[k],z[k+1],face);

  }
//  printDXF(pw,x[i],x[i+1],y[j],y[j+1],z[k],z[k+1],face);
  }
  return outputNum;
  }

  private void printDXF(PrintWriter fw2,double x0,double x1,double y0,double y1,double z0,double z1,boolean[] faces) throws Exception{
// System.out.println("AAAAAAAAAA3");
 //::::::::::::  1/4 Model ::::::::::::::::::
 //   double x = (x0+x1)*0.5D;
 //   double y = (y0+y1)*0.5D;
 //   if(x>0 || y>0) return;
 //::::::::::::  1/4 Model ::::::::::::::::::
 //System.out.println("AAAAAAAAAA3");

 
 
    try{
      if(faces[4]){
      fw2.write("  0\n"+"3DFACE\n"+"  8\n"+"Face5");
      fw2.write("\n 62\n   "+7);
      fw2.write("\n  10\n"+x0);
      fw2.write("\n  20\n"+y0);
      fw2.write("\n  30\n"+z0);
      fw2.write("\n  11\n"+x1);
      fw2.write("\n  21\n"+y0);
      fw2.write("\n  31\n"+z0);
      fw2.write("\n  12\n"+x1);
      fw2.write("\n  22\n"+y1);
      fw2.write("\n  32\n"+z0);
      fw2.write("\n  13\n"+x0);
      fw2.write("\n  23\n"+y1);
      fw2.write("\n  33\n"+z0);
      fw2.write("\n");
      }
// System.out.println("AAAAAAAAAA3");
      if(faces[5]){
      fw2.write("  0\n"+"3DFACE\n"+"  8\n"+"Face6");
      fw2.write("\n 62\n   "+7);
      fw2.write("\n  10\n"+x0);
      fw2.write("\n  20\n"+y0);
      fw2.write("\n  30\n"+z1);
      fw2.write("\n  11\n"+x1);
      fw2.write("\n  21\n"+y0);
      fw2.write("\n  31\n"+z1);
      fw2.write("\n  12\n"+x1);
      fw2.write("\n  22\n"+y1);
      fw2.write("\n  32\n"+z1);
      fw2.write("\n  13\n"+x0);
      fw2.write("\n  23\n"+y1);
      fw2.write("\n  33\n"+z1);
      fw2.write("\n");
      }
// System.out.println("AAAAAAAAAA4");
      if(faces[2]){
      fw2.write("  0\n"+"3DFACE\n"+"  8\n"+"Face3");
      fw2.write("\n 62\n   "+7);
      fw2.write("\n  10\n"+x0);
      fw2.write("\n  20\n"+y0);
      fw2.write("\n  30\n"+z0);
      fw2.write("\n  11\n"+x1);
      fw2.write("\n  21\n"+y0);
      fw2.write("\n  31\n"+z0);
      fw2.write("\n  12\n"+x1);
      fw2.write("\n  22\n"+y0);
      fw2.write("\n  32\n"+z1);
      fw2.write("\n  13\n"+x0);
      fw2.write("\n  23\n"+y0);
      fw2.write("\n  33\n"+z1);
      fw2.write("\n");
      }
// System.out.println("AAAAAAAAAA5");
      if(faces[3]){
      fw2.write("  0\n"+"3DFACE\n"+"  8\n"+"Face4");
      fw2.write("\n 62\n   "+7);
      fw2.write("\n  10\n"+x0);
      fw2.write("\n  20\n"+y1);
      fw2.write("\n  30\n"+z0);
      fw2.write("\n  11\n"+x1);
      fw2.write("\n  21\n"+y1);
      fw2.write("\n  31\n"+z0);
      fw2.write("\n  12\n"+x1);
      fw2.write("\n  22\n"+y1);
      fw2.write("\n  32\n"+z1);
      fw2.write("\n  13\n"+x0);
      fw2.write("\n  23\n"+y1);
      fw2.write("\n  33\n"+z1);
      fw2.write("\n");
      }
// System.out.println("AAAAAAAAAA6");
      if(faces[0]){
      fw2.write("  0\n"+"3DFACE\n"+"  8\n"+"Face1");
      fw2.write("\n 62\n   "+7);
      fw2.write("\n  10\n"+x0);
      fw2.write("\n  20\n"+y0);
      fw2.write("\n  30\n"+z0);
      fw2.write("\n  11\n"+x0);
      fw2.write("\n  21\n"+y1);
      fw2.write("\n  31\n"+z0);
      fw2.write("\n  12\n"+x0);
      fw2.write("\n  22\n"+y1);
      fw2.write("\n  32\n"+z1);
      fw2.write("\n  13\n"+x0);
      fw2.write("\n  23\n"+y0);
      fw2.write("\n  33\n"+z1);
      fw2.write("\n");
      }
// System.out.println("AAAAAAAAAA7");
      if(faces[1]){
      fw2.write("  0\n"+"3DFACE\n"+"  8\n"+"Face2");
      fw2.write("\n 62\n   "+7);
      fw2.write("\n  10\n"+x1);
      fw2.write("\n  20\n"+y0);
      fw2.write("\n  30\n"+z0);
      fw2.write("\n  11\n"+x1);
      fw2.write("\n  21\n"+y1);
      fw2.write("\n  31\n"+z0);
      fw2.write("\n  12\n"+x1);
      fw2.write("\n  22\n"+y1);
      fw2.write("\n  32\n"+z1);
      fw2.write("\n  13\n"+x1);
      fw2.write("\n  23\n"+y0);
      fw2.write("\n  33\n"+z1);
      fw2.write("\n");
      }
    }catch(Exception exxx){
      exxx.printStackTrace();
      throw exxx;
    }
  }


  public static void main(String[] args) {
    CubeDxfPrinter3 cubeDxfPrinter31 = new CubeDxfPrinter3();
  }

}