package by.htp.parking;

public class SyncThread extends Thread{
	
	private Resource rs;
	private int maxWaiting = 3000;
	private int currWaiting = 0;
	
	public SyncThread(String name, Resource rs) {
		super(name);
		this.rs = rs;
	}
	
	public void run() {
		try {
			int id = 0;
			while ( currWaiting < maxWaiting  ) {
				currWaiting += 500;
				System.out.println("thread "+Thread.currentThread().getName() + " start work");
				id = rs.takePlace();
				if ( id >= 0 ) {
					Thread.sleep(6000);
					rs.setEmptyPlace(id);
					System.out.println("place id=" + id + " is free");
					break;
				}
				else
					Thread.sleep(500);
			}

			if ( id < 0 ) {
				System.out.println("thread " + Thread.currentThread().getName() + " is tired for waiting and go out");
			}
			System.out.println("thread " + Thread.currentThread().getName() + " end work");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
