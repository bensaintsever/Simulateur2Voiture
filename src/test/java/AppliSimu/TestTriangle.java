package AppliSimu;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTriangle {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testConversionMetresPixels() {
		
		IHM monTriangle = new IHM();
		
		int xPixels = monTriangle.calculerPositionPixels(110);
		
		assertEquals(55, xPixels);
	}

}
