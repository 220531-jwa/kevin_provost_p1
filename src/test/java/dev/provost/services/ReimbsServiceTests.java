package dev.provost.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.provost.models.Reimbs;
import dev.provost.repositories.ReimbsDAO;

@ExtendWith(MockitoExtension.class)
class ReimbsServiceTests {

	@InjectMocks
	private static ReimbsService reimbsService;

	@Mock
	private static ReimbsDAO reimbsDaoMock;

	String s1 = "2022-06-29";
	String s2 = "2022-11-25";
	String s3 = "09:30:00";
	LocalDate ld1 = LocalDate.parse(s1);
	LocalDate ld2 = LocalDate.parse(s2);
	LocalTime lt1 = LocalTime.parse(s3);
	List<Reimbs> mockReimbs = new ArrayList<>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		reimbsService = new ReimbsService(reimbsDaoMock);

	}

	@Test
	void testGetReimbsByReimbStatus() {

		mockReimbs.add(new Reimbs(1, 2, 3, 1, 60, 500.00, ld1, ld2, lt1, "Tampa, Florida",
				"SQL Training Course to improve my skills in the workplace", null, 1, "Adequate justification", false));
		mockReimbs.add(new Reimbs(2, 2, 3, 1, 70, 300.00, ld1, ld2, lt1, "Orlando, Florida",
				"Java Training Course to improve my skills in the workplace", null, 2, "Adequate justification",
				false));
		mockReimbs.add(new Reimbs(3, 2, 3, 1, 60, 200.00, ld1, ld2, lt1, "Miami, Florida",
				"Kotlin Training Course to improve my skills in the workplace", null, 3, "Adequate justification",
				false));
		when(reimbsDaoMock.getReimbsByReimbStatus(anyInt())).thenReturn(mockReimbs);

		List<Reimbs> reimbs = reimbsService.getReimbsByReimbStatus(1);
		assertEquals(reimbs, mockReimbs);
	}

	@Test
	void testGetReimbsByReimbId() {
		mockReimbs.add(new Reimbs(1, 2, 3, 1, 60, 500.00, ld1, ld2, lt1, "Tampa, Florida",
				"SQL Training Course to improve my skills in the workplace", null, 1, "Adequate justification", false));
		when(reimbsDaoMock.getReimbsByReimbId(anyInt())).thenReturn(mockReimbs);

		List<Reimbs> reimbs = reimbsService.getReimbsByReimbId(1);
		assertEquals(reimbs, mockReimbs);
	}

	@Test
	void testGetReimbsByReimbStatusAndEmpId() {
		mockReimbs.add(new Reimbs(1, 2, 3, 1, 60, 500.00, ld1, ld2, lt1, "Tampa, Florida",
				"SQL Training Course to improve my skills in the workplace", null, 1, "Adequate justification", false));
		mockReimbs.add(new Reimbs(2, 2, 3, 1, 70, 300.00, ld1, ld2, lt1, "Orlando, Florida",
				"Java Training Course to improve my skills in the workplace", null, 2, "Adequate justification",
				false));
		mockReimbs.add(new Reimbs(3, 2, 3, 1, 60, 200.00, ld1, ld2, lt1, "Miami, Florida",
				"Kotlin Training Course to improve my skills in the workplace", null, 3, "Adequate justification",
				false));
		when(reimbsDaoMock.getReimbsByReimbStatusAndEmpId(anyInt(), anyInt())).thenReturn(mockReimbs);

		List<Reimbs> reimbs = reimbsService.getReimbsByReimbStatusAndEmpId(2, 2);
		assertEquals(reimbs, mockReimbs);
	}

	@Test
	void testGetReimbsByEmpId() {
		mockReimbs.add(new Reimbs(1, 2, 3, 1, 60, 500.00, ld1, ld2, lt1, "Tampa, Florida",
				"SQL Training Course to improve my skills in the workplace", null, 1, "Adequate justification", false));
		mockReimbs.add(new Reimbs(2, 2, 3, 1, 70, 300.00, ld1, ld2, lt1, "Orlando, Florida",
				"Java Training Course to improve my skills in the workplace", null, 2, "Adequate justification",
				false));
		mockReimbs.add(new Reimbs(3, 2, 3, 1, 60, 200.00, ld1, ld2, lt1, "Miami, Florida",
				"Kotlin Training Course to improve my skills in the workplace", null, 3, "Adequate justification",
				false));
		when(reimbsDaoMock.getReimbsByEmpId(anyInt())).thenReturn(mockReimbs);

		List<Reimbs> reimbs = reimbsService.getReimbsByEmpId(2);

		assertEquals(reimbs, mockReimbs);
	}

	@Test
	void testCreateReimb() {
		Reimbs mockReimb = new Reimbs(1, 2, 3, 1, 60, 500.00, ld1, ld2, lt1, "Tampa, Florida",
				"SQL Training Course to improve my skills in the workplace", null, 1, "Adequate justification", false);

		when(reimbsDaoMock.createReimb(any(Reimbs.class), anyInt())).thenReturn(mockReimb);

		Reimbs reimb = reimbsService.createReimb(mockReimb, 2);

		assertEquals(reimb, mockReimb);
	}

	@Test
	void testCreateReimbWithoutEnoughAvailFundsShouldBeNull() {
		Reimbs mockReimb = new Reimbs(1, 2, 3, 1, 60, 1500.00, ld1, ld2, lt1, "Tampa, Florida",
				"SQL Training Course to improve my skills in the workplace", null, 1, "Adequate justification", false);

		Reimbs reimb = reimbsService.createReimb(mockReimb, 2);

		assertEquals(reimb, null);
	}

	/*
	 * @Test void testEditReimbStatus() { Reimbs mockReimb = new Reimbs(1, 2, 3, 1,
	 * 60, 500.00, ld1, ld2, lt1, "Tampa, Florida",
	 * "SQL Training Course to improve my skills in the workplace", null, 1,
	 * "Adequate justification", false); // Reimbs editedMockReimb = new Reimbs(1,
	 * 2, 3, 1, 60, 500.00, ld1, ld2, lt1, "Tampa, Florida", //
	 * "SQL Training Course to improve my skills in the workplace", null, 2,
	 * "Hello", false);
	 * 
	 * when(reimbsDaoMock.editReimbStatus(anyInt(), anyInt(),
	 * anyString())).thenReturn(mockReimb);
	 * 
	 * assertEquals(mockReimb, reimbsService.editReimbStatus(anyInt(), anyInt(),
	 * anyString()));
	 * 
	 * }
	 * 
	 * @Test void testDeleteReimb() { Reimbs mockReimb = new Reimbs(1, 2, 3, 1, 60,
	 * 500.00, ld1, ld2, lt1, "Tampa, Florida",
	 * "SQL Training Course to improve my skills in the workplace", null, 1,
	 * "Adequate justification", false); mockReimbs.add(mockReimb);
	 * 
	 * // when(reimbsDaoMock.deleteReimb(anyInt())).thenReturn(null);
	 * reimbsService.deleteReimb(1);
	 * 
	 * assertEquals(reimbsService.getReimbsByReimbId(1), null);
	 */

}
