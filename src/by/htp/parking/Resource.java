package by.htp.parking;


public class Resource {
	
	private volatile int[] places;
	private int maxWaiting = 3000;
	private int currWaiting = 0;
	
	public Resource(int size) {
		places = new int[size];
	}
	
	public int[] getPlaces() {
		return places;
	}
	
	public synchronized int takePlace() throws InterruptedException {
		int id = getEmptyPlaceId();
		if ( id >= 0 ) {
			places[id] = 1;
			System.out.println("thread " + Thread.currentThread().getName() + " has taken place id=" + id);
		} else {
			if ( currWaiting < maxWaiting ) {
				currWaiting += 500;
				Thread.sleep(500);
				takePlace();
			} else {
				System.out.println("thread " + Thread.currentThread().getName() + " is tired for waiting and go out");
			}
		}
		return id;
	}
	
	public int getEmptyPlaceId() {
		for ( int i = 0; i < places.length; i++ ) {
			if ( places[i] == 0 ) {
				return i;
			}
		}
		return -1;
	}
	
	public void setEmptyPlace(int id) {
		places[id] = 0;
	}
}
