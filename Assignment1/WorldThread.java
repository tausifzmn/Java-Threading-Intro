
public class WorldThread extends Thread {
	

	public static void main(String[] args) {
		
		WorldThread extThread = new WorldThread();
		extThread.setName("ExtendedThread 1");
		
		//extThread.run();	
		
		System.out.println("Thread Name: "+ extThread.getName() + ", Thread status: " + extThread.getState());

		extThread.start();
		System.out.println("Thread Name: "+ extThread.getName() + ", Thread status: " + extThread.getState());

	}
	
	public void run(){
		
        System.out.print("This thread is now running...\n");
    }

}
