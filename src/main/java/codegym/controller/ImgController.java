package codegym.controller;

import codegym.model.Img;
import codegym.service.Img_comment;
import codegym.service.Img_comment_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getLandingPage(Model model,@PageableDefault(size = 3) Pageable pageable){
        Page<Img> commentList = img_comment.showAllComment(pageable);
        model.addAttribute("comments",commentList);
        return "index";
    }


    @PostMapping("/comment")
    public String comment(@ModelAttribute Img img){
        img_comment.comment(img);
        return ("redirect:/");
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable Long id){
        Img likeImg = img_comment.findByid(id);
        img_comment.like(likeImg);
        return ("redirect:/");
    }
}
