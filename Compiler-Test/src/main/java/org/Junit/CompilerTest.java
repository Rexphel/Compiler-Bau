import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CompilerTest {
    private final ABC abc = new ABC();
    @Test
    public void abcd(){
        assertEquals(2, abc.add(1,1));
    }
}
