package Integracion.Ventas;

public class Ventas {
    private Integer id; 
    private String nombre;
    private String descripcion; 
    private Integer precio; 
    private Integer stock; 
    
    private Integer getId(){
        return id; 
    }

    private String getNombre(){ 
        return nombre; 
    }

    private String getDescripcion(){
        return descripcion; 
    }

    private Integer getPrecion(){
        return precio; 
    }

    private Integer getStock(){
        return stock; 
    }

    public void setId(Integer id){
        this.id = id; 
    }

    public void setNombre(String nombre){
        this.nombre = nombre; 
    }

    public void setDescripcion(String descripcion){ 
        this.descripcion = descripcion; 
    }

    public void setPrecio(Integer precio){
        this.precio = precio; 
    }

    public void setStock(Integer stock){ 
        this.stock = stock; 
    }

}

