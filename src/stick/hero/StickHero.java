/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stick.hero;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
        
public class StickHero extends Application {
   int y = 0;
   int yb= 150;
    @Override
    public void start(Stage primaryStage) {
        /* CREACIÓN DE LA VENTANA Y DE LOS CONTENEDORES PRINCIPALES */
        
        // Contenedor principal donde se alojarán todos los elementos
        Group root = new Group();  
        // Creación de una zona de dibujo (canvas) de 200 x 150 puntos
        Canvas canvas = new Canvas(120, 150);
        Canvas canvaspalo = new Canvas(200, 200);
        // Obtención del contexto gráfico del canvas anterior que permitirá
        //  realizar posteriormente los dibujos
        GraphicsContext gc = canvas.getGraphicsContext2D();
         GraphicsContext gcpalo = canvaspalo.getGraphicsContext2D();
        // Se añade el canvas al contenedor principal (root)
        root.getChildren().add(canvas);
        root.getChildren().add(canvaspalo);
        // Creación del área (scene) correspondiente al contenido que tendrá la 
        //  ventana, de 600 x 400 puntos, con color gris claro, indicando que el
        //  elemento root va a ser el contenedor principal de este espacio
        Scene scene = new Scene(root, 600, 400, Color.LIGHTGRAY);
        // Se asocia la ventana (scene) al parámetro primaryStage (escenario
        //  principal). El parámetro primaryStage se recibe en este método start
        primaryStage.setScene(scene);
        // Título que se aparecerá en la ventana
        primaryStage.setTitle("Dibujando formas con JavaFX");
        // Orden para que se muestre la ventana        
        primaryStage.show();

        /* DIBUJO DE LAS FORMAS */
        
        /* Se utiliza el objeto gc (GraphicsContext) que se ha obtenido
            anteriormente a partir del canvas de se ha creado */
        
        // Dibujo de un rectángulo vacío (strokeRect) que va a ocupar todo
        //  el espacio del canvas
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.GREEN);
        gc.fillRoundRect(40, 40, 40, 70, 25, 25);
        //Para hacer el ojo
        gc.setFill(Color.WHITE);
        gc.fillOval(60, 50, 15, 15);
         gc.setFill(Color.BLACK);
        gc.fillOval(65, 57, 5, 5);
        //Para hacer la cinta que rodea la cabeza
        gc.setFill(Color.BLUE);
        gc.fillRoundRect(40, 50, 40, 10, 0, 0);
        //Haremos dos rectangulos para acer las piernas
        gc.setFill(Color.GREEN);
        gc.fillRoundRect(45, 100, 10, 25, 15, 15);
        gc.fillRoundRect(65, 100, 10, 25, 15, 15);
        //Haremos unos pantalones
        gc.setFill(Color.BLUE);
        gc.fillRoundRect(45, 100, 10, 15, 0, 0);
        gc.fillRoundRect(65, 100, 10, 15, 0, 0);
        gc.fillRoundRect(40, 85, 40, 25, 25, 25);
        gc.fillRoundRect(40, 85, 40, 10, 0, 0);
        // Hacer una linea para el brazo
        gc.setLineWidth(10);
        gc.setStroke(Color.GREEN);
        gc.strokeLine(40, 75, 30, 80);
        gc.setFill(Color.GREEN);
        gc.fillOval(20, 77, 10, 10);
    
        //Boca
        gc.setFill(Color.WHITE);
        gc.fillRoundRect(61, 70, 20, 5, 5, 5);
         gc.setFill(Color.GREEN);
         gc.fillPolygon( new double[]{30.0,40.0,50.0},
                        new double[]{30.0,50.0,40.0},3);
         //primer triangulo
         gc.fillPolygon( new double[]{35.0,45.0,55.0},
                        new double[]{30.0,50.0,40.0},3);
         //segundo triangulo
         gc.fillPolygon( new double[]{40.0,50.0,60.0},
                        new double[]{30.0,40.0,40.0},3);
         //tercero triangulo
         gc.fillPolygon( new double[]{45.0,55.0,65.0},
                        new double[]{30.0,40.0,40.0},3);
         //tercero triangulo
         gc.fillPolygon( new double[]{50.0,60.0,70.0},
                        new double[]{30.0,40.0,40.0},3);
         //cuarto triangulo
         gc.fillPolygon( new double[]{55.0,65.0,74.0},
                        new double[]{45.0,40.0,40.0},3);
         //Quinto triangulo
         gc.fillPolygon( new double[]{70.0,65.0,74.0},
                        new double[]{45.0,50.0,45.0},3);
        //dibujar dientes verticales
        gc.setLineWidth(1);
        gc.setStroke(Color.BLACK);
        gc.strokeLine(60, 70, 60, 75);
        gc.strokeLine(64, 70, 64, 75);
        gc.strokeLine(68, 70, 68, 75);
        gc.strokeLine(72, 70, 72, 75);
        gc.strokeLine(76, 70, 76, 75);
        gc.strokeLine(80, 70, 80, 75); 
        //dibujar dientes horizontales
        gc.setLineWidth(1);
        gc.setStroke(Color.BLACK);
        gc.strokeLine(80, 72, 60, 72);
       
        
        AnimationTimer animationTimer = new AnimationTimer() {
    public void handle(long now) {
       // Escribe aquí el código que deseas ejecutar repetidamente
       gcpalo.setFill(Color.BROWN);
       gcpalo.fillRoundRect(130, yb--, 10, y++, 0, 0); // yb va restando de uno en uno y la variable uno le suma uno
    }
};
        
  // Detectar ratón pulsado
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                // Insertar aquí el código a ejecutar cuando se pulse el ratón
                animationTimer.start();
            }
        });
    //Detectar raton soltado
       scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                // Insertar aquí el código a ejecutar cuando se suelte el ratón
               animationTimer.stop();
            }
    });
}
}

