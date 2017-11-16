package com.lmig.gfc.hero_and_villians.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.hero_and_villians.models.Hero;
import com.lmig.gfc.hero_and_villians.models.Monster;

@Controller
public class HomeController {
	
	private ArrayList<Monster> ourMonsters;
	private Hero ourHero;
	
	public HomeController() {
		this.initGame();
	}

	@RequestMapping("/")
	public ModelAndView defaultPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		
		mv.setViewName("index");
		return mv;
	}
	
	
//	@RequestMapping("/fight")
//	public ModelAndView fightPage() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("monsters", ourMonsters);
//		mv.addObject("hero", ourHero);
//		
//		while(this.isGameOver() == false) {
//			ourHero.attack(ourMonster);
//		}
//		
//		//same as above but loop always runs at least 1 time
////		do {
////			ourHero.attack(ourMonster);
////		} while (this.isGameOver() == false);
//		
//		mv.addObject("isGameOver", this.isGameOver());
//		
//		mv.setViewName("index"); 
//		return mv;
//	}
	
	@RequestMapping("/reset")
	public ModelAndView resetPage() {
		ModelAndView mv = new ModelAndView();
		
		this.initGame();
		
		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		
		mv.setViewName("index"); 
		return mv;
	}
	
//	public boolean isGameOver() {
////		return (!ourHero.isAlive() || !ourMonster.isAlive());
//		return (ourHero.isAlive() == false || ourMonster.isAlive() == false);
//	}
	
	public void initGame() {
		
		ourMonsters = new ArrayList<Monster>();
		
		Monster monster1 = new Monster("Steve", 80, "Ogre");
		Monster monster2 = new Monster("Bob", 75, "Vampire");
		Monster monster3 = new Monster("Joe", 90, "Warewolf");
		Monster monster4 = new Monster("Billy", 100, "Psycho Killer");
		Monster monster5 = new Monster("Doug", 20, "Coding Monster");
		
		ourMonsters.add(monster1);
		ourMonsters.add(monster2);
		ourMonsters.add(monster3);
		ourMonsters.add(monster4);
		ourMonsters.add(monster5);
		
		ourHero = new Hero("Clark Kent", 100, "Superman"); 
	}
	
}
