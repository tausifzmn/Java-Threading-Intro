
public class RunnableThread implements Runnable {

	@Override
	public void run() {
		
		try {
			Thread.sleep(500);
		} catch (Exception err) {
			
			System.out.println(err);			
		}
		
		System.out.println("``");
	}


	
	public static void main(String[] args) {

        RunnableThread runThread = new RunnableThread();		 // create object 
  
        Thread t1 = new Thread(runThread, "Runnable Thread 1\n");        // pass the runnable reference to Thread
  
        //t.start();
  
        System.out.println(t1.getName()+ "Thread status : "+ t1.getState());
        
        t1.start();
        
        System.out.println(t1.getName()+ "Thread status : "+ t1.getState());
        
        Thread t2 = new Thread(runThread, "Runnable Thread 2\n");
        
        System.out.println( "State of Thread 2 after creating it - "+ t2.getState());
        
        t2.start();
        
        System.out.println( "State of Thread 2 after starting it - "+ t2.getState());
        
        try {
        	
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "State of thread2 after calling .sleep() method on it - " + t2.getState());
        
        try {
        	t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "State of thread2 after calling .sleep() method on it - "+ t2.getState()); 
        
	}

}
