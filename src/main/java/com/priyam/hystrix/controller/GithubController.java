/**
 * 
 */
package com.priyam.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyam.hystrix.helper.JSONUtil;
import com.priyam.hystrix.model.Github;
import com.priyam.hystrix.service.GithubService;

/**
 * @author priyamgupta
 *
 */
@RestController
@RequestMapping("github")
public class GithubController {
	
	@Autowired
	private GithubService githubService;

	@GetMapping("git/{username}")
	public Github getGitHubProfile(@PathVariable("username") String username) {
		return githubService.getProfile(username);
	}
	
	@GetMapping("{username}")
	public String getGitHub(Model model, @PathVariable("username") String username) {
		model.addAttribute("greeting", JSONUtil.objectToJSON(githubService.getProfile(username)));
		return "view";
	}
}
