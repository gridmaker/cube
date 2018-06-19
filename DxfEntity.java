package cube;

//import karman2.*;
import java.util.*;
import java.math.BigDecimal;

public class DxfEntity {

  private int size = 0;
  private String[] groupCode;
  private String[] data;
  private Vector vecX,vecY,vecZ;
  private boolean triangle = false;
  private boolean d3face   = false;
  private boolean regular  = false;
  private Double[]  firstTriangle;
  private Double[] secondTriangle;

  public DxfEntity(){}

  public DxfEntity(Vector groupCodeSets) {
  DxfGroupCodeSet groupCodeSet;
  int count = 0;
  size = groupCodeSets.size();
  groupCode = new String[size];
  data      = new String[size];

  Enumeration enum2 = groupCodeSets.elements();
  while(enum2.hasMoreElements()){
     groupCodeSet = (DxfGroupCodeSet)enum2.nextElement();
     groupCode[count] = groupCodeSet.getGroupCode();
     data[count]      = groupCodeSet.getData();
     count++;
  }
  }

  public void setDatum(Vector groupCodeSets){
  DxfGroupCodeSet groupCodeSet;
  int count = 0;
  size = groupCodeSets.size();
  groupCode = new String[size];
  data      = new String[size];

  Enumeration enum2 = groupCodeSets.elements();
  while(enum2.hasMoreElements()){
     groupCodeSet = (DxfGroupCodeSet)enum2.nextElement();
     groupCode[count] = groupCodeSet.getGroupCode();
     data[count]      = groupCodeSet.getData();
     count++;
  }

  }

  public String getData(String gc){
    for(int i=0;i<size;i++)
      if(gc.trim().equals(groupCode[i].trim())) return data[i];
  return null;
  }

  public String getData(int gc){return getData(""+gc);}

  public void setData(String gc,String dt){
    for(int i=0;i<size;i++)
      if(gc.trim().equals(groupCode[i].trim())) data[i] = dt;
  }

  public void setData(int gc,String dt){setData(""+gc,dt);}

  public void initEntity(){

    double val;
    String sval;
    int i;
    vecX = new Vector();
    vecY = new Vector();
    vecZ = new Vector();

    String type = getData(0).trim();
    type = type.toUpperCase();
    if(type.equals("3DFACE")){d3face=true;}
    else{d3face=false;return;}

    for(i=0;i<9;i++){
//  19  29  39  は要確認
       sval = getData(10+i);
       if(sval == null) break;
       val=new BigDecimal((""+sval).trim()).doubleValue();
       val=new Eng(val).doubleValue();
       vecX.addElement(new Double(""+val));
    }
    for(i=0;i<9;i++){
//  19  29  39  は要確認
       sval = getData(20+i);
       if(sval == null) break;
       val=new BigDecimal((""+sval).trim()).doubleValue();
       val=new Eng(val).doubleValue();
       vecY.addElement(new Double(""+val));
    }
    for(i=0;i<9;i++){
//  19  29  39  は要確認
       sval = getData(30+i);
//       System.out.println("ZZZ "+sval);
       if(sval == null) break;
       val=new BigDecimal((""+sval).trim()).doubleValue();
       val=new Eng(val).doubleValue();
       vecZ.addElement(new Double(""+val));
    }

   if(vecX.size()!=4 || vecY.size()!=4 || vecZ.size()!=4){regular = false;return;}
   else{regular = true;}

//***** 3DFACE が前提　細かいチェックは無視
    Double x2 = (Double)vecX.elementAt(2);
    Double x3 = (Double)vecX.elementAt(3);
    Double y2 = (Double)vecY.elementAt(2);
    Double y3 = (Double)vecY.elementAt(3);
    Double z2 = (Double)vecZ.elementAt(2);
    Double z3 = (Double)vecZ.elementAt(3);

    if(x2.compareTo(x3)==0 && y2.compareTo(y3)==0 && z2.compareTo(z3)==0){triangle = true;}
    else{triangle = false;}
  }

  public boolean is3DFace()  {



    return d3face;}
  public boolean isTriangle(){return triangle;}
  public boolean isRegular() {return regular;}

