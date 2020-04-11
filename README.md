# DesignQuestion7

Retail line problem:

A retail store manager wants to efficiently let customers check out in the quickest way possible during busier times. Their solution is a system on which customers ready to check out enter their name and the number of items they have. They are then directed to an appropriate line (line 1 for 1–10 items, line 2 for 11–20 items, etc). The system should keep track of the people in each of the lines so that it can provide each cashier with the name of the first person in their line, allowing each customer to be greeted by name.


My Answer:
Data structure choice: I used "LinkedList" for storing people in lines. This type is a Doubly linked list, therefore access to the first and last item of the list is in constant time. Therefore, this structure is efficient for lines with multiple insert in remove from both ends.
In this problem the store could have multiple lines, each for persons with a specified range for number of items they bought. Since I needed to access different lines, multiple time during the execution of the program the best data structure for keeping the lines was ArrayList. The ArrayList in provides constant time access to element at index i (whereas the LinkedList needs O(n) operation). I created an ArrayList of lines each is a LinkedList.
I also created the class Person to get easy access to the properties of a person.

When a customer checks out, it will be added to end of a line based on number of items he is buying. For 0-10 items it will be added to line 0, for 10-20 it will be added to lone 1, etc. The line number starts from 0 and is actually the index of the line in ArrayList. The line index is computed by the quotient part of number of items divided by 10. For items which this formula gives a line index greater than the possible number for index, I use the last line.

Multiple methods implemented for retail line including:
•	GetFirst(number): returns the first person in the line with index "number". If number is invalid returns null. This method does not remove the person from line.
•	Pop(number): removes and returns the first person from line with index "number". If number is invalid returns null. 
•	Size(number): returns current number of people in the line with index "number".
•	Size(): returns total number of people in retail lines.
•	lineCount(): returns the number of lines in this store. This number will be set in initialization time.
I created a user interface in console which asks from user to choose between available options and then performs the action.
I added some basic tests using Junit framework to test the correctness of the program.
