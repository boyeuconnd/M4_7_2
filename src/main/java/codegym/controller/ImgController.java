package codegym.controller;

import codegym.model.Img;
import codegym.service.Img_comment;
import codegym.service.Img_comment_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class ImgController {
    @Autowired
    private Img_comment img_comment;

    @GetMapping("/")
    public String getLandingPage(Model model){
        List<Img> commentList = img_comment.showAllComment();
        model.addAttribute("comments",commentList);
        return "index";
    }


    @PostMapping("/comment")
    public String comment(@ModelAttribute Img img){
        img_comment.comment(img);
        return ("redirect:/");
    }
}
