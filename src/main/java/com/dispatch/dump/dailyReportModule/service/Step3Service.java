package com.dispatch.dump.dailyReportModule.service;

import com.dispatch.dump.commonModule.db.dto.DailyReportStep3TmpMain;
import com.dispatch.dump.commonModule.db.dto.DailyReportStep3TmpSub;
import com.dispatch.dump.commonModule.db.dto.Login;
import com.dispatch.dump.commonModule.db.mapper.DailyReportStep3TmpMainMapper;
import com.dispatch.dump.commonModule.db.mapper.DailyReportStep3TmpSubMapper;
import com.dispatch.dump.commonModule.util.CommonUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Step3Service {

    private final DailyReportStep3TmpMainMapper dailyReportStep3TmpMainMapper;
    private final DailyReportStep3TmpSubMapper dailyReportStep3TmpSubMapper;
    private final CommonUtil commonUtil;
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    //제출처(부모테이블), 상하차정보(자식테이블) 동시 저장
    public String save(DailyReportStep3TmpMain dailyReportMain, DailyReportStep3TmpSub dailyReportStep3TmpSub) {
        Map<String, Object> rtnMap = commonUtil.returnMap();
        HttpSession session = commonUtil.getSession();

        try {
            Login loginData = (Login) session.getAttribute("loginInfo");
            dailyReportMain.setCarNo(loginData.getUserId());
            if (dailyReportMain.getSheetID() == 0) {
                //제출처 정보가 조회된 게 있다면

                //제출처 정보가 조회된 게 없다면
                //dailyReportMain
                dailyReportStep3TmpMainMapper.insertDailyReportMain(dailyReportMain);
                //위에서 등록한 idx를 등록하기(mapper에 selectKey로 등록해둠)
                dailyReportStep3TmpSub.setSheetID2(dailyReportMain.getSheetID());
                //dailyReportSub
                dailyReportStep3TmpSubMapper.insertDailyReportSub(dailyReportStep3TmpSub);
            } else  {
                //dailyReportMainMapper.updateDailyReport(dailyReportMain);
            }
            rtnMap.put("httpCode", 200);
        } catch (Exception e) {
            log.error("Exception["+ e.getMessage() +"]");
        }
        return commonUtil.jsonFormatTransfer(rtnMap); }

    public String save(DailyReportStep3TmpMain dailyReportMain) {
        Map<String, Object> rtnMap = commonUtil.returnMap();
        HttpSession session = commonUtil.getSession();

        try {
            Login loginData = (Login) session.getAttribute("loginInfo");
            dailyReportMain.setCarNo(loginData.getUserId());
            if (dailyReportMain.getSheetID() == 0) {
                //제출처 정보가 조회된 게 있다면

                //제출처 정보가 조회된 게 없다면
                //dailyReportMain
                dailyReportStep3TmpMainMapper.insertDailyReportMain(dailyReportMain);

            } else  {
                //dailyReportMainMapper.updateDailyReport(dailyReportMain);
            }
            rtnMap.put("httpCode", 200);
        } catch (Exception e) {
            log.error("Exception["+ e.getMessage() +"]");
        }
        return commonUtil.jsonFormatTransfer(rtnMap);
    }

    public String list(Model model, DailyReportStep3TmpMain dailyReportMain) {
        HttpSession session = commonUtil.getSession();

        try {
            Login loginData = (Login) session.getAttribute("loginInfo");
            dailyReportMain.setCarNo(loginData.getUserId());

            log.info(dailyReportMain.getCarNo());
            DailyReportStep3TmpMain list = dailyReportStep3TmpMainMapper.findDailyReportMainList(dailyReportMain);
            System.out.println(list);

            model.addAttribute("list", list);
        } catch (Exception e) {
            log.error("Exception["+ e.getMessage() +"]");
        }
        return "/dailyReport/workspace/list";
    }

}
