package com.example.motorvognregister;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorvognController {

    public final List<Motorvogn> alleBiler = new ArrayList<>();

    @PostMapping("/lagre")
    public void lagreBiler(@RequestBody Motorvogn innBiler) {
        alleBiler.add(innBiler);
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlle() {
        return alleBiler;
    }

    @GetMapping("/slettAlle")
    public void slettAlle() {
        alleBiler.clear();
    }

    private final List<Motorvogn> alleBiler;

    // Konstruktør som laster inn bilene ved opprettelse av controlleren

    this.alleBiler = new ArrayList<>();
    alleBiler.add(new Motorvogn("Mercedes", "A-Class", ...));
    alleBiler.add(new Motorvogn("Toyota", "Camry", ...));
    }

    // Endepunkt for å hente alle bilmerker
    @GetMapping("/hentMerker")
    public List<String> hentMerker() {
        // Hent unike bilmerker fra bilene på serveren
        return alleBiler.stream().map(Motorvogn::getBrand).distinct().collect(Collectors.toList());
    }

    // Endepunkt for å hente modeller basert på valgt merke
    @GetMapping("/hentModeller")
    public List<String> hentModeller(@RequestParam String brand) {
        // Hent modeller basert på valgt bilmerke fra bilene på serveren
        return alleBiler.stream()
                .filter(motorvogn -> motorvogn.getBrand().equals(brand))
                .map(Motorvogn::getModel)
                .distinct()
                .collect(Collectors.toList());
    }

    // Legg til andre endepunkter som kreves for å håndtere bilene
    // ...

}
