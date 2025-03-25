package org.senai;

public class MainLancher {
	
	public static void main(String[] args) {
		
		Conta c1 = new Conta("João", 1000);
		Conta c2 = new Conta("Carlos", 5500);
		
		c1.transferir(c2, 200);
		
		System.out.println(c1.getSaldo());
		System.out.println(c2.getSaldo());

		
	}

}
