
/* Purpose: Data Structure and Algorithms Lab 8 Problem 1
 * Status: complete and fully tested
 * Last update: 11/02/16
 * Submitted: 11/02/16
 * Comment: sample run attached
 * @author: Brooke Brown
 * @version: 2016.11.02
 */

import java.io.*;
import java.util.*;

public class Driver1
{
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
        ListArrayBasedPlus list = new ListArrayBasedPlus();

        String askPrompt =  "   1. Insert item to list.\n   2. Remove item from list.\n   3. Get item from list.\n   4. Search for a specified item in the list.\n   5. Clear list.\n   6. Print size and content of list. \n   7. Exit program. \nMake your menu selection now: ";
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
                System.out.print("   Enter position to insert item in: ");
                int posi = Integer.parseInt(stdin.readLine().trim());
                System.out.println(posi);
                if(posi > list.size()) {
                    System.out.println("Position specified is out of range!");
                }
                else {
                    list.add(posi, item);
                    System.out.println("Item " + list.get(posi) + " inserted in position " + posi + " in the list.");
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
            case 4: //search for a specified item in the list, returns index of where the match is & whether it was successful or not
                System.out.print("Enter search item: ");
                String search = stdin.readLine().trim();
                System.out.println(search);
                int i;
                for(i = 0; i < list.size() && !(search.equals(list.get(i))); i++) {
                    //System.out.println("Successful! A match was found at index: " + i);
                }
                if(i == list.size()) {
                    //stop, if unsuccessful, state that the index will be list.size()
                    System.out.println("Unsuccessful.");
                }
                else {
                    System.out.println("Successful! A match was found at index: " + i);
                }
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
