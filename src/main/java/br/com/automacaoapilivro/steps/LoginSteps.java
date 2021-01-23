package br.com.automacaoapilivro.steps;

import com.google.gson.Gson;
import br.com.automacaoapilivro.pojos.Customer;
import br.com.automacaoapilivro.pojos.Login;
import br.com.automacaoapilivro.servicos.Autenticacao;
import br.com.automacaoapilivro.servicos.Resposta;
import br.com.automacaoapilivro.servicos.ServicosImpl;

public class LoginSteps {
	
	Login login = new Login();
	Gson gson = new Gson();
	ServicosImpl verbos = new ServicosImpl();
	Customer customer = new Customer();
	Autenticacao autenticacao = new Autenticacao();
	Resposta resposta;
	String idAuthToken;
	
	public void fazendoLogin() {
		login.setUsername("logindousuario@gmail.com");
		login.setPassword("fafafaf");
		String jsonLogin = gson.toJson(login);
		resposta = autenticacao.login("endpoint da API", jsonLogin);
	}
	
	public void salvarToken() {
		
		idAuthToken = resposta.salvarToken("idToken");
		
	}
	
	public void logado() {
		customer.setName("Daniel");
		customer.setAdress("Rua das Dores");
		String jsonCustomer = gson.toJson(customer);
		resposta = verbos.postEndpointWithAuthorization("endpoint da API", idAuthToken,jsonCustomer);
	}

}
