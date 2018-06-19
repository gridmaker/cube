package cube;
import java.io.*;
import java.util.*;

public class CubeDxfPrinter {

   private PrintWriter  fw;

  public CubeDxfPrinter() {
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

  }catch (Exception e){System.out.println("\nDxfPrinter.print3DFACE_RECT\n "+e);}

}





  public static void main(String[] args) {
    CubeDxfPrinter cubeDxfPrinter1 = new CubeDxfPrinter();
  }

}