class test {
    int i = 5;
	int meth ( int a , int b ) {
		int x = 10000000;
		int y = b + a;
		return x * y;
	}
	
	char meth2 (boolean a, int b) {
		boolean r = !a;
		String f = "42";
		char x = '2';
		char y = '4';
		int i = b - 5;
		return x - y;
	}
	
	test meth3 () {
		return new test();
	}
	
	String meth4() {
		return "42";
	}
}
