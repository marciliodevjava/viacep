package br.com.viacep.http;

import br.com.viacep.domain.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class RequestViaCep {
    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/";

    @Autowired
    private RestTemplate restTemplate;
    private final String MODELO = "/json/";


    public Cep buscarCep(String cep) {
        String apiUrl = VIA_CEP_URL + cep + "/json";
        Cep cepRecebido = restTemplate.getForObject(apiUrl, Cep.class);

        if (cepRecebido != null) {
            Cep cepMapeado = this.mapeiaCep(cepRecebido);
            return cepMapeado;
        } else {
            return null; // Trate o caso de CEP não encontrado ou erro na chamada.
        }
    }

    private Cep mapeiaCep(Cep response) {
        if (Objects.nonNull(response)) {
            Cep cep = new Cep();

            cep.setCep(response.getCep());
            cep.setLogradouro(response.getLogradouro());
            cep.setComplemento(response.getComplemento());
            cep.setBairro(response.getBairro());
            cep.setLocalidade(response.getLocalidade());
            cep.setUf(response.getUf());

            return cep;
        }
        return null;
    }
}
