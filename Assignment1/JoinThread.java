import java.io.*;

public class JoinThread extends Thread {
	
	public void run() {
		
		for (int j = 0; j < 2;  j++) {
			try {
				Thread.sleep(300);
				System.out.print("The current thread:" + Thread.currentThread().getName() + "\n");
			} catch(Exception e) {
				System.out.println(j+ "\n");
			}
		}
	}

	public static void main(String[] args) {
		
		JoinThread t1 = new JoinThread();
		JoinThread t2 = new JoinThread();
		JoinThread t3 = new JoinThread();
		
		System.out.println(" Current thread status: " + Thread.currentThread().getState() + "\n");
		
		t1.start();
		
		System.out.println(" Current thread status: " + t1.getState() + "\n");
		
		
		try {
			System.out.print("The current thread:" + Thread.currentThread().getName() + "\n");
			
			t1.join();
			
		} catch(Exception e) {
			System.out.println("There was an exception " + e+ "\n");  
		}
		
		System.out.println(" Current thread status: " + Thread.currentThread().getState() + "\n");
		
		t2.start();
		
		System.out.println(" Current thread status: " + t2.getState() + "\n");
		
		try {
			System.out.print("The current thread:" + Thread.currentThread().getName() + "\n");
			
			t2.join();
			
		} catch(Exception e) {
			System.out.println("There was an exception " + e+ "\n");  

		}
		
		System.out.println(" Current thread status: " + Thread.currentThread().getState() + "\n");
		


		System.out.println(" Current thread status: " + t3.getState() + "\n");
		t3.start();

		System.out.println(" Current thread status: " + t2.getState() + "\n");
	}
}
