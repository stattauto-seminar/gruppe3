package de.stattauto.unfallmeldung.restcontroller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.stattauto.unfallmeldung.entity.Unfallmeldung;
import de.stattauto.unfallmeldung.repository.UnfallRepository;

@RefreshScope
@RestController
public class UnfallmeldungRestController {
	
	private UnfallRepository repo;
	@Value("${welcome.message}")
	private String hello;
	
	public UnfallmeldungRestController(UnfallRepository repo) {
		this.repo = repo;
	}
	
	
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "unfallmeldung: " + hello + " " +name;
	}

	@GetMapping("/hello")
	public String hello() {
		return "unfallmeldung";
	}
	
	@GetMapping("/hallo")
	public String hello(@RequestParam String vorname, @RequestParam String nachname) {
		return "unfallmeldung: " + hello + " " + vorname+" "+nachname;
	}
	
	@GetMapping("/unfallmeldung/{id}")
	public ResponseEntity<Unfallmeldung> holeUnfallmeldung(@PathVariable Long id) {
		
		Optional<Unfallmeldung> result = repo.findById(id);
		if (result.isPresent())
			return new ResponseEntity<Unfallmeldung>(result.get(),HttpStatus.OK);
		else
			return new ResponseEntity<Unfallmeldung>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/alleUnfallmeldungen")
	public Collection<Unfallmeldung> holeAlleUnfallmeldungen() {
		List<Unfallmeldung> result = repo.findAll();
		return (Collection<Unfallmeldung>) result;
	}
	
	@GetMapping("/unfallmeldungenbyFahrer/{id}")
	public Collection<Unfallmeldung> holeAlleUnfallmeldungenByFahrer(@PathVariable Long id){
		Collection<Unfallmeldung> result = repo.findByFahrer(id);
		return result;
	}
	
}
