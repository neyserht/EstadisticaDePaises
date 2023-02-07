package neyser.estadisticadepaises;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label labelPais, labelPoblacion, labelArea, labelPbi;
    @FXML
    private TextField textFiel1;
    @FXML
    private ComboBox comboBoxPaises;
    @FXML
    private Button button1;
    ArrayList<Paises> paises = new ArrayList<>();
    @FXML
    protected void onF1()
    {
        limpiarTextField();
        // Obtener tipo de busqueda
        Integer indicador = comboBoxPaises.getSelectionModel().getSelectedIndex();

        // Obtener valor de busqueda
        String valor = textFiel1.getText();

        // Obtener posicion de busqueda
        Integer posicion = 99;

        System.out.println("Indicador: " + indicador);

        for (int i = 0; i < paises.size() ; i++) {
            switch (indicador){
                case 0:
                    if (paises.get(i).nombre.equalsIgnoreCase(valor)){
                        posicion = i;
                    }
                    break;
                case 1:
                    if (paises.get(i).poblacion==Integer.parseInt(valor)){
                        posicion = i;
                    }
                    break;
                case 2:
                    if (paises.get(i).area==Double.parseDouble(valor)){
                        posicion = i;
                    }
                    break;
                case 3:
                    if (paises.get(i).pbi==Double.parseDouble(valor)){
                        posicion = i;
                    }
                    break;
                default:


            }
            if (indicador==0){
                if (paises.get(i).nombre.equalsIgnoreCase(valor)){
                    posicion = i;
                    break;
                }
            }
        }

        // Imprimir resultados
        labelPais.setText("Pais: "+paises.get(posicion).nombre);
        labelPoblacion.setText("Población: "+paises.get(posicion).poblacion);
        labelArea.setText("Área: "+paises.get(posicion).area);
        labelPbi.setText("PBI: "+paises.get(posicion).pbi);
    }
    @FXML
    protected void initialize()
    {
        cargarPaises();
    }

    @FXML
    protected  void cargarPaises()
    {
        paises.add(new Paises("España",47351567,499603.0,27063.0));
        paises.add(new Paises("Alemania",83240525,349380.0,46208.0));
        paises.add(new Paises("Francia",67391582,547557.0,39030.0));
        paises.add(new Paises("Italia",59554023 ,297730.0,31714.0));
    }
    @FXML
    protected void limpiarTextField()
    {
        labelPais.setText("");
        labelPoblacion.setText("");
        labelArea.setText("");
        labelPbi.setText("");
    }
    protected boolean isNumeric(String numero)
    {
        boolean resultado = true;
        try {
            Double.parseDouble(numero);
        }
        catch (Exception e)
        {
            resultado = true;
        }
        return resultado;
    }

}