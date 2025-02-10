package principal;

import empleados.CargoMedio;
import empleados.Empleado;
import input.Input;
import output.Output;
import validador.Validador;


public class Principal {

    private static final int AGREGAR= 1;
    private static final int MODIFICAR= 2;
    private static final int LISTAR= 3;
    private static final int ELIMINAR= 4;
    private static final int SALIR= 5;
    private static final int SUBORDINADO= 3;


    private static int opcionMenu;
    private static int tamañoListaEmp;
    private static int cantidadEmpleados;
    private static Empleado[] listaEmpleados;
    private static boolean usuarioQuiereSalir;
    //private static Scanner sc;
    private static  Output output;
    private static Input input;



    public static void main(String[] args) {
        output = new Output();
        input = new Input();
        cantidadEmpleados = cantidadEmpleados();
        listaEmpleados = new Empleado[cantidadEmpleados];
        usuarioQuiereSalir = false;
        tamañoListaEmp = listaEmpleados.length;
       // sc = new Scanner(System.in);


        do {
            boolean esValido;
            do {
                mostrarMenu();
                obtenerOpcionMenu();
                esValido= validarOpcionUsuario();
            }while (!esValido);

            if (opcionMenu==1){


            }

            ejecutarOpcionMenu(opcionMenu);

        }while (!usuarioQuiereSalir);

    }

    private static void mostrarMenu(){
        output.mostrarMenu();
    }

    private static void obtenerOpcionMenu(){

        opcionMenu = input.obtenerOpcionMenu();


    }

    private static boolean validarOpcionUsuario(){

        Validador datoValido = new Validador();
       boolean esValido = datoValido.validarOpcionMenu(opcionMenu);

        return esValido;
    }

    private static void ejecutarOpcionMenu(int opcionMenu){

        switch (opcionMenu){

            case AGREGAR -> {



                solicitarDatosempleado();

            }
            case MODIFICAR -> {
            modificarUsuario();

            }
            case LISTAR -> {


                for (int i = 0 ; i < tamañoListaEmp; i++){

                    if (listaEmpleados[i]== null){

                    }else {
                        output.mostrarEmpleado(listaEmpleados[i]);
                    }


                }
            }
            case ELIMINAR -> {
            eliminarUsuario();

            }
            case SALIR -> {
                usuarioQuiereSalir = true;
            }

        }

    }

    private static int cantidadEmpleados(){
        output.mostrarMensajecantidadEmpleados();
        cantidadEmpleados = input.obtenerInt();
        return cantidadEmpleados;
    }


    private static void solicitarDatosempleado(){


        for (int i = 0 ; i < tamañoListaEmp ; i++){


            if (i < SUBORDINADO){
                output.mostrarMensajeNombre(i+1);
                String nombre = input.obtenerString();
                output.mostrarMensajeEdad(i+1);
                int edad = input.obtenerInt();
                output.mostrarMensajeFecha(i+1);
                String fechaAlta = input.obtenerString();
                output.mostrarMensajeSalario(i+1);
                double salario = input.obtenerDouble();

                listaEmpleados[i] = new Empleado(nombre, edad , fechaAlta, salario);

                output.saltoDeLinea();
            }else {
                output.mostrarMensajeNombre(i+1);
                String nombre = input.obtenerString();
                output.mostrarMensajeEdad(i+1);
                int edad = input.obtenerInt();
                output.mostrarMensajeFecha(i+1);
                String fechaAlta = input.obtenerString();
                output.mostrarMensajeSalario(i+1);
                double salario = input.obtenerDouble();
                output.mostrarMensajeComision(i+1);
                int comision = input.obtenerInt();


                listaEmpleados[i] = new CargoMedio(nombre, edad , fechaAlta, salario,comision);

                output.saltoDeLinea();
            }

        }
    }

    private static void modificarUsuario(){
        for (int i = 0 ; i < tamañoListaEmp; i++){

            output.mostrarEmpleadoModificar((i+1),listaEmpleados[i].getNombreCompleto(),listaEmpleados[i].getSalario());
        }
        output.opcionModificarEmpleado();
        int opcion = input.obtenerInt();
        output.mostrarMensajeSalarioActualizado();
        double salarioActualizado = input.obtenerDouble();

        listaEmpleados[opcion-1].setSalario(salarioActualizado);
    }

    private static void eliminarUsuario(){
        for (int i = 0 ; i < tamañoListaEmp; i++){

            if (listaEmpleados[i]== null){

            }else {
                output.mostrarEmpleadoActualizar((i+1),listaEmpleados[i].getNombreCompleto());
            }


        }
        System.out.println("Elije el numero de usuario que deseas eliminar");
        int opcion = input.obtenerInt();
        listaEmpleados[opcion-1] = null;
    }


}
