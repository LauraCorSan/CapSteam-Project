package com.capgemini.capsteam.repository;

import java.text.SimpleDateFormat;

import com.capgemini.capsteam.model.Game;

public class GameDaoImpl implements GameDao{
@Override 
public boolean saveGame(Game game) {
	 try {
         // Si cualquier valor del juego es igual a null significa que esta vacio por 
		 //consiguiente te va decir que los valores son nulos
         if (game.getName() == null && game.getName().isEmpty() &&
             game.getDeveloper() == null || game.getDeveloper().isEmpty() ||
             game.getReleaseDate() == null) { 
             System.out.println("Todos los parámetros deben tener un valor.");
             return false;
         }

         // Aqui revisamos si lo datos que introdujo en los años son correctos
         if (!isNumeric(game.getReleaseYear())) {
             System.out.println("El dato de los años son incorrectos.");
             return false;
         }
         //Aquí creamos un metodo en el cual analiza el campo de ventas de NorteAmérica
         //Japón y el mundo
         if (!isDecimal(game.getNaSales()) || !isDecimal(game.getEuSales()) ||
                 !isDecimal(game.getJpSales()) || !isDecimal(game.getOtherSales()) ||
                 !isDecimal(game.getGlobalSales())) {
                 System.out.println("Hay un campo en ventas que  tiene un valor incorrecto reviselo por favor.");
                 return false;
             }
         //Aquí metemos los datos en la base de datos
         System.out.println("Guardando el juego: " + game.getName());
         // Simular guardado en la BBDD, suponiendo éxito.
         return true;

     } catch (Exception e) {
         e.printStackTrace();
         return false;
     }
	 //Aqui comprobamos si es un número
	 private boolean isNumeric(String str) {
	        try {
	            Integer.parseInt(str); 
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }

	    //Aqui comprobamos si es un decimal
	    private boolean isDecimal(String str) {
	        try {
	            Double.parseDouble(str); 
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
}
