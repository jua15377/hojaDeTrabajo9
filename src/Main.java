/**
 * Created by Eric on 15/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        String tipoMapa = "";

        Map<String, Association<String, String>> diccionario = MapFactory.getMap(tipoMapa);
        assert diccionario != null;
        //diccionario.put("run", new Association<String, String>("run", "correr"));
    }
}
