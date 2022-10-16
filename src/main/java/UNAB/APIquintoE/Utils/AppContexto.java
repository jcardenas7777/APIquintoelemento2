package UNAB.APIquintoE.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContexto implements ApplicationContextAware{
    //maneja el contexto de los objetos o beans
    private static ApplicationContext contexto;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // traer el contexto de los bean
        contexto = applicationContext;
    } 

    public static Object getBean (String nombre){
        //obtener el contexto por fuera es estatico para no instanciarlo
        return contexto.getBean(nombre);

    }
    
}
