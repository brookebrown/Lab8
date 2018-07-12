
/* Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: complete and fully tested
 * Last update: 11/02/16
 * Submitted: 11/02/16
 * Comment: sample run attached
 * @author: Brooke Brown
 * @version: 2016.11.02
 */

import java.io.*;
import java.util.*;

public class Driver3
{
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
        AscendinglyOrderedStringList list = new AscendinglyOrderedStringList();

        String askPrompt =  "   1. Insert specified item into list.\n   2. Remove item in specified position in the list.\n   3. Search for a specified item in the list.\n   4. Clear list.\n   5. Display content of list. \n   6. Exit program. \nMake your menu selection now: ";
        System.out.print(askPrompt);
        int answer = Integer.parseInt(stdin.readLine().trim());
        System.out.println(answer);
        while(answer != 6) {
            switch (answer) {
            case 1: //insert item to list, user ONLY specifies item that will be inserted
                System.out.println("You are now inserting an item into the list.");
                System.out.print("   Enter item: ");
                String item  = stdin.readLine().trim();
                System.out.println(item);
                list.add(item);
                System.out.println("Item " + item +  " inserted in the list.");
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
            case 4: //clear list
                list.clear();
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 5: //print size and content of the list
                if(list.isEmpty()) {
                    System.out.println("List is empty.");
                }
                else {
                    System.out.println(list.toString());
                }
                System.out.print(askPrompt);
                answer = Integer.parseInt(stdin.readLine().trim());
                System.out.println(answer);
                break;
            case 3: //search for a specified item in the list, returns index of where the match is & whether it was successful or not
                System.out.print("Enter search item: ");
                String search = stdin.readLine().trim();
                System.out.println(search);
                int index = list.search(search);
                System.out.println("Item would be placed in " + index);
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
}
