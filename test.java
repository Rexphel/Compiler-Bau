class test {
    int i = 5;
	int meth ( int a , int b ) {
		int x = a + b;
		int y = x - a;
		return y;
	}
	
	int meth2 (boolean a, int b) {
		boolean r = a;
		return this.meth(5, b);
	}
}
