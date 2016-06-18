package org.wcy.wee.design.bridge;

public interface Computer {

	public void sale();
	
}

class Desktop implements Computer {

	@Override
	public void sale() {
		System.out.println("销售台式机");
	}
	
}

class Laptop implements Computer {
	@Override
	public void sale() {
		System.out.println("销售笔记本");
	}
}

class Pad implements Computer {
	@Override
	public void sale() {
		System.out.println("销售平板电脑");
	}
}

class LenovoDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售联想台式机");
	}
}

class LenovoLapTop extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售联想笔记本");
	}
}

class LenovoPad extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售联想平板电脑");
	}
}

class ShengZouDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售神州台式机");
	}
}

class ShengZouLapTop extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售神州笔记本");
	}
}

class ShengZouPad extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售神州平板电脑");
	}
}
