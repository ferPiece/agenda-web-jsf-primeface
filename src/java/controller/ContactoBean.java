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
import org.primefaces.event.RowEditEvent;
/**
 *
 * @author lopez
 */
@ManagedBean
@SessionScoped
public class ContactoBean implements Serializable {

    private static final long serialVersionUID = 455659950717243338L;
    private Contacto contacto = new Contacto();
    private Contacto contactoUpdate = new Contacto();
    private List<Contacto> contactos = new ArrayList<Contacto>();
    private int id = 1;
    
    
    
    
    
    public ContactoBean() {
        //cargar lista de contactos
        //falta implementar
        contactos.add(new Contacto(getUltimoId(),"Lilian","Galeano","@haideg.93","haideg.93@gmail.com","Ñemby","(71)666-567"));        
        contactos.add(new Contacto(getUltimoId(),"Fernando","Lopez","@ferpiece","flopez@gomail.com","San Lorenzo","(84)401-286"));       
        contactos.add(new Contacto(getUltimoId(),"Rodrigo","Benitez","@rbenitez94","rorobenm@gmail.com","Lambare","(82)166-858"));
        contactos.add(new Contacto(getUltimoId(),"Nicolas","Lopez","@unloco","nichito93@gmail.com","San Lorenzo","(72)213-929"));
    }
    
    public void agregarContacto(){
        int id = getUltimoId();
        contacto.setId(id);
        contactos.add(contacto);
        showMessage("Contacto " + contacto.getNombre() + " agregado con exito!");
    }
    
    public void eliminarContacto(Contacto contacto){
        String nombre = contacto.getNombre();
        contactos.remove(contacto);
        showMessage("Contacto " + nombre + " eliminado con exito!");
    }
    
    public void modificarContacto(RowEditEvent event){
        //recupero el contacto a actualizar
        Contacto c = (Contacto) event.getObject();
        
        //siempre que el nombre que vaya a actualizar sea distinto de actual
        //y si el actualizable es != null
        if ( !contactoUpdate.getNombre().equals(c.getNombre()) && !contactoUpdate.getNombre().equals("")  ) {
            c.setNombre(contactoUpdate.getNombre());
        }
        
        if ( !contactoUpdate.getApellido().equals(c.getApellido()) && !contactoUpdate.getApellido().equals("") ) {
            c.setApellido(contactoUpdate.getApellido());
        }
        
        if ( !contactoUpdate.getUsername().equals(c.getUsername()) && !contactoUpdate.getUsername().equals("")) {
            c.setUsername(contactoUpdate.getUsername());
        }
       
        if ( !contactoUpdate.getEmail().equals(c.getEmail()) && !contactoUpdate.getEmail().equals("")) {
            c.setEmail(contactoUpdate.getEmail());
        }
        
        if ( !contactoUpdate.getDireccion().equals(c.getDireccion()) && !contactoUpdate.getDireccion().equals("")) {
            c.setDireccion(contactoUpdate.getDireccion());
        }
        
        if ( !contactoUpdate.getTelefono().equals(c.getTelefono()) && !contactoUpdate.getTelefono().equals("")) {
            c.setTelefono(contactoUpdate.getTelefono());
        }
        showMessage("Modificado con exito!");
    }
    
    public void cancelarModificarContacto(RowEditEvent event){        
        //falta implementar
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cancelado!!"));
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

    private int getUltimoId() {
        return this.id++;
    }

    public Contacto getContactoUpdate() {
        return contactoUpdate;
    }

    public void setContactoUpdate(Contacto contactoUpdate) {
        this.contactoUpdate = contactoUpdate;
    }
 
    
}
