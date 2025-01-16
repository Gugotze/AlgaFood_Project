import com.algaworks.algafood.AlgaFoodApiApplication;
import com.algaworks.algafood.domain.Restaurante;
import com.algaworks.algafood.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoRestauranteMain {

    public static void main (String [] args){
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteReposity = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Dominos");

        Restaurante restaurante2 = new Restaurante();
        restaurante1.setNome("PizzaHut");

        restaurante1 = restauranteReposity.salvar(restaurante1);
        restaurante2 = restauranteReposity.salvar(restaurante2);

    }
}
