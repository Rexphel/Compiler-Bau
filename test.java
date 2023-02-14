class test {
    int i = 5;
	int meth ( int a , int b ) {
		int x = 10000;
		int y = b + a;
		return x * y;
	}
	
	int meth2 (boolean a, int b) {
		boolean r = !a;
		String f = "42";
		int i = b;
		return i;
	}
	
	test meth3 () {
		return new test();
	}
}
