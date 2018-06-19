package cube;

public class DxfGroupCodeSet {

  private String groupCode;
  private String data;

  public DxfGroupCodeSet() {}
  public DxfGroupCodeSet(String groupCode,String data){
  this.groupCode = groupCode;
  this.data = data;
  }

  public void setGroupCode(String groupCode){this.groupCode = groupCode;}
  public void setData(String data){this.data = data;}
  public String getGroupCode(){return groupCode;}
  public String getData(){return data;}
  public boolean isGroupCode(String gc){
    return gc.trim().equals(groupCode.trim());
  }

  public String toString(){
    return "GROUPCODE "+groupCode+"\n"+"DATA      "+data+"\n";
  }

  public static void main(String[] args) {
    DxfGroupCodeSet dxfGroupCodeSet = new DxfGroupCodeSet();
    dxfGroupCodeSet.invokedStandalone = true;
  }
  private boolean invokedStandalone = false;
}
