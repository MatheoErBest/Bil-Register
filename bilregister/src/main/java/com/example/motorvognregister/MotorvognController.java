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
}
