package codegym.controller;

import codegym.model.ImgComment;
import codegym.service.Img_comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class ImgController {
    @Autowired
    private Img_comment img_comment;

    @GetMapping("/")
    public String getLandingPage(Model model,@PageableDefault(size = 3) Pageable pageable){
        Page<ImgComment> commentList = img_comment.showAllComment(pageable);
        model.addAttribute("comments",commentList);
        return "index";
    }


    @PostMapping("/comment")
    public String comment(@ModelAttribute ImgComment imgComment) throws RuntimeException{
        img_comment.comment(imgComment);
        return ("redirect:/");
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable Long id){
        ImgComment likeImgComment = img_comment.findByid(id);
        img_comment.like(likeImgComment);
        return ("redirect:/");
    }

    @ExceptionHandler(RuntimeException.class)
    public String showErrorForm(){
        return "error";
    }
}
