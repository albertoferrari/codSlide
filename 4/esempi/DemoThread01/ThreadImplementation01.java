/**
 * The {@code ThreadImplementation01} class is an example
 * of Thread implementation
 */
public class ThreadImplementation01 extends Thread{

	private String nameOfThread;

	public ThreadImplementation01(String nameOfThread) {
		super();
		this.nameOfThread = nameOfThread;
	}
	
	/**
	 * Invoked by .start()
	 */
	public void run(){
		int i = (int) (Math.random() * 1000);
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(nameOfThread);
	}
}
