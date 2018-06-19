package cube;

public class Test22 {
  public Test22() {
  }
  public static void main(String[] args) {
    Test22 test221 = new Test22();
    Byte b = new Byte("11");

//    String instr = "abcdefghijk";
    String instr = "<0:;8: {rn {jm {ii {mm {kk -:):-,:; {mo {rn |";

   String outstr = "";
   for (int i = 0; i < instr.length(); i++) {
       outstr += Integer.toHexString(instr.charAt(i));
  }
   System.out.println("[" + outstr + "]");

//   String instr = "abcdefghijk";
  outstr = "";

  byte[] xxx = new byte[instr.length()];
  byte   tmp = 0;
  for (int i = 0; i < instr.length(); i++) {
      tmp = (byte)(0x9f-instr.charAt(i));
      if(tmp<0x21 || 0x7e < tmp) xxx[i] = ' ';
      else         xxx[i] = tmp;
//      System.out.print(""+new String(xxx));
 }
 System.out.print(""+new String(xxx));

/*
  System.out.println("[" + outstr + "]");
     char aaa = 0x9f;
      String bb = Integer.toOctalString(aaa);;
      System.out.println("[" + bb + "]");

      for (int i = 0; i < instr.length(); i++) {
 */
//        int x = 237-new Integer(Integer.toOctalString(instr.charAt(i))).intValue();
/*
        int x = 159-new Integer(Integer.toOctalString(instr.charAt(i))).intValue();

      System.out.println("zzz "+x);
      byte[] xx = new byte[1];
      xx[0] = (byte)x;

      System.out.println("sss "+new String(xx));
*/

  }






}