

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

public class TArbolPadronAfiliados extends TArbolBB<Afiliado> implements IArbolPadronAfiliados {

    @Override
    public TArbolPadronAfiliados cargarDesdeLista(Lista<Afiliado> listaAfiliados) {
        TArbolPadronAfiliados resultado = new TArbolPadronAfiliados();
        Nodo<Afiliado> afiliadoNuevo = listaAfiliados.getPrimero();
        while (afiliadoNuevo != null) {
            Afiliado afiliadoAux = afiliadoNuevo.getDato();
            TElementoAB<Afiliado> elementoNuevo = new TElementoAB(afiliadoAux.getCedula(), afiliadoAux);
            resultado.insertar(elementoNuevo);
            afiliadoNuevo = afiliadoNuevo.getSiguiente();
        }
        return resultado;
    }
    
    @Override
    public TArbolBB<Afiliado> obtenerConsultasDelDia(String fecha) {
        TArbolBB<Afiliado> resultado = new TArbolBB<>();
        Lista<Afiliado> listaAfiliados = this.inorden();
        if (!listaAfiliados.esVacia()) {
            Nodo<Afiliado> nodoAfiliado = listaAfiliados.getPrimero();
            while (nodoAfiliado != null) { 
                Afiliado afiliadoAux = nodoAfiliado.getDato();
                if ( !afiliadoAux.pendientes.esVacia()) {
                    Nodo<Consulta> nodoConsulta = afiliadoAux.pendientes.getPrimero();
                    while (nodoConsulta != null) {
                        Consulta consultaAux = nodoConsulta.getDato();
                        if (consultaAux.getFecha().equals(fecha)) {
                            TElementoAB<Afiliado> afiAux = new TElementoAB(afiliadoAux.getCedula(), afiliadoAux);
                            resultado.insertar(afiAux);
                        }
                        nodoConsulta = nodoConsulta.getSiguiente();
                    }
                }
                nodoAfiliado = nodoAfiliado.getSiguiente();
            }
        }
        return resultado;
    }

    
    @Override
    public Integer cantidadConsultasdelDia(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        TArbolBB<Afiliado> consultasDelDia = this.obtenerConsultasDelDia(dtf.format(LocalDateTime.now()));   
        Lista<Afiliado> listaAfiliadosConConsulta = consultasDelDia.inorden();
        try {
            return listaAfiliadosConConsulta.cantElementos();   
        } catch (Exception e) {
            return 0;
        }
    }
} 
    

