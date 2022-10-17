package UNAB.APIquintoE.security;

public class ConstantesSecurity {

    public static final String SINGUP_URL="/login";//url que se usara para el login *no se uso*
    public static final String HEADER_STRING="Authorization";//string del header
    public static final String TOKEN_PREFIJO="Bearer ";//palabra estandar para saber donde esta el token
    //token generado con io.jsonwebtoken.security.Keys
    public static final String TOKEN_SECRETO="PlPywmQnZNttmYssVIMI7xOcpq795YOZxvk/An/zJ9FrbM8uAo3KgWhM7y8K0dLP7Ikvy57AoalH5cWqD++3xA==";
    public static final long FECHA_EXPIRACION= 57600000;//tiempo en ms para la expiracion del token 16 horas
}
