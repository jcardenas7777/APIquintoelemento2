package UNAB.APIquintoE.Services;




import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import UNAB.APIquintoE.Data.entidades.RolEntity;
import UNAB.APIquintoE.Data.entidades.UsuarioEntity;
import UNAB.APIquintoE.Data.repositorio.IRolRepository;
import UNAB.APIquintoE.Data.repositorio.IUsuarioRepository;
import UNAB.APIquintoE.Shared.UsuarioDto;

@Service
public class UsuarioServices implements IUsuarioServices{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    IRolRepository iRolRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UsuarioDto crearusuario(UsuarioDto usuarioCrearDto) {
        
        if (iUsuarioRepository.findByEmail(usuarioCrearDto.getEmail())!=null) {
            throw new RuntimeException("Este correo ya se encuentra registrado");
            
        }
        if (iUsuarioRepository.findByUsername(usuarioCrearDto.getUsername())!=null) {
            throw new RuntimeException("Este usuario ya se encuentra registrado");
            
        }
        if (iUsuarioRepository.findByDocumento(usuarioCrearDto.getDocumento())!=null) {
            throw new RuntimeException("Este documento ya se encuentra registrado");
            
        }

        RolEntity rolEntity = iRolRepository.findById(usuarioCrearDto.getNombreRol());

        UsuarioEntity usuarioEntityDto = modelMapper.map(usuarioCrearDto, UsuarioEntity.class);
        usuarioEntityDto.setIdUsuario(UUID.randomUUID().toString());
        usuarioEntityDto.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioCrearDto.getPassword()));
        usuarioEntityDto.setRolEntity(rolEntity);

        UsuarioEntity usuarioEntity = iUsuarioRepository.save(usuarioEntityDto);

        UsuarioDto usuarioDto = modelMapper.map(usuarioEntity,UsuarioDto.class);
        return usuarioDto;
    }

    @Override
    public UsuarioDto leerUsuario(String Username) {
        
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(Username);
  

        if (usuarioEntity==null) {
            
            throw new UsernameNotFoundException(Username);
         }


        UsuarioDto usuarioDto= modelMapper.map(usuarioEntity, UsuarioDto.class);

        
        return usuarioDto;
    }

    @Override
    public List<UsuarioDto> verUsuarios() {

        List<UsuarioEntity> usuarioEntityList = iUsuarioRepository.findAll();

        List<UsuarioDto> usuarioDtoList= new ArrayList<>();

        for (UsuarioEntity usuarioEntity : usuarioEntityList) {

            UsuarioDto usuarioDto = modelMapper.map(usuarioEntity, UsuarioDto.class);
            usuarioDtoList.add(usuarioDto);
        }

        return usuarioDtoList;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(username);

        if (usuarioEntity==null) {

            throw new UsernameNotFoundException(username);
        }

        User usuario = new User(usuarioEntity.getUsername(), usuarioEntity.getPasswordEncriptada(), new ArrayList<>());

        return usuario;

    }

    @Override
    public UsuarioDto detalleUsuario(String id) {
       
            UsuarioEntity usuarioEntity = iUsuarioRepository.findByIdUsuario(id);

            UsuarioDto usuarioDto = modelMapper.map(usuarioEntity, UsuarioDto.class);

            return usuarioDto;
    }

    @Override
    public void eliminarUsuario(String idUsuario) {
        
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByIdUsuario(idUsuario);

        iUsuarioRepository.delete(usuarioEntity);
        
    }

  

    
}
