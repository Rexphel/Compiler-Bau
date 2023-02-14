class test {
    int i = 5;
	int meth ( int a , int b ) {
		int x = 7;
		int y = b + a;
		return x * y;
	}
	
	int meth2 (boolean a, int b) {
		boolean r = !a;
		int i = b;
		while ( r != true){
			r = true;
			i = i + 1;
		}
		return i;
	}
}
