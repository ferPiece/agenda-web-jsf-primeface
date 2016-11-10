/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Contacto;
/**
 *
 * @author lopez
 */
@ManagedBean
@SessionScoped
public class ContactoBean implements Serializable {

    private static final long serialVersionUID = 455659950717243338L;
    private Contacto contacto = new Contacto();
    private List<Contacto> contactos = new ArrayList<Contacto>();
    
    public ContactoBean() {
        //cargar lista de contactos
        //falta implementar
    }
    
    public void agregarContacto(){
        //falta implementar
        contactos.add(contacto);
        showMessage("Contacto " + contacto.getNombre() + " agregado con exito!");
    }
    
    public void eliminarContacto(){
        //falta implementar
        contactos.remove(contacto);
        showMessage("Contacto " + contacto.getNombre() + " eliminado con exito!");
    }
    
    public void modificarContacto(){
        //falta implementar
        
        showMessage("Contacto " + contacto.getNombre() + " modificado con exito!");
    }
    
    public void limpiar(){
        this.contacto = new Contacto();
    }
    
    private void showMessage(String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage(mensaje));  
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    public Contacto getNullContacto(){
        return new Contacto();
    }
    
}
