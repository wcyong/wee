package org.wcy.wee.design.composite;

public class Client {

	public static void main(String[] args) {
		AbstractFile f2,f3;
		Floder f1 = new Floder();
		f2 = new ImageFile();
		f3 = new TxtFile();
		f1.add(f2);
		f1.add(f3);
		
		f2.killVirus();
		f3.killVirus();
		f1.killVirus();
	}
}
