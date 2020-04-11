import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class DLLJunitTest {

	SecurityCheckLine line;

	@Before
	public void setup() throws Exception {
		line = new SecurityCheckLine();
	}

	@Test
	public void Addtest1() {
		line.AddPerson("R1", "regular");
		assertEquals("R1", line.GetFirst());
		line.AddPerson("R2", "regular");
		assertEquals("R1", line.GetFirst());
		line.AddPerson("V1", "VIP");
		assertEquals("V1", line.GetFirst());
		line.AddPerson("R3", "regular");
		assertEquals("V1", line.GetFirst());
		line.AddPerson("S1", "staff");
		assertEquals("V1", line.GetFirst());
		line.AddPerson("R4", "regular");
		assertEquals("V1", line.GetFirst());
		line.AddPerson("S2", "staff");
		assertEquals("V1", line.GetFirst());
		line.AddPerson("V2", "regular");
		assertEquals("V1", line.GetFirst());

	}

	@Test
	public void Sizetest1() {
		line.AddPerson("R1", "regular");
		assertEquals("R1", line.GetFirst());
		
		line.AddPerson("R2", "regular");
		assertEquals("R1", line.GetFirst());
		assertEquals(2, line.Size());
		assertEquals(0, line.PriorityLineSize());		
		
		line.AddPerson("V1", "VIP");
		assertEquals("V1", line.GetFirst());
		assertEquals(3, line.Size());
		assertEquals(1, line.PriorityLineSize());	
		
		line.AddPerson("R3", "regular");
		assertEquals("V1", line.GetFirst());
		assertEquals(4, line.Size());
		assertEquals(1, line.PriorityLineSize());	
		
		line.AddPerson("S1", "staff");
		assertEquals("V1", line.GetFirst());
		assertEquals(5, line.Size());
		assertEquals(2, line.PriorityLineSize());	
		
		line.AddPerson("R4", "regular");
		assertEquals("V1", line.GetFirst());
		assertEquals(6, line.Size());
		assertEquals(2, line.PriorityLineSize());	
		
		line.AddPerson("S2", "staff");
		assertEquals("V1", line.GetFirst());
		assertEquals(7, line.Size());
		assertEquals(3, line.PriorityLineSize());
		
		line.AddPerson("V2", "VIP");
		assertEquals("V1", line.GetFirst());
		assertEquals(8, line.Size());
		assertEquals(4, line.PriorityLineSize());
		
	}

	@Test
	public void emptylinetest1() {
		assertEquals(line.GetFirst(), null);
		line.AddPerson("R1", "regular");
		assertEquals(line.GetFirst(), "R1");
		line.Pop();
		assertEquals(line.GetFirst(), null);
	}
	
	@Test
	public void popAndRemovetest1()
	{
		line.AddPerson("R1", "regular");
		line.AddPerson("R2", "regular");
		assertEquals("R1", line.Pop());
		assertEquals("R2", line.Pop());
		assertEquals(null, line.Pop());
		assertEquals(null, line.Pop());
		
		line.AddPerson("R1", "regular");
		line.AddPerson("R2", "regular");
		line.AddPerson("V1", "VIP");
		line.AddPerson("R3", "regular");
		line.AddPerson("S1", "staff");
		line.AddPerson("R4", "regular");
		line.AddPerson("S2", "staff");
		line.AddPerson("V2", "VIP");
		
		assertEquals("V1", line.Pop());
		assertEquals("S1", line.Pop());
		assertEquals("S2", line.Pop());
		assertEquals("V2", line.Pop());
		assertEquals("R1", line.Pop());
		assertEquals("R2", line.Pop());
		assertEquals("R3", line.Pop());
		assertEquals("R4", line.Pop());
		assertEquals(null, line.Pop());
		assertEquals(null, line.Pop());
	}
	

}
