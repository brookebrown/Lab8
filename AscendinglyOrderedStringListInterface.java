/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 09/21/16
 * Submitted:  09/21/16
 * Comment: test suite and sample run attached
 * @author: Brooke Brown
 * @version: 2016.09.21
 */

public interface AscendinglyOrderedStringListInterface 
{
  boolean isEmpty();
  int size();
  void add(String item) throws ListIndexOutOfBoundsException;
  String get(int index) throws ListIndexOutOfBoundsException;
  void remove(int index) throws ListIndexOutOfBoundsException;
  int search(String item);
  void clear();
} 
