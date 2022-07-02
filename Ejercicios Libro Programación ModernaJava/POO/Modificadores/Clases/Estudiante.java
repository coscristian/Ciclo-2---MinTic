public class Estudiante {
    private final String codigo;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;

    public Estudiante(String cod, String nomb, String ape, String fechNac){
        codigo = cod;
        nombre = nomb;
        apellidos = ape;
        fechaNacimiento = fechNac;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String muestraDatos(){
        return "\nCodigo: \t" + codigo + "\nNombre: \t" + nombre + "\nApellidos: \t" + apellidos + "\nFecha Nac: \t" + fechaNacimiento;
    }
}
