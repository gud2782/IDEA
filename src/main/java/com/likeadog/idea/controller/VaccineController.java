//package com.likeadog.idea.controller;
//
//import com.likeadog.idea.controller.form.VaccineForm;
//import com.likeadog.idea.domain.Register;
//import com.likeadog.idea.domain.RegisterVaccine;
//import com.likeadog.idea.domain.Vaccine;
//import com.likeadog.idea.domain.Vinfo;
//import com.likeadog.idea.service.RegisterService;
//import com.likeadog.idea.service.VinfoService;
//import com.likeadog.idea.service.VaccineService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@AllArgsConstructor
//@RequestMapping(value = "/vc")
//public class VaccineController {
//
//    private final VaccineService vaccineService;
//    private final VinfoService v_infoService;
//    private final RegisterService registerService;
//
//    @GetMapping("/new")
//    public String createForm(Model model) {
//        List<Register> registers = registerService.findAnis();
//        List<Vinfo> vinfos = v_infoService.findVcs();
//        VaccineForm vaccineForm = new VaccineForm();
//
//        model.addAttribute("vaccineForm", new VaccineForm());
//        model.addAttribute("registers", registers );
//
//        return "vc/createVaccineForm";
//
//
//    }
//    @PostMapping("/new")
//    public String create(@RequestParam("registerIdx") String registerIdx, VaccineForm form) {
//
//        //넘어오는 registerIdx , 기준 파싱
//        String[] parsedRegId = registerIdx.split(",");
//        System.out.println(registerIdx);
//        //파싱한 결과들 중 registerIdx에 해당하는 부분 Long으로 캐스팅
//        Long lngregisterIdx = Long.parseLong(parsedRegId[0]);
//
//
//        Register registers = registerService.findOne(lngregisterIdx);
//        RegisterVaccine registerVaccine = new RegisterVaccine();
//        registerVaccine.setRegister(registers);
//
//        Vaccine vaccine = new Vaccine();
//
//
//        vaccine.setVaccineIdx(form.getVaccineIdx());
//        vaccine.setRegisterVaccines(registers.getRegisterVaccines());
//        vaccine.getRegisterVaccines().get(0).getRegister().getRegisterIdx();
//        vaccine.setVNumber(form.getVNumber());
//        vaccine.setVDate(form.getVDate());
//        vaccine.setNDate(form.getNDate());
//        vaccine.getRegisterVaccines().;
////        vaccine.getRegister().getAniId();
////        vaccine.getRegister().getRegisterIdx();
//
//
//
//
//
//
////        donationService.saveDo(donation);
//
//        return "redirect:/donation/list";
//    }
//
////    @PostMapping("/new")
////    public String create(@RequestParam("first") String first,
////                         @RequestParam("second") String second,
////                         @RequestParam("third") String third, Long vaccineIdx, VaccineForm form) {
////
////        Vinfo vinfos = v_infoService.findVaccine(vaccineIdx);
////
////        Vaccine vaccine = new Vaccine();
////
////        vaccine.setVNumber(form.getVNumber());
////
////
////
////        vaccineService.saveVc(vaccine);
////
////        return "redirect:/donation/list";
////
////    }
//
//    @GetMapping("/list")
//    public void vaccineList() {
//
//    }
//
//    @GetMapping("/update")
//    public void vaccineUpdate() {
//
//    }
//
//    @GetMapping("/delete")
//    public void vaccineDelete() {
//
//    }
//
//}
