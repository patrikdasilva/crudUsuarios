package br.com.teste.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import br.com.teste.model.Usuario;
import br.com.teste.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@GetMapping("/usuario/add")
	public String addUsuario(Model model, Usuario usuario) {
		model.addAttribute("usuario", new Usuario() );
		return "add";
	}
	
	@PostMapping("usuario/save")
	public String saveUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String listUsuario(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll(Sort.by("nome")));
		return "index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUsuario(@PathVariable long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (Exception e ) {
			System.out.println("Erro: "+ e.getMessage());
		}
		return "redirect:/list";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public Optional<Usuario> editUsuario(long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario;
	}
	
	@PostMapping("/editSave/{id}")
	public String editUsuario(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
		} catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
		return "redirect:/list";
	}
}
