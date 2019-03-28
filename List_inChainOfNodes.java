**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */


    /**
      @return the number of elements in this list
     */
    public int size() {
      Node check = headReference;
      int count = 0;
      if (headReference != null){
        count++;
        while (check.getReferenceToNextNode() != null){
          count++;
          check = check.getReferenceToNextNode();
        }
      }
      return count;
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
      Node currentNode = headReference;
      String ans = "";
      ans += "# elements: " + size() + " ";
      ans += " [";

      for (int i = 0; i < size(); i++){
        ans += currentNode.getCargoReference() + ", ";
        currentNode = currentNode.getReferenceToNextNode();
      }
      return ans + "]";
    }


    /**
      Append @value to the head of this list.
      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        Node head = new Node(val, headReference);
        headReference = head;
        return true;
     }

     private Node findReferenceAtIndex(int index){
       Node referenceAtIndex = headReference;
       int counter = 0;
       for (counter = 0, referenceAtIndex = headReference; counter < index; counter++, referenceAtIndex = referenceAtIndex.getReferenceToNextNode()){
         ;
       }
       return referenceAtIndex;
     }

     public Object set(int index, Object val){
       Node referenceAtIndex = findReferenceAtIndex(index);
       referenceAtIndex.setValueOfNode(val);
       return referenceAtIndex.getCargoReference();
     }

     public Object get(int index){
       Node referenceAtIndex = findReferenceAtIndex(index);
       return referenceAtIndex.getCargoReference();
     }

     public void add(int index, Object val){
       if (index == 0){
         addAsHead(val);
       }else{
         Node prevReference = findReferenceAtIndex(index - 1);
         // Node prevReference = headReference;
         // for (int counter = 0; counter < index-1; counter++){
         //   prevReference = prevReference.getReferenceToNextNode();
         //}

         Node referenceAtIndex = prevReference.getReferenceToNextNode();
         Node newNode = new Node(val, referenceAtIndex);
         prevReference.setReferenceToNextNode(newNode);
       }
     }


     public Object remove(int index){
       Object returner = 0;
       if (index == 0){
         returner = headReference.getCargoReference();
         headReference = headReference.getReferenceToNextNode();
       }else if (index == size() - 1){
         Node secondToLast = findReferenceAtIndex(index - 2);
         // Node secondToLast = headReference;
         // for (int counter = 0; counter < index - 2; counter++){
         //   secondToLast = secondToLast.getReferenceToNextNode();
         // }
         Node newLastReference = secondToLast.getReferenceToNextNode();
         returner = newLastReference.getReferenceToNextNode().getCargoReference();
         Node newLast = new Node(newLastReference.getCargoReference());
         secondToLast.setReferenceToNextNode(newLast);

         // Node newLastReference = headReference;
         // for (int counter = 0; counter < index - 1; counter++){
         //   newLastReference = newLastReference.getReferenceToNextNode();
         // }
         // returner = newLastReference.getReferenceToNextNode().getCargoReference();
         // newLastReference.setReferenceToNextNode(null);
         // System.out.println(newLastReference);

       }else{
         Node refBefore = findReferenceAtIndex(index - 1);
         // Node refBefore = headReference;
         // for (int counter = 0; counter < index - 1; counter++){
         //   refBefore = refBefore.getReferenceToNextNode();
         // }
         returner = refBefore.getReferenceToNextNode().getCargoReference();
         Node refAfter = findReferenceAtIndex(index+1);
         // Node refAfter = headReference;
         // for (int counter = 0; counter < index + 1; counter++){
         //   refAfter = refAfter.getReferenceToNextNode();
         // }
         refBefore.setReferenceToNextNode(refAfter);
       }
       return returner;
     }
}
