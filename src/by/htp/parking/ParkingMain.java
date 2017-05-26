package by.htp.parking;

import java.io.IOException;

/*Автостоянка. Доступно несколько машиномест. На одном месте может
находиться только один автомобиль. Если все места заняты, то автомо-
биль не станет ждать больше определенного времени и уедет на другую
стоянку.
*/
public class ParkingMain {

	public static void main(String[] args) {
		Resource rs = new Resource(5);
		try {
			SyncThread th1 = new SyncThread("first", rs);
			SyncThread th2 = new SyncThread("second", rs);
			SyncThread th3 = new SyncThread("third", rs);
			SyncThread th4 = new SyncThread("fourth", rs);
			SyncThread th5 = new SyncThread("fifth", rs);
			SyncThread th6 = new SyncThread("sixth", rs);
			SyncThread th7 = new SyncThread("secondth", rs);
			SyncThread th8 = new SyncThread("eighth", rs);
			SyncThread th9 = new SyncThread("nineth", rs);
			SyncThread th10 = new SyncThread("tenth", rs);
			th1.start();
			th2.start();
			th3.start();
			th4.start();
			th5.start();
			th6.start();
			th7.start();
			th8.start();
			th9.start();
			th10.start();
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			th5.join();
			th6.join();
			th7.join();
			th8.join();
			th9.join();
			th10.join();
		} catch (InterruptedException e) {
			System.out.println("thread error: " + e);
		}
		
	}

}
