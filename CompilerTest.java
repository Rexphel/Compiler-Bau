import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CompilerTest {
    boolean testBool = true;
    boolean otherBool = false;
    char testChar = 'a';
    char otherChar = 'z';
    int testInt = 1;
    int otherInt = 69;
    String testString = "This is for testing purposes only!";
    String otherString = "Ok you may look :)";
    String testLongString = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.";
    String otherLongString = "We're no strangers to love You know the rules and so do I (do I) A full commitment's what I'm thinking of You wouldn't get this from any other guy I just wanna tell you how I'm feeling Gotta make you understand Never gonna give you up Never gonna let you down Never gonna run around and desert you Never gonna make you cry Never gonna say goodbye Never gonna tell a lie and hurt you We've known each other for so long Your heart's been aching, but you're too shy to say it (say it) Inside, we both know what's been going on (going on) We know the game and we're gonna play it And if you ask me how I'm feeling Don't tell me you're too blind to see Never gonna give you up Never gonna let you down Never gonna run around and desert you Never gonna make you cry Never gonna say goodbye Never gonna tell a lie and hurt you Never gonna give you up Never gonna let you down Never gonna run around and desert you Never gonna make you cry Never gonna say goodbye Never gonna tell a lie and hurt you We've known each other for so long Your heart's been aching, but you're too shy to say it (to say it) Inside, we both know what's been going on (going on) We know the game and we're gonna play it I just wanna tell you how I'm feeling Gotta make you understand Never gonna give you up Never gonna let you down Never gonna run around and desert you Never gonna make you cry Never gonna say goodbye Never gonna tell a lie and hurt you Never gonna give you up Never gonna let you down Never gonna run around and desert you Never gonna make you cry Never gonna say goodbye Never gonna tell a lie and hurt you Never gonna give you up Never gonna let you down Never gonna run around and desert you Never gonna make you cry Never gonna say goodbye Never gonna tell a lie and hurt you";
    String stringNull = null;


    TestSuite tS = new TestSuite();
    @Test
    public void Constructor(){
        System.out.print("Testing Getter ...");

        TestSuite Ob = tS.init();
        assertNotNull(Ob.returnThis());
        assertEquals(Ob.returnThis(), Ob);

        System.out.print("Done \n");
    }

    @Test
    public void Getter(){
        System.out.print("Testing Getter ...");

        assertEquals(tS.getTestBool(), testBool);
        assertEquals(tS.getTestChar(), testChar);
        assertEquals(tS.getTestInt(), testInt);
        assertEquals(tS.getTestString(), testString);
        assertEquals(tS.getTestLongString(), testLongString);

        System.out.print("Done \n");
    }

    @Test
    public void Setter(){
        System.out.print("Testing Getter ...");

        tS.setTestBool(otherBool);
        tS.setTestChar(otherChar);
        tS.setTestInt(otherInt);
        tS.setTestString(otherString);
        tS.setTestLongString(otherLongString);

        assertEquals(tS.getTestBool(), otherBool);
        assertEquals(tS.getTestChar(), otherChar);
        assertEquals(tS.getTestInt(), otherInt);
        assertEquals(tS.getTestString(), otherString);
        assertEquals(tS.getTestLongString(), otherLongString);

        System.out.print("Done \n");
    }

    @Test
    public void Maths(){
        System.out.print("Testing Getter ...");

        assertEquals(tS.getInverseTestInt(), -testInt);
        tS.incrementTestInt();
        assertEquals(tS.getTestInt(), testInt + 1);
        assertEquals(tS.testMath(4,20), 24);
        assertEquals(tS.complexMath(6,9,4), this.complexMath(6,9,4));
        assertEquals(tS.squareTestInt(), tS.getTestInt() * tS.getTestInt());
        assertEquals(tS.recursionSum(12), this.recursionSum(12));

        System.out.print("Done \n");
    }

    @Test
    public void Logic(){
        System.out.print("Testing Getter ...");

        assertEquals(tS.greaterThan(10, 5), true);
        assertEquals(tS.greaterThan(10,15), false);

        assertEquals(tS.greaterOrEqual(10, 5), true);
        assertEquals(tS.greaterOrEqual(5, 5), true);
        assertEquals(tS.greaterOrEqual(4, 5), false);

        assertEquals(tS.and(true, true), true);
        assertEquals(tS.and(true, false), false);
        assertEquals(tS.and(false, true), false);
        assertEquals(tS.and(false, false), false);

        assertEquals(tS.or(true, true), true);
        assertEquals(tS.or(true, false), true);
        assertEquals(tS.or(false, true), true);
        assertEquals(tS.or(false, false), false);

        assertEquals(tS.notTestBool(), !tS.getTestBool());

        System.out.print("Done \n");
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

    int recursionSum(int k) {
        if (k > 0) {
            return k + recursionSum(k - 1);
        } else {
            return 0;
        }
    }
}
