public class UserOfOrderedList{
  public static void main(String[] commandLine){
    //Basics: constructor, adding and removing elements, getting an element, toString.
    OrderedList_inArraySlots list = new OrderedList_inArraySlots();
    System.out.println(list);

    int[] elements = {1, 6, 4, 2, 0, 8};
    for (int element: elements){
      list.add(element);
      System.out.println(list);
    }
    System.out.println(list);

    list.remove(0);
    System.out.println(list);

    list.remove(2);
    System.out.println(list);

    System.out.println(list.get(0));
    System.out.println(list);
  }
}
