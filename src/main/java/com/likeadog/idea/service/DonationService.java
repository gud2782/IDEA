package com.likeadog.idea.service;

import com.likeadog.idea.controller.form.DonationForm;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.UserEntity;
import com.likeadog.idea.enumCollection.DeleteStatus;
import com.likeadog.idea.provider.SecurityInfoProvider;
import com.likeadog.idea.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DonationService {

    @Autowired RegisterService registerService;
    @Autowired QrcodeService qrcodeService;

    private final DonationRepository donationRepository;
    private final UserService userService;




    @Transactional
    public Donation saveDonation(String registerIdx, DonationForm form) {


        //넘어오는 registerIdx , 기준 파싱
        String[] parsedRegId = registerIdx.split(",");
        //파싱한 결과들 중 registerIdx에 해당하는 부분 Long으로 캐스팅
        Long lngregisterIdx = Long.parseLong(parsedRegId[0]);

        Register register = findRegister(lngregisterIdx);
        //System.out.println("service GEtDonationIdx"+form.getDonationIdx());
        //System.out.println("service GetType"+form.getType());

        Donation donation = Donation.builder()
                .donationIdx(form.getDonationIdx())
                .register(register)
                .kind(register.getKind())
                .dDate(form.getDDate())
                .dHos(form.getDHos())
                .type(form.getType())
                .dPack(form.getDPack())
                .build();
        donation.setDel(DeleteStatus.NO);
        donationRepository.regDo(donation);

        Long donationIdx = donation.getDonationIdx();
        System.out.println("donationIDx =" +donation.getDonationIdx());

        qrcodeService.donationQrcode(donationIdx);



        return donation;
    }


    public DonationForm getUpdateDonation(Long donationIdx) {

        Donation donation = findOne(donationIdx);

        DonationForm form = DonationForm.builder()
                .donationIdx(donation.getDonationIdx())
                .dWeight(donation.getDWeight())
                .kind(donation.getRegister().getKind())
                .dDate(donation.getDDate())
                .dHos(donation.getDHos())
                .type(donation.getType())
                .dPack(donation.getDPack())
                .neutralization(donation.getRegister().getNeutralization())
                .register(donation.getRegister())
                .build();
        form.setDel(donation.getDel());

        return form;

    }

    @Transactional
    public void updateDonation(String donationIdx, DonationForm form) {

        Donation donation = Donation.builder()
                .donationIdx(form.getDonationIdx())
                .dWeight(form.getDWeight())
                .kind(form.getKind())
                .dDate(form.getDDate())
                .dHos(form.getDHos())
                .type(form.getType())
                .dPack(form.getDPack())
                .neutralization(form.getNeutralization())
                .register(form.getRegister())
                .build();
        donation.setDel(form.getDel());

        donationRepository.regDo(donation);

    }

    @Transactional
    public void deleteDo(Long donationIdx) {
        Donation donation = donationRepository.findOne(donationIdx);
        donation.setDel(DeleteStatus.YES);
        donationRepository.regDo(donation);
    }


    public List<Donation> findDos() {
        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = userService.findByUserID(userId);
        return donationRepository.findDosByUserIDX(userEntity.getUserIdx());
    }



    public Donation findOne(Long donationIdx) {
        return donationRepository.findOne(donationIdx);
    }

    public  List<Register> findAnis() {
        return registerService.findAnis();
    }

    public Register findRegister(Long registerIdx) {
        return registerService.findOne(registerIdx);
    }


    public Donation findDonationByAniId(String donationIdx){
        return  donationRepository.findDonationByAniId(donationIdx);
    }

    public void saveDonation(Donation donation){
        donationRepository.regDo(donation);
    }



}