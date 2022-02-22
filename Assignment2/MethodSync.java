class NumPow {
	synchronized void printPower(int n) { //sync'ing the method (if you run without synchronize it wont show two threads in separately sets
		int temp = 1;
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName()+" - " +  n + "^" + i + " equals = " + n*temp);
			temp = n*temp;
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

class ThreadOne extends Thread{
	NumPow p;
	ThreadOne(NumPow p) { 
		this.p = p;
	}


	public void run() {
		p.printPower(7);
	}
}

class ThreadTwo extends Thread{
	NumPow p;
	ThreadTwo(NumPow p) { 
		this.p = p;
	}


	public void run() {
		p.printPower(4);
	}
}



public class MethodSync {

	public static void main(String[] args) {
		NumPow object = new NumPow();
		ThreadOne th1 = new ThreadOne(object);
		ThreadTwo th2 = new ThreadTwo(object);
		
		th1.start();
		th2.start();

	}

}
