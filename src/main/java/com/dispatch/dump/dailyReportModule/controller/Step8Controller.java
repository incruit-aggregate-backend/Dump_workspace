package com.dispatch.dump.dailyReportModule.controller;

import com.dispatch.dump.commonModule.db.dto.DailyReport;
import com.dispatch.dump.commonModule.db.dto.DailyReportStep8;
import com.dispatch.dump.dailyReportModule.service.DailyReportService;
import com.dispatch.dump.dailyReportModule.service.Step8Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dailyReport")
@RequiredArgsConstructor
public class Step8Controller {

    private final DailyReportService dailyReportService;
    private final Step8Service step8Service;

    //기존꺼
//    @RequestMapping(value = "/receipts", method = RequestMethod.GET)
//    public String step8(Model model, DailyReport dailyReport) {
//        dailyReportService.list(model, dailyReport);
//        return "/dailyReport/step8/receipts";
//    }

    @GetMapping("/receipts")
    public ModelAndView getReceipts() {
        ModelAndView modelAndView = new ModelAndView("/dailyReport/step8/receipts"); // 뷰 이름 설정 (receipts.jsp)
        // 모델 데이터 추가
//        List<DailyReportStep8> receiptsList = step8Service.getReceipts();
        modelAndView.addObject("receiptsList", step8Service.getReceipts());
        return modelAndView;
    }

//    @RequestMapping(value = "/receipts", method = RequestMethod.GET)
//    @ModelAttribute("receiptsList")
//    public List<DailyReportStep8Sub> getReceiptsList() {
//        List<DailyReportStep8Sub> receiptsList = step8Service.getSummary();
//        return receiptsList;
//    }



}
