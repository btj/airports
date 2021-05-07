package airports;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class AirportTest {

	@Test
	void test() {
		Airport brussels = new Airport();
		assertEquals(Set.of(), brussels.getConnectedAirports());
		
		Airport london = new Airport();
		brussels.connectTo(london);
		assertEquals(Set.of(london), brussels.getConnectedAirports());
		assertEquals(Set.of(brussels), london.getConnectedAirports());
		
		Airport berlin = new Airport();
		london.connectTo(berlin);
		assertEquals(Set.of(london), brussels.getConnectedAirports());
		assertEquals(Set.of(brussels, berlin), london.getConnectedAirports());
		assertEquals(Set.of(london), berlin.getConnectedAirports());
		
		london.disconnectFrom(brussels);
		assertEquals(Set.of(), brussels.getConnectedAirports());
		assertEquals(Set.of(berlin), london.getConnectedAirports());
		assertEquals(Set.of(london), berlin.getConnectedAirports());
	}

}
