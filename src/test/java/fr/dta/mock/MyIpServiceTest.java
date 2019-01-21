package fr.dta.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MyIpServiceTest {
	private HttpDataService mock;
	private MyIpService ip;

	@Before
	public void before() {
		mock = Mockito.mock(HttpDataService.class); // on émule la classe HttpDataService
		Mockito.when(mock.getJsonIp()).thenReturn( // on simule le résultat de la classe émulé
				"{\"ip\":\"192.168.1.1\",\"about\":\"/about\",\"Pro!\":\"http://getjsonip.com\",\"reject-fascism\":\"Liberal America will prevail\"}");
	}

	@Test
	public void testMyIpService() {

		ip = new MyIpService(mock);
		String res = ip.getMyIp();
		Assert.assertEquals(res, "192.168.1.1"); // on verifie le resultat
		Mockito.verify(mock).getJsonIp(); // on vérifie comme quoi on a bien fait appelle à la classe émulé

	}
}
