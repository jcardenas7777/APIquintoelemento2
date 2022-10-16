package UNAB.APIquintoE;



// import javax.crypto.SecretKey;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import UNAB.APIquintoE.Utils.AppContexto;

// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Encoders;
// import io.jsonwebtoken.security.Keys;

import org.modelmapper.convention.MatchingStrategies;

// @SpringBootApplication (exclude =  {SecurityAutoConfiguration.class})
@SpringBootApplication()
@EnableJpaAuditing
public class ApIquintoEApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApIquintoEApplication.class, args);
		System.out.println("*/*/*/*/*/*/*/*/*/*/API Corriendo.../*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");

		// SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
		// String key64 = Encoders.BASE64.encode(key.getEncoded());
		// System.out.println("su clave secreta es "+key64);
		//la key es: PlPywmQnZNttmYssVIMI7xOcpq795YOZxvk/An/zJ9FrbM8uAo3KgWhM7y8K0dLP7Ikvy57AoalH5cWqD++3xA==
		
		
		
	}
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		return bCryptPasswordEncoder;

	}

	@Bean
	public AppContexto AppContexto(){
		//bean para poder llamarla en otros ambitos y no hacer instancia
		return new AppContexto();

	}
}
