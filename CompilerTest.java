class  CompilerTest {
	int i = 3;
	boolean f = false;
	char c = 'x';
	String str = "this is a string";

	int getI(){
		return i;
	}

	void setI(int j){
		i = j;
	}

	void incrementI(){
		i = i +1;
	}

	boolean getNotF(){
		return !f;
	}

	char getC(){
		char r = c;
		return r;
	}

	CompilerTest getNew(){
		return new  CompilerTest();
	}

	String getLongString(){
		String str = "It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.  During the battle, Rebel spies managed to steal secret plans to the Empire's ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet  Pursued by the Empire's sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy....";
		return str;
	}

	int calculateVolumeOfCuboid(int r, int s, int t){
		int volume = r * s * t;
		return volume;
	} 

	int complexCalculation(int a, int b, int c){
		int x = a % c;
		int y = 0;
		if (x == 5){
			y = 12;
		} else {
			y = a - b;
		}
		x = x - y;
		int count = 0;
		while (count < 5){
			x = x + count;
			count = count + 1;
		}

		if (count != 4){
			return b / c;
		} else {
			return x;
		}
	}

	boolean lt (char a, char b){
		return a < b;
	}
	boolean gt (int a, char b){
		return a > b;
	}
	boolean le (int a, int b){
		return a <= b;
	}
	boolean ge (char a, char b){
		return a >= b;
	}

	boolean and (boolean a, boolean b){
		return a && b;
	}

	boolean or (boolean a, boolean b){
		return a || b;
	}

	int negativeOf(int x){
		return -x;
	}

	boolean not(boolean a) {
		return !a;
	}

	int recursion(int x){
		int y = x - 1;
		if (x > 0){
			y = recursion(y);
		}
		return y;
	}

	boolean notnot(boolean f){
		 CompilerTest t = new  CompilerTest();
		boolean not = t.not(f);
		return !not;
	}

	int getIncrement(int v){
		this.setI(v);
		this.incrementI();
		return getI();
	}

}
