
//タイトル:   Karman2
//バージョン: 1.0
//著作権:     Copyright (c) 2001
//作者:       青木 正寿
//説明:       差分格子自動生成プログラム

package cube;
import java.text.*;
import java.math.*;

public class Eng {

/********PRECISIONとPRECISION_SIZEは常に対応********/
//  private  double  PRECISION      =      10.0D;//有効桁数 2　
//  private  double  PRECISION      =     100.0D;//有効桁数 3
//  private  double  PRECISION      =    1000.0D;//有効桁数 4
    private  double  PRECISION      = 1000000.0D;//有効桁数 7
//  private     int  PRECISION_SIZE =          2;//有効桁数 2　
//  private     int  PRECISION_SIZE =          3;//有効桁数 3
//  private     int  PRECISION_SIZE =          4;//有効桁数 4
    private     int  PRECISION_SIZE =          7;//有効桁数 7
/********PRECISIONとPRECISION_SIZEは常に対応********/

  private double  dNumber;
  private long    iNumber;
  private boolean fInt = true;

  public Eng() {}

  public Eng(double dNumber){
//  this.dNumber = dNumber;
  fInt = false;
  this.dNumber = epsilonCorrection5(dNumber);
//  System.out.println("dNum "+this.dNumber);
  }

  public Eng(long iNumber){
  this.iNumber = iNumber;
  fInt = true;
  }

  public Eng(double dNumber,double pre){
//  this.dNumber = dNumber;
  this.PRECISION = pre;
  fInt = false;
  this.dNumber = epsilonCorrection5(dNumber);
  }

  public Eng(long iNumber,double pre){
  this.iNumber = iNumber;
  this.PRECISION = pre;
  fInt = true;
  }

  public double doubleValue(){return dNumber;}

  public String toString(){
  if(fInt == true) return getInteger();
  return getDouble5();
  }

  private String getDouble(){
    double exponent = 0.0D;
    if(dNumber != 0.0D)exponent = Math.floor(Math.log(Math.abs(dNumber))/Math.log(10.0D));
    dNumber/=Math.pow(10.0D,exponent);
    String signN = dNumber>=0.0D ?" ":"-";
    String signB = exponent>=0 ?"+":"-";
    DecimalFormat form2 = new DecimalFormat("00");
    return " "+signN+getFormatNumber(Math.abs(dNumber))+"E"+signB+form2.format(Math.abs(exponent));
  }


  private String getDouble4(){
    double exponent = 0.0D;
    if(dNumber != 0.0D)exponent = Math.floor(Math.log(Math.abs(dNumber))/Math.log(10.0D));
    //dNumber= 1000.0のときexponent=2.0の数値誤差エラー
    dNumber/=Math.pow(10.0D,exponent);
    if(dNumber==10.0D || dNumber==-10.0D) {//数値誤差修正
    dNumber/=10.0D;
    this.epsilonCorrection4(dNumber);
    exponent+=1.0D;
    }
    String signN = dNumber>=0.0D ?" ":"-";
    String signB = exponent>=0 ?"+":"-";
    DecimalFormat form2 = new DecimalFormat("00");
    return " "+signN+getFormatNumber(Math.abs(dNumber))+"E"+signB+form2.format(Math.abs(exponent));
  }


  private String getDouble5(){
     int exponent = 0;
    if(dNumber != 0.0D)exponent = (int)Math.floor(Math.log(Math.abs(dNumber))/Math.log(10.0D));

    //dNumber= 1000.0のときexponent=2.0の数値誤差エラー
    //dNumber= 0.01のときexponent=-3.0の数値誤差エラー
    BigDecimal bdNumber = new BigDecimal(""+dNumber);
    int signum = bdNumber.signum();
    bdNumber = bdNumber.movePointLeft(exponent).abs();
    if(bdNumber.compareTo(new BigDecimal(10.0D))==0){
    bdNumber = bdNumber.movePointLeft(1);
    exponent++;
    }

    String signN = signum  >=0 ?" ":"-";
    String signB = exponent>=0 ?"+":"-";
    DecimalFormat form2 = new DecimalFormat("00");
    return " "+signN+getFormatNumber2(bdNumber.doubleValue())+"E"+signB+form2.format(Math.abs(exponent));
  }






  private boolean isInt(double val){


  BigDecimal a_val = new BigDecimal(""+val);
  BigDecimal b_val = new BigDecimal("1.0");
  BigDecimal c_val = b_val.divide(a_val,16,BigDecimal.ROUND_HALF_UP);

  return false;

  }

