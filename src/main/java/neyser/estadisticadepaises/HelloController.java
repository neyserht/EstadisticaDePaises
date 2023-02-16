package neyser.estadisticadepaises;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label labelMensaje, labelPais, labelPoblacion, labelArea, labelPbi;
    @FXML
    private TextField textFiel1;
    @FXML
    private ComboBox comboBoxPaises;
    @FXML
    private Button button1;
    String mensaje = "";
    ArrayList<Paises> paises = new ArrayList<>();

    @FXML
    protected void onF1()
    {
        limpiarLabel();
        // Obtener tipo de busqueda
        Integer indicador = comboBoxPaises.getSelectionModel().getSelectedIndex();

        // Obtener valor de busqueda
        String valor = textFiel1.getText();

        // Obtener posicion de busqueda
        Integer posicion = 99;

        // System.out.println("Indicador: " + indicador);
        // System.out.println("Valor: " + valor);

        for (int i = 0; i < paises.size() ; i++) {
            switch (indicador){
                case 0:
                    if (paises.get(i).nombre.equalsIgnoreCase(valor)){
                        posicion = i;

                    } else { mensaje = "País no encontrado"; }
                    break;
                case 1:
                    if (isNumeric(valor)) {
                        if (paises.get(i).poblacion==Integer.parseInt(valor)){
                            posicion = i;
                        } else { mensaje = "Población no encontrado"; }
                    } else {
                        mensaje = "Formato de Población incorrecto";
                    }
                    break;
                case 2:
                    if (isNumeric(valor)) {
                        if (paises.get(i).area==Integer.parseInt(valor)){
                            posicion = i;
                        } else { mensaje = "Área no encontrada"; }
                    } else {
                        mensaje = "Formato de Área incorrecto";
                    }
                    break;
                case 3:
                    if (isNumeric(valor)) {
                        if (paises.get(i).pbi==Integer.parseInt(valor)){
                            posicion = i;
                        } else { mensaje = "PBI no encontrado"; }
                    } else {
                        mensaje = "Formato de PBI incorrecto";
                    }
                    break;
                default:
                    mensaje = "Error: Debe Seleccionar una opción válida";
            }
            // System.out.println("Posicion: " + posicion);
        }

        if (posicion==99){
            labelMensaje.setText(mensaje);
            labelMensaje.setBackground(Background.fill(Color.web("#ff0000")));
            limpiarLabel();
        }
        else
        {
            // Imprimir resultados
            labelMensaje.setText("");
            labelPais.setText("Pais: "+paises.get(posicion).nombre);
            labelPoblacion.setText("Población: "+paises.get(posicion).poblacion + " personas");
            labelArea.setText("Área: "+paises.get(posicion).area + " km^2");
            labelPbi.setText("PBI: US$ "+paises.get(posicion).pbi);
        }
        textFiel1.clear();
    }

    protected boolean isNumeric(String texto)
    {
        Boolean respuesta = true;

        try
        {
            Double.parseDouble(texto);
        } catch (Exception e)
        {
            respuesta = false;
        }

        return respuesta;
    }

    @FXML
    protected void initialize()
    {
        cargarPaises();
    }

    @FXML
    protected  void cargarPaises()
    {
        paises.add(new Paises("España",47351567,499603,27063));
        paises.add(new Paises("Alemania",83240525,349380,46208));
        paises.add(new Paises("Francia",67391582,547557,39030));
        paises.add(new Paises("Italia",59554023 ,297730,31714));
    }
    @FXML
    protected void limpiarLabel()
    {
        labelPais.setText("");
        labelPoblacion.setText("");
        labelArea.setText("");
        labelPbi.setText("");
    }

}