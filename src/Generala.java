import java.util.List;
import java.util.Scanner;

public class Generala {
        int min=11111;
        int max=66666;
        int tirada;//
        int [] arrayContador = new int[5];
        char [] arrayTirada = new char[5];
        char caracter;
        String jugadas(String dados){
            if(esNumero(dados)){
                tirada = Integer.parseInt(dados);
                //veo si la tirada está dentro del rango
                if (!(dados.contains("7") || dados.contains("8") || dados.contains("9") || dados.contains("0"))){
                    //inicializo mi array contador
                    inicializarArray(arrayContador,arrayContador.length);
                    //convierto mi String dados en un array
                    arrayTirada = dados.toCharArray();
                    //recorro mi array con los caracteres para poder contarlos
                    for (int i=0; i<arrayTirada.length; i++){
                        caracter = arrayTirada[i];
                        for (int j=0; j<arrayTirada.length; j++){
                            if(caracter==arrayTirada[j]){
                                arrayContador[i]++;
                            }
                        }
                    }
                    //recorro mi array contador para poder ver la cantidad de veces que se repiten las tiradas
                    int bandera = 0;//uso para verificar escaleras
                    for (int i = 0; i<arrayContador.length; i++){
                        //Si un numero se repite 5 veces es Generala
                        if (arrayContador[i]==5){
                            return "GENERALA";
                        }else if(arrayContador[i]==4){//Póker
                            return "PÓKER";
                        }else if(arrayContador[i]==3 || arrayContador[i]==2){
                            if (arrayContador[i]==3){
                                for (int j=0; j<arrayContador.length; j++){
                                    if (arrayContador[j]==2){
                                        return "FULL";
                                    }
                                }
                            }
                            if (arrayContador[i]==2){
                                for (int j=0; j<arrayContador.length; j++){
                                    if (arrayContador[j]==3){
                                        return "FULL";
                                    }
                                }
                            }
                        }else{
                            for (int j=0; j<arrayTirada.length-1; j++){
                                if(Character.getNumericValue(arrayTirada[j])+1 == Character.getNumericValue(arrayTirada[j+1]) ){
                                    bandera++;
                                }else if ((arrayTirada[j]=='6' && arrayTirada[j+1]=='1') && arrayTirada[0] == '3'){
                                    bandera++;
                                }
                            }
                            if(bandera==4){
                                return "ESCALERA";
                            }else {
                                return "NADA";
                            }
                        }
                    }

                }else {
                    return "Invalido";
                }
        }
        return "nada";
    }
    //Método para general numero aleatorio
    public String generarNumero() {
        double nroAleatorio = 11111 + Math.random() * 66666;
        int nro = (int) nroAleatorio;
        return String.valueOf(nro);
    }
    /*inicializo un array*/
    public static void inicializarArray(int[] array, int n){
        for(int i = 0; i<n; i++){
            array[i]=0;
        }
    }
    /*esNumero - Me permite saber si el texto es un número*/
    public static boolean esNumero(String dados) {
        try {
            Integer.parseInt(dados);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
    public static void main(String[] args) throws Exception{
        Generala g = new Generala();
        //System.out.println(g.jugadas("45612"));
        String jugada = g.generarNumero();
        System.out.println("La tirada: "+jugada+" es: "+ g.jugadas(jugada));
    }

}
