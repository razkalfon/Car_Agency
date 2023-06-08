package ex5.doublyLinkedList;

import java.util.Scanner;

enum menu{
    ADD_FIRST,ADD_LAST,REMOVE,CONTAINS,FORWARD,BACKWARD,IS_EMPTY,SIZE,CLEAR,EXIT;
        }
/**
 * A program that builds a menu and implements the department
 */
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Scanner in=new Scanner(System.in);
        // Adding elements to the list
        list.addFirst(3);
        list.addLast(5);
        list.addFirst(1);
        list.addLast(7);
        while (true) {
        System.out.println("Choose an option:");
        System.out.println("1. Add a number to the beginning of the list");
        System.out.println("2. Add a number to the end of the list");
        System.out.println("3. Remove a number from the list");
        System.out.println("4. Check if a number is in the list");
        System.out.println("5. Print the list forward");
        System.out.println("6. Print the list backward");
        System.out.println("7. Check if the list is empty");
        System.out.println("8. Give me back the size of the list");
        System.out.println("9. Clear my list");
        System.out.println("10. Exit");
        int num=in.nextInt();
        menu select=menu.values()[num-1];
            switch (select) {
                case ADD_FIRST:
                    System.out.println("Enter a number to add to the beginning of the list:");
                    int numToAddAtStart = in.nextInt();
                    list.addFirst(numToAddAtStart);
                    break;
                case ADD_LAST:
                    System.out.println("Enter a number to add to the end of the list:");
                    int numToAddAtEnd = in.nextInt();
                    list.addLast(numToAddAtEnd);
                    break;
                case REMOVE:
                    System.out.println("Enter a number to remove from the list:");
                    int numToRemove = in.nextInt();
                    list.remove(numToRemove);
                    break;
                case CONTAINS:
                    System.out.println("Enter a number to check if it's in the list:");
                    int numToCheck = in.nextInt();
                    boolean containsNum = list.contains(numToCheck);
                    System.out.println("The list " + (containsNum ? "contains" : "does not contain") + " the number " + numToCheck);
                    break;
                case FORWARD:
                    list.printForward();
                    break;
                case BACKWARD:
                    list.printBackward();
                    break;
                case IS_EMPTY:
                    list.isEmpty();
                    break;
                case SIZE:
                    int size= list.size();
                    System.out.println(size);
                    break;
                case CLEAR:
                    list.clear();
                    break;
                case EXIT:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from 1 to 10.");
            }
        }
    }
}

