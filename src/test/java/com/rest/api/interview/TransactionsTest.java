package com.rest.api.interview;

// import com.rest.api.interview.service.IClientService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TransactionsTest {


	@Autowired
	private MockMvc mockMvc;

	// @MockBean
	// private IClientService clientService;

	@Test
	public void test1() {
		System.out.println(01);
		Assert.assertNotNull(new Object());
	}

}
