package syncthread;



public class Share {
  private int contents;
  public int get(){//�ӹ�����ȡ����
    return contents;
  }
  public void put(int value){//���빲����
    contents=value;
  }
}
