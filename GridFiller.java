package cube;

public class GridFiller {

  private int sizeX = 0;
  private int sizeY = 0;
  private int sizeZ = 0;
  private int l     = 0;
  private int m     = 0;
  private int n     = 0;

  private long before = 0L;//閉領域処理の前後でのキューブの変化を比較して
  private long after  = 0L;//正常かどうかの判定に使用する

  private boolean[][][] tmp      = null;
  private boolean[][][] block    = null;
  private boolean[][][] original = null;

  private int mirror_1 = 0;
  private int mirror_2 = 0;
  private int mirror_3 = 0;
  private int mirror_4 = 0;
  private int mirror_5 = 0;
  private int mirror_6 = 0;


  public GridFiller() {}


  public GridFiller(int lt,int mt,int nt,boolean[][][] org,int m1,int m2,int m3,int m4,int m5,int m6) {

  original = org;

  mirror_1 = m1;
  mirror_2 = m2;
  mirror_3 = m3;
  mirror_4 = m4;
  mirror_5 = m5;
  mirror_6 = m6;

  System.out.println("mirror_1 "+mirror_1);
  System.out.println("mirror_2 "+mirror_2);
  System.out.println("mirror_3 "+mirror_3);
  System.out.println("mirror_4 "+mirror_4);
  System.out.println("mirror_5 "+mirror_5);
  System.out.println("mirror_6 "+mirror_6);




    l =lt;
    m =mt;
    n =nt;

    sizeX = l+2;
    sizeY = m+2;
    sizeZ = n+2;

  tmp = new boolean[sizeX][sizeY][sizeZ];

//***************
//*-------------*
//*-------------*
//*-------------*
//*-------------*
//*-------------*
//*-------------*
//***************
// * false - true

  for(int i=0;i<sizeX;i++)
  for(int j=0;j<sizeY;j++)
  for(int k=0;k<sizeZ;k++) tmp[i][j][k] = true;

    for(int i=0;i<sizeX;i++)
    for(int j=0;j<sizeY;j++){
      if(mirror_5==0)tmp[i][j][0      ] = false;
      if(mirror_6==0)tmp[i][j][sizeZ-1] = false;
    }
    for(int i=0;i<sizeX;i++)
    for(int k=0;k<sizeZ;k++){
      if(mirror_3==0)tmp[i][0      ][k] = false;
      if(mirror_4==0)tmp[i][sizeY-1][k] = false;
    }
    for(int j=0;j<sizeY;j++)
    for(int k=0;k<sizeZ;k++){
      if(mirror_1==0)tmp[0      ][j][k] = false;
      if(mirror_2==0)tmp[sizeX-1][j][k] = false;
    }

  block = new boolean[sizeX][sizeY][sizeZ];

  for(int i=0;i<sizeX;i++)
  for(int j=0;j<sizeY;j++)
  for(int k=0;k<sizeZ;k++)   block[i][j][k] = false;

  for(int i=1;i<sizeX-1;i++)
  for(int j=1;j<sizeY-1;j++)
  for(int k=1;k<sizeZ-1;k++) block[i][j][k] = original[i-1][j-1][k-1];
  }


  private long fillBlock(){

    long count = 0L;
    boolean buf;

    for (int i = 1; i < sizeX - 1; i++)
    for (int j = 1; j < sizeY - 1; j++)
    for (int k = 1; k < sizeZ - 1; k++) {
    if (block[i][j][k]){tmp[i][j][k] = true; continue;}
          buf = tmp[i][j][k];
          if (!block[i-1][j  ][k  ] && !tmp[i-1][j  ][k  ]) {tmp[i][j][k] = false;}
          if (!block[i+1][j  ][k  ] && !tmp[i+1][j  ][k  ]) {tmp[i][j][k] = false;}
          if (!block[i  ][j-1][k  ] && !tmp[i  ][j-1][k  ]) {tmp[i][j][k] = false;}
          if (!block[i  ][j+1][k  ] && !tmp[i  ][j+1][k  ]) {tmp[i][j][k] = false;}
          if (!block[i  ][j  ][k-1] && !tmp[i  ][j  ][k-1]) {tmp[i][j][k] = false;}
          if (!block[i  ][j  ][k+1] && !tmp[i  ][j  ][k+1]) {tmp[i][j][k] = false;}
          if (buf != tmp[i][j][k])
          count++;
        }
//  System.out.println("閉領域処理中 " + count+" tmp "+this.countTmpCube());
    System.out.println("閉領域処理中 " + count);

    return count;
  }

  private long fillBlock2(){

    long count = 0L;
    boolean buf;

    for(int i=sizeX-2;i>0;i--)
    for(int j=sizeY-2;j>0;j--)
    for(int k=sizeZ-2;k>0;k--){
    if(block[i][j][k]){tmp[i][j][k]=true; continue;}
    buf = tmp[i][j][k];
    if(!block[i-1][j  ][k  ] && !tmp[i-1][j  ][k  ]){tmp[i][j][k] = false;}
    if(!block[i+1][j  ][k  ] && !tmp[i+1][j  ][k  ]){tmp[i][j][k] = false;}
    if(!block[i  ][j-1][k  ] && !tmp[i  ][j-1][k  ]){tmp[i][j][k] = false;}
    if(!block[i  ][j+1][k  ] && !tmp[i  ][j+1][k  ]){tmp[i][j][k] = false;}
    if(!block[i  ][j  ][k-1] && !tmp[i  ][j  ][k-1]){tmp[i][j][k] = false;}
    if(!block[i  ][j  ][k+1] && !tmp[i  ][j  ][k+1]){tmp[i][j][k] = false;}
    if(buf != tmp[i][j][k]) count++;
//    System.out.println("AAAxx");
    }
//System.out.println("閉領域処理中 "+count+" tmp "+this.countTmpCube());
  System.out.println("閉領域処理中 "+count);

  return count;
  }

public long countCube(){
long c =0;
for(int i=0;i<l;i++)
for(int j=0;j<m;j++)
for(int k=0;k<n;k++)   if(original[i][j][k]) c++;
return c;
}


  public long countTmpCube(){
  long c =0;
  for(int i=0;i<sizeX;i++)
  for(int j=0;j<sizeY;j++)
  for(int k=0;k<sizeZ;k++)   if(tmp[i][j][k]) c++;
  return c;
  }



  public boolean[][][] makeBlock(){
//    System.out.println("l m n "+l+" "+m+" "+n+" "+original[0][0][0]);

 System.out.println("FILL CLOSED AREA.");
  before = countCube();
  while(true){
    if(fillBlock() ==0L){break;}
    if(fillBlock2()==0L){break;}
  }

  for(int i=1;i<sizeX-1;i++)
  for(int j=1;j<sizeY-1;j++)
  for(int k=1;k<sizeZ-1;k++) original[i-1][j-1][k-1] = tmp[i][j][k];
//System.out.println("l m n "+l+" "+m+" "+n+" "+original[0][0][0]);

//    System.out.println("COUNT B "+countCube());
  after = countCube();
  if(before==after){System.out.println("! 閉領域はありません。処理前:"+before+" 処理後:"+after);}
  else             {System.out.println("閉領域が充填されました。処理前:"+before+" 処理後:"+after);}
  return original;
  }




  public static void main(String[] args) {
    GridFiller gridFiller1 = new GridFiller();
  }

}