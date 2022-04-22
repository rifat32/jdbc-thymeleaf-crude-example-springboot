package com.example.jdbcexample.net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    private final SalesDao dao;

    public AppController(SalesDao dao) {
        this.dao = dao;
    }
    @RequestMapping("/")
    public  String viewhomePage(Model model){
        List<Sale> listSales = dao.list();
        model.addAttribute("sales",listSales);
        System.out.println(listSales);
        return "index";

    }
    @RequestMapping("/new")
    public  String showNewForm(Model model){
      Sale sale = new Sale();
        model.addAttribute("sale",sale);
        System.out.println(sale);
        return "new";

    }
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public  String save(@ModelAttribute("sale") Sale sale){

     dao.save(sale);
        return "redirect:/";

    }
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable(name = "id") int id){
        System.out.println("fffffffff");
        ModelAndView mav = new ModelAndView("edit_form");
        Sale sale = dao.get(id);
        mav.addObject("sale",sale);
return mav;


    }
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public  String update(@ModelAttribute("sale") Sale sale){

        dao.update(sale);
        return "redirect:/";

    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") int id){
dao.delete(id);
        return "redirect:/";


    }
}
