/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bernardo Rychtenberg
 */

 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Principal {
    
    public static void main(String[] args){

        IManejadorArchivosGenerico ManejadorArchivos = new ManejadorArchivosGenerico();
        Lista<Afiliado> listaAfiliados = new Lista<>();
        
        // 1) Instanciar y cargar los afiliados a un árbol de afiliados desde padron.txt. 
        String[] lineasPadron = ManejadorArchivos.leerArchivo("padron.txt");
        for (String linea : lineasPadron) {
            String[] lineaSplit = linea.split(",");
            Afiliado afiliado = new Afiliado(Integer.parseInt(lineaSplit[0]), lineaSplit[1], lineaSplit[2]);
            Nodo<Afiliado> nodoNuevo = new Nodo(afiliado.getCedula(), afiliado);
            listaAfiliados.insertar(nodoNuevo);
        }
        
        // 2) Instanciar y cargar las consultas a partir de los archivos historicos.txt y agendadas.txt
        String[] lineasAgendadas = ManejadorArchivos.leerArchivo("agendadas.txt");
        for (String linea : lineasAgendadas) {
            String[] lineaSplit = linea.split(",");
            Consulta consultaAux = new Consulta(lineaSplit[1], lineaSplit[2], Integer.parseInt(lineaSplit[3]), Integer.parseInt(lineaSplit[4]));
            Nodo<Afiliado> nodoAfiliado = listaAfiliados.buscar(Integer.parseInt(lineaSplit[0]));
            if (nodoAfiliado != null) { 
                nodoAfiliado.getDato().cargarConsultaPendiente(consultaAux);
            }
        }
        String[] lineasHistoricas = ManejadorArchivos.leerArchivo("historicas.txt");
        for (String linea : lineasHistoricas) {
            String[] lineaSplit = linea.split(",");
            Consulta consultaAux = new Consulta(lineaSplit[1], lineaSplit[2], Integer.parseInt(lineaSplit[3]), Integer.parseInt(lineaSplit[4]));
            Nodo<Afiliado> nodoAfiliado = listaAfiliados.buscar(Integer.parseInt(lineaSplit[0]));
            if (nodoAfiliado != null) { 
                nodoAfiliado.getDato().cargarConsultaHistorica(consultaAux);
            }
        }

        // 3) Aplicar el método de carga de afiliados a partir de una lista (invocando el método cargarDesdeLista)
        //TArbolPadronAfiliados padrones = new TArbolPadronAfiliados();
        //System.out.println(padrones.cargarDesdeLista(listaAfiliados).inOrden()+"\n");
        TArbolPadronAfiliados padron = new TArbolPadronAfiliados();
        TArbolPadronAfiliados arbolAfiliados = padron.cargarDesdeLista(listaAfiliados);
        System.out.println("Arbol de afiliados cargado desde lista:\n"+arbolAfiliados.inOrden()+"\n");

        // 4) Aplicar el método obtenerConsultasDelDia para obtener las consultas del día de la fecha. 
        String fecha = "20190903";
        TArbolBB<Afiliado> consultasDelDia = arbolAfiliados.obtenerConsultasDelDia(fecha);
        System.out.println("Consultas del día de la fecha dada:\n"+consultasDelDia.inOrden()+"\n");
        Lista<Afiliado> listaDescarga = consultasDelDia.inorden();
        Nodo<Afiliado> nodoActual = listaDescarga.getPrimero();
        while (nodoActual != null) { 
            String[] arregloLineas = new String[1];
            arregloLineas[0] =  Integer.toString(nodoActual.getDato().getCedula());
            ManejadorArchivos.escribirArchivo("AfiliadosConsultasDelDia.txt", arregloLineas);
            nodoActual = nodoActual.getSiguiente();
        }
        
        // 5) Obtener la cantidad de consultas en el día.
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        if(arbolAfiliados.cantidadConsultasdelDia() == 0){
            System.out.println("No hay consultas para el dia de hoy " + dtf2.format(LocalDateTime.now()));
        }else{
            System.out.println("Hay " + arbolAfiliados.cantidadConsultasdelDia() + " consultas para el dia de hoy " + dtf2.format(LocalDateTime.now()));
        }


    }
    
}