  private String getDouble3(){
    double exponent = 0.0D;
    if(dNumber != 0.0D){
    exponent = Math.log(Math.abs(dNumber))/Math.log(10.0D);
    if(this.isInt(dNumber)){ exponent = this.epsilonCorrection4(exponent);}
    else{exponent = Math.floor(exponent);}
    }


    dNumber/=Math.pow(10.0D,exponent);


    String signN = dNumber>=0.0D ?" ":"-";
    String signB = exponent>=0 ?"+":"-";
    DecimalFormat form2 = new DecimalFormat("00");
    return " "+signN+getFormatNumber(Math.abs(dNumber))+"E"+signB+form2.format(Math.abs(exponent));
  }

  private String getDouble2(){
    double exponent = 0.0D;
    double xxx = Math.log(Math.abs(dNumber))/Math.log(10.0D);
    boolean positive = true;
    if(xxx<0.0D){ positive = false; xxx*=-1.0D;}
    xxx = Math.round(xxx);
    if(!positive) xxx*=-1.0D;

    if(dNumber != 0.0D)exponent = xxx;
    dNumber/=Math.pow(10.0D,exponent);
    String signN = dNumber>=0.0D ?" ":"-";
    String signB = exponent>=0 ?"+":"-";
    DecimalFormat form2 = new DecimalFormat("00");
    return " "+signN+getFormatNumber(Math.abs(dNumber))+"E"+signB+form2.format(Math.abs(exponent));
  }

  private String getInteger(){
    int counter  = 6;
    double exponent = 0;

    if(iNumber <0) counter--;
    if(iNumber != 0)
    exponent = Math.floor(Math.log(Math.abs((double)iNumber))/Math.log(10.0D));
    counter -= exponent;
    StringBuffer sb = new StringBuffer();
    for(int i=0;i<counter;i++) sb.append(" ");
    sb.append(iNumber);
    return sb.toString();
  }


  private String getInteger2(){
   DecimalFormat form2 = new DecimalFormat("000000");
   return form2.format(iNumber);
  }



  private double epsilonCorrection(double value){
  if(value == 0.0D) return value; //0.0のときは何もしない
  boolean positiveNumber = true;
  if(value<0.0D){positiveNumber = false;value = Math.abs(value);}
  //+++++ valueは整数 で精度の範囲
  if(Math.floor(value)==Math.ceil(value) && value < PRECISION*10.0D){
    if(positiveNumber) return value;
    return -1.0D*value;
    }
  //+++++ 小数を含むか精度より大きい
  // value     = 8888.8885
  // PRECISION = 1000000.0　有効桁数 7
//  System.out.println("XXX "+value);

  double  exponent = (int)(Math.floor(Math.log(value)/Math.log(10.0D)));//底の変換
  //exponent = 3.0
//  System.out.println("A111 "+exponent);

//  System.out.println("A222 "+1.0/Math.pow(10.0D,exponent));
  double ppp = Math.pow(10.0D,exponent);

  if(ppp>=1.0) ppp = Math.rint(ppp);
  if(ppp< 1.0) ppp = 1.0/Math.rint(1.0/ppp);

//  System.out.println("PPP "+ppp);

//  value/= Math.pow(10.0D,exponent);//value = 8.88888849999998
  value= value/ppp;//value = 8.88888849999998
//  System.out.println("value  " +value);
//  value = (int)Math.round(value*PRECISION)*Math.pow(10.0D,exponent)/PRECISION;
  value = (int)Math.round(value*PRECISION)*ppp/PRECISION;

//  System.out.println("BBB  " +value);

  //step1  value = 888.89999
  //step2  value = 889.0
  //step3  value = 888000.0
  //step4  value = 8880
  if(positiveNumber) return value;
  return -1.0D*value;
  }

