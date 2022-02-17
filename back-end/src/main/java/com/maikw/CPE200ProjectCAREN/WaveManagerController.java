package com.maikw.CPE200ProjectCAREN;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/waveManager") // http://localhost:8080/waveManager
public class WaveManagerController {

    WaveManager waveManager = new WaveManager();


}
