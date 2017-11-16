package com.lmig.gfc.hero_and_villians.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.hero_and_villians.models.Hero;
import com.lmig.gfc.hero_and_villians.models.Monster;

@Controller
public class HomeController {
	
	private Monster ourMonster;
	private Hero ourHero;
	
	public HomeController() {
		this.initGame();
	}

	@RequestMapping("/")
	public ModelAndView defaultPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/attack")
	public ModelAndView attackPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		
		ourHero.attack(ourMonster);
		
		mv.addObject("isGameOver", this.isGameOver());
		
		mv.setViewName("index"); 
		return mv;
	}
	
	@RequestMapping("/fight")
	public ModelAndView fightPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		
		while(this.isGameOver() == false) {
			ourHero.attack(ourMonster);
		}
		
		//same as above but loop always runs at least 1 time
//		do {
//			ourHero.attack(ourMonster);
//		} while (this.isGameOver() == false);
		
		mv.addObject("isGameOver", this.isGameOver());
		
		mv.setViewName("index"); 
		return mv;
	}
	
	@RequestMapping("/reset")
	public ModelAndView resetPage() {
		ModelAndView mv = new ModelAndView();
		
		this.initGame();
		
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		
		mv.setViewName("index"); 
		return mv;
	}
	
	public boolean isGameOver() {
//		return (!ourHero.isAlive() || !ourMonster.isAlive());
		return (ourHero.isAlive() == false || ourMonster.isAlive() == false);
	}
	
	public void initGame() {
		ourMonster = new Monster("Steve", 80, "Ogre");
		ourHero = new Hero("Clark Kent", 100, "Superman"); 
	}
	
}
