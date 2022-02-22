
public class DeadLock {
	
	public static Object Item1 = new Object();
	public static Object Item2 = new Object();
	

	public static void main(String[] args) {
		ThreadOne th1 = new ThreadOne();
		ThreadTwo th2 = new ThreadTwo();
		th1.start();
		th2.start();

	}
	
	private static class ThreadOne extends Thread {
		public void run() {
			synchronized (Item1) {
				System.out.println("ThreadOne: Holding Item 1...");
				
				try { Thread.sleep(10);}
				catch (InterruptedException e) {}
					System.out.println("ThreadOne: Waiting for Item 2...");
				
				synchronized (Item2) { //nested sync over here caused a deadlock
					System.out.println("ThreadOne: Holding Item 1 and 2...");
				}
			}
		}
	
	}
	
	private static class ThreadTwo extends Thread {
		public void run() {
			synchronized (Item2) {
				System.out.println("ThreadOne: Holding Item 2...");
				
				try { Thread.sleep(10);}
				catch (InterruptedException e) {}
					System.out.println("ThreadOne: Waiting for Item 1...");
	
				synchronized (Item1) { //nested sync over here caused a deadlock
					System.out.println("ThreadOne: Holding Item 1 and 2...");
				}
			}
		}
	
	}

}
