/**
 * Starter code for the Sandwich Shop Problem
 * 

 */
public class SandwichShop {
	
	public static Semaphore s1 = new Semaphore(1);
	public static Semaphore s2 = new Semaphore(0);
	public static Semaphore s3 = new Semaphore(0);
	
	
    public static void main(String[] args) {
    	
        if (args.length != 1) {
            printUsage();
        }

        int num = 0;
        try {
            num = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            printUsage();
        }

        System.out.println("Customer:\t\t\t\t\t\t\t\t\t\t\t| Employee:");
        System.out.print("Traveling\tArrived\t\tOrdering\tBrowsing\tAt Register\tLeaving");
        System.out.println("\t\t| Waiting\tSandwich Making\t\tAt Register\tPayment Accepted");
        System.out .println("---------------------------------------------------"
                        + "---------------------------------------------+--------"
                        + "-------------------------------------------------------------------");

        Thread emp = new EmployeeThread(s1, s2, s3);
        emp.start();

        Thread[] custs = new Thread[num];
        for (int i = 0; i < num; i++) {
            custs[i] = new CustomerThread(i, s1, s2, s3);
            custs[i].start();
        }
        for (int i = 0; i < num; i++) {
            try {
                custs[i].join();
            }
            catch (InterruptedException e) {
            }
        }

        System.exit(0);
    }

    private static void printUsage() {
        System.out.println("Usage: java SandwichShop <num>");
        System.out.println("  <num>: Number of customers.");
        System.exit(-1);
    }

    public static void randomSleep(int max) {
        try {
            Thread.sleep((int) (Math.random() * max));
        }
        catch (InterruptedException e) {
        }
    }
}

class CustomerThread extends Thread {

    private int id;
    private Semaphore s1;
    private Semaphore s2;
    private Semaphore s3;


    public CustomerThread(int id, Semaphore s1, Semaphore s2, Semaphore s3) {
        this.id = id;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
       
    }

    public void run() {
        travelToShop();
  
       
      
        arriveAtShop();
        s1.acquire();
        placeOrder();
        s2.release();
        
       
        browseShop();
       
        atRegister();
      
        s3.release();
        s2.acquire();
        leaveShop();
        s1.release();
      
    }

    private void travelToShop() {
        System.out.println("Customer " + id + "\t\t\t\t\t\t\t\t\t\t\t|");
        SandwichShop.randomSleep(1000);
    }

    private void arriveAtShop() {
        System.out.println("\t\tCustomer " + id + "\t\t\t\t\t\t\t\t\t|");
    }

    private void placeOrder() {
        System.out.println("\t\t\t\tCustomer " + id + "\t\t\t\t\t\t\t|");
    }

    private void browseShop() {
        System.out.println("\t\t\t\t\t\tCustomer " + id + "\t\t\t\t\t|");
        SandwichShop.randomSleep(1000);
    }

    private void atRegister() {
        System.out.println("\t\t\t\t\t\t\t\tCustomer " + id + "\t\t\t|");
    }

    private void leaveShop() {
        System.out.println("\t\t\t\t\t\t\t\t\t\tCustomer " + id + "\t|");
    }
}

class EmployeeThread extends Thread {
	private Semaphore s1;
	private Semaphore s2;
	private Semaphore s3;

	
	public EmployeeThread(Semaphore s1, Semaphore s2, Semaphore s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
     
	}

	public void run() {
		while (true) {
			
			waitForCustomer();
	
			s2.acquire();
			makeSandwich();
			
			atCashRegister();
			
			s3.acquire();
			paymentAccepted();
			s2.release();
			
			
		}
    }

    private void waitForCustomer() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t| Employee");
    }

    private void makeSandwich() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t| \t\tEmployee");
        SandwichShop.randomSleep(1000);
    }

    private void atCashRegister() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t| \t\t\t\t\tEmployee");
    }

    private void paymentAccepted() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t| \t\t\t\t\t\t\tEmployee");
    }
}
