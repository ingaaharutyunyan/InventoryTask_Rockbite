# InventoryTask_Rockbite
 
How to run: 
Compile program by writing javac Main.java
Run code by writing java Main

Design Considerations:
I decided to use the Model View Controller for the inventory because it is a simple enough design for the task, but the task of creating an inventory  system would still require a design pattern of some sort. 
I also created types Item and Rarity and stored them in a simple arraylist because I don't think there was any need for a complex data structure like a type of map.
Initially I thought of making Rarity an enum type, but decided it would be more convenient to upgrade the types through an array by just ++ing the initial index. However, I think enums would be more of an industry standard (not sure).

Things I missed out on: 
I ran out of time to implement a data storage class, but I have done this before!!
I would have either made a class from scratch that would store the raw data (string, int) in a json file, or I would have installed a package that would do that for me

I also probably missed out on some edge cases (eg how to react when someone tries to upgrade inventory with itself?) so sorry about that, and I also should have converted the thrown exceptions into strings so the program can continue running instead of throwing an exception and stopping the program.

Thank you for your time and I look forward to hearing from you!!
(Please let me know what I could improve on too if that's ok)
Inga
