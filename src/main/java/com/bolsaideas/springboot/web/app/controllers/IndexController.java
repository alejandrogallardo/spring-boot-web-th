package com.bolsaideas.springboot.web.app.controllers;

import com.bolsaideas.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
// Ruta Base para el controlador
@RequestMapping(value = "/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

//    Si no se indica por defecto es get
//    Tambien se puede user @GetMapping o @PostMapping
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    se puede mapear a varial rutas ({"/index", "/", "/home"})
    // Se puede usar ModelMap o directamente (Map<String, Object> map) -> map.put("Algo kjalskdj") (ModelAndView mv) -> mv.addObject("algo")
//    @RequestMapping(value = "/")
    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Alejandro");
        usuario.setApellido("Gallardo");
        usuario.setEmail("agallardo@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        /*
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Madison", "Gallardo", "madi@madi.com"));
        usuarios.add(new Usuario("Alejandro", "Gallardo", "alejandro@madi.com"));
        usuarios.add(new Usuario("Sofia", "Gallardo", "sofia@madi.com"));
        */
        // tambien se puede usar Arrays.asList(elementos separados por coma);
        model.addAttribute("titulo", textoListar);
//        model.addAttribute("usuarios", usuarios);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Madison", "Gallardo", "madi@madi.com"));
        usuarios.add(new Usuario("Alejandro", "Gallardo", "alejandro@madi.com"));
        usuarios.add(new Usuario("Sofia", "Gallardo", "sofia@madi.com"));
        return usuarios;
    }

}
