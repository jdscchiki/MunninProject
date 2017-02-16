/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.application;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Juan David Segura
 */
@Named(value = "navbarMenuContent")
@ApplicationScoped
public class NavbarMenuContent {

    /**
     * Creates a new instance of NavbarMenuContent
     */
    public NavbarMenuContent() {
    }
    
}
