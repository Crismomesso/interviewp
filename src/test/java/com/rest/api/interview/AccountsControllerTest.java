package com.rest.api.interview;

import com.rest.api.interview.dto.TransactionDTO;
import com.rest.api.interview.enums.OperationEnum;
import com.rest.api.interview.exception.EntityNotFoundException;
import com.rest.api.interview.model.OperationsTypes;
import com.rest.api.interview.service.ITransactionsService;

// import com.rest.api.interview.service.IClientService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AccountsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private OAuthHelper authHelper;

	@MockBean
	private ITransactionsService service;

	@Test
	public void test1() throws Exception {

		RequestPostProcessor bearerToken = authHelper.addBearerToken("cris");

		TransactionDTO dto =new TransactionDTO(1l,OperationEnum.PAGAMENTO,1d);
		Mockito.when(service.findById(1l)).thenReturn(dto);
		mockMvc.perform(get("/accounts/1").with(bearerToken)).andExpect(status().isOk());
	}

}
