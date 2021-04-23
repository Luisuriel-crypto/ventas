package com.example.ventas;

import me.tell.ventas.EliminarVentaRequest;
import me.tell.ventas.EliminarVentaResponse;
import me.tell.ventas.ModificarVentaRequest;
import me.tell.ventas.ModificarVentaResponse;
import me.tell.ventas.MostrarVentaResponse;
import me.tell.ventas.RealizarVentaRequest;
import me.tell.ventas.RealizarVentaResponse;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VentasEndPoint {

  @Autowired
  private Iventas iventas;

  @PayloadRoot(namespace = "http://tell.me/ventas", localPart = "RealizarVentaRequest")

  @ResponsePayload
  public RealizarVentaResponse guardaVenta(@RequestPayload RealizarVentaRequest peticion) {

    RealizarVentaResponse respuesta = new RealizarVentaResponse();
    respuesta.setRespuesta("Venta Realizada " + peticion.getNombre());

    Productos productos = new Productos();
    productos.setNombre(peticion.getNombre());
    productos.setDescripcion(peticion.getDescripcion());
    productos.setPrecio(peticion.getPrecio());
    productos.setStock(peticion.getStock());
    iventas.save(productos);

    return respuesta;
  }

  

@PayloadRoot(namespace = "http://tell.me/ventas", localPart = "ModificarVentaRequest")



  @PayloadRoot(namespace = "http://tell.me/ventas",localPart = "EliminarVentaRequest")

  @ResponsePayload
  public EliminarVentaResponse borrarVenta(
    @RequestPayload EliminarVentaRequest peticion) {
    EliminarVentaResponse respuesta = new EliminarVentaResponse();
    respuesta.setRespuesta("Eliminado correctamente el id " + peticion.getId());
    //validad que no existe
    iventas.deleteById(peticion.getId());
    return respuesta;
  }
  
  
  }