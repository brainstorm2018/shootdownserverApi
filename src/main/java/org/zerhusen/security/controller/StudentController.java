package org.zerhusen.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.ScreenShot;
import org.zerhusen.TypeOfServer;
import org.zerhusen.security.repository.UserControoller;

import java.io.IOException;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class StudentController {

    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    UserControoller controoller;


    ObjectMapper mapper = new ObjectMapper();

    // -------------------Retrieve All Students---------------------------------------------
    @RequestMapping(value = "/lock", method = RequestMethod.GET)
    public ResponseEntity<?> lock() {

        if (TypeOfServer.isWindows()) {
            try {
                Runtime.getRuntime().exec("C:\\Windows\\System32\\rundll32.exe user32.dll,LockWorkStation");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new ResponseEntity<>(new ScreenShot().getByteArray(), HttpStatus.OK);
    }
    // -------------------Retrieve All Students---------------------------------------------

    @RequestMapping(value = "/sleep", method = RequestMethod.GET)
    public ResponseEntity<?> spleep() {
        if (TypeOfServer.isWindows()) {
            try {
                Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(new ScreenShot().getByteArray(), HttpStatus.OK);
    }

    @RequestMapping(value = "/screenshot", method = RequestMethod.GET)
    public ResponseEntity<?> screenshot() {
        return  new ResponseEntity<>(new ScreenShot().getByteArray(), HttpStatus.OK);
//        ScreenShot s = new ScreenShot();
//        return  new ResponseEntity<>("cfsdfds", HttpStatus.OK);
    }

    @RequestMapping(value = "/shutdown", method = RequestMethod.GET)
    public ResponseEntity<?> shutdown() {
        String shutdownCommand;
        if (TypeOfServer.isLinux() || TypeOfServer.isMac()) {
            shutdownCommand = "shutdown -h now";
        } else if (TypeOfServer.isWindows()) {
            shutdownCommand = "shutdown.exe -s -t 0";
        } else {
            return new ResponseEntity<>("Usuportet OS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            Runtime.getRuntime().exec(shutdownCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ScreenShot().getByteArray(), HttpStatus.OK);
    }


}