  private double epsilonCorrection2(double value){
  if(value == 0.0D) return value; //0.0のときは何もしない
  boolean positiveNumber = true;
  if(value<0.0D){positiveNumber = false;value = Math.abs(value);}
  //+++++ valueは整数 で精度の範囲
  if(Math.floor(value)==Math.ceil(value) && value < PRECISION*10.0D){
    if(positiveNumber) return value;
    return -1.0D*value;
    }
  //+++++ 小数を含むか精度より大きい
  // value     = 8888.8885
  // PRECISION = 1000000.0　PRECISION_SIZE = 7 有効桁数 7

  int  exponent = (int)(Math.floor(Math.log(value)/Math.log(10.0D)));//底の変換
  //exponent = 3

  int mov = PRECISION_SIZE-exponent-1;
   //mov = 3

  double mov2 = Math.pow(10.0,mov);
  //mov2 = 1000;

  value = value*mov2;
  value = value+.0000001;

  /******************************************
   8888.8885に1000を掛けると誤差が生じ、内部で8888888.4999999999
  となってしまう。
  .0000001を足して強引に8888.8885にしている。
  .0000001は経験値なので要注意。
   ******************************************/
  int value2 = (int)Math.rint(value) ;
  BigDecimal bigNum = new BigDecimal(value2);//**************
  bigNum = bigNum.movePointLeft(mov);
  if(positiveNumber) return bigNum.doubleValue();
  return bigNum.negate().doubleValue();
  }

  private double epsilonCorrection3(double value){//遅い
  if(value == 0.0D) return value; //0.0のときは何もしない
  boolean positiveNumber = true;
  if(value<0.0D){positiveNumber = false;value = Math.abs(value);}
  //+++++ valueは整数 で精度の範囲
  if(Math.floor(value)==Math.ceil(value) && value < PRECISION*10.0D){
    if(positiveNumber) return value;
    return -1.0D*value;
    }
  //+++++ 小数を含むか精度より大きい
  // value     = 8888.8885
  // PRECISION = 1000000.0　PRECISION_SIZE = 7 有効桁数 7

  int  exponent = (int)(Math.floor(Math.log(value)/Math.log(10.0D)));//底の変換
  //exponent = 3

  int mov = PRECISION_SIZE-exponent-1;
   //mov = 3

  double mov2 = Math.pow(10.0,mov);
  //mov2 = 1000;


//  BigDecimal bd  = new BigDecimal(""+value);//ERROR !!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!   1.81E-5 ---> 81E-5　　　バグ修正済み？
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

  BigDecimal bd  = new BigDecimal(value);//-->8888.8884999999

  if(mov>0)bd = bd.movePointRight(mov);
  if(mov<0)bd = bd.movePointLeft( mov);
  //8888888.5

//  System.out.println("BIG DECILAL "+bd);
  /******************************************
   8888.8885に1000を掛けると誤差が生じ、内部で8888888.4999999999
  となってしまう。
  .0000001を足して強引に8888.8885にしている。
  .0000001は経験値なので要注意。
   ******************************************/
  bd = bd.multiply(new BigDecimal("10.0"));
  bd = bd.divide(new BigDecimal("10.0"),0,BigDecimal.ROUND_HALF_UP);
  //  int value2 = (int)Math.rint(bd.doubleValue()) ;
//  System.out.println("VAL2 "+bd);
  BigDecimal bigNum = new BigDecimal(""+bd);//**************
  bigNum = bigNum.movePointLeft(mov);
  if(positiveNumber) return bigNum.doubleValue();
  return bigNum.negate().doubleValue();
  }


  private double epsilonCorrection4(double value){//遅い
  if(value == 0.0D) return value; //0.0のときは何もしない
  boolean positiveNumber = true;

//  System.out.println("ZZZ "+value);
  BigDecimal bd = new BigDecimal(""+value);//BigDecimal(value)->8888.88849999
  value = bd.doubleValue();
  if(value<0.0D){
  positiveNumber = false;
  value = bd.negate().doubleValue();
  }
//System.out.println("ZZZZZ");
  //+++++ valueは整数 で精度の範囲
  if(Math.floor(value)==Math.ceil(value) && value < PRECISION*10.0D){
    if(positiveNumber) return value;
    return -1.0D*value;
    }
  //+++++ 小数を含むか精度より大きい
  // value     = 8888.8885
  // PRECISION = 1000000.0　PRECISION_SIZE = 7 有効桁数 7

/*
  double keta = Math.log(dNumber)/Math.log(10.0D);
  BigDecimal bKeta = new BigDecimal(""+keta);
  System.out.println("KETA "+bKeta.doubleValue());
*/
  int  exponent = (int)(Math.floor(Math.log(value)/Math.log(10.0D)));//底の変換
  //exponent = 3

//  System.out.println("EXP "+exponent);

  int mov = PRECISION_SIZE-exponent-1;
   //mov = 3

//  BigDecimal bd  = new BigDecimal(""+value);//ERROR !!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!   1.81E-5 ---> 81E-5 1.4 バグ修正？
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//  BigDecimal bd  = new BigDecimal(value);---->8888.8884999999  error
//System.out.println(" MOV "+mov);

  if(mov>=0){
  bd = bd.setScale(mov,BigDecimal.ROUND_HALF_UP);
  }

  else{
  bd = bd.movePointRight(mov);
  bd = bd.setScale(0,BigDecimal.ROUND_HALF_UP);
  bd = bd.movePointLeft(mov);
  }
//  System.out.println("DDDDD  "+bd.doubleValue());
  return bd.doubleValue();
  }

