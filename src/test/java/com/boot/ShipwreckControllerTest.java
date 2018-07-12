package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController shipwreckController;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void tesShipwreckTest() {
		Shipwreck shipwreckLocal = new Shipwreck();
		shipwreckLocal.setId(1L);
		when(shipwreckRepository.getOne(1L)).thenReturn(shipwreckLocal);
		
		Shipwreck shipwreck = shipwreckController.get(1L);
		
		verify(shipwreckRepository).getOne(1L);
		
//		assertEquals(1L, shipwreck.getId().longValue()); JUnit way to do
		assertThat(shipwreck.getId(), is(1L));
	}

}
