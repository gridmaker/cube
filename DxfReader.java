package cube;


import java.io.*;
import java.util.*;

public class DxfReader {

private  LineNumberReader lnr;
//private static FileWriter fw;

public DxfReader(){}

public  DxfEntity readEntity() throws IOException {

Vector groupCodeSets = new Vector();
DxfGroupCodeSet temp;

//  0
//  SEQEND
//****これも独立したエンティティーとみなす
//  0
//  ENDSEC
//****これを読み込んで終了
  temp = getDxfGroupCodeSet();
  if(temp.getGroupCode().trim().equals("0") && temp.getData().trim().equals("ENDSEC")) throw new EOFException();
  groupCodeSets.addElement(temp);
  while(true){
    lnr.mark(256);
      temp = getDxfGroupCodeSet();
      if(temp.getGroupCode().trim().equals("0")){lnr.reset();break;}
    groupCodeSets.addElement(temp);
  }
  return new DxfEntity(groupCodeSets);
}//----------  END OF getOneGeometry()  ----------

private void moveEntitySection() throws IOException{
//System.out.println("ZZZZZ");
DxfGroupCodeSet temp;
try{
while(true){
  temp = getDxfGroupCodeSet();
  if(temp.getGroupCode().trim().equals("0")
  && temp.getData().trim().equals("SECTION")){
    temp = getDxfGroupCodeSet();
    if(temp.getGroupCode().trim().equals("2")
    && temp.getData().trim().equals("ENTITIES")) return;
  }
//System.out.println("ZZZZZ33");
}
}catch(IOException eee){
//System.out.println("ZZZZZ22");
eee.printStackTrace();
throw eee;
}
//System.out.println("ZZZZZ");
}

public void switchOn(String filename) throws IOException{
try{
lnr = new LineNumberReader(new FileReader(filename));
moveEntitySection();
}catch(Exception e){
    e.printStackTrace();
    throw new IOException("DXFのスイッチオン失敗");
    }
    //finally{lnr.close();}
}

public void switchOff() throws IOException{
lnr.close();
}

private boolean isEven(){
return lnr.getLineNumber()%2 == 0;
}

private    DxfGroupCodeSet getDxfGroupCodeSet() throws IOException {
return new DxfGroupCodeSet(lnr.readLine(),lnr.readLine());
}

public static void main(String arg[]){

}//END  OF  MAIN()
}//////////  END OF CLASS  DxfReader  //////////