  public Vector getVecX(){
  return vecX;
  }
  public Vector getVecY(){
  return vecY;
  }
  public Vector getVecZ(){
  return vecZ;
  }


  public Double[] getRectangleX(){
  Double[] rec = new Double[4];
  rec[0] = (Double)vecX.elementAt(0);
  rec[1] = (Double)vecX.elementAt(1);
  rec[2] = (Double)vecX.elementAt(2);
  rec[3] = (Double)vecX.elementAt(3);
  return rec;
  }

  public Double[] getRectangleY(){
  Double[] rec = new Double[4];
  rec[0] = (Double)vecY.elementAt(0);
  rec[1] = (Double)vecY.elementAt(1);
  rec[2] = (Double)vecY.elementAt(2);
  rec[3] = (Double)vecY.elementAt(3);
  return rec;
  }

  public Double[] getRectangleZ(){
  Double[] rec = new Double[4];
  rec[0] = (Double)vecZ.elementAt(0);
  rec[1] = (Double)vecZ.elementAt(1);
  rec[2] = (Double)vecZ.elementAt(2);
  rec[3] = (Double)vecZ.elementAt(3);
  return rec;
  }

  public Double[] getFirstTriangleX(){
  Double[] tri = new Double[3];
  tri[0] = (Double)vecX.elementAt(0);
  tri[1] = (Double)vecX.elementAt(1);
  tri[2] = (Double)vecX.elementAt(2);
  return tri;
  }
  public Double[] getFirstTriangleY(){
  Double[] tri = new Double[3];
  tri[0] = (Double)vecY.elementAt(0);
  tri[1] = (Double)vecY.elementAt(1);
  tri[2] = (Double)vecY.elementAt(2);
  return tri;
  }
  public Double[] getFirstTriangleZ(){
  Double[] tri = new Double[3];
  tri[0] = (Double)vecZ.elementAt(0);
  tri[1] = (Double)vecZ.elementAt(1);
  tri[2] = (Double)vecZ.elementAt(2);
  return tri;
  }

  public Double[] getLastTriangleX(){
  Double[] tri = new Double[3];
  tri[0] = (Double)vecX.elementAt(0);
  tri[1] = (Double)vecX.elementAt(2);
  tri[2] = (Double)vecX.elementAt(3);
  return tri;
  }
  public Double[] getLastTriangleY(){
  Double[] tri = new Double[3];
  tri[0] = (Double)vecY.elementAt(0);
  tri[1] = (Double)vecY.elementAt(2);
  tri[2] = (Double)vecY.elementAt(3);
  return tri;
  }
  public Double[] getLastTriangleZ(){
  Double[] tri = new Double[3];
  tri[0] = (Double)vecZ.elementAt(0);
  tri[1] = (Double)vecZ.elementAt(2);
  tri[2] = (Double)vecZ.elementAt(3);
  return tri;
  }






/*
  public Vector getPoints() throws NumberFormatException{

  Vector points = new Vector();

  double x,y,z;
  String sx,sy,sz;
  for(int i=0;i<9;i++){
//  19  29  39  は要確認
     sx = getData(10+i);
     sy = getData(20+i);
     sz = getData(30+i);
     if(sx == null || sy == null || sz == null) break;
     x=new Double(sx).doubleValue();
     y=new Double(sy).doubleValue();
     z=new Double(sz).doubleValue();
     points.addElement(new Point4(x,y,z));

  }
  return points;
  }
*/
/*
  public void setPoints(Vector points){

  double x,y,z;
  int count = 0;
  Point4 point;

     Enumeration enum = points.elements();
     while(enum.hasMoreElements()){
       point=(Point4)enum.nextElement();
         x=point.getX();
         y=point.getY();
         z=point.getZ();
       setData(10+count,""+x);
       setData(20+count,""+y);
       setData(30+count,""+z);
     count++;
     if(count == 10) break;
     }
  }
*/
  public String toString(){
  String str="";
    for(int i=0;i<size;i++){
    str+=groupCode[i];
    str+="\n";
    str+=data[i];
    str+="\n";
    }
   return str;
  }

  public static void main(String[] args) {
    DxfEntity dxfEntity = new DxfEntity();
    dxfEntity.invokedStandalone = true;
  }
  private boolean invokedStandalone = false;
}
