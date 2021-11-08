package br.com.ibm.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UdemyApplication {

//  @Bean
//  public CommandLineRunner run(@Autowired ClienteRepository repository) {
//    return args -> {
//      Cliente cliente = Cliente.builder().cpf("12345678918").nome("Bruno").build();
//      repository.save(cliente);
//      
//    };
//  }
  
  
  
	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
		
	}

}
