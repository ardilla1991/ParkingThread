package by.htp.parking;

public class SyncThread extends Thread{
	
	private Resource rs;
	
	public SyncThread(String name, Resource rs) {
		super(name);
		this.rs = rs;
	}
	
	public void run() {
		try {
			System.out.println("thread "+Thread.currentThread().getName() + " start work");
			int id = rs.takePlace();
			Thread.sleep(6000);
			if ( id >=0 ) {
				rs.setEmptyPlace(id);
				System.out.println("place id=" + id + " is free");
			}
			System.out.println("thread " + Thread.currentThread().getName() + " end work");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
