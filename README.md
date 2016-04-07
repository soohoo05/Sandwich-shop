# Sandwich-shop

The Sandwich Shop Problem

The sandwich shop in this problem is very small. It has a single employee and there is room for only one customer to be in the shop at a time. This problem contains two types of threads. There is a single thread modeling an employee and there are multiple threads modeling customers.

The employee waits in the shop until a customer places an order. Once a customer places an order the employee takes a random amount of time to make the sandwich. When the sandwich is made, the employee carries the sandwich to the cash register and waits for the customer to pay. Once the customer pays, the employee waits for the next order.

Each customer thread takes a random amount of time to travel to the sandwich shop. After travelling the the customer arrives at the sandwich shop. If the shop is not empty the customer must wait until the shop is empty before leaving. The sandwiches are excellent, so the customer will wait as long as it takes to get into the shop. When the shop is empty, one of the waiting customers enters the shop and places an order. The customer then browses around the shop for a random amount of time. After browsing, the customer goes to the cash register and waits for the employee to bring the sandwich. When the employee arrives at the cash register, the customer pays for the sandwich and leaves the shop.

Your solution for the employee will augment the run methods in the EmployeeThread class and the CustomerThreaad class to enforce the synchronization constraints just described. Each of these run methods currently contains method calls that indicate what the thread is doing and provide the random waits that have been described. Once synchronized these methods must be invoked as described below.

The EmployeeThread must invoke the method waitForCustomer() to indicate that it is waiting for a customer to order. It must invoke the makeSanwich() method when it begins making a sandwich for the customer. When the sandwich is finished being made, the EmployeeThread must invoke the atCashRegister() method to indicate that the employee is waiting for payment. Finally the EmployeeThread must invoke the aymentAccepted() method to indicate that the customer's payment has been taken.

The CustomerThread must invoke the method travelToShop() when it is first started. When the customer arrives at the shop it must invoke the arriveAtShop() method. When the shop is empty and the customer has entered it must invoke the placeOrder() method. After the order has been placed, the CustomerThread must invoke the browseShop() method. When the customer is finished browsing it must invoke the atRegister() method. Finally, after the employee has taken the customer's payment the CustomerThread must invoke the leaveShop() method.

The starter code for this problem is provided in the SandwichShop.java file. This starter code provides unsynchronized versions of the EmployeeThread and the CustomerThread that display nicely formatted output. Be sure to run this code and understand the output before you start making modifications to the code. The only modifications that you may make to the provided code are to add public static variables to the SandwichShop class and to add synchronization code, using semaphores, to the run methods within the EmployeeThread and CustomerThread classes.



NOTES FROM USER
initial code was given from the professor, what was added was semaphore locks/releases
