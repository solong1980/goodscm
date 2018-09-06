package com.xlw.zerg.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.zerg.model.Banner;
import com.xlw.zerg.model.Theme;
import com.xlw.zerg.service.FrontEndService;

@RestController
@RequestMapping("/zerg/public/v1")
public class ApiController {

	@Autowired
	private FrontEndService frontEndService;

	@RequestMapping("/banner/{id}")
	public Banner banner(@PathVariable("id") Integer id) {
		return frontEndService.banner(id);
	}

	@RequestMapping("/theme")
	public List<Theme> theme(@RequestParam(name = "ids", required = false) String ids) {
		return frontEndService.theme(ids);
	}

	@RequestMapping("/theme/{id}")
	public Theme theme(@PathVariable("id") Integer id) {
		return frontEndService.theme(id);
	}

}
