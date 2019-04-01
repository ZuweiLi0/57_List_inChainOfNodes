    
public class OrderedList_inArraySlots{
  private List_inArraySlots refToList;

  public OrderedList_inArraySlots(){
    refToList = new List_inArraySlots();
  }

  public int add(int val){
    if (refToList.size() == 0){//first element is being added
      refToList.add(val);
      return val;
    }else{
      for (int i = 0; i < refToList.size(); i++){
        System.out.println("at index " + i + " element " + refToList.get(i));
        System.out.println(val);
        if (refToList.get(i) >= val){
          if (i == 0){
            System.out.println("added to beginning");
            refToList.add(0, val);
            return val;
          }else{
            System.out.println("added to one less than i");
            refToList.add(i, val);
            return val;
          }
        }
      }
      refToList.add(val);
      return val;
    }
  }

  public String toString(){
    return refToList.toString();
  }

  public int remove(int index){
    return refToList.remove(index);
  }

  public int get(int index){
    return refToList.get(index);
  }
