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
    private int id = 1;
    
    public ContactoBean() {
        //cargar lista de contactos
        //falta implementar
        contactos.add(new Contacto(getUltimoId(),"Fernando","Lopez","@ferpiece","flopez@gomail.com","Lucerito","(84)401-286)"));
        contactos.add(new Contacto(getUltimoId(),"Fernando","Lopez","@ferpiece","flopez@gomail.com","Lucerito","(84)401-286)"));
        contactos.add(new Contacto(getUltimoId(),"Fernando","Lopez","@ferpiece","flopez@gomail.com","Lucerito","(84)401-286)"));
        contactos.add(new Contacto(getUltimoId(),"Fernando","Lopez","@ferpiece","flopez@gomail.com","Lucerito","(84)401-286)"));
        contactos.add(new Contacto(getUltimoId(),"Fernando","Lopez","@ferpiece","flopez@gomail.com","Lucerito","(84)401-286)"));
        contactos.add(new Contacto(getUltimoId(),"Fernando","Lopez","@ferpiece","flopez@gomail.com","Lucerito","(84)401-286)"));
    }
    
    public void agregarContacto(){
        //falta implementar
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

    private int getUltimoId() {
        return this.id++;
    }

    
}
