package UNAB.APIquintoE.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import UNAB.APIquintoE.Shared.UsuarioDto;

public interface IUsuarioServices extends UserDetailsService{
    
    UsuarioDto crearusuario (UsuarioDto usuarioCrearDto);

    UsuarioDto leerUsuario (String Username);

    List <UsuarioDto> verUsuarios ();

    UsuarioDto detalleUsuario(String id);

    void eliminarUsuario (String idUsuario);
}
