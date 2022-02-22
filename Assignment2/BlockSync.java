class NumPower{  
	void printPower(int n){ 
		synchronized(this){ //sync'ed block instead of the whole method
			int temp = 1;
			for(int i=1;i<=5;i++){ 
				System.out.println(Thread.currentThread().getName() + ":- " +n + "^"+ i + " equals = " + n*temp);
				temp = n*temp;
				try{  
					Thread.sleep(500);  
				}catch(Exception e){System.out.println(e);}  
			}  
		}  
	}  
}
	  
class Thread1 extends Thread{  
	NumPower p;
	Thread1(NumPower num) { 
		this.p = num;
	}


	public void run() {
		p.printPower(3);
	}
}
	class Thread2 extends Thread{  
		NumPower p;
		Thread2(NumPower num) { 
			this.p = num;
		}


		public void run() {
			p.printPower(2);
		}
	}
	  
public class BlockSync{  
	public static void main(String args[]){  
		NumPower object = new NumPower();	//only one object  
		Thread1 th1=new Thread1(object);  
		Thread2 th2=new Thread2(object);  
	
		th1.start();  
		th2.start();

	}  
}