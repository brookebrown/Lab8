
/* Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: complete and fully tested
 * Last update: 11/02/16
 * Submitted: 11/02/16
 * Comment: sample run attached
 * @author: Brooke Brown
 * @version: 2016.11.02
 */


public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface
{

    private static final int MAX_LIST = 3;
    protected String []items;  // an array of list items
    protected int numItems;  // number of items in list

    public AscendinglyOrderedStringList()
    {
        items = new String[MAX_LIST];
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size

    public void clear()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = new String[MAX_LIST];
        numItems = 0;
    } // end removeAll

    public void resize()
    {
        String []temp = new String[items.length + items.length];
        for(int index = 0; index < numItems; index++) {
            temp[index] = items[index];
        }
        items = temp;
    }

    public String toString()
    {
        String output = new String();
        for(int i = 0; i < numItems; i++) {
            output = output + get(i) + " ";
        }
        return output;
    }

    public void add(String item)
    throws  ListIndexOutOfBoundsException
    {
        if (items.length == numItems)
            //fixes implementation error
            //fixes programm
        {
            resize();
        }  // end if
        if(numItems > 0) {
            int index = search(item);
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items[pos+1] = items[pos];
            } // end for
            // insert new item
            items[index] = item;
        }
        else {
            items[0] = item;
        }
        numItems++;
    } //end add

    public String get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

            {
                items[pos-1] = items[pos];
            }  // end for
            items[--numItems] = null;
            // fixes memory leak
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove

    public int search(String item) // i used binary search 2 because it was more efficient. Except when it came to knowing if the item was larger or smaller, this search failed, which is why I have at the end, an equality and comparison check.
    {
        int high = numItems - 1;
        int low = 0;
        int comp = 0;
        while(low != high) {
            int mid = (high + low) / 2;
            comp = item.compareTo(items[mid]);
  
            if(comp <= 0) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
//out of for loop, therefore it has reached end of the tree
        if(item.compareTo(items[low])== 0) {
            System.out.println("This item is in the list!");
            return low;
        }
        else {
            System.out.println("This item was not in the list.");
            if(item.compareTo(items[low]) < 0) {
                return low;
            }
            else {
                return low + 1;
            }
        }
    }


}
