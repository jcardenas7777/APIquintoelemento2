package UNAB.APIquintoE.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UNAB.APIquintoE.Models.peticiones.UsuarioCrearRequestModel;
import UNAB.APIquintoE.Models.respuestas.MensajeRestModel;
import UNAB.APIquintoE.Models.respuestas.UsuarioDataRestModel;
import UNAB.APIquintoE.Services.IUsuarioServices;
import UNAB.APIquintoE.Shared.UsuarioDto;

@RestController
@RequestMapping("/admin")
public class UsuarioController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioServices iUsuarioServices;


    @GetMapping
    public UsuarioDataRestModel leerUsuario(){
        
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();

        UsuarioDto usuarioDto= iUsuarioServices.leerUsuario(username);

        UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);

        return usuarioDataRestModel;

    }

    @PostMapping
    public UsuarioDataRestModel CrearUsuario (@RequestBody UsuarioCrearRequestModel usuarioCrearRequestModel){
        //realizamos la autenticación
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();
        
        UsuarioDto usuarioLoginDto = iUsuarioServices.leerUsuario(username);
        
        if (usuarioLoginDto.getRolEntity().getId()==1) {
            
        UsuarioDto usuarioCrearDto = modelMapper.map(usuarioCrearRequestModel, UsuarioDto.class);

        UsuarioDto usuarioDto = iUsuarioServices.crearusuario(usuarioCrearDto);

        UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);


        return usuarioDataRestModel;
        }
    
        return null;
    }
    
    @GetMapping(path = "/verusuarios")
    public List<UsuarioDataRestModel> verUsuarios(){
       
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();

        UsuarioDto usuarioLoginDto = iUsuarioServices.leerUsuario(username);
        
        if (usuarioLoginDto.getRolEntity().getId()==1) {
            List<UsuarioDto> usuarioDtoList= iUsuarioServices.verUsuarios();
            List<UsuarioDataRestModel> usuarioDataRestModelList = new ArrayList<>();

            for (UsuarioDto usuarioDto : usuarioDtoList) {

                UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);
                usuarioDataRestModelList.add(usuarioDataRestModel);
                
            }

            return usuarioDataRestModelList;
        }
        return null;
    }

    @GetMapping(path = "/{id}")
    public UsuarioDataRestModel detalleUsuario(@PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();

        UsuarioDto usuarioLoginDto = iUsuarioServices.leerUsuario(username);
        
        if (usuarioLoginDto.getRolEntity().getId()==1) {

            UsuarioDto usuarioDto= iUsuarioServices.detalleUsuario(id);
            UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);

            return usuarioDataRestModel;
        }    

        return null;

    }

    @DeleteMapping(path = "/{id}")
    public MensajeRestModel eliminarUsuario (@PathVariable String id){
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();
        
        UsuarioDto usuarioLoginDto = iUsuarioServices.leerUsuario(username);

        MensajeRestModel mensajeRestModel =new MensajeRestModel();

        if (usuarioLoginDto.getRolEntity().getId()==1){

            iUsuarioServices.eliminarUsuario(id);

            mensajeRestModel.setNombre("Eliminar Usuario");
            mensajeRestModel.setResultado("Usuario Eliminado Con exito");
            
            return mensajeRestModel;
        }
        

        mensajeRestModel.setNombre("Permisos Insuficientes");
        mensajeRestModel.setResultado("Fallo eliminar usuario, sin permisos de acceso");

        return mensajeRestModel;


    }


}
