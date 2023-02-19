class TestSuite {

    boolean testBool = true;
    char testChar = 'a';
    int testInt = 1;
    String testString = "This is for testing purposes only!";
    String testLongString = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.";
    TestSuite init(){
        return new TestSuite();
    }
    TestSuite returnThis(){
        return this;
    }
    boolean getTestBool() {
        return testBool;
    }
    char getTestChar() {
        return testChar;
    }
    int getTestInt() {
        return testInt;
    }
    String getTestString() {
        return testString;
    }
    String getTestLongString() {
        return testLongString;
    }

    void setTestBool(boolean b) {
        testBool = b;
    }
    void setTestChar(char c) {
        testChar = c;
    }
    void setTestInt(int i) {
        testInt = i;
    }
    void setTestString(String s) {
        testString = s;
    }
    void setTestLongString(String s) {testLongString = s;}

    int getInverseTestInt(){
        return -testInt;
    }
    int incrementTestInt(){testInt = testInt + 1; return testInt;}
    int testMath(int a, int b){
        return a+b;
    }
    int complexMath(int a, int b, int c){
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
    int squareTestInt(){
        return testInt * testInt;
    }
    int recursionSum(int k) {
        if (k > 0) {
            return k + recursionSum(k - 1);
        } else {
            return 0;
        }
    }

    boolean greaterThan (int a, int b){
        return a > b;
    }
    boolean greaterOrEqual (int a, int b){ return a >= b; }
    boolean and (boolean a, boolean b){ return a && b; }
    boolean or (boolean a, boolean b){ return a || b; }
    boolean notTestBool(){ return !testBool; }
}
