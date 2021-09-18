package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.DonationForm;
import com.likeadog.idea.controller.form.VaccineForm;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Vinfo;
import com.likeadog.idea.service.V_infoService;
import com.likeadog.idea.service.VaccineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/vc")
public class VaccineController {

    private final VaccineService vaccineService;
    private final V_infoService v_infoService;

    @GetMapping("/new")
    public String createForm(Model model) {
        List<Vinfo> vinfos = v_infoService.findVaccine();
        VaccineForm vaccineForm = new VaccineForm();

        model.addAttribute("vaccineForm", new VaccineForm());
        model.addAttribute("vInfo", new Vinfo());

        return "vc/createVaccineForm";


    }

    @PostMapping("/new")
    public String create(@RequestParam("first") String first,
                         @RequestParam("second") String second,
                         @RequestParam("third") String third, Long vaccineIdx, VaccineForm form) {

        Register registers = v_infoService.findOne(vaccineIdx);
        Donation donation = new Donation();

        donation.setRegister(registers);
        donation.setDWeight(form.getDWeight());
        donation.setKind(registers.getKind());
        donation.setDDate(form.getDDate());
        donation.setDHos(form.getDHos());
        donation.setType(form.getType());
        donation.setDPack(form.getDPack());
        donation.setNeutralization(registers.getNeutralization());
        donation.getRegister().getAniId();

        System.out.println(donation.getRegister().getRegisterIdx());
        System.out.println(donation.getRegister().getAniName());



        donationService.saveDo(donation);

        return "redirect:/donation/list";



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
