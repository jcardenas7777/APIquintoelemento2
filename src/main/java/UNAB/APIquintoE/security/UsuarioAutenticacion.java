package UNAB.APIquintoE.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.fasterxml.jackson.databind.ObjectMapper;

import UNAB.APIquintoE.Models.peticiones.UsuarioSingUpRequestModel;
import UNAB.APIquintoE.Services.IUsuarioServices;
import UNAB.APIquintoE.Shared.UsuarioDto;
import UNAB.APIquintoE.Utils.AppContexto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;

import io.jsonwebtoken.security.Keys;

public class UsuarioAutenticacion extends UsernamePasswordAuthenticationFilter{

    private final AuthenticationManager authenticationManager;

    public UsuarioAutenticacion(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
                //controlador del login usuario recibimos las peticiones del usuario
            
        try {
            
            UsuarioSingUpRequestModel usuarioSingUpRequestModel = new  ObjectMapper().readValue(
                request.getInputStream(), UsuarioSingUpRequestModel.class);

            UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                usuarioSingUpRequestModel.getUsername(), 
                usuarioSingUpRequestModel.getPassword(), 
                new ArrayList<>());

                //Usamos para hacer todas las autenticaciones de la API
            Authentication authentication = authenticationManager.authenticate(upat);

            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }   
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        //generar token 
        String username = ((User) authResult.getPrincipal()).getUsername();

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(ConstantesSecurity.TOKEN_SECRETO));
        
        String token = Jwts.builder()
        .setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis()+ConstantesSecurity.FECHA_EXPIRACION))
        .signWith(key)
        .compact();
        
        //no es un bean por lo que debemos obtener el contexto. 
        IUsuarioServices iUsuarioServices = (IUsuarioServices) AppContexto.getBean("usuarioServices");
        //traemos el Username a travez de los servicios y lo guardamos con un Dto para enviar lo que queramos al front por el header
        UsuarioDto usuarioDto = iUsuarioServices.leerUsuario(username);

        response.addHeader("Access-Control-Expose-Headers", "Authorization, IdUsuario, RolUsuario");
        response.addHeader("IdUsuario", usuarioDto.getIdUsuario());  
        response.addHeader("RolUsuario", usuarioDto.getRolEntity().getNombreRol());      
        response.addHeader(ConstantesSecurity.HEADER_STRING, ConstantesSecurity.TOKEN_PREFIJO+token);
    }

   
}
