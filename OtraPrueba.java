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
        // Texto
        String sTexto = "<id>2</id><nombre>Juanito&</nombre><otro>texto</otro>";
        
        System.out.println(convierteQuitardoCaracteres(sTexto, "nombre"));
        
        System.out.println(convierteCData(sTexto, "nombre"));
        
    }

    public static String convierteQuitardoCaracteres(String cadena, String tag) {
        
        
        int inicio = cadena.indexOf("<"+tag+">")+tag.length()+2;
        int fin = cadena.indexOf("</"+tag+">");
        String texto = cadena.substring(inicio, fin);
        
        //reemplaza todos los caractéres que necesite
        texto = texto.replaceAll("&", "y");
        
        String nuevaCadena = cadena.substring(0, inicio)+texto+cadena.substring(fin,cadena.length());
        
        return nuevaCadena;
    }
    
    public static String convierteCData(String cadena, String tag) {
        
        
        int inicio = cadena.indexOf("<"+tag+">")+tag.length()+2;
        int fin = cadena.indexOf("</"+tag+">");
        String texto = cadena.substring(inicio, fin);
        
        //hago un CData al contenido del tag
        texto = "<![CDATA["+texto+"]]>";
        
        String nuevaCadena = cadena.substring(0, inicio)+texto+cadena.substring(fin,cadena.length());
        
        return nuevaCadena;
    }
}
