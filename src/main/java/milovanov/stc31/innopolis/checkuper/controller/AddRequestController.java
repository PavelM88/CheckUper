package milovanov.stc31.innopolis.checkuper.controller;

import milovanov.stc31.innopolis.checkuper.dao.RequestDao;
import milovanov.stc31.innopolis.checkuper.pojo.Request;
import milovanov.stc31.innopolis.checkuper.pojo.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class AddRequestController {
    @Autowired
    private RequestDao requestDao;

    @GetMapping(value = "/addrequest")
    public ModelAndView addRequest() {
        Request request = new Request();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("request", request);
        modelAndView.setViewName("addrequest");
        return modelAndView;
    }

    @PostMapping(value = "/addrequest")
    public String createRequest(@ModelAttribute Request request) {
        request.setStatus(RequestStatus.TODO);
        requestDao.save(request);
        return "show_request";
    }
}
