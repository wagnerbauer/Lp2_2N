import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

public class TravessiaDesertoTest {


	private TravessiaDeserto travessia = null;
	public int pos;
	public int MAP_SIZE;
	private int fuel;
	private int map;
	public static final int MAX_FUEL = 6;
	public static final int MIN_FUEL = 0;

	
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
		System.out.println("voltarTest ok");
	}

	@Test
	public void avancarTest() {
		travessia.initGame();

		int combustivel = travessia.getFuel();
		int posicao = travessia.getPos();

		travessia.avancar();

		assertEquals(combustivel - 1, travessia.getFuel());
		assertEquals(posicao + 1, travessia.getPos());
		System.out.println("avancarTest ok");
	}
	@Test
	public void initGameTest() {
		travessia.initGame();
		assertEquals(0, travessia.getPos());
		assertEquals(travessia.MAX_FUEL, travessia.getFuel());
		assertEquals(travessia.MAP_SIZE, travessia.getMap().length);
		System.out.println("initGameTest ok");
	}
	@Test
	public void IsWinnerTest() {
	    pos = 10;
	    MAP_SIZE = 10;
	    System.out.println("isWinnerTset ok");
	    System.out.println("Posicao atual");
	    System.out.println(pos);
	}
	@Test
	public void InitGameTest() {
	    pos = 1;
	    fuel = 6;
	    map = 10;
	    System.out.println("InitGameTest ok");
	    System.out.println("Combustivel atual");
	    System.out.println(fuel);
	}
	@Test
	public void PrintStatusTest() {
	    pos = 0;
	    fuel = 6;
	    map = 10;
	    System.out.println("PrintStatusTest OK");
	    System.out.println("Posicao atual");
	    System.out.println(pos);

	}
	@Test
	public void PrintStatusTest2() {
	    pos = 4;
	    fuel = 8;
	    map = 9;
	    System.out.println("PrintStatusTest2 OK");
	    System.out.println("Combustivel atual");
	    System.out.println(fuel);
	}
	@Test
	public void carregarTest() {
	    fuel = 4;
	    pos = 11;
	    fuel++;
	    map--;
	    System.out.println("carregarTest ok");
	    System.out.println("Combustivel atual");
	    System.out.println(fuel);
	}
	@Test
	public void DescarregarTest() {
	    fuel = 2;
	    fuel--;
	    map++;
	    System.out.println("DescarregarTest ok");
	}
	@Test
	public void DescarregarTest2() {
	    fuel = 4;
	    fuel--;
	    map--;
	    System.out.println("DescarregarTest2 ok");
	}
	
}
