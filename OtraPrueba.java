/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasvarias;

/**
 *
 * @author Fitec
 */
public class OtraPrueba {

    public static void main(String[] args) {

        String sTexto = ""
                + "<documento>"
                + "<id>1</id>"
                + "<nombre>retención en la fuente &</nombre>"
                + "<tipo>contabilidad</tipo>"
                + "</documento>"
                
                + "<documento>"
                + "<id>2</id>"
                + "<nombre>requerimiento <</nombre>"
                + "<tipo>sistemas</tipo>"
                + "</documento>"
                
                + "<documento>"
                + "<id>3</id>"
                + "<nombre>contrato /</nombre>"
                + "<tipo>recursos humano</tipo>"
                + "</documento>"
                + "";
        System.out.println(convierteQuitardoCaracteres(sTexto, "nombre"));

        /*
        Esto imprime
        
        <documento><id>1</id><nombre>retención en la fuente y</nombre><tipo>contabilidad</tipo></documento>
        <documento><id>2</id><nombre>requerimiento </nombre><tipo>sistemas</tipo></documento>
        <documento><id>3</id><nombre>contrato </nombre><tipo>recursos humano</tipo></documento>
        
              
        
        
        */

    }

    public static String convierteQuitardoCaracteres(String cadena, String tag) {

        int index = cadena.indexOf("<"+tag+">");
        int fin = cadena.indexOf("</"+tag+">");
               
        
        // Busca cada coincidencia del tag con indexOf para el incio y fin del tag
        // Obtiene el texto de ello y luego rremplaza caracteres
        // Despues concatena el texto corregido a la cadena originar con substring
        // Despues busca la siguiente coinidencia apartir del tag encontrado, 
        // para que no se quede siempre en el primero
        
        // pero esto es mucho trabajo... El tipo que le envia eso debería hacerlo, pero bueno
        
        while (index >= 0) {
              
            String texto = cadena.substring(index + tag.length() + 2, fin);

            //reemplaza todos los caractéres que necesite
            texto = texto.replaceAll("&", "y");
            texto = texto.replaceAll("<", "");
            texto = texto.replaceAll("/", "");

            cadena = cadena.substring(0, index + tag.length() + 2) + texto + cadena.substring(fin, cadena.length());

            index = cadena.indexOf("<"+tag+">", index + 1);
            fin = cadena.indexOf("</"+tag+">", fin + 1);

        }
        return cadena;
    }

    /*
        Este método ya paila toca el de arriba
    */
    
//    public static String convierteCData(String cadena, String tag) {
//
//        int inicio = cadena.indexOf("<" + tag + ">") + tag.length() + 2;
//        int fin = cadena.indexOf("</" + tag + ">");
//        String texto = cadena.substring(inicio, fin);
//
//        //hago un CData al contenido del tag
//        texto = "<![CDATA[" + texto + "]]>";
//
//        String nuevaCadena = cadena.substring(0, inicio) + texto + cadena.substring(fin, cadena.length());
//
//        return nuevaCadena;
//    }

}
