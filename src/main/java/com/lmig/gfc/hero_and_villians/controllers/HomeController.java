package com.lmig.gfc.hero_and_villians.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.hero_and_villians.models.Hero;
import com.lmig.gfc.hero_and_villians.models.LivingThing;
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
	
	
	@RequestMapping("/fight")
	public ModelAndView fightPage() {
		ModelAndView mv = new ModelAndView();
		
		for(Monster monster : ourMonsters) {
			
			while(ourHero.isAlive() && monster.isAlive()) {
				ourHero.attack(monster);
			}
			
			//if the game is over lets just stop
			if(this.isGameOver()) {
				break;
			}
			
		}
		
		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		mv.addObject("isGameOver", this.isGameOver());
		
		mv.setViewName("index"); 
		return mv;
	}
	
	@RequestMapping("/reset")
	public ModelAndView resetPage() {
		ModelAndView mv = new ModelAndView();
		
		this.initGame();
		
		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		
		mv.setViewName("index"); 
		return mv;
	}
	
	public boolean isGameOver() {
		
		if(!ourHero.isAlive()) {
			return true;
		}
		
		
		//our hero has to be alive if we made it here
		//lets determine if any monsters (or generic living thing) are alive
		
		//assume all dead
		boolean isOver = true;
		for(Monster monster : ourMonsters) {
			if(monster.isAlive()) {
				
				//if we find one alive, set is over to false
				isOver = false;
				break;
			}
		}
		
		return isOver;
	}
	
	public void initGame() {
		
		ourMonsters = new ArrayList<Monster>();
		
		Monster monster1 = new Monster("Steve", 80, "Ogre");
		Monster monster2 = new Monster("Bob", 75, "Vampire");
		Monster monster3 = new Monster("Joe", 90, "Warewolf");
		Monster monster4 = new Monster("Billy", 100, "Psycho Killer Monster");
		Monster monster5 = new Monster("Doug", 20, "Coding Monster");
		
		ourMonsters.add(monster1);
		ourMonsters.add(monster2);
		ourMonsters.add(monster3);
		ourMonsters.add(monster4);
		ourMonsters.add(monster5);
		
		ourHero = new Hero("Clark Kent", 375, "Superman"); 
	}
	
}
