
/* Purpose: Data Structure and Algorithms Lab 8 Problem 2
 * Status: complete and fully tested
 * Last update: 11/02/16
 * Submitted: 11/02/16
 * Comment: sample run attached
 * @author: Brooke Brown
 * @version: 2016.11.02
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class Driver2
{
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
        ListArrayBasedPlus list = new ListArrayBasedPlus();

        String askPrompt =  "   1. Insert item to ordered list.\n   2. Remove item from list.\n   3. Get item from list.\n   4. Search for a specified item in the list.\n   5. Clear list.\n   6. Print size and content of list. \n   7. Exit program. \nMake your menu selection now: ";
        System.out.print(askPrompt);
        int answer = Integer.parseInt(stdin.readLine().trim());
        System.out.println(answer);
        while(answer != 7) {
            switch (answer) {
            case 1: //insert item to list
                System.out.println("You are now inserting an item into the list.");
                System.out.print("   Enter item: ");
                Object item  = stdin.readLine().trim();
                System.out.println(item);
                if(list.size() == 0) {
                    list.add(0, item);
                    System.out.println("Item " + list.get(0) + " inserted in position 0 in the list.");
                }
                else { //searches the list to see how item will be placed ascendingly in the list
                    list.add(searchMethod(list, item), item);
                }
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 2: //remove item from list
                System.out.print("    Enter position to remove item from: ");
                int delete = Integer.parseInt(stdin.readLine().trim());
                System.out.println(delete);
                if(delete < 0 | delete >= list.size()) {
                    System.out.println("Position specified is out of range!");
                }
                else {
                    System.out.println("Item " + list.get(delete) + " removed from position " + delete + " in the list.");
                    list.remove(delete);
                }
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 3: //get item from list
                System.out.print("    Enter position to retrieve item from: ");
                int num = Integer.parseInt(stdin.readLine().trim());
                System.out.println(num);
                if(num < 0 | num >= list.size()) {
                    System.out.println("Position specified is out of range!");
                }
                else {
                    System.out.println("Item " + list.get(num) + " retrieved from position " + num + " in the list.");
                }
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 5: //clear list
                list.removeAll();
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 6: //print size and content of the list
                if(list.isEmpty()) {
                    System.out.println("List is empty.");
                }
                else {
                    System.out.print("     List of size " + list.size() + " has the following items: ");
                    System.out.println(list.toString());
                }
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 4: //search for a specified item in the list by using A: Modified Sequential Search 1 (eager equality checking)
                System.out.print("Enter search item: ");
                Object search = stdin.readLine().trim();
                System.out.println(search);
                System.out.println(searchMethod(list, search) + " is the index.");
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            default:
                System.out.println("Oh no! You put an incorrect number. Try again!");
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            }
        }
        System.out.print("Exiting program... Good Bye!");
    }

    public static int searchMethod(ListArrayBasedPlus list, Object search)
    {
        boolean finished = false;
        for(int i = 0; i < list.size(); i++) {
            if(search.equals(list.get(i)) && !finished) {
                //stop, state index and successful
                finished = true;
                System.out.println("Successful! ");
                return i;
            }
            else if((((String) list.get(i)).compareTo((String) search) > 0) && !finished) {
                //stop, state index and unsuccessful
                finished = true;
                System.out.println("Unsuccessful. ");
                return i;
            }
        }
        if(!finished) {
            //stop, if unsuccessful, state that the index will be list.size()
            System.out.println("Unsuccessful. ");
            return list.size();
        }
        else {
            return -1;
        }
    }
}
