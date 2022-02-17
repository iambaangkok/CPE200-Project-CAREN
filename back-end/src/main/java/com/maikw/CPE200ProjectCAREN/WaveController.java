package com.maikw.CPE200ProjectCAREN;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/wave") // http://localhost:8080/wave


public class WaveController {


    Wave wave1 = new Wave(1);
    Wave wave2 = new Wave(2);
    Wave wave3 = new Wave(3);
    Wave wave4 = new Wave(4);
    Wave wave5 = new Wave(5);



    @CrossOrigin
    @GetMapping(path = "/getwave1") // http://localhost:8080/wave/getwave1
    public  Wave getWave1(){
        return wave1;
    }
    @CrossOrigin
    @GetMapping(path = "/getwave2") // http://localhost:8080/wave/getwave2
    public  Wave getWave2(){
        return wave2;
    }
    @CrossOrigin
    @GetMapping(path = "/getwave3") // http://localhost:8080/wave/getwave3
    public  Wave getWave3(){
        return wave3;
    }
    @CrossOrigin
    @GetMapping(path = "/getwave4") // http://localhost:8080/wave/getwave4
    public  Wave getWave4(){
        return wave4;
    }
    @CrossOrigin
    @GetMapping(path = "/getwave5") // http://localhost:8080/wave/getwave5
    public  Wave getWave5(){
        return wave5;
    }

}
