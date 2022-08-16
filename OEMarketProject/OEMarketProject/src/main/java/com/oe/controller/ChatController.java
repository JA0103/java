package com.oe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oe.service.ChatRoomService;

import lombok.extern.log4j.Log4j;

@Controller
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@WebAppConfiguration
@Log4j
public class ChatController {

//	@RequestMapping("/chat")
//	public ModelAndView chat() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("chat");
//		return mv;
//	}
	@Autowired
	private ChatRoomService service;
	
	@GetMapping("/chat/room")
	public void getRoom() {
		
	}
	
	@PostMapping("/room")
	public String getRoom(String cr_buyer,String cr_seller, RedirectAttributes rttr) {
		log.info(service.checkRoom(cr_buyer, cr_seller));
		log.info("cr_seller : "+cr_seller);
		log.info("cr_buyer : "+cr_buyer);
		
			
		
		if(service.checkRoom(cr_seller, cr_buyer) == null) {
			service.register(cr_buyer,cr_seller);
			rttr.addAttribute("cr_seller",cr_seller);
			log.info("if return");
			return "redirect:/chat";
		}else if(service.checkRoom(cr_seller, cr_buyer) != null)  {
			rttr.addAttribute("cr_seller",cr_seller);
			log.info("else return");
			return "redirect:/chat";
		}
		return null;
		
	}
	
	@GetMapping("/chat")
	public void chat( Model model, String cr_seller) {
		model.addAttribute("cr_seller", cr_seller);
		log.info("================================="+cr_seller);
	}
}
