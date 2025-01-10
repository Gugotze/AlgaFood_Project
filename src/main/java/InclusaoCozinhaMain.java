import com.algaworks.algafood.AlgaFoodApiApplication;
import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoCozinhaMain {

    public static void main (String [] args){
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        Cozinha cozinha2 = new Cozinha();
        cozinha1.setNome("Canadense");

        cozinha1 = cadastroCozinha.salvar(cozinha1);
        cozinha2 = cadastroCozinha.salvar(cozinha2);
    }
}
