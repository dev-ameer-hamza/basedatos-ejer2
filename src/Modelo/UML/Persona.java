package Modelo.UML;

public class Persona {
    private String nombre;
    private String dni;
    private String tel;
    private String empresa;

    public Persona(String nombre, String dni, String tel, String empresa) {
        this.nombre = nombre;
        this.dni = dni;
        this.tel = tel;
        this.empresa = empresa;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
