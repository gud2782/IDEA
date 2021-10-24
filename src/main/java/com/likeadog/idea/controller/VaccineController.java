package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.VaccineForm;
import com.likeadog.idea.domain.*;
import com.likeadog.idea.enumCollection.FirstStatus;
import com.likeadog.idea.enumCollection.SecondStatus;
import com.likeadog.idea.enumCollection.ThirdStatus;
import com.likeadog.idea.service.RegisterService;
import com.likeadog.idea.service.VinfoService;
import com.likeadog.idea.service.VaccineService;
import lombok.AllArgsConstructor;
import org.bouncycastle.math.raw.Mod;
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
    public String create(@RequestParam("first") FirstStatus first,
                         @RequestParam("second") SecondStatus second,
                         @RequestParam(value = "third",required = false) ThirdStatus third,
                         @RequestParam("registerIdx") String registerIdx
            ,VaccineForm form) {

        //ThirdStatus third;

        if (third == null) {
            third = ThirdStatus.none;
        }
        System.out.println(first);
        System.out.println(third);

        // vaccineService.saveVc(vaccine);

        vaccineService.saveVc(first,second,third,registerIdx,form);
        return "redirect:/vc/list";

    }

    @GetMapping("/list")
    public String vaccineList(Model model) {
        List<Vaccine> vcs = vaccineService.findVC();
        // System.out.println("vccon:"+vcs.get(1).getNDate());
        model.addAttribute("vcs", vcs);
        return "vc/list";

    }


    @GetMapping("/{vaccineIdx}/update")
    public String vcNew(@PathVariable("vaccineIdx") Long vaccineIdx, Model model) {
        VaccineForm form = vaccineService.getUpdateVaccine(vaccineIdx);

        model.addAttribute("form", form);
        return "vc/updateVaccineForm";

    }

    @PostMapping("/{vaccineIdx}/update")
    public String updateVc(@PathVariable String vaccineIdx, @ModelAttribute("form") VaccineForm form) {
        vaccineService.updateVaccine(vaccineIdx, form);

        return "redirect:/vc/list";
    }

    @GetMapping("/{vaccineIdx}/detail")
    public String vcsDetail(@PathVariable("vaccineIdx") Long vaccineIdx, Model model) {

        Vaccine vaccine = vaccineService.findOne(vaccineIdx);
        model.addAttribute("vaccine", vaccine);

        return "vc/detail";

    }

//    @GetMapping("/{vaccineIdx}/delete")
//    public void vaccineDelete() {
//
//    }

}