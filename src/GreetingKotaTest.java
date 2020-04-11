import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingKotaTest {
    private GreetingKota g;

    @Before
    public void setup() throws Exception{
        g = new GreetingKota();
    }

    @Test
    public void greet1() throws Exception{
        assertEquals("Hello, Bob.", g.greet("Bob"));
    }

    @Test
    public void greet2() throws Exception{
     //   assertEquals("Hello, my friend.", g.greet(null));
        assertEquals("Hello, my friend.", g.greet(""));
    }

    @Test
    public void greet3() throws Exception{
        assertEquals("HELLO JERRY!", g.greet("JERRY"));
    }

    @Test
    public void greet4() throws Exception {
        assertEquals("Hello, Jill and Jane.", g.greet("Jill", "Jane"));
    }

    @Test
    public void greet5() throws Exception {
        assertEquals("Hello, Amy, Brian, and Charlotte.", g.greet("Amy", "Brian", "Charlotte"));
    }

    @Test
    public void greet6() throws Exception {
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", g.greet("Amy", "BRIAN", "Charlotte"));
        assertEquals("Hello, Amy, Jay, and Charlotte. AND HELLO BRIAN!", g.greet("Amy", "BRIAN", "Jay", "Charlotte"));
        assertEquals("Hello, Amy. AND HELLO BRIAN!", g.greet("Amy", "BRIAN"));
    }

    @Test
    public void greet7() throws Exception {
        assertEquals("Hello, Amy, Brian, and Charlotte.", g.greet("Amy", "Brian, Charlotte"));
        assertEquals("Hello, Amy, Brian, Charlotte, and Jay.", g.greet("Amy", "Brian, Charlotte, Jay"));
        assertEquals("Hello, Amy, Brian, and Jay. AND HELLO CHARLOTTE!", g.greet("Amy", "Brian, CHARLOTTE, Jay"));
    }

    @Test
    public void greet8() throws Exception {
        assertEquals("Hello, Bob and Charlie, Dianne.", g.greet("Bob", "\"Charlie, Dianne\""));
    }
}