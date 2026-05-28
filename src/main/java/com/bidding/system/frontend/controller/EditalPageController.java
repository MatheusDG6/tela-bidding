/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.controller;

import com.bidding.system.frontend.model.EditalDTO;
import com.bidding.system.frontend.model.UserRequestDTO;
import com.bidding.system.frontend.service.AuthRestClientService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 *
 * @author Aluno
 */
@Controller
public class EditalPageController {
    
    @Autowired
    private AuthRestClientService restService;
    
    @GetMapping("/editais")
    public String home(
            HttpSession session
    ) {
        return "editais";
    }
    
    @GetMapping
        public List<EditalDTO> listarEditais(
            @RequestHeader("Authorization") String auth
        ){
            String token = auth.replace("Bearer", "");
            List<EditalDTO> lista = restService.listarEditais(token);
            return lista;
    }
}
