package org.jtm.query.service.controller;

import org.jtm.common.util.CalUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {
	@RequestMapping("/query")
	public String hi(){
		CalUtils cal = new CalUtils();
		return cal.MergeDateOrderByDesc();
	}
}
