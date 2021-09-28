package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.VaccineForm;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.RegisterVaccine;
import com.likeadog.idea.domain.Vaccine;
import com.likeadog.idea.domain.Vinfo;
import com.likeadog.idea.service.RegisterService;
import com.likeadog.idea.service.VinfoService;
import com.likeadog.idea.service.VaccineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/vc")
public class VaccineController {

    private final VaccineService vaccineService;
    private final VinfoService vinfoService;
    private final RegisterService registerService;

    @GetMapping("/new")
    public String createForm(Model model) {
        List<Register> registers = registerService.findAnis();
        List<Vinfo> vinfos = vinfoService.findVcs();
        VaccineForm vaccineForm = new VaccineForm();

        model.addAttribute("vaccineForm", new VaccineForm());
        model.addAttribute("registers", registers );
        model.addAttribute("vinfos", vinfos );
        System.out.println(model.getAttribute("vinfos"));
        System.out.println("1111111");

        return "vc/createVaccineForm";


    }
    @PostMapping("/new")
    public String create(@RequestParam("registerIdx") String registerIdx, @ModelAttribute("form") VaccineForm form, Model model) {

//        List<Vinfo> vinfos = v_infoService.findVcs();
        vaccineService.saveVaccine(registerIdx, form);
        System.out.println("333333");



        return "redirect:/vc/list";
    }

//    @PostMapping("/new")
//    public String create(@RequestParam("first") String first,
//                         @RequestParam("second") String second,
//                         @RequestParam("third") String third, Long vaccineIdx, VaccineForm form) {
//
//        Vinfo vinfos = v_infoService.findVaccine(vaccineIdx);
//
//        Vaccine vaccine = new Vaccine();
//
//        vaccine.setVNumber(form.getVNumber());
//
//
//
//        vaccineService.saveVc(vaccine);
//
//        return "redirect:/donation/list";
//
//    }

    @GetMapping("/list")
    public void vaccineList() {

    }

    @GetMapping("/update")
    public void vaccineUpdate() {

    }

    @GetMapping("/delete")
    public void vaccineDelete() {

    }

}
