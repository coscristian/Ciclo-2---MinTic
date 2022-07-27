import javax.swing.JOptionPane;

public class PruebaEmpleado {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[2];

        for(int i = 0; i < 2; i++){
            String nombre,
                    apellido;
            Double salarioMensual;
            try {
                nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado");
                apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del empleado");
                salarioMensual = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario mensual del empleado"));
    
                Empleado e1 = new Empleado(nombre, apellido, salarioMensual);
                empleados[i] = e1;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e);
            }
        }
    }
}
