package com.randd.parkingservice;

import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class ParkingService {
	
	final int size = 160;
	TreeMap<Integer,CustomerDetails> parkingMap = new TreeMap<Integer,CustomerDetails>(); 
	SortedSet<Integer> available = new TreeSet<Integer>();
	SortedSet<Integer> filled = new TreeSet<Integer>();
	
	public ParkingService() {
		for(int index=1;index<161; index++) {
			available.add(index);
		}
	}
	
	public void addCar(CustomerDetails c) {
		
		if(parkingMap.size()>=160) {
			throw new RuntimeException("Parking Full");
		}
		int key = available.first();
		parkingMap.put(key, c);
		available.remove(key);
		filled.add(key);
		c = findSlot(key, c);
	}
	
	public TreeMap<Integer, CustomerDetails> retrieveCars() {
		return parkingMap;
	}
	
	public void remoceCar(String token) {
		
		int floor, section, compartment;
		String[] s = token.split(":");
		floor = Integer.parseInt(s[0]);
		section = Integer.parseInt(s[1]);
		compartment = Integer.parseInt(s[2]);
		
			for( Integer index : parkingMap.keySet()) {
				if(floor == parkingMap.get(index).getFloor() && section == parkingMap.get(index).getSection() && compartment == parkingMap.get(index).getCompartment())
				{
					parkingMap.remove(index);
					filled.remove(index);
					available.add(index);
					return;
				}
			}
		throw new RuntimeException("Car not found");
	}
	
	public CustomerDetails findSlot(int index, CustomerDetails c)
	{
		int count = 1;
		while(count< 5) {	
		if(index>=1*count && index<=40*count)
		{
			c.setFloor(count);
			if(index< (40*(count-1) + 11))
			{
				c.setSection(1);
				c.setCompartment(index%10);
				return c;
			}
			else if(index < (40*(count-1) + 21))
			{
				c.setSection(2);
				c.setCompartment(index%10);
				return c;
			}
			else if(index < (40*(count-1) + 31))
			{
				c.setSection(3);
				c.setCompartment(index%10);
				return c;
			}
			else
			{
				c.setSection(4);
				c.setCompartment(index%10);
				return c;
			}
		}
		count++;
		}
		throw new RuntimeException("Invalid Key");
	}
	
	
	public static void main(String[] args)
	{
		ParkingService p = new ParkingService();
		CustomerDetails c1 = new CustomerDetails("Ranjana", "1321gkjsd", "10:10", 6548654L);
		p.addCar(c1);
		CustomerDetails c2 = new CustomerDetails("Nitin", "1321gkjsd", "11:11", 6548654L);
		p.addCar(c2);
		CustomerDetails c3 = new CustomerDetails("Yashaswini", "1321gkjsd", "10:10", 6548654L);
		p.addCar(c3);
		CustomerDetails c4 = new CustomerDetails("Ashish", "1321gkjsd", "10:10", 6548654L);
		p.addCar(c4);
		CustomerDetails c5 = new CustomerDetails("Bindu", "1321gkjsd", "10:10", 6548654L);
		p.addCar(c5);
		System.out.println("5 Cars added\n"+p.retrieveCars());
		
		p.remoceCar(c2.getToken());
		System.out.println("Car 2 (toekn = 1:1:2) removed\n"+p.retrieveCars());
		
		CustomerDetails c6 = new CustomerDetails("Pragnya", "1321gkjsd", "10:10", 6548654L);
		p.addCar(c6);
		System.out.println("Car 6 added (it goes to token 1:1:2)\n"+p.retrieveCars());
	}
}