  private double epsilonCorrection5(double value){//遅い
  if(value == 0.0D) return value; //0.0のときは何もしない
  boolean positiveNumber = true;
//  System.out.println("val "+value);
  BigDecimal bd = new BigDecimal(""+value);//BigDecimal(value)->8888.88849999
  value = bd.doubleValue();
  if(bd.compareTo(new BigDecimal(0.0))<0){
  positiveNumber = false;
  bd = bd.abs();
  value = bd.doubleValue();
  }
  //+++++ valueは整数 で精度の範囲
  if(Math.floor(value)==Math.ceil(value) && value < PRECISION*10.0D){
//    System.out.println("MMMMM "+positiveNumber);
    if(positiveNumber){ return value;}
//    System.out.println("MMMMM22 "+bd.negate().doubleValue());
    return bd.negate().doubleValue();
    }
  //+++++ 小数を含むか精度より大きい
  // value     = 8888.8885
  // PRECISION = 1000000.0　PRECISION_SIZE = 7 有効桁数 7

  int  exponent = (int)(Math.floor(Math.log(value)/Math.log(10.0D)));//底の変換

    bd = bd.movePointLeft(exponent).abs();
    if(bd.compareTo(new BigDecimal(10.0D))==0){
    bd = bd.movePointLeft(1);
    exponent++;
    }

//    System.out.println("SSS "+bd);

//  int mov = PRECISION_SIZE-exponent-1;




   //mov = 3

//  BigDecimal bd  = new BigDecimal(""+value);//ERROR !!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!   1.81E-5 ---> 81E-5 1.4 バグ修正？
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//  BigDecimal bd  = new BigDecimal(value);---->8888.8884999999  error
//System.out.println(" MOV "+mov);

//  bd = bd.movePointLeft(mov);
  bd = bd.setScale(PRECISION_SIZE-1,BigDecimal.ROUND_HALF_UP);
  bd = bd.movePointRight(exponent);
//  System.out.println("VVV "+bd);
  if(positiveNumber) return bd.doubleValue();
  return bd.negate().doubleValue();
  }



  private String getFormatNumber(double number){
  number *= PRECISION;
  if(number == 0.0D) return "0.000000";
  StringBuffer sn = new StringBuffer(""+(int)Math.rint(number));
  sn.insert(1,".");
  return ""+ sn;
  }

  private String getFormatNumber2(double number){
//  if(number == 0.0D) return "0.000000";
  DecimalFormat form2 = new DecimalFormat("0.000000");
  return form2.format(number);
  }

/**
 * 数値誤差を考慮した比較
 * @param a 比較する数値
 * @param b 比較する数値
 * @return a > b -> 1<BR>a==b -> 0 <BR> a < b -> -1
 */
  public static int compare(double a,double b){
  BigDecimal big_a = new BigDecimal(""+new Eng(a).doubleValue());
  BigDecimal big_b = new BigDecimal(""+new Eng(b).doubleValue());
  return big_a.compareTo(big_b);
  }


  public static void main(String[] args) {
    Eng eng = new Eng();
    eng.invokedStandalone = true;
    System.out.println("NUM "+new Eng(8888.8885)+" "+new Eng(-.0099999995));
    System.out.println("NUM "+new Eng(-1.5));
    System.out.println("NUM "+new Eng(99999999999.0));
    System.out.println("NUM "+new Eng(-1.0));
    System.out.println("NUM "+new Eng(-0.1));

    double val = -1.0D/3.0D;
    System.out.println("VAL1 "+val);
    val = new Eng(val).doubleValue();
    System.out.println("VAL2 "+val);
    val = new Eng(val).doubleValue();
    System.out.println("VAL3 "+val);

    System.out.println("NUMxx "+new Eng(999.9999999396001));
   System.out.println("NUMxx "+new Eng(1.0D/999.9999999396001));
   System.out.println("NUMxx "+new Eng(0.00099999999999999D));
   System.out.println("NUMxx "+new Eng(1000.0D));
   System.out.println("NUMxx "+new Eng(-1000.0D));
   System.out.println("NUMxx "+new Eng(-1000));


  }
  private boolean invokedStandalone = false;
}
