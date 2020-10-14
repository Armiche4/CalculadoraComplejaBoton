

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.When;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.css.converter.StringConverter;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class calculadora extends Application  {
	
		
    private TextField resul1Text, resul2Text,dtext,ctext,btext,atext;	
	private Label etiqueta,etiquetamas,etiquetai,etiquetamas1,etiquetai1,etiquetamas2,etiquetai2;
	private ComboBox combo;

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		resul1Text = new TextField("0");		
		resul1Text.setPrefColumnCount(7);
		resul1Text.setEditable(false);
		
		resul2Text = new TextField("0");
		resul2Text.setPrefColumnCount(7);
		resul2Text.setEditable(false);
		
		atext = new TextField("0");
		atext.setPrefColumnCount(7);
		
		btext = new TextField("0");		
		btext.setPrefColumnCount(7);
		
		ctext = new TextField("0");		
		ctext.setPrefColumnCount(7);
		
		dtext = new TextField("0");		
		dtext.setPrefColumnCount(7);
		

		etiquetamas = new Label();
		etiquetamas.setText("+");
		
		etiquetai= new Label();
		etiquetai.setText("i");
		
		
		etiquetamas1 = new Label();
		etiquetamas1.setText("+");
		
		etiquetai1= new Label();
		etiquetai1.setText("i");
		

		etiquetamas2 = new Label();
		etiquetamas2.setText("+");
		
		etiquetai2= new Label();
		etiquetai2.setText("i");
		
		etiqueta = new Label();
		etiqueta.setText("Opera");

					
			
		 HBox ahbox = new HBox(8);
		 ahbox.setAlignment(Pos.BASELINE_CENTER);
		 ahbox.setSpacing(7);
		 ahbox.getChildren().addAll(atext,etiquetamas,btext,etiquetai);
		 
		 
		 
		 
		 
		 HBox chbox = new HBox(8);
		 chbox.setAlignment(Pos.BASELINE_CENTER);
		 chbox.setSpacing(7);
		 chbox.getChildren().addAll(ctext,etiquetamas1,dtext,etiquetai1);
		 
		 
		
		 
		 HBox resulhbox = new HBox(8);
		 resulhbox.setAlignment(Pos.BASELINE_CENTER);
		 resulhbox.setSpacing(7);
		 resulhbox.getChildren().addAll(resul1Text,etiquetamas2,resul2Text,etiquetai2);
		 

		 combo = new ComboBox();
			combo.getItems().addAll("+","-","*","/");
	
		combo.getSelectionModel().select("+");
			combo.setTranslateX(-10);
			
				
					

					
			Button resultado = new Button();
			resultado.setText("=");
			resultado.setOnAction(e -> onOperacion(e));
			resultado.setDefaultButton(true);
			resultado.setTranslateX(10);
		
			 Separator separator = new Separator(Orientation.HORIZONTAL);
			
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(etiqueta,ahbox,chbox,separator,resulhbox);
		
		
		VBox operador = new VBox();
		operador.setSpacing(5);
		operador.setAlignment(Pos.CENTER);
		operador.getChildren().addAll(combo);
		
		VBox boton = new VBox();
		boton.setSpacing(5);
		boton.setAlignment(Pos.CENTER);
		boton.getChildren().addAll(resultado);
		
		
		
		HBox panel =new HBox();
		panel.getChildren().addAll(operador,root,resultado);
		panel.setAlignment(Pos.CENTER);

		Scene escena = new Scene(panel, 350, 250);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Calcuadora Compleja");
		primaryStage.show();
	}
	
	private void onOperacion(ActionEvent e) {
		
		try {
		Double cantidadA = Double.parseDouble(atext.getText());
		Double cantidadB = Double.parseDouble(btext.getText());
		Double cantidadC = Double.parseDouble(ctext.getText());
		Double cantidadD = Double.parseDouble(dtext.getText());
		
		Double resultado1=0.0,resultado2=0.0;
		
	
				
		Object operacion  =combo.getValue();
	
		
		if(operacion.equals("+")) {
			resultado1=cantidadA+cantidadC;
			resultado2=cantidadB+cantidadD;
			
		}
		
		if(operacion.equals("-")) {
			resultado1=cantidadA-cantidadC;
			resultado2=cantidadB-cantidadD;
		}
		
		if(operacion.equals("*")) {
			resultado1=(cantidadA*cantidadC)-(cantidadB*cantidadD);
			resultado2=(cantidadA*cantidadD)+(cantidadB*cantidadC);
		}
		if(operacion.equals("/")) {
			resultado1=((cantidadA*cantidadC)+(cantidadB*cantidadD))/((cantidadC*cantidadC)+(cantidadD*cantidadD));
			resultado2=(-(cantidadA*cantidadD)+(cantidadB*cantidadC))/((cantidadC*cantidadC)+(cantidadD*cantidadD));
			
		}
	
			

		resul1Text.setText( resultado1 +"" );
		resul2Text.setText( resultado2 +"" );
		}
		catch(Exception err) {
			Alert alert3 = new Alert(AlertType.ERROR);
			alert3.setTitle("Calculadora");
			alert3.setHeaderText("ERROR");
			alert3.setContentText("No pongas letras amigo");
			alert3.showAndWait();
		}
		
		
	}

	

	public static void main(String[] args) {
		launch(args);
	}

	
	
	
	
	
	
	
}