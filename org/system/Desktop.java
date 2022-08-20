package org.system;

public class Desktop extends Computer{
	public void desktopSize() {
		System.out.println("desktopSize: 15 inches - full HD");
	}
	public static void main(String[] args) {
		Desktop d = new Desktop();
		d.computerModel();
		d.desktopSize();
	}
}
