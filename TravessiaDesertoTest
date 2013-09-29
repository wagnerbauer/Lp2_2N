import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

public class TravessiaDesertoTest {


	private TravessiaDeserto travessia = null;
	private int pos;
	private int MAP_SIZE;
	private int fuel;
	private int map;
	
	@Before
	public void setUp() {
		travessia = new TravessiaDeserto();
	}

	@After
	public void tearDown() {
		travessia = null;
	}
	
	@Test
	public void voltarTest(){
		travessia.initGame();
		travessia.avancar();
		
		int combustivel = travessia.getFuel();
		int posicao = travessia.getPos();
		
		travessia.voltar();
		
		assertEquals(combustivel, travessia.getFuel() - 1);
		assertEquals(posicao - 1, travessia.getPos());
	}

	@Test
	public void avancarTest() {
		travessia.initGame();

		int combustivel = travessia.getFuel();
		int posicao = travessia.getPos();

		travessia.avancar();

		assertEquals(combustivel - 1, travessia.getFuel());
		assertEquals(posicao + 1, travessia.getPos());
	}
	@Test
	public void initGameTest() {
		travessia.initGame();
		assertEquals(0, travessia.getPos());
		assertEquals(travessia.MAX_FUEL, travessia.getFuel());
		assertEquals(travessia.MAP_SIZE, travessia.getMap().length);
	}
	@Test
	public void testIsWinner() {
	    pos = 10;
	    MAP_SIZE = 10;
	    System.out.println("ok");
	}
	@Test
	public void testInitGame() {
	    pos = 0;
	    fuel = 6;
	    map = 10;
	    System.out.println("ok");
	}
	@Test
	public void testPrintStatus() {
	    pos = 0;
	    fuel = 6;
	    map = 10;
	    System.out.println("OK");
	}
	@Test
	public void testDescarregar() {
	    fuel = 1;
	    fuel--;
	    map++;
	    System.out.println("ok");
	}
}
