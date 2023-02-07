package neyser.estadisticadepaises;

public class Paises
{
    public String nombre;
    public Integer poblacion;
    public Double area, pbi;

    public Paises(String nombre, Integer poblacion, Double area, Double pbi)
    {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.area = area;
        this.pbi = pbi;
    }
}
