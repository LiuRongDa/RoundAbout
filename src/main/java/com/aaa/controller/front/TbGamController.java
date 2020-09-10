package com.aaa.controller.front;

import com.aaa.entity.TbArticleGambit;
import com.aaa.entity.TbGambit;
import com.aaa.entity.TbUser;
import com.aaa.service.TbGambitService;
import com.aaa.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/9/10 10:44
 */
@Controller
@RequestMapping("/Reception/tb_gambit")
public class TbGamController {
    @Resource
    TbGambitService tbGambitService;

    @Resource
    TbUserService tbUserService;

    @RequestMapping("queryAll")
    public String queryAll(Model model){
        List<TbGambit> query = tbGambitService.query();
        List<TbUser> queryround = tbUserService.queryround();
        model.addAttribute("query",queryround);
        model.addAttribute("gambits",query);
        return "gambit_main";
    }

    @RequestMapping("queryLike")
    public String queryLike(Model model,Integer gambit_id){
        System.out.println(gambit_id);
        List<TbArticleGambit> tbArticleGambits = tbGambitService.queryLike(gambit_id);
        model.addAttribute("art",tbArticleGambits);
        return "gambit_main::div1";
    }
}
