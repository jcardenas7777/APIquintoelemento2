package UNAB.APIquintoE.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;

import UNAB.APIquintoE.Services.IUsuarioServices;

//cors
@Configuration
@EnableWebSecurity
public class ConfiguracionSecurity extends WebSecurityConfigurerAdapter{

    public static final String TOKEN_PREFIJO = null;
    private final IUsuarioServices iUsuarioServices;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ConfiguracionSecurity(IUsuarioServices iUsuarioServices, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.iUsuarioServices = iUsuarioServices;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
        //cors para permitir el intercambio de datos con servidores
        .cors()
        //and para que siga funcionando el resto despues de habilitar los cors
        .and()
        .csrf().disable()
        .authorizeRequests()//autorizar algunos endpoint y con que reglas
        .anyRequest().authenticated()
        .and()
        //clase Usuario autenticacion tiene un constructor con authentication Manager
        .addFilter(new UsuarioAutenticacion(authenticationManager()))
        //Clase TokenAutorizacion.java con su constructor de authenticationManager
        .addFilter(new TokenAutorizacion(authenticationManager()))
        //no se cren estados, queremos que envie el token cada vez que envie una peticion
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //clase que usa el userdetails y lo que usamos para encriptar la pass
        auth.userDetailsService(iUsuarioServices).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration= new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
        
        
    }


}
