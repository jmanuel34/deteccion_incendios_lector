/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareas;

import java.util.List;
import model.Ficha;
import service.TemperaturasFactory;
import service.TemperaturasFicheroService;
import service.TemperaturasFicheroServiceImpl;
import service.TemperaturasService;

/**
 *
 * @author josemanuelmendez
 */
public class TareaDetector implements Runnable{

    @Override
    public void run() {
       
        List<Ficha> fichas = TemperaturasFactory.getTemperaturasFicheroService().recogerTemperaturas();
        TemperaturasFactory.getTemperaturasService().enviarFichas(fichas);
        
        
/*        
        PedidosService service2 = PedidosFactory.getPedidosService();
        pedidos.stream()
                .filter(p->!service2.existePedido(p))
                .forEach(p->service2.introducirPedido(p));
  */      
//        for(Ficha f: fichas) {
//            System.out.println("Ficha: "+f.getIdFicha());
//            System.out.println("Sensor: "+ f.getSensor());
//            System.out.println("Tempoeratura "+ f.getTemperatura());
//            System.out.println("Fecha y Hora: "+ f.getFechaHora());
//    }
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
// */
//package tareas;
//
//import escuchadores.NuevoPedidoListener;
//import java.util.List;
//import model.Pedido;
//import service.PedidosFactory;
//import service.PedidosService;
//import service.TiendaFicheroService;
//
///**
// *
// * @author Antonio
// */
//public class TareaTienda implements Runnable{
//    private String tienda;
//    private NuevoPedidoListener listener;
//
//    public TareaTienda(String tienda, NuevoPedidoListener listener) {
//        this.tienda = tienda;
//        this.listener = listener;
//    }
//    
//    
//    @Override
//    public void run() {
//        TiendaFicheroService service1 = PedidosFactory.getTiendaFicheroService(tienda);
//        List<Pedido> pedidos = service1.recogerPedido();
//        
//        PedidosService service2 = PedidosFactory.getPedidosService();
//        long res = pedidos.stream()
//                    .filter(p->!service2.existePedido(p))
//                    .peek(p->service2.introducirPedido(p))
//                    .count();
//        if (res>0)listener.nuevoPedido();
//                    
//                
//        //pedidos.forEach(p->service2.introducirPedido(p));
//        
//    }
//
//}