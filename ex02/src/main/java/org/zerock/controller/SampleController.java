package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDAO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/basic")//-->view
	public String basic(SampleDAO dao,Model model) {
		log.info("basic--------------------------------");//-->데이터(model)
		log.info("dao : " + dao);
		model.addAttribute("list",dao);
		return "sample/basic";
	}
	
}
