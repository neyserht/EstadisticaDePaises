package neyser.estadisticadepaises;

public class Paises
{
    public String nombre;
    public Integer poblacion, area, pbi;

    public Paises(String nombre, Integer poblacion, Integer area, Integer pbi)
    {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.area = area;
        this.pbi = pbi;
    }
}
